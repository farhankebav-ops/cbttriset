package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12265a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ z1 f12266b;

    public j1(z1 z1Var, long j) {
        this.f12266b = z1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12265a) {
            case 0:
                this.f12266b.getClass();
                break;
            default:
                ((k4.n) this.f12266b.f12563a.f3216b).s(i4.n1.m.h("Keepalive failed. The connection is likely gone"));
                break;
        }
    }

    public j1(z1 z1Var, i4.o1 o1Var) {
        this.f12266b = z1Var;
    }
}
