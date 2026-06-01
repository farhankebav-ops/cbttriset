package androidx.camera.core.impl;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public interface RequestProcessor {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Callback {
        void onCaptureBufferLost(Request request, long j, int i2);

        void onCaptureCompleted(Request request, CameraCaptureResult cameraCaptureResult);

        void onCaptureFailed(Request request, CameraCaptureFailure cameraCaptureFailure);

        void onCaptureProgressed(Request request, CameraCaptureResult cameraCaptureResult);

        void onCaptureSequenceAborted(int i2);

        void onCaptureSequenceCompleted(int i2, long j);

        void onCaptureStarted(Request request, long j, long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public interface Request {
        Config getParameters();

        List<Integer> getTargetOutputConfigIds();

        int getTemplateId();
    }

    void abortCaptures();

    int setRepeating(Request request, Callback callback);

    void stopRepeating();

    int submit(Request request, Callback callback);

    int submit(List<Request> list, Callback callback);
}
