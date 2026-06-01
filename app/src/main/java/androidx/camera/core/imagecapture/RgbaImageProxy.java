package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageInfo;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.a0;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.processing.Packet;
import androidx.camera.core.y;
import androidx.core.util.Preconditions;
import java.nio.ByteBuffer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class RgbaImageProxy implements ImageProxy {
    private final Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;

    @GuardedBy("mLock")
    ImageProxy.PlaneProxy[] mPlaneProxy;
    private final int mWidth;

    public RgbaImageProxy(Packet<Bitmap> packet) {
        this(packet.getData(), packet.getCropRect(), packet.getRotationDegrees(), packet.getSensorToBufferTransform(), packet.getCameraCaptureResult().getTimestamp());
    }

    private void checkNotClosed() {
        synchronized (this.mLock) {
            Preconditions.checkState(this.mPlaneProxy != null, "The image is closed.");
        }
    }

    private static ImageInfo createImageInfo(final long j, final int i2, final Matrix matrix) {
        return new ImageInfo() { // from class: androidx.camera.core.imagecapture.RgbaImageProxy.2
            @Override // androidx.camera.core.ImageInfo
            public final /* synthetic */ int getFlashState() {
                return y.a(this);
            }

            @Override // androidx.camera.core.ImageInfo
            public int getRotationDegrees() {
                return i2;
            }

            @Override // androidx.camera.core.ImageInfo
            public Matrix getSensorToBufferTransformMatrix() {
                return new Matrix(matrix);
            }

            @Override // androidx.camera.core.ImageInfo
            public TagBundle getTagBundle() {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain TagBundle");
            }

            @Override // androidx.camera.core.ImageInfo
            public long getTimestamp() {
                return j;
            }

            @Override // androidx.camera.core.ImageInfo
            public void populateExifData(ExifData.Builder builder) {
                throw new UnsupportedOperationException("Custom ImageProxy does not contain Exif data.");
            }
        };
    }

    private static ImageProxy.PlaneProxy createPlaneProxy(final ByteBuffer byteBuffer, final int i2, final int i8) {
        return new ImageProxy.PlaneProxy() { // from class: androidx.camera.core.imagecapture.RgbaImageProxy.1
            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public ByteBuffer getBuffer() {
                return byteBuffer;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getPixelStride() {
                return i8;
            }

            @Override // androidx.camera.core.ImageProxy.PlaneProxy
            public int getRowStride() {
                return i2;
            }
        };
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        synchronized (this.mLock) {
            checkNotClosed();
            this.mPlaneProxy = null;
        }
    }

    public Bitmap createBitmap() {
        Bitmap bitmapCreateBitmapFromPlane;
        synchronized (this.mLock) {
            checkNotClosed();
            bitmapCreateBitmapFromPlane = ImageUtil.createBitmapFromPlane(getPlanes(), getWidth(), getHeight());
        }
        return bitmapCreateBitmapFromPlane;
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        Rect rect;
        synchronized (this.mLock) {
            checkNotClosed();
            rect = this.mCropRect;
        }
        return rect;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return 1;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        int i2;
        synchronized (this.mLock) {
            checkNotClosed();
            i2 = this.mHeight;
        }
        return i2;
    }

    @Override // androidx.camera.core.ImageProxy
    @ExperimentalGetImage
    public Image getImage() {
        synchronized (this.mLock) {
            checkNotClosed();
        }
        return null;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        ImageInfo imageInfo;
        synchronized (this.mLock) {
            checkNotClosed();
            imageInfo = this.mImageInfo;
        }
        return imageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        ImageProxy.PlaneProxy[] planeProxyArr;
        synchronized (this.mLock) {
            checkNotClosed();
            ImageProxy.PlaneProxy[] planeProxyArr2 = this.mPlaneProxy;
            Objects.requireNonNull(planeProxyArr2);
            planeProxyArr = planeProxyArr2;
        }
        return planeProxyArr;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        int i2;
        synchronized (this.mLock) {
            checkNotClosed();
            i2 = this.mWidth;
        }
        return i2;
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect rect) {
        synchronized (this.mLock) {
            try {
                checkNotClosed();
                if (rect != null) {
                    this.mCropRect.set(rect);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return a0.a(this);
    }

    public RgbaImageProxy(Bitmap bitmap, Rect rect, int i2, Matrix matrix, long j) {
        this(ImageUtil.createDirectByteBuffer(bitmap), 4, bitmap.getWidth(), bitmap.getHeight(), rect, i2, matrix, j);
    }

    public RgbaImageProxy(ByteBuffer byteBuffer, int i2, int i8, int i9, Rect rect, int i10, Matrix matrix, long j) {
        this.mLock = new Object();
        this.mWidth = i8;
        this.mHeight = i9;
        this.mCropRect = rect;
        this.mImageInfo = createImageInfo(j, i10, matrix);
        byteBuffer.rewind();
        this.mPlaneProxy = new ImageProxy.PlaneProxy[]{createPlaneProxy(byteBuffer, i8 * i2, i2)};
    }
}
