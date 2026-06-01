package j5;

import d5.g0;
import java.util.concurrent.atomic.AtomicReference;
import r2.q;
import s4.g;
import w1.f;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends AtomicReference implements g, o7.b, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.camera.core.impl.b f12582a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f12583b = z4.b.e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r4.c f12584c = z4.b.f17983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g0 f12585d = g0.f11093a;

    public c(androidx.camera.core.impl.b bVar) {
        this.f12582a = bVar;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (get() == k5.f.f12707a) {
            return;
        }
        try {
            this.f12582a.accept(obj);
        } catch (Throwable th) {
            q.y0(th);
            ((o7.b) get()).cancel();
            onError(th);
        }
    }

    @Override // o7.b
    public final void c(long j) {
        ((o7.b) get()).c(j);
    }

    @Override // o7.b
    public final void cancel() {
        k5.f.a(this);
    }

    @Override // u4.b
    public final void dispose() {
        k5.f.a(this);
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.b(this, bVar)) {
            try {
                this.f12585d.accept(this);
            } catch (Throwable th) {
                q.y0(th);
                bVar.cancel();
                onError(th);
            }
        }
    }

    @Override // s4.g
    public final void onComplete() {
        Object obj = get();
        k5.f fVar = k5.f.f12707a;
        if (obj != fVar) {
            lazySet(fVar);
            try {
                this.f12584c.getClass();
            } catch (Throwable th) {
                q.y0(th);
                n7.b.F(th);
            }
        }
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        Object obj = get();
        k5.f fVar = k5.f.f12707a;
        if (obj == fVar) {
            n7.b.F(th);
            return;
        }
        lazySet(fVar);
        try {
            this.f12583b.accept(th);
        } catch (Throwable th2) {
            q.y0(th2);
            n7.b.F(new v4.b(th, th2));
        }
    }
}
