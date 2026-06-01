package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.compat.CameraCaptureSessionCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper f3385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f3386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f3387d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Object obj, int i2) {
        this.f3384a = i2;
        this.f3385b = captureCallbackExecutorWrapper;
        this.f3386c = cameraCaptureSession;
        this.f3387d = captureRequest;
        this.e = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3384a) {
            case 0:
                this.f3385b.lambda$onCaptureCompleted$2(this.f3386c, this.f3387d, (TotalCaptureResult) this.e);
                break;
            case 1:
                this.f3385b.lambda$onCaptureProgressed$1(this.f3386c, this.f3387d, (CaptureResult) this.e);
                break;
            default:
                this.f3385b.lambda$onCaptureFailed$3(this.f3386c, this.f3387d, (CaptureFailure) this.e);
                break;
        }
    }
}
