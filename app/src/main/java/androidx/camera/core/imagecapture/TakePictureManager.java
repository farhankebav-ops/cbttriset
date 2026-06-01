package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ImageCaptureException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface TakePictureManager {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static abstract class CaptureError {
        public static CaptureError of(int i2, ImageCaptureException imageCaptureException) {
            return new AutoValue_TakePictureManager_CaptureError(i2, imageCaptureException);
        }

        public abstract ImageCaptureException getImageCaptureException();

        public abstract int getRequestId();
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Provider {
        TakePictureManager newInstance(ImageCaptureControl imageCaptureControl);
    }

    @MainThread
    void abortRequests();

    @VisibleForTesting
    RequestWithCallback getCapturingRequest();

    @VisibleForTesting
    ImagePipeline getImagePipeline();

    @VisibleForTesting
    List<RequestWithCallback> getIncompleteRequests();

    @VisibleForTesting
    boolean hasCapturingRequest();

    @MainThread
    void offerRequest(TakePictureRequest takePictureRequest);

    @MainThread
    void pause();

    @MainThread
    void resume();

    @MainThread
    void setImagePipeline(ImagePipeline imagePipeline);
}
