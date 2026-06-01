package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o0 f12375b;

    public /* synthetic */ q0(o0 o0Var, int i2) {
        this.f12374a = i2;
        this.f12375b = o0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12374a) {
            case 0:
                this.f12375b.f12344c.request();
                break;
            case 1:
                this.f12375b.f12344c.j();
                break;
            case 2:
                this.f12375b.g();
                break;
            case 3:
                this.f12375b.f12344c.flush();
                break;
            default:
                this.f12375b.f12344c.l();
                break;
        }
    }
}
