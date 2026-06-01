package androidx.camera.core;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.Image;
import androidx.annotation.GuardedBy;
import androidx.annotation.RestrictTo;
import androidx.camera.core.ImageProxy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class ForwardingImageProxy implements ImageProxy {
    protected final ImageProxy mImage;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private final Set<OnImageCloseListener> mOnImageCloseListeners = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface OnImageCloseListener {
        void onImageClose(ImageProxy imageProxy);
    }

    public ForwardingImageProxy(ImageProxy imageProxy) {
        this.mImage = imageProxy;
    }

    public void addOnImageCloseListener(OnImageCloseListener onImageCloseListener) {
        synchronized (this.mLock) {
            this.mOnImageCloseListeners.add(onImageCloseListener);
        }
    }

    @Override // androidx.camera.core.ImageProxy, java.lang.AutoCloseable
    public void close() {
        this.mImage.close();
        notifyOnImageCloseListeners();
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
        return this.mImage.getImage();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageInfo getImageInfo() {
        return this.mImage.getImageInfo();
    }

    @Override // androidx.camera.core.ImageProxy
    public ImageProxy.PlaneProxy[] getPlanes() {
        return this.mImage.getPlanes();
    }

    @Override // androidx.camera.core.ImageProxy
    public int getWidth() {
        return this.mImage.getWidth();
    }

    public void notifyOnImageCloseListeners() {
        HashSet hashSet;
        synchronized (this.mLock) {
            hashSet = new HashSet(this.mOnImageCloseListeners);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            ((OnImageCloseListener) it.next()).onImageClose(this);
        }
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
