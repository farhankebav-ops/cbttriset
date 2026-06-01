package androidx.camera.core.imagecapture;

import android.hardware.camera2.CameraCharacteristics;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CaptureBundles;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.imagecapture.CaptureNode;
import androidx.camera.core.imagecapture.TakePictureManager;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.w;
import androidx.camera.core.internal.compat.workaround.ExifRotationAvailability;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.InternalImageProcessor;
import androidx.core.util.Pair;
import j2.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ImagePipeline {
    static final ExifRotationAvailability EXIF_ROTATION_AVAILABILITY = new ExifRotationAvailability();
    static final byte JPEG_QUALITY_MAX_QUALITY = 100;
    static final byte JPEG_QUALITY_MIN_LATENCY = 95;
    private static int sNextRequestId;
    private final CaptureConfig mCaptureConfig;
    private final CaptureNode mCaptureNode;
    private final CaptureNode.In mPipelineIn;
    private final ProcessingNode mProcessingNode;
    private final ImageCaptureConfig mUseCaseConfig;

    @MainThread
    @VisibleForTesting
    public ImagePipeline(ImageCaptureConfig imageCaptureConfig, Size size, CameraCharacteristics cameraCharacteristics) {
        this(imageCaptureConfig, size, cameraCharacteristics, null, false, null);
    }

    private CameraRequest createCameraRequest(int i2, CaptureBundle captureBundle, TakePictureRequest takePictureRequest, TakePictureCallback takePictureCallback) {
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(captureBundle.hashCode());
        List<CaptureStage> captureStages = captureBundle.getCaptureStages();
        Objects.requireNonNull(captureStages);
        for (CaptureStage captureStage : captureStages) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.mCaptureConfig.getTemplateType());
            builder.addImplementationOptions(this.mCaptureConfig.getImplementationOptions());
            builder.addAllCameraCaptureCallbacks(takePictureRequest.getSessionConfigCameraCaptureCallbacks());
            builder.addSurface(this.mPipelineIn.getSurface());
            if (this.mPipelineIn.getOutputFormats().size() > 1 && this.mPipelineIn.getSecondarySurface() != null) {
                builder.addSurface(this.mPipelineIn.getSecondarySurface());
            }
            boolean zShouldEnablePostview = shouldEnablePostview();
            if (zShouldEnablePostview) {
                DeferrableSurface postviewSurface = this.mPipelineIn.getPostviewSurface();
                Objects.requireNonNull(postviewSurface);
                builder.addSurface(postviewSurface);
            }
            builder.setPostviewEnabled(zShouldEnablePostview);
            if (ImageUtil.isJpegFormats(this.mPipelineIn.getInputFormat()) || ImageUtil.isRawFormats(this.mPipelineIn.getInputFormat())) {
                if (EXIF_ROTATION_AVAILABILITY.isRotationOptionSupported()) {
                    builder.addImplementationOption(CaptureConfig.OPTION_ROTATION, Integer.valueOf(takePictureRequest.getRotationDegrees()));
                }
                builder.addImplementationOption(CaptureConfig.OPTION_JPEG_QUALITY, Integer.valueOf(getCameraRequestJpegQuality(takePictureRequest)));
            }
            builder.addImplementationOptions(captureStage.getCaptureConfig().getImplementationOptions());
            builder.addTag(strValueOf, Integer.valueOf(captureStage.getId()));
            builder.setId(i2);
            builder.addCameraCaptureCallback(this.mPipelineIn.getCameraCaptureCallback());
            if (this.mPipelineIn.getOutputFormats().size() > 1 && this.mPipelineIn.getSecondaryCameraCaptureCallback() != null) {
                builder.addCameraCaptureCallback(this.mPipelineIn.getSecondaryCameraCaptureCallback());
            }
            arrayList.add(builder.build());
        }
        return new CameraRequest(arrayList, takePictureCallback);
    }

    private CaptureBundle createCaptureBundle() {
        CaptureBundle captureBundle = this.mUseCaseConfig.getCaptureBundle(CaptureBundles.singleDefaultCaptureBundle());
        Objects.requireNonNull(captureBundle);
        return captureBundle;
    }

    private ProcessingRequest createProcessingRequest(int i2, CaptureBundle captureBundle, TakePictureRequest takePictureRequest, TakePictureCallback takePictureCallback, q qVar) {
        return new ProcessingRequest(captureBundle, takePictureRequest, takePictureCallback, qVar, i2);
    }

    private int getOutputFormat() {
        ImageCaptureConfig imageCaptureConfig = this.mUseCaseConfig;
        Config.Option<Integer> option = ImageCaptureConfig.OPTION_BUFFER_FORMAT;
        imageCaptureConfig.getClass();
        Integer num = (Integer) w.g(imageCaptureConfig, option, null);
        if (num != null) {
            return num.intValue();
        }
        ImageCaptureConfig imageCaptureConfig2 = this.mUseCaseConfig;
        Config.Option<Integer> option2 = ImageInputConfig.OPTION_INPUT_FORMAT;
        imageCaptureConfig2.getClass();
        Integer num2 = (Integer) w.g(imageCaptureConfig2, option2, null);
        if (num2 == null || num2.intValue() != 4101) {
            return (num2 == null || num2.intValue() != 32) ? 256 : 32;
        }
        return 4101;
    }

    private boolean shouldEnablePostview() {
        return this.mPipelineIn.getPostviewSurface() != null;
    }

    @MainThread
    public void close() {
        Threads.checkMainThread();
        this.mCaptureNode.release();
        this.mProcessingNode.release();
    }

    @MainThread
    public Pair<CameraRequest, ProcessingRequest> createRequests(TakePictureRequest takePictureRequest, TakePictureCallback takePictureCallback, q qVar) {
        Threads.checkMainThread();
        CaptureBundle captureBundleCreateCaptureBundle = createCaptureBundle();
        int i2 = sNextRequestId;
        sNextRequestId = i2 + 1;
        return new Pair<>(createCameraRequest(i2, captureBundleCreateCaptureBundle, takePictureRequest, takePictureCallback), createProcessingRequest(i2, captureBundleCreateCaptureBundle, takePictureRequest, takePictureCallback, qVar));
    }

    public SessionConfig.Builder createSessionConfigBuilder(Size size) {
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(this.mUseCaseConfig, size);
        builderCreateFrom.addNonRepeatingSurface(this.mPipelineIn.getSurface());
        if (this.mPipelineIn.getOutputFormats().size() > 1 && this.mPipelineIn.getSecondarySurface() != null) {
            builderCreateFrom.addNonRepeatingSurface(this.mPipelineIn.getSecondarySurface());
        }
        if (this.mPipelineIn.getPostviewSurface() != null) {
            builderCreateFrom.setPostviewSurface(this.mPipelineIn.getPostviewSurface());
        }
        return builderCreateFrom;
    }

    @VisibleForTesting
    public boolean expectsMetadata() {
        return this.mCaptureNode.getSafeCloseImageReaderProxy().getImageReaderProxy() instanceof MetadataImageReader;
    }

    public int getCameraRequestJpegQuality(TakePictureRequest takePictureRequest) {
        return ((takePictureRequest.getOnDiskCallback() != null) && TransformUtils.hasCropping(takePictureRequest.getCropRect(), this.mPipelineIn.getSize())) ? takePictureRequest.getCaptureMode() == 0 ? 100 : 95 : takePictureRequest.getJpegQuality();
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        return this.mCaptureNode.getCapacity();
    }

    @VisibleForTesting
    public CaptureNode getCaptureNode() {
        return this.mCaptureNode;
    }

    @VisibleForTesting
    public PostviewSettings getPostviewSettings() {
        return this.mPipelineIn.getPostviewSettings();
    }

    @VisibleForTesting
    public ProcessingNode getProcessingNode() {
        return this.mProcessingNode;
    }

    @MainThread
    public void notifyCaptureError(TakePictureManager.CaptureError captureError) {
        Threads.checkMainThread();
        this.mPipelineIn.getErrorEdge().accept(captureError);
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        this.mCaptureNode.setOnImageCloseListener(onImageCloseListener);
    }

    @MainThread
    public void submitProcessingRequest(ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        this.mPipelineIn.getRequestEdge().accept(processingRequest);
    }

    @MainThread
    public ImagePipeline(ImageCaptureConfig imageCaptureConfig, Size size, CameraCharacteristics cameraCharacteristics, CameraEffect cameraEffect, boolean z2) {
        this(imageCaptureConfig, size, cameraCharacteristics, cameraEffect, z2, null);
    }

    @MainThread
    public ImagePipeline(ImageCaptureConfig imageCaptureConfig, Size size, CameraCharacteristics cameraCharacteristics, CameraEffect cameraEffect, boolean z2, PostviewSettings postviewSettings) {
        Threads.checkMainThread();
        this.mUseCaseConfig = imageCaptureConfig;
        this.mCaptureConfig = CaptureConfig.Builder.createFrom(imageCaptureConfig).build();
        CaptureNode captureNode = new CaptureNode();
        this.mCaptureNode = captureNode;
        Executor ioExecutor = imageCaptureConfig.getIoExecutor(CameraXExecutors.ioExecutor());
        Objects.requireNonNull(ioExecutor);
        ProcessingNode processingNode = new ProcessingNode(ioExecutor, cameraCharacteristics, cameraEffect != null ? new InternalImageProcessor(cameraEffect) : null);
        this.mProcessingNode = processingNode;
        ArrayList arrayList = new ArrayList();
        imageCaptureConfig.getClass();
        if (s.c(imageCaptureConfig) != 0) {
            arrayList.add(32);
            arrayList.add(256);
        } else {
            arrayList.add(Integer.valueOf(getOutputFormat()));
        }
        CaptureNode.In inOf = CaptureNode.In.of(size, imageCaptureConfig.getInputFormat(), arrayList, z2, imageCaptureConfig.getImageReaderProxyProvider(), postviewSettings);
        this.mPipelineIn = inOf;
        processingNode.transform(captureNode.transform(inOf));
    }
}
