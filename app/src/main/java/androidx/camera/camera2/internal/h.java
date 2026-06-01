package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3448a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3450c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3451d;

    public /* synthetic */ h(int i2, ExposureControl exposureControl, CallbackToFutureAdapter.Completer completer) {
        this.f3448a = 2;
        this.f3449b = exposureControl;
        this.f3451d = completer;
        this.f3450c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3448a) {
            case 0:
                ((CameraCaptureCallback) this.f3449b).onCaptureFailed(this.f3450c, (CameraCaptureFailure) this.f3451d);
                break;
            case 1:
                ((CameraCaptureCallback) this.f3449b).onCaptureCompleted(this.f3450c, (CameraCaptureResult) this.f3451d);
                break;
            default:
                ((ExposureControl) this.f3449b).lambda$setExposureCompensationIndex$1((CallbackToFutureAdapter.Completer) this.f3451d, this.f3450c);
                break;
        }
    }

    public /* synthetic */ h(CameraCaptureCallback cameraCaptureCallback, int i2, Object obj, int i8) {
        this.f3448a = i8;
        this.f3449b = cameraCaptureCallback;
        this.f3450c = i2;
        this.f3451d = obj;
    }
}
