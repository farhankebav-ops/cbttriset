package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n3 extends i4.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12335a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12336b;

    public n3(i4.k0 k0Var) {
        r2.q.D(k0Var, "result");
        this.f12336b = k0Var;
    }

    @Override // i4.m0
    public final i4.k0 a(q3 q3Var) {
        switch (this.f12335a) {
            case 0:
                return (i4.k0) this.f12336b;
            default:
                i4.k0 k0VarA = ((i4.m0) this.f12336b).a(q3Var);
                i4.f fVar = k0VarA.f11884a;
                if (fVar == null) {
                    return k0VarA;
                }
                i4.b bVarD = fVar.d();
                return i4.k0.b(fVar, new q4.r((q4.k) bVarD.f11822a.get(q4.t.f13479n), k0VarA.f11885b));
        }
    }

    public String toString() {
        switch (this.f12335a) {
            case 0:
                e2.i iVar = new e2.i(n3.class.getSimpleName());
                iVar.c((i4.k0) this.f12336b, "result");
                return iVar.toString();
            default:
                return super.toString();
        }
    }

    public n3(i4.m0 m0Var) {
        this.f12336b = m0Var;
    }
}
