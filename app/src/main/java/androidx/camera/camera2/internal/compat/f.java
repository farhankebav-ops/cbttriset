package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSessionCompat.StateCallbackExecutorWrapper f3401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f3402c;

    public /* synthetic */ f(CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int i2) {
        this.f3400a = i2;
        this.f3401b = stateCallbackExecutorWrapper;
        this.f3402c = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3400a) {
            case 0:
                this.f3401b.lambda$onActive$3(this.f3402c);
                break;
            case 1:
                this.f3401b.lambda$onClosed$5(this.f3402c);
                break;
            case 2:
                this.f3401b.lambda$onCaptureQueueEmpty$4(this.f3402c);
                break;
            case 3:
                this.f3401b.lambda$onConfigured$0(this.f3402c);
                break;
            case 4:
                this.f3401b.lambda$onReady$2(this.f3402c);
                break;
            default:
                this.f3401b.lambda$onConfigureFailed$1(this.f3402c);
                break;
        }
    }
}
