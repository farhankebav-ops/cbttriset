package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.TagBundle;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class AndroidImageProxy implements ImageProxy {
    private final Image mImage;
    private final ImageInfo mImageInfo;
    private final PlaneProxy[] mPlanes;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class PlaneProxy implements ImageProxy.PlaneProxy {
        private final Image.Plane mPlane;

        public PlaneProxy(Image.Plane plane) {
            this.mPlane = plane;
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public ByteBuffer getBuffer() {
            return this.mPlane.getBuffer();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getPixelStride() {
            return this.mPlane.getPixelStride();
        }

        @Override // androidx.camera.core.ImageProxy.PlaneProxy
        public int getRowStride() {
            return this.mPlane.getRowStride();
        }
    }

    public AndroidImageProxy(Image image) {
        this.mImage = image;
        Image.Plane[] planes = image.getPlanes();
        if (planes != null) {
            this.mPlanes = new PlaneProxy[planes.length];
            for (int i2 = 0; i2 < planes.length; i2++) {
                this.mPlanes[i2] = new PlaneProxy(planes[i2]);
            }
        } else {
            this.mPlanes = new PlaneProxy[0];
        }
        this.mImageInfo = ImmutableImageInfo.create(TagBundle.emptyBundle(), image.getTimestamp(), 0, new Matrix(), 0);
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
    }

    @Override // androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        return this.mImage.getCropRect();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getFormat() {
        return this.mImage.getFormat();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mImage.getHeight();
    }

    @Override // androidx.camera.core.ImageProxy
    @ExperimentalGetImage
    public Image getImage() {
        return this.mImage;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mPlanes;
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    @Override // androidx.camera.core.ImageProxy
    public void setCropRect(Rect rect) {
        this.mImage.setCropRect(rect);
    }

    @Override // androidx.camera.core.ImageProxy
    public final /* synthetic */ Bitmap toBitmap() {
        return a0.a(this);
    }
}
