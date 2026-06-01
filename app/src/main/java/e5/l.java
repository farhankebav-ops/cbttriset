package e5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l extends s4.h implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Callable f11281a;

    public l(Callable callable) {
        this.f11281a = callable;
    }

    @Override // s4.h
    public final void c(s4.j jVar) {
        b5.b bVar = new b5.b(z4.b.f17982b);
        jVar.a(bVar);
        if (bVar.b()) {
            return;
        }
        try {
            Object objCall = this.f11281a.call();
            if (bVar.b()) {
                return;
            }
            if (objCall == null) {
                jVar.onComplete();
            } else {
                jVar.onSuccess(objCall);
            }
        } catch (Throwable th) {
            r2.q.y0(th);
            if (bVar.b()) {
                n7.b.F(th);
            } else {
                jVar.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f11281a.call();
    }
}
