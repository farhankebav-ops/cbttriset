package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TorchControl f3377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f3378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f3379d;

    public /* synthetic */ c1(TorchControl torchControl, CallbackToFutureAdapter.Completer completer, int i2, int i8) {
        this.f3376a = i8;
        this.f3377b = torchControl;
        this.f3378c = completer;
        this.f3379d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3376a) {
            case 0:
                this.f3377b.lambda$setTorchStrengthLevel$3(this.f3378c, this.f3379d);
                break;
            default:
                this.f3377b.lambda$enableTorch$1(this.f3378c, this.f3379d);
                break;
        }
    }
}
