package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class m0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f3485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3486c;

    public /* synthetic */ m0(FocusMeteringControl focusMeteringControl, CallbackToFutureAdapter.Completer completer, int i2) {
        this.f3484a = i2;
        this.f3485b = focusMeteringControl;
        this.f3486c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3484a) {
            case 0:
                this.f3485b.lambda$cancelFocusAndMetering$12(this.f3486c);
                break;
            default:
                this.f3485b.lambda$triggerAePrecapture$2(this.f3486c);
                break;
        }
    }
}
