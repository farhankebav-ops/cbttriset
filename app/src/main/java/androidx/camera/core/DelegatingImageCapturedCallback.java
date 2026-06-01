package androidx.camera.core;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCapture;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
final class DelegatingImageCapturedCallback extends ImageCapture.OnImageCapturedCallback {
    private final AtomicReference<ImageCapture.OnImageCapturedCallback> _delegate;

    public DelegatingImageCapturedCallback(ImageCapture.OnImageCapturedCallback delegate) {
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this._delegate = new AtomicReference<>(delegate);
    }

    private final ImageCapture.OnImageCapturedCallback getDelegate() {
        return this._delegate.get();
    }

    public final void dispose() {
        this._delegate.set(null);
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureProcessProgressed(int i2) {
        ImageCapture.OnImageCapturedCallback delegate = getDelegate();
        if (delegate != null) {
            delegate.onCaptureProcessProgressed(i2);
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureStarted() {
        ImageCapture.OnImageCapturedCallback delegate = getDelegate();
        if (delegate != null) {
            delegate.onCaptureStarted();
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onCaptureSuccess(ImageProxy imageProxy) {
        kotlin.jvm.internal.k.e(imageProxy, "imageProxy");
        ImageCapture.OnImageCapturedCallback delegate = getDelegate();
        if (delegate != null) {
            delegate.onCaptureSuccess(imageProxy);
        } else {
            imageProxy.close();
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onError(ImageCaptureException exception) {
        kotlin.jvm.internal.k.e(exception, "exception");
        ImageCapture.OnImageCapturedCallback delegate = getDelegate();
        if (delegate != null) {
            delegate.onError(exception);
        }
    }

    @Override // androidx.camera.core.ImageCapture.OnImageCapturedCallback
    public void onPostviewBitmapAvailable(Bitmap bitmap) {
        kotlin.jvm.internal.k.e(bitmap, "bitmap");
        ImageCapture.OnImageCapturedCallback delegate = getDelegate();
        if (delegate != null) {
            delegate.onPostviewBitmapAvailable(bitmap);
        }
    }
}
