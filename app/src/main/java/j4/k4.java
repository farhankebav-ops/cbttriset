package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12290a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m4 f12291b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ g5 f12292c;

    public /* synthetic */ k4(g5 g5Var, m4 m4Var, int i2) {
        this.f12290a = i2;
        this.f12292c = g5Var;
        this.f12291b = m4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f12290a;
        g5 g5Var = this.f12292c;
        switch (i2) {
            case 0:
                ((g2) g5Var.f12230c).f12205b.execute(new a4.c(this, 14));
                break;
            default:
                g2 g2Var = (g2) g5Var.f12230c;
                i4.v0 v0Var = g2.E;
                g2Var.p(this.f12291b);
                break;
        }
    }
}
