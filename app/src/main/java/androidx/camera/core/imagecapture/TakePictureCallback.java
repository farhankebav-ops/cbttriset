package androidx.camera.core.imagecapture;

import android.graphics.Bitmap;
import androidx.annotation.MainThread;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
interface TakePictureCallback {
    boolean isAborted();

    @MainThread
    void onCaptureFailure(ImageCaptureException imageCaptureException);

    void onCaptureProcessProgressed(int i2);

    void onCaptureStarted();

    @MainThread
    void onFinalResult(ImageCapture.OutputFileResults outputFileResults);

    @MainThread
    void onFinalResult(ImageProxy imageProxy);

    @MainThread
    void onImageCaptured();

    void onPostviewBitmapAvailable(Bitmap bitmap);

    @MainThread
    void onProcessFailure(ImageCaptureException imageCaptureException);
}
