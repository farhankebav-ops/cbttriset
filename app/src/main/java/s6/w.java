package s6;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import q6.c0;
import q6.g1;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class w extends q6.a implements x, l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f13759d;

    public w(v5.h hVar, h hVar2) {
        super(hVar, true);
        this.f13759d = hVar2;
    }

    @Override // q6.n1, q6.f1
    public final void a(CancellationException cancellationException) {
        if (isCancelled()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new g1(x(), null, this);
        }
        v(cancellationException);
    }

    @Override // q6.a
    public final void a0(boolean z2, Throwable th) {
        if (this.f13759d.i(false, th) || z2) {
            return;
        }
        c0.r(this.f13523c, th);
    }

    @Override // q6.a
    public final void b0(Object obj) {
        this.f13759d.o(null);
    }

    @Override // s6.a0
    public final Object c(Object obj, v5.c cVar) {
        return this.f13759d.c(obj, cVar);
    }

    @Override // s6.a0
    public final Object d(Object obj) {
        return this.f13759d.d(obj);
    }

    public final void d0(v vVar) {
        h hVar = this.f13759d;
        hVar.getClass();
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h.j;
        while (!atomicReferenceFieldUpdater.compareAndSet(hVar, null, vVar)) {
            if (atomicReferenceFieldUpdater.get(hVar) != null) {
                while (true) {
                    Object obj = atomicReferenceFieldUpdater.get(hVar);
                    e2.f fVar = j.f13745q;
                    if (obj != fVar) {
                        if (obj == j.f13746r) {
                            throw new IllegalStateException("Another handler was already registered and successfully invoked");
                        }
                        throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
                    }
                    e2.f fVar2 = j.f13746r;
                    while (!atomicReferenceFieldUpdater.compareAndSet(hVar, fVar, fVar2)) {
                        if (atomicReferenceFieldUpdater.get(hVar) != fVar) {
                            break;
                        }
                    }
                    vVar.invoke(hVar.r());
                    return;
                }
            }
        }
    }

    @Override // s6.z
    public final android.support.v4.media.g h() {
        return this.f13759d.h();
    }

    @Override // s6.z
    public final Object l() {
        return this.f13759d.l();
    }

    @Override // s6.z
    public final Object m(v5.c cVar) {
        return this.f13759d.m(cVar);
    }

    @Override // s6.a0
    public final boolean o(Throwable th) {
        return this.f13759d.i(false, th);
    }

    @Override // s6.z
    public final Object p(u6.i iVar) throws Throwable {
        h hVar = this.f13759d;
        hVar.getClass();
        Object objD = h.D(hVar, iVar);
        w5.a aVar = w5.a.f17774a;
        return objD;
    }

    @Override // q6.n1
    public final void v(CancellationException cancellationException) {
        this.f13759d.i(true, cancellationException);
        u(cancellationException);
    }
}
