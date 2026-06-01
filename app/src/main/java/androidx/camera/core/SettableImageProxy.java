package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SettableImageProxy extends ForwardingImageProxy {

    @GuardedBy("mLock")
    private Rect mCropRect;
    private final int mHeight;
    private final ImageInfo mImageInfo;
    private final Object mLock;
    private final int mWidth;

    public SettableImageProxy(ImageProxy imageProxy, ImageInfo imageInfo) {
        this(imageProxy, null, imageInfo);
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public Rect getCropRect() {
        synchronized (this.mLock) {
            try {
                if (this.mCropRect == null) {
                    return new Rect(0, 0, getWidth(), getHeight());
                }
                return new Rect(this.mCropRect);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getHeight() {
        return this.mHeight;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImageInfo;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mWidth;
    }

    @Override // androidx.camera.core.ForwardingImageProxy, androidx.camera.core.ImageProxy
    public void setCropRect(Rect rect) {
        if (rect != null) {
            Rect rect2 = new Rect(rect);
            if (!rect2.intersect(0, 0, getWidth(), getHeight())) {
                rect2.setEmpty();
            }
            rect = rect2;
        }
        synchronized (this.mLock) {
            this.mCropRect = rect;
        }
    }

    public SettableImageProxy(ImageProxy imageProxy, Size size, ImageInfo imageInfo) {
        super(imageProxy);
        this.mLock = new Object();
        if (size == null) {
            this.mWidth = super.getWidth();
            this.mHeight = super.getHeight();
        } else {
            this.mWidth = size.getWidth();
            this.mHeight = size.getHeight();
        }
        this.mImageInfo = imageInfo;
    }
}
