package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControlImpl f3366b;

    public /* synthetic */ b(Camera2CameraControlImpl camera2CameraControlImpl, int i2) {
        this.f3365a = i2;
        this.f3366b = camera2CameraControlImpl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3365a) {
            case 0:
                return this.f3366b.lambda$updateSessionConfigAsync$7(completer);
            default:
                return this.f3366b.lambda$isRepeatingRequestAvailable$11(completer);
        }
    }
}
