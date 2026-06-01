package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y0 extends e3 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12554d;
    public final i4.n1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final x f12555f;
    public final i4.i[] g;

    public y0(i4.n1 n1Var, x xVar, i4.i[] iVarArr) {
        super(0);
        r2.q.y(!n1Var.f(), "error must not be OK");
        this.e = n1Var;
        this.f12555f = xVar;
        this.g = iVarArr;
    }

    @Override // j4.e3, j4.w
    public final void m(y yVar) {
        r2.q.H(!this.f12554d, "already started");
        this.f12554d = true;
        i4.i[] iVarArr = this.g;
        int length = iVarArr.length;
        int i2 = 0;
        while (true) {
            i4.n1 n1Var = this.e;
            if (i2 >= length) {
                yVar.c(n1Var, this.f12555f, new i4.a1());
                return;
            } else {
                iVarArr[i2].m(n1Var);
                i2++;
            }
        }
    }

    @Override // j4.e3, j4.w
    public final void n(l1 l1Var) {
        l1Var.a(this.e, "error");
        l1Var.a(this.f12555f, "progress");
    }
}
