package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g4 extends i4.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m4 f12224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g2 f12226d;

    public g4(g2 g2Var, m4 m4Var) {
        this.f12226d = g2Var;
        this.f12224b = m4Var;
    }

    @Override // i4.i
    public final void l(long j) {
        if (this.f12226d.f12211o.f12277f != null) {
            return;
        }
        synchronized (this.f12226d.f12209i) {
            try {
                if (this.f12226d.f12211o.f12277f == null) {
                    m4 m4Var = this.f12224b;
                    if (!m4Var.f12323b) {
                        long j3 = this.f12225c + j;
                        this.f12225c = j3;
                        g2 g2Var = this.f12226d;
                        long j8 = g2Var.f12215t;
                        if (j3 <= j8) {
                            return;
                        }
                        if (j3 > g2Var.k) {
                            m4Var.f12324c = true;
                        } else {
                            long jAddAndGet = g2Var.j.f12198a.addAndGet(j3 - j8);
                            g2 g2Var2 = this.f12226d;
                            g2Var2.f12215t = this.f12225c;
                            if (jAddAndGet > g2Var2.l) {
                                this.f12224b.f12324c = true;
                            }
                        }
                        m4 m4Var2 = this.f12224b;
                        z3 z3VarF = m4Var2.f12324c ? this.f12226d.f(m4Var2) : null;
                        if (z3VarF != null) {
                            z3VarF.run();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
