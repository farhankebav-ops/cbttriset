package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3459a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f3460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3461c;

    public /* synthetic */ i0(Object obj, boolean z2, int i2) {
        this.f3459a = i2;
        this.f3461c = obj;
        this.f3460b = z2;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3459a) {
            case 0:
                return ((FocusMeteringControl) this.f3461c).lambda$enableExternalFlashAeMode$5(this.f3460b, completer);
            default:
                return ((LowLightBoostControl) this.f3461c).lambda$enableLowLightBoost$2(this.f3460b, completer);
        }
    }
}
