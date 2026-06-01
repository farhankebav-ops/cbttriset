package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a4.a f12328b;

    public /* synthetic */ n0(a4.a aVar, int i2) {
        this.f12327a = i2;
        this.f12328b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12327a) {
            case 0:
                this.f12328b.m(true);
                break;
            case 1:
                this.f12328b.m(false);
                break;
            default:
                q2 q2Var = (q2) this.f12328b.f3216b;
                r2.q.H(q2Var.G.get(), "Channel must have been shut down");
                q2Var.H = true;
                q2Var.k(false);
                q2.g(q2Var);
                break;
        }
    }
}
