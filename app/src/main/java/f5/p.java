package f5;

import java.util.concurrent.Callable;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends s4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11413a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.workaround.c f11414b;

    public p(Object obj, androidx.camera.camera2.internal.compat.workaround.c cVar) {
        this.f11413a = obj;
        this.f11414b = cVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.l
    public final void d(s4.m mVar) {
        u4.b bVar = y4.b.f17849a;
        try {
            s4.l lVar = (s4.l) this.f11414b.apply(this.f11413a);
            if (!(lVar instanceof Callable)) {
                lVar.c(mVar);
                return;
            }
            try {
                Object objCall = ((Callable) lVar).call();
                if (objCall == null) {
                    mVar.a(bVar);
                    mVar.onComplete();
                } else {
                    o oVar = new o(mVar, objCall);
                    mVar.a(oVar);
                    oVar.run();
                }
            } catch (Throwable th) {
                q.y0(th);
                mVar.a(bVar);
                mVar.onError(th);
            }
        } catch (Throwable th2) {
            mVar.a(bVar);
            mVar.onError(th2);
        }
    }
}
