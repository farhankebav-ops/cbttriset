package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l0 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12297c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.x f12298d;
    public final i4.n1 e;

    public l0(m2 m2Var, i4.x xVar, i4.n1 n1Var) {
        super(m2Var.f12316f, 0);
        this.f12298d = xVar;
        this.e = n1Var;
    }

    @Override // j4.h0
    public final void b() {
        switch (this.f12297c) {
            case 0:
                this.f12298d.f(this.e, new i4.a1());
                break;
            default:
                this.f12298d.f(this.e, new i4.a1());
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(h2 h2Var, i4.x xVar, i4.n1 n1Var) {
        super(h2Var.h, 0);
        this.f12298d = xVar;
        this.e = n1Var;
    }
}
