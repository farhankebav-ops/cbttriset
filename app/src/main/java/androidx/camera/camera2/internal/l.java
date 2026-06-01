package androidx.camera.camera2.internal;

import androidx.camera.camera2.internal.MeteringRepeatingSession;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements CallbackToFutureAdapter.Resolver, MeteringRepeatingSession.SurfaceResetCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f3477b;

    public /* synthetic */ l(Camera2CameraImpl camera2CameraImpl, int i2) {
        this.f3476a = i2;
        this.f3477b = camera2CameraImpl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3476a) {
            case 0:
                return this.f3477b.lambda$release$5(completer);
            case 1:
            default:
                return this.f3477b.lambda$isMeteringRepeatingAttached$14(completer);
            case 2:
                return this.f3477b.lambda$getOrCreateUserReleaseFuture$6(completer);
            case 3:
                return this.f3477b.lambda$openCameraConfigAndClose$1(completer);
        }
    }

    @Override // androidx.camera.camera2.internal.MeteringRepeatingSession.SurfaceResetCallback
    public void onSurfaceReset() {
        this.f3477b.lambda$addOrRemoveMeteringRepeatingUseCase$18();
    }
}
