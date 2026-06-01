package e5;

import d5.a0;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends AtomicReference implements s4.i, u4.b, s4.j, s4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11260a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f11261b;

    public /* synthetic */ c(AtomicInteger atomicInteger, int i2) {
        this.f11260a = i2;
        this.f11261b = atomicInteger;
    }

    @Override // s4.j, s4.r
    public void a(u4.b bVar) {
        switch (this.f11260a) {
            case 1:
                y4.a.e(this, bVar);
                break;
            case 2:
                y4.a.e(this, bVar);
                break;
            default:
                y4.a.e(this, bVar);
                break;
        }
    }

    @Override // u4.b
    public final void dispose() {
        switch (this.f11260a) {
            case 0:
                y4.a.a(this);
                break;
            case 1:
                y4.a.a(this);
                break;
            case 2:
                y4.a.a(this);
                break;
            default:
                y4.a.a(this);
                break;
        }
    }

    @Override // s4.j
    public final void onComplete() {
        u4.b bVar;
        switch (this.f11260a) {
            case 0:
                Object obj = get();
                y4.a aVar = y4.a.f17847a;
                if (obj == aVar || (bVar = (u4.b) getAndSet(aVar)) == aVar) {
                    return;
                }
                try {
                    ((s4.j) this.f11261b).onComplete();
                    if (bVar != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            case 1:
                a0 a0Var = (a0) this.f11261b;
                int i2 = a0Var.f11053b;
                s4.g gVar = a0Var.f11052a;
                AtomicInteger atomicInteger = a0Var.e;
                a0Var.f11055d.c(this);
                if (a0Var.get() == 0) {
                    if (a0Var.compareAndSet(0, 1)) {
                        boolean z2 = atomicInteger.decrementAndGet() == 0;
                        h5.b bVar2 = (h5.b) a0Var.h.get();
                        if (!z2 || (bVar2 != null && !bVar2.isEmpty())) {
                            if (i2 != Integer.MAX_VALUE) {
                                a0Var.f11057i.c(1L);
                            }
                            if (a0Var.decrementAndGet() == 0) {
                                return;
                            }
                            a0Var.g();
                            return;
                        }
                        l5.b bVar3 = a0Var.f11056f;
                        bVar3.getClass();
                        Throwable thB = l5.c.b(bVar3);
                        if (thB != null) {
                            gVar.onError(thB);
                            return;
                        } else {
                            gVar.onComplete();
                            return;
                        }
                    }
                }
                atomicInteger.decrementAndGet();
                if (i2 != Integer.MAX_VALUE) {
                    a0Var.f11057i.c(1L);
                }
                a0Var.d();
                return;
            case 2:
                f5.j jVar = (f5.j) this.f11261b;
                jVar.f11396d.c(this);
                jVar.onComplete();
                return;
            default:
                f5.k kVar = (f5.k) this.f11261b;
                kVar.f11401d.c(this);
                kVar.onComplete();
                return;
        }
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        u4.b bVar;
        switch (this.f11260a) {
            case 0:
                Throwable nullPointerException = th == null ? new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.") : th;
                Object obj = get();
                y4.a aVar = y4.a.f17847a;
                if (obj == aVar || (bVar = (u4.b) getAndSet(aVar)) == aVar) {
                    n7.b.F(th);
                    return;
                }
                try {
                    ((s4.j) this.f11261b).onError(nullPointerException);
                    if (bVar != null) {
                        return;
                    } else {
                        return;
                    }
                } finally {
                    if (bVar != null) {
                        bVar.dispose();
                    }
                }
            case 1:
                a0 a0Var = (a0) this.f11261b;
                u4.a aVar2 = a0Var.f11055d;
                aVar2.c(this);
                l5.b bVar2 = a0Var.f11056f;
                bVar2.getClass();
                if (!l5.c.a(bVar2, th)) {
                    n7.b.F(th);
                    return;
                }
                a0Var.f11057i.cancel();
                aVar2.dispose();
                a0Var.e.decrementAndGet();
                a0Var.d();
                return;
            case 2:
                f5.j jVar = (f5.j) this.f11261b;
                jVar.f11396d.c(this);
                jVar.onError(th);
                return;
            default:
                f5.k kVar = (f5.k) this.f11261b;
                kVar.f11401d.c(this);
                kVar.onError(th);
                return;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0081  */
    @Override // s4.j, s4.r
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSuccess(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f11261b
            d5.a0 r0 = (d5.a0) r0
            u4.a r1 = r0.f11055d
            r1.c(r6)
            int r1 = r0.get()
            if (r1 != 0) goto L81
            r1 = 0
            r2 = 1
            boolean r3 = r0.compareAndSet(r1, r2)
            if (r3 == 0) goto L81
            java.util.concurrent.atomic.AtomicInteger r3 = r0.e
            int r3 = r3.decrementAndGet()
            if (r3 != 0) goto L20
            r1 = r2
        L20:
            java.util.concurrent.atomic.AtomicLong r2 = r0.f11054c
            long r2 = r2.get()
            r4 = 0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 == 0) goto L6e
            s4.g r2 = r0.f11052a
            r2.b(r7)
            java.util.concurrent.atomic.AtomicReference r7 = r0.h
            java.lang.Object r7 = r7.get()
            h5.b r7 = (h5.b) r7
            if (r1 == 0) goto L5a
            if (r7 == 0) goto L43
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L5a
        L43:
            l5.b r7 = r0.f11056f
            r7.getClass()
            java.lang.Throwable r7 = l5.c.b(r7)
            if (r7 == 0) goto L54
            s4.g r0 = r0.f11052a
            r0.onError(r7)
            return
        L54:
            s4.g r7 = r0.f11052a
            r7.onComplete()
            return
        L5a:
            java.util.concurrent.atomic.AtomicLong r7 = r0.f11054c
            r1 = 1
            a.a.P(r7, r1)
            int r7 = r0.f11053b
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r7 == r3) goto L77
            o7.b r7 = r0.f11057i
            r7.c(r1)
            goto L77
        L6e:
            h5.b r1 = r0.h()
            monitor-enter(r1)
            r1.offer(r7)     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7e
        L77:
            int r7 = r0.decrementAndGet()
            if (r7 != 0) goto L96
            goto L95
        L7e:
            r7 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L7e
            throw r7
        L81:
            h5.b r1 = r0.h()
            monitor-enter(r1)
            r1.offer(r7)     // Catch: java.lang.Throwable -> L9a
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9a
            java.util.concurrent.atomic.AtomicInteger r7 = r0.e
            r7.decrementAndGet()
            int r7 = r0.getAndIncrement()
            if (r7 == 0) goto L96
        L95:
            return
        L96:
            r0.g()
            return
        L9a:
            r7 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L9a
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e5.c.onSuccess(java.lang.Object):void");
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public String toString() {
        switch (this.f11260a) {
            case 0:
                return androidx.camera.core.processing.util.a.l(c.class.getSimpleName(), "{", super.toString(), "}");
            default:
                return super.toString();
        }
    }

    public c(s4.j jVar) {
        this.f11260a = 0;
        this.f11261b = jVar;
    }
}
