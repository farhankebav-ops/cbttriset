package androidx.camera.camera2.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FocusMeteringControl f3453b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f3454c;

    public /* synthetic */ h0(int i2, long j, FocusMeteringControl focusMeteringControl) {
        this.f3452a = i2;
        this.f3453b = focusMeteringControl;
        this.f3454c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3452a) {
            case 0:
                this.f3453b.lambda$executeMeteringAction$10(this.f3454c);
                break;
            case 1:
                this.f3453b.lambda$executeMeteringAction$8(this.f3454c);
                break;
            case 2:
                this.f3453b.lambda$executeMeteringAction$9(this.f3454c);
                break;
            default:
                this.f3453b.lambda$executeMeteringAction$11(this.f3454c);
                break;
        }
    }
}
