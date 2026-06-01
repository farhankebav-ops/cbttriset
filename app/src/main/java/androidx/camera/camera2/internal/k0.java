package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3472a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f3474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3475d;

    public /* synthetic */ k0(FocusMeteringControl focusMeteringControl, boolean z2, CallbackToFutureAdapter.Completer completer) {
        this.f3475d = focusMeteringControl;
        this.f3474c = z2;
        this.f3473b = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3472a) {
            case 0:
                ((FocusMeteringControl) this.f3475d).lambda$enableExternalFlashAeMode$4(this.f3474c, this.f3473b);
                break;
            default:
                ((LowLightBoostControl) this.f3475d).lambda$enableLowLightBoost$1(this.f3473b, this.f3474c);
                break;
        }
    }

    public /* synthetic */ k0(LowLightBoostControl lowLightBoostControl, CallbackToFutureAdapter.Completer completer, boolean z2) {
        this.f3475d = lowLightBoostControl;
        this.f3473b = completer;
        this.f3474c = z2;
    }
}
