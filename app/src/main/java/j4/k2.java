package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k2 extends i4.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j2 f12284d;
    public final i4.x e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ q2 f12285f;

    public k2(q2 q2Var, j2 j2Var, r4 r4Var) {
        this.f12285f = q2Var;
        this.f12284d = j2Var;
        r2.q.D(r4Var, "resolver");
        this.e = r4Var;
    }

    @Override // i4.f
    public final void k(i4.n1 n1Var) {
        r2.q.y(!n1Var.f(), "the error status must not be OK");
        this.f12285f.m.execute(new i0(17, this, n1Var));
    }

    @Override // i4.f
    public final void l(i4.f1 f1Var) {
        this.f12285f.m.execute(new i0(18, this, f1Var));
    }
}
