package androidx.camera.core;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public class ImageCaptureException extends Exception {
    private final int mImageCaptureError;

    public ImageCaptureException(int i2, String str, Throwable th) {
        super(str, th);
        this.mImageCaptureError = i2;
    }

    public int getImageCaptureError() {
        return this.mImageCaptureError;
    }
}
