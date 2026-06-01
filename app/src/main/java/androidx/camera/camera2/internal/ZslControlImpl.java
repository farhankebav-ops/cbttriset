package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.InputConfiguration;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageWriter;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.camera2.internal.compat.CameraCharacteristicsCompat;
import androidx.camera.camera2.internal.compat.quirk.DeviceQuirks;
import androidx.camera.camera2.internal.compat.quirk.ZslDisablerQuirk;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.CompareSizesByArea;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.compat.ImageWriterCompat;
import androidx.camera.core.internal.utils.ZslRingBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
final class ZslControlImpl implements ZslControl {

    @VisibleForTesting
    static final int MAX_IMAGES = 9;

    @VisibleForTesting
    static final int RING_BUFFER_CAPACITY = 3;
    private static final String TAG = "ZslControlImpl";
    private final CameraCharacteristicsCompat mCameraCharacteristicsCompat;
    private final Executor mExecutor;

    @VisibleForTesting
    final ZslRingBuffer mImageRingBuffer;
    private boolean mIsPrivateReprocessingSupported;
    private DeferrableSurface mReprocessingImageDeferrableSurface;
    SafeCloseImageReaderProxy mReprocessingImageReader;
    ImageWriterHolder mReprocessingImageWriterHolder;
    private boolean mShouldZslDisabledByQuirks;
    private boolean mIsZslDisabledByUseCaseConfig = false;
    private boolean mIsZslDisabledByFlashMode = false;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @VisibleForTesting
    public static class ImageWriterHolder {
        private final Executor mExecutor;
        private ImageWriter mImageWriter;
        private final AtomicBoolean mIsOpened = new AtomicBoolean(true);

        public ImageWriterHolder(Executor executor) {
            this.mExecutor = executor;
        }

        public void deactivate() {
            this.mIsOpened.set(false);
        }

        public boolean enqueueImageToImageWriter(final ImageProxy imageProxy) {
            ImageWriter imageWriter;
            Image image = imageProxy.getImage();
            if (this.mIsOpened.get() && (imageWriter = this.mImageWriter) != null && image != null) {
                try {
                    ImageWriterCompat.queueInputImage(imageWriter, image);
                    ImageWriterCompat.setOnImageReleasedListener(this.mImageWriter, new ImageWriter.OnImageReleasedListener() { // from class: androidx.camera.camera2.internal.h1
                        @Override // android.media.ImageWriter.OnImageReleasedListener
                        public final void onImageReleased(ImageWriter imageWriter2) {
                            imageProxy.close();
                        }
                    }, this.mExecutor);
                    return true;
                } catch (IllegalStateException e) {
                    Logger.e(ZslControlImpl.TAG, "enqueueImageToImageWriter throws IllegalStateException = " + e.getMessage());
                }
            }
            return false;
        }

        public void onImageWriterCreated(ImageWriter imageWriter) {
            if (this.mIsOpened.get()) {
                if (this.mImageWriter != null) {
                    Logger.w(ZslControlImpl.TAG, "ImageWriter already existed in the ImageWriter holder. Closing the previous one.");
                    this.mImageWriter.close();
                }
                this.mImageWriter = imageWriter;
            }
        }

        public void release() {
            deactivate();
            ImageWriter imageWriter = this.mImageWriter;
            if (imageWriter != null) {
                imageWriter.close();
            }
        }
    }

    public ZslControlImpl(CameraCharacteristicsCompat cameraCharacteristicsCompat, Executor executor) {
        this.mIsPrivateReprocessingSupported = false;
        this.mShouldZslDisabledByQuirks = false;
        this.mCameraCharacteristicsCompat = cameraCharacteristicsCompat;
        this.mExecutor = executor;
        this.mIsPrivateReprocessingSupported = ZslUtil.isCapabilitySupported(cameraCharacteristicsCompat, 4);
        this.mShouldZslDisabledByQuirks = DeviceQuirks.get(ZslDisablerQuirk.class) != null;
        this.mImageRingBuffer = new ZslRingBuffer(3, new w(8));
    }

    private void cleanup() {
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mReprocessingImageReader;
        if (safeCloseImageReaderProxy != null) {
            safeCloseImageReaderProxy.clearOnImageAvailableListener();
            this.mReprocessingImageReader = null;
        }
        ImageWriterHolder imageWriterHolder = this.mReprocessingImageWriterHolder;
        if (imageWriterHolder != null) {
            imageWriterHolder.deactivate();
            this.mReprocessingImageWriterHolder = null;
        }
        clearRingBuffer();
        DeferrableSurface deferrableSurface = this.mReprocessingImageDeferrableSurface;
        if (deferrableSurface != null) {
            deferrableSurface.close();
            this.mReprocessingImageDeferrableSurface = null;
        }
    }

    private void clearRingBuffer() {
        ZslRingBuffer zslRingBuffer = this.mImageRingBuffer;
        while (!zslRingBuffer.isEmpty()) {
            zslRingBuffer.dequeue().close();
        }
    }

