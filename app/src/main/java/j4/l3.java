package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l3 implements i4.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i4.f f12302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o3 f12303b;

    public l3(o3 o3Var, i4.f fVar) {
        this.f12303b = o3Var;
        this.f12302a = fVar;
    }

    @Override // i4.n0
    public final void a(i4.n nVar) {
        i4.m0 n3Var;
        o3 o3Var = this.f12303b;
        i4.x xVar = o3Var.f12351f;
        i4.m mVar = nVar.f11911a;
        if (mVar == i4.m.e) {
            return;
        }
        i4.m mVar2 = i4.m.f11897d;
        i4.m mVar3 = i4.m.f11896c;
        if (mVar == mVar3 || mVar == mVar2) {
            xVar.k();
        }
        if (o3Var.h == mVar3) {
            if (mVar == i4.m.f11894a) {
                return;
            }
            if (mVar == mVar2) {
                o3Var.e();
                return;
            }
        }
        int iOrdinal = mVar.ordinal();
        if (iOrdinal != 0) {
            i4.f fVar = this.f12302a;
            if (iOrdinal == 1) {
                n3Var = new n3(i4.k0.b(fVar, null));
            } else if (iOrdinal == 2) {
                n3Var = new n3(i4.k0.a(nVar.f11912b));
            } else {
                if (iOrdinal != 3) {
                    throw new IllegalArgumentException("Unsupported state:" + mVar);
                }
                n3Var = new i3(o3Var, fVar);
            }
        } else {
            n3Var = new n3(i4.k0.e);
        }
        o3Var.h = mVar;
        xVar.n(mVar, n3Var);
    }
}
