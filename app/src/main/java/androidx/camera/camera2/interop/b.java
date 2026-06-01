package androidx.camera.camera2.interop;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3555a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControl f3556b;

    public /* synthetic */ b(Camera2CameraControl camera2CameraControl, int i2) {
        this.f3555a = i2;
        this.f3556b = camera2CameraControl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3555a) {
            case 0:
                return this.f3556b.lambda$addCaptureRequestOptions$3(completer);
            case 1:
                return this.f3556b.lambda$setCaptureRequestOptions$1(completer);
            default:
                return this.f3556b.lambda$clearCaptureRequestOptions$5(completer);
        }
    }
}