    private Map<Integer, Size> createReprocessingInputSizeMap(CameraCharacteristicsCompat cameraCharacteristicsCompat) {
        StreamConfigurationMap streamConfigurationMap;
        try {
            streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        } catch (AssertionError e) {
            Logger.e(TAG, "Failed to retrieve StreamConfigurationMap, error = " + e.getMessage());
            streamConfigurationMap = null;
        }
        if (streamConfigurationMap == null || streamConfigurationMap.getInputFormats() == null) {
            return new HashMap();
        }
        HashMap map = new HashMap();
        for (int i2 : streamConfigurationMap.getInputFormats()) {
            Size[] inputSizes = streamConfigurationMap.getInputSizes(i2);
            if (inputSizes != null) {
                Arrays.sort(inputSizes, new CompareSizesByArea(true));
                map.put(Integer.valueOf(i2), inputSizes[0]);
            }
        }
        return map;
    }

    private boolean isJpegValidOutputForInputFormat(CameraCharacteristicsCompat cameraCharacteristicsCompat, int i2) {
        int[] validOutputFormatsForInput;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristicsCompat.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap == null || (validOutputFormatsForInput = streamConfigurationMap.getValidOutputFormatsForInput(i2)) == null) {
            return false;
        }
        for (int i8 : validOutputFormatsForInput) {
            if (i8 == 256) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addZslConfig$0(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                this.mImageRingBuffer.enqueue(imageProxyAcquireLatestImage);
            }
        } catch (IllegalStateException e) {
            Logger.e(TAG, "Failed to acquire latest image IllegalStateException = " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$addZslConfig$1(SafeCloseImageReaderProxy safeCloseImageReaderProxy, ImageWriterHolder imageWriterHolder) {
        safeCloseImageReaderProxy.safeClose();
        imageWriterHolder.release();
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void addZslConfig(SessionConfig.Builder builder) {
        cleanup();
        if (this.mIsZslDisabledByUseCaseConfig) {
            builder.setTemplateType(1);
            return;
        }
        if (this.mShouldZslDisabledByQuirks) {
            builder.setTemplateType(1);
            return;
        }
        Map<Integer, Size> mapCreateReprocessingInputSizeMap = createReprocessingInputSizeMap(this.mCameraCharacteristicsCompat);
        if (!this.mIsPrivateReprocessingSupported || mapCreateReprocessingInputSizeMap.isEmpty() || !mapCreateReprocessingInputSizeMap.containsKey(34) || !isJpegValidOutputForInputFormat(this.mCameraCharacteristicsCompat, 34)) {
            builder.setTemplateType(1);
            return;
        }
        Size size = mapCreateReprocessingInputSizeMap.get(34);
        MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), 34, 9);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = new SafeCloseImageReaderProxy(metadataImageReader);
        Surface surface = safeCloseImageReaderProxy.getSurface();
        Objects.requireNonNull(surface);
        ImmediateSurface immediateSurface = new ImmediateSurface(surface, new Size(safeCloseImageReaderProxy.getWidth(), safeCloseImageReaderProxy.getHeight()), 34);
        final ImageWriterHolder imageWriterHolder = new ImageWriterHolder(this.mExecutor);
        this.mReprocessingImageReader = safeCloseImageReaderProxy;
        this.mReprocessingImageDeferrableSurface = immediateSurface;
        this.mReprocessingImageWriterHolder = imageWriterHolder;
        safeCloseImageReaderProxy.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.camera2.internal.g1
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                this.f3447a.lambda$addZslConfig$0(imageReaderProxy);
            }
        }, CameraXExecutors.ioExecutor());
        immediateSurface.getTerminationFuture().addListener(new j(6, safeCloseImageReaderProxy, imageWriterHolder), this.mExecutor);
        builder.addSurface(immediateSurface);
        builder.addCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
        builder.addSessionStateCallback(new CameraCaptureSession.StateCallback() { // from class: androidx.camera.camera2.internal.ZslControlImpl.1
            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                Surface inputSurface = cameraCaptureSession.getInputSurface();
                if (inputSurface != null) {
                    imageWriterHolder.onImageWriterCreated(ImageWriterCompat.newInstance(inputSurface, 1));
                }
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            }
        });
        builder.setInputConfiguration(new InputConfiguration(safeCloseImageReaderProxy.getWidth(), safeCloseImageReaderProxy.getHeight(), safeCloseImageReaderProxy.getImageFormat()));
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void clearZslConfig() {
        cleanup();
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public ImageProxy dequeueImageFromBuffer() {
        try {
            return this.mImageRingBuffer.dequeue();
        } catch (NoSuchElementException unused) {
            Logger.e(TAG, "dequeueImageFromBuffer no such element");
            return null;
        }
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean enqueueImageToImageWriter(ImageProxy imageProxy) {
        ImageWriterHolder imageWriterHolder = this.mReprocessingImageWriterHolder;
        if (imageWriterHolder != null) {
            return imageWriterHolder.enqueueImageToImageWriter(imageProxy);
        }
        return false;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByFlashMode() {
        return this.mIsZslDisabledByFlashMode;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public boolean isZslDisabledByUserCaseConfig() {
        return this.mIsZslDisabledByUseCaseConfig;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByFlashMode(boolean z2) {
        this.mIsZslDisabledByFlashMode = z2;
    }

    @Override // androidx.camera.camera2.internal.ZslControl
    public void setZslDisabledByUserCaseConfig(boolean z2) {
        if (this.mIsZslDisabledByUseCaseConfig != z2 && z2) {
            clearRingBuffer();
        }
        this.mIsZslDisabledByUseCaseConfig = z2;
    }
}
