package d5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r0 extends s4.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x4.c f11146c;

    public r0(Object obj, x4.c cVar) {
        this.f11145b = obj;
        this.f11146c = cVar;
    }

    @Override // s4.d
    public final void e(s4.g gVar) {
        try {
            Object objApply = this.f11146c.apply(this.f11145b);
            z4.b.a(objApply, "The mapper returned a null Publisher");
            o7.a aVar = (o7.a) objApply;
            if (!(aVar instanceof Callable)) {
                aVar.a(gVar);
                return;
            }
            try {
                Object objCall = ((Callable) aVar).call();
                if (objCall == null) {
                    k5.d.a(gVar);
                } else {
                    gVar.f(new k5.e(objCall, gVar));
                }
            } catch (Throwable th) {
                r2.q.y0(th);
                k5.d.b(th, gVar);
            }
        } catch (Throwable th2) {
            k5.d.b(th2, gVar);
        }
    }
}
