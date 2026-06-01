package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.CameraBurstCaptureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements CameraBurstCaptureCallback.CaptureSequenceCallback, CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureSession f3428a;

    public /* synthetic */ e0(CaptureSession captureSession) {
        this.f3428a = captureSession;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f3428a.lambda$release$1(completer);
    }

    @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
    public void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i2, boolean z2) {
        this.f3428a.lambda$issueBurstCaptureRequest$3(cameraCaptureSession, i2, z2);
    }
}
