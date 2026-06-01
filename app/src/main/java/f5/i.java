package f5;

import java.util.concurrent.Callable;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.workaround.c f11391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11392c;

    public i(s4.l lVar, androidx.camera.camera2.internal.compat.workaround.c cVar, int i2) {
        super(lVar);
        this.f11391b = cVar;
        this.f11392c = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.l
    public final void d(s4.m mVar) {
        u4.b bVar = y4.b.f17849a;
        s4.l lVar = this.f11364a;
        boolean z2 = lVar instanceof Callable;
        androidx.camera.camera2.internal.compat.workaround.c cVar = this.f11391b;
        if (!z2) {
            lVar.c(new h(mVar, cVar, this.f11392c));
            return;
        }
        try {
            Object objCall = ((Callable) lVar).call();
            if (objCall == null) {
                mVar.a(bVar);
                mVar.onComplete();
                return;
            }
            try {
                s4.l lVar2 = (s4.l) cVar.apply(objCall);
                if (!(lVar2 instanceof Callable)) {
                    lVar2.c(mVar);
                    return;
                }
                try {
                    Object objCall2 = ((Callable) lVar2).call();
                    if (objCall2 == null) {
                        mVar.a(bVar);
                        mVar.onComplete();
                    } else {
                        o oVar = new o(mVar, objCall2);
                        mVar.a(oVar);
                        oVar.run();
                    }
                } catch (Throwable th) {
                    q.y0(th);
                    mVar.a(bVar);
                    mVar.onError(th);
                }
            } catch (Throwable th2) {
                q.y0(th2);
                mVar.a(bVar);
                mVar.onError(th2);
            }
        } catch (Throwable th3) {
            q.y0(th3);
            mVar.a(bVar);
            mVar.onError(th3);
        }
    }
}
