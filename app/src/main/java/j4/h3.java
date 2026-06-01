package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h3 extends i4.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12243a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12244b;

    public h3(i4.k0 k0Var) {
        r2.q.D(k0Var, "result");
        this.f12244b = k0Var;
    }

    @Override // i4.m0
    public final i4.k0 a(q3 q3Var) {
        switch (this.f12243a) {
            case 0:
                return (i4.k0) this.f12244b;
            default:
                return i4.k0.a((i4.n1) this.f12244b);
        }
    }

    public String toString() {
        switch (this.f12243a) {
            case 0:
                e2.i iVar = new e2.i(h3.class.getSimpleName());
                iVar.c((i4.k0) this.f12244b, "result");
                return iVar.toString();
            default:
                return super.toString();
        }
    }

    public h3(i4.n1 n1Var) {
        this.f12244b = n1Var;
    }
}
