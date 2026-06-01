package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a1 implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3364c;

    public /* synthetic */ a1(Object obj, int i2, int i8) {
        this.f3362a = i8;
        this.f3364c = obj;
        this.f3363b = i2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3362a) {
            case 0:
                return ((TorchControl) this.f3364c).lambda$setTorchStrengthLevel$4(this.f3363b, completer);
            default:
                return ((ExposureControl) this.f3364c).lambda$setExposureCompensationIndex$2(this.f3363b, completer);
        }
    }
}
