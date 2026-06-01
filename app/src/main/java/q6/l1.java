package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l1 extends j1 {
    public final n1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final m1 f13564f;
    public final p g;
    public final Object h;

    public l1(n1 n1Var, m1 m1Var, p pVar, Object obj) {
        this.e = n1Var;
        this.f13564f = m1Var;
        this.g = pVar;
        this.h = obj;
    }

    @Override // q6.j1
    public final boolean i() {
        return false;
    }

    @Override // q6.j1
    public final void j(Throwable th) {
        p pVar = this.g;
        p pVarQ = n1.Q(pVar);
        n1 n1Var = this.e;
        m1 m1Var = this.f13564f;
        Object obj = this.h;
        if (pVarQ == null || !n1Var.Z(m1Var, pVarQ, obj)) {
            m1Var.f13571a.c(new v6.h(2), 2);
            p pVarQ2 = n1.Q(pVar);
            if (pVarQ2 == null || !n1Var.Z(m1Var, pVarQ2, obj)) {
                n1Var.r(n1Var.B(m1Var, obj));
            }
        }
    }
}
