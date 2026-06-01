package q4;

import i4.j0;
import i4.m0;
import i4.o0;
import j4.n3;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13433a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f13434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ o0 f13435c;

    public d(e eVar) {
        this.f13435c = eVar;
    }

    @Override // q4.a, i4.x
    public i4.f a(j0 j0Var) {
        switch (this.f13433a) {
            case 1:
                t tVar = (t) this.f13435c;
                l lVar = tVar.f13480f;
                s sVar = new s(tVar, j0Var, (h) this.f13434b);
                List list = j0Var.f11878b;
                if (t.g(list)) {
                    if (lVar.f13458a.containsKey(((i4.u) list.get(0)).f11961a.get(0))) {
                        k kVar = (k) lVar.f13458a.get(((i4.u) list.get(0)).f11961a.get(0));
                        kVar.a(sVar);
                        if (kVar.f13456d != null) {
                            sVar.u();
                        }
                    }
                }
                return sVar;
            default:
                return super.a(j0Var);
        }
    }

    @Override // q4.a, i4.x
    public final void n(i4.m mVar, m0 m0Var) {
        switch (this.f13433a) {
            case 0:
                o0 o0Var = (o0) this.f13434b;
                e eVar = (e) this.f13435c;
                o0 o0Var2 = eVar.k;
                i4.m mVar2 = i4.m.f11895b;
                if (o0Var == o0Var2) {
                    r2.q.H(eVar.f13439n, "there's pending lb while current lb has been out of READY");
                    eVar.l = mVar;
                    eVar.m = m0Var;
                    if (mVar == mVar2) {
                        eVar.h();
                    }
                } else if (o0Var == eVar.f13438i) {
                    boolean z2 = mVar == mVar2;
                    eVar.f13439n = z2;
                    if (z2 || o0Var2 == eVar.f13437f) {
                        eVar.g.n(mVar, m0Var);
                    } else {
                        eVar.h();
                    }
                }
                break;
            default:
                ((h) this.f13434b).n(mVar, new n3(m0Var));
                break;
        }
    }

    @Override // q4.a
    public final i4.x o() {
        switch (this.f13433a) {
            case 0:
                return ((e) this.f13435c).g;
            default:
                return (h) this.f13434b;
        }
    }

    public d(t tVar, i4.x xVar) {
        this.f13435c = tVar;
        this.f13434b = new h(xVar, 0);
    }
}
