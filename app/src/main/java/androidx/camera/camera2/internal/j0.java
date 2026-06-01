package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j0 implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f3466b;

    public /* synthetic */ j0(FocusMeteringControl focusMeteringControl, int i2) {
        this.f3465a = i2;
        this.f3466b = focusMeteringControl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        switch (this.f3465a) {
            case 0:
                return this.f3466b.lambda$cancelFocusAndMetering$13(completer);
            default:
                return this.f3466b.lambda$triggerAePrecapture$3(completer);
        }
    }
}
