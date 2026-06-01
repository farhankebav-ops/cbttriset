package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s0 implements Camera2CameraControlImpl.CaptureResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3520b;

    public /* synthetic */ s0(Object obj, int i2) {
        this.f3519a = i2;
        this.f3520b = obj;
    }

    @Override // androidx.camera.camera2.internal.Camera2CameraControlImpl.CaptureResultListener
    public final boolean onCaptureResult(TotalCaptureResult totalCaptureResult) {
        switch (this.f3519a) {
            case 0:
                return ((LowLightBoostControl) this.f3520b).lambda$new$0(totalCaptureResult);
            default:
                return ((TorchControl) this.f3520b).lambda$new$0(totalCaptureResult);
        }
    }
}
