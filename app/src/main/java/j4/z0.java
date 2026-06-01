package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12560a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12562c;

    public z0(i4.n1 n1Var, x xVar) {
        r2.q.y(!n1Var.f(), "error must not be OK");
        this.f12561b = n1Var;
        this.f12562c = xVar;
    }

    @Override // i4.d0
    public final i4.e0 a() {
        switch (this.f12560a) {
            case 0:
                throw new UnsupportedOperationException("Not a real transport");
            default:
                return ((y2) this.f12562c).a();
        }
    }

    @Override // j4.z
    public final w b(i4.c1 c1Var, i4.a1 a1Var, i4.d dVar, i4.i[] iVarArr) {
        int i2 = this.f12560a;
        Object obj = this.f12562c;
        Object obj2 = this.f12561b;
        switch (i2) {
            case 0:
                return new y0((i4.n1) obj2, (x) obj, iVarArr);
            default:
                i4.d dVar2 = i4.d.h;
                r2.q.D(dVar, "callOptions cannot be null");
                i4.i iVarA = ((i4.h) obj2).a(new f2.b(dVar, 0, false), a1Var);
                r2.q.H(iVarArr[iVarArr.length - 1] == f1.f12190o, "lb tracer already assigned");
                iVarArr[iVarArr.length - 1] = iVarA;
                return ((y2) obj).b(c1Var, a1Var, dVar, iVarArr);
        }
    }

    public z0(i4.h hVar, y2 y2Var) {
        this.f12561b = hVar;
        this.f12562c = y2Var;
    }
}
