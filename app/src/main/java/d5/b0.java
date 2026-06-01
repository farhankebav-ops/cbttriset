package d5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b0 extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11064c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11065d;
    public final Object e;

    public b0(x xVar, int i2) {
        super(xVar);
        this.e = z4.b.f17981a;
        this.f11065d = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.d
    public final void e(s4.g gVar) {
        switch (this.f11064c) {
            case 0:
                this.f11051b.d(new a0(gVar, (x4.c) this.e, this.f11065d));
                break;
            case 1:
                r4.c cVar = (r4.c) this.e;
                s4.d dVar = this.f11051b;
                if (!(dVar instanceof Callable)) {
                    dVar.d(new c0(gVar, cVar, this.f11065d));
                } else {
                    try {
                        Object objCall = ((Callable) dVar).call();
                        if (objCall == null) {
                            k5.d.a(gVar);
                        } else {
                            try {
                                cVar.getClass();
                                m.f(gVar, ((Iterable) objCall).iterator());
                            } catch (Throwable th) {
                                r2.q.y0(th);
                                k5.d.b(th, gVar);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        r2.q.y0(th2);
                        k5.d.b(th2, gVar);
                        return;
                    }
                }
                break;
            default:
                s4.o oVarA = ((s4.p) this.e).a();
                boolean z2 = gVar instanceof a5.a;
                int i2 = this.f11065d;
                s4.d dVar2 = this.f11051b;
                if (!z2) {
                    dVar2.d(new k0(gVar, oVarA, i2));
                } else {
                    dVar2.d(new j0((a5.a) gVar, oVarA, i2));
                }
                break;
        }
    }

    public b0(s4.d dVar, s4.p pVar, int i2) {
        super(dVar);
        this.e = pVar;
        this.f11065d = i2;
    }

    public b0(s4.d dVar, x4.c cVar) {
        super(dVar);
        this.e = cVar;
        this.f11065d = Integer.MAX_VALUE;
    }
}
