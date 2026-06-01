package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.compat.CameraDeviceCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraDeviceCompat.StateCallbackExecutorWrapper f3407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraDevice f3408c;

    public /* synthetic */ h(CameraDeviceCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraDevice cameraDevice, int i2) {
        this.f3406a = i2;
        this.f3407b = stateCallbackExecutorWrapper;
        this.f3408c = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3406a) {
            case 0:
                this.f3407b.lambda$onClosed$3(this.f3408c);
                break;
            case 1:
                this.f3407b.lambda$onDisconnected$1(this.f3408c);
                break;
            default:
                this.f3407b.lambda$onOpened$0(this.f3408c);
                break;
        }
    }
}
