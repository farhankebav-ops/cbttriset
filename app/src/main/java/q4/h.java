package q4;

import i4.j0;
import i4.m0;
import i4.n0;
import i4.o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13445b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f13444a = i2;
        this.f13445b = obj;
    }

    @Override // q4.a, i4.x
    public i4.f a(j0 j0Var) {
        switch (this.f13444a) {
            case 0:
                n0 n0Var = (n0) j0Var.b();
                i4.f fVarA = super.a(j0Var);
                if (n0Var != null) {
                    return fVarA.d().f11822a.get(o0.f11924d) == null ? new g(fVarA, n0Var) : fVarA;
                }
                return fVarA;
            default:
                return super.a(j0Var);
        }
    }

    @Override // q4.a, i4.x
    public void n(i4.m mVar, m0 m0Var) {
        switch (this.f13444a) {
            case 1:
                i iVar = (i) this.f13445b;
                x xVar = iVar.g;
                if (xVar.f13485f.containsKey(iVar.f13446a)) {
                    iVar.f13449d = mVar;
                    iVar.e = m0Var;
                    if (!iVar.f13450f && !xVar.h) {
                        if (mVar == i4.m.f11897d) {
                            iVar.f13447b.e();
                        }
                        xVar.j();
                        break;
                    }
                }
                break;
            default:
                super.n(mVar, m0Var);
                break;
        }
    }

    @Override // q4.a
    public final i4.x o() {
        switch (this.f13444a) {
            case 0:
                return (i4.x) this.f13445b;
            default:
                return ((i) this.f13445b).g.g;
        }
    }
}
