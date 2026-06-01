package androidx.camera.extensions.internal.compat.workaround;

import android.media.Image;
import android.media.ImageWriter;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.ImageReaderProxys;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.extensions.internal.compat.quirk.CaptureOutputSurfaceOccupiedQuirk;
import androidx.camera.extensions.internal.compat.quirk.DeviceQuirks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@OptIn(markerClass = {ExperimentalGetImage.class})
public class CaptureOutputSurfaceForCaptureProcessor {
    private static final int MAX_IMAGES = 2;
    private static final String TAG = "CaptureOutputSurface";
    private static final long UNSPECIFIED_TIMESTAMP = -1;

    @GuardedBy("mLock")
    private final ImageWriter mImageWriter;

    @GuardedBy("mLock")
    private final ImageReaderProxy mIntermediateImageReader;
    private final boolean mNeedIntermediaSurface;
    private final boolean mNeedOverrideTimestamp;
    private final Surface mOutputSurface;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mIsClosed = false;
    long mOutputImageTimeStamp = -1;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(23)
    public static final class Api23Impl {
        private Api23Impl() {
        }

        public static void setImageTimestamp(Image image, long j) {
            image.setTimestamp(j);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    @RequiresApi(29)
    public static final class ImageWriterCompat {
        private ImageWriterCompat() {
        }

        public static void close(ImageWriter imageWriter) {
            imageWriter.close();
        }

        public static ImageWriter newInstance(Surface surface, int i2, int i8) {
            return ImageWriter.newInstance(surface, i2, i8);
        }

        public static void queueInputImage(ImageWriter imageWriter, Image image) {
            imageWriter.queueInputImage(image);
        }
    }

    public CaptureOutputSurfaceForCaptureProcessor(Surface surface, Size size, boolean z2) {
        this.mNeedOverrideTimestamp = z2;
        boolean z7 = DeviceQuirks.get(CaptureOutputSurfaceOccupiedQuirk.class) != null || z2;
        this.mNeedIntermediaSurface = z7;
        if (Build.VERSION.SDK_INT < 29 || !z7) {
            this.mOutputSurface = surface;
            this.mIntermediateImageReader = null;
            this.mImageWriter = null;
        } else {
            Logger.d(TAG, "Enabling intermediate surface");
            ImageReaderProxy imageReaderProxyCreateIsolatedReader = ImageReaderProxys.createIsolatedReader(size.getWidth(), size.getHeight(), 35, 2);
            this.mIntermediateImageReader = imageReaderProxyCreateIsolatedReader;
            this.mOutputSurface = imageReaderProxyCreateIsolatedReader.getSurface();
            this.mImageWriter = ImageWriterCompat.newInstance(surface, 2, 35);
            imageReaderProxyCreateIsolatedReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.extensions.internal.compat.workaround.a
                @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
                public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                    this.f3767a.lambda$new$0(imageReaderProxy);
                }
            }, CameraXExecutors.directExecutor());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(ImageReaderProxy imageReaderProxy) {
        Image image;
        synchronized (this.mLock) {
            try {
                if (this.mIsClosed) {
                    return;
                }
                ImageProxy imageProxyAcquireNextImage = imageReaderProxy.acquireNextImage();
                if (imageProxyAcquireNextImage != null && (image = imageProxyAcquireNextImage.getImage()) != null) {
                    if (this.mNeedOverrideTimestamp) {
                        long j = this.mOutputImageTimeStamp;
                        if (j != -1) {
                            Api23Impl.setImageTimestamp(image, j);
                        }
                    }
                    ImageWriterCompat.queueInputImage(this.mImageWriter, image);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        synchronized (this.mLock) {
            try {
                this.mIsClosed = true;
                if (Build.VERSION.SDK_INT >= 29 && this.mNeedIntermediaSurface) {
                    this.mIntermediateImageReader.clearOnImageAvailableListener();
                    this.mIntermediateImageReader.close();
                    ImageWriterCompat.close(this.mImageWriter);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Surface getSurface() {
        return this.mOutputSurface;
    }

    public void setOutputImageTimestamp(long j) {
        if (this.mNeedOverrideTimestamp) {
            this.mOutputImageTimeStamp = j;
        }
    }
}
