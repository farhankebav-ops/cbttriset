package e5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class x extends AtomicReference implements s4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f11306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11307b;

    public x(w wVar, int i2) {
        this.f11306a = wVar;
        this.f11307b = i2;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        y4.a.e(this, bVar);
    }

    @Override // s4.j
    public final void onComplete() {
        w wVar = this.f11306a;
        if (wVar.getAndSet(0) > 0) {
            wVar.a(this.f11307b);
            wVar.f11302a.onComplete();
        }
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        w wVar = this.f11306a;
        if (wVar.getAndSet(0) <= 0) {
            n7.b.F(th);
        } else {
            wVar.a(this.f11307b);
            wVar.f11302a.onError(th);
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        w wVar = this.f11306a;
        s4.j jVar = wVar.f11302a;
        Object[] objArr = wVar.f11305d;
        objArr[this.f11307b] = obj;
        if (wVar.decrementAndGet() == 0) {
            try {
                Object objApply = wVar.f11303b.apply(objArr);
                z4.b.a(objApply, "The zipper returned a null value");
                jVar.onSuccess(objApply);
            } catch (Throwable th) {
                r2.q.y0(th);
                jVar.onError(th);
            }
        }
    }
}
