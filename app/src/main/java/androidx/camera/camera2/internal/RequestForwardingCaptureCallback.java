package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final class RequestForwardingCaptureCallback extends CameraCaptureSession.CaptureCallback {
    private final CameraCaptureSession.CaptureCallback delegate;
    private final CaptureRequest forwardedRequest;

    public RequestForwardingCaptureCallback(CaptureRequest forwardedRequest, CameraCaptureSession.CaptureCallback delegate) {
        kotlin.jvm.internal.k.e(forwardedRequest, "forwardedRequest");
        kotlin.jvm.internal.k.e(delegate, "delegate");
        this.forwardedRequest = forwardedRequest;
        this.delegate = delegate;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    @RequiresApi(24)
    public void onCaptureBufferLost(CameraCaptureSession session, CaptureRequest request, Surface target, long j) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(target, "target");
        this.delegate.onCaptureBufferLost(session, this.forwardedRequest, target, j);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureCompleted(CameraCaptureSession session, CaptureRequest request, TotalCaptureResult result) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(result, "result");
        this.delegate.onCaptureCompleted(session, this.forwardedRequest, result);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession session, CaptureRequest request, CaptureFailure failure) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(failure, "failure");
        this.delegate.onCaptureFailed(session, this.forwardedRequest, failure);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession session, CaptureRequest request, CaptureResult partialResult) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        kotlin.jvm.internal.k.e(partialResult, "partialResult");
        this.delegate.onCaptureProgressed(session, this.forwardedRequest, partialResult);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession session, int i2) {
        kotlin.jvm.internal.k.e(session, "session");
        this.delegate.onCaptureSequenceAborted(session, i2);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession session, int i2, long j) {
        kotlin.jvm.internal.k.e(session, "session");
        this.delegate.onCaptureSequenceCompleted(session, i2, j);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession session, CaptureRequest request, long j, long j3) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        this.delegate.onCaptureStarted(session, this.forwardedRequest, j, j3);
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    @RequiresApi(34)
    public void onReadoutStarted(CameraCaptureSession session, CaptureRequest request, long j, long j3) {
        kotlin.jvm.internal.k.e(session, "session");
        kotlin.jvm.internal.k.e(request, "request");
        this.delegate.onReadoutStarted(session, this.forwardedRequest, j, j3);
    }
}
