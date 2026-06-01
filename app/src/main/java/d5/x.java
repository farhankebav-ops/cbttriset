package d5;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f11157d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ x(s4.d dVar, Object obj, int i2) {
        super(dVar);
        this.f11156c = i2;
        this.f11157d = obj;
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        switch (this.f11156c) {
            case 0:
                x4.d dVar = (x4.d) this.f11157d;
                boolean z2 = gVar instanceof a5.a;
                s4.d dVar2 = this.f11051b;
                if (!z2) {
                    dVar2.d(new w(gVar, dVar));
                } else {
                    dVar2.d(new v((a5.a) gVar, dVar, 0));
                }
                break;
            case 1:
                w3.a aVar = (w3.a) this.f11157d;
                boolean z7 = gVar instanceof a5.a;
                s4.d dVar3 = this.f11051b;
                if (!z7) {
                    dVar3.d(new h0(gVar, aVar));
                } else {
                    dVar3.d(new v((a5.a) gVar, aVar, 1));
                }
                break;
            default:
                try {
                    ((l5.a) this.f11157d).getClass();
                    ArrayList arrayList = new ArrayList();
                    s0 s0Var = new s0(gVar);
                    s0Var.f12702b = arrayList;
                    this.f11051b.d(s0Var);
                } catch (Throwable th) {
                    r2.q.y0(th);
                    k5.d.b(th, gVar);
                    return;
                }
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(b0 b0Var) {
        super(b0Var);
        this.f11156c = 2;
        this.f11157d = l5.a.f12821a;
    }
}
