package e5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r extends AtomicReference implements s4.j, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.j f11291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.c f11292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11293c = true;

    public r(s4.j jVar, x4.c cVar) {
        this.f11291a = jVar;
        this.f11292b = cVar;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        if (y4.a.e(this, bVar)) {
            this.f11291a.a(this);
        }
    }

    @Override // u4.b
    public final void dispose() {
        y4.a.a(this);
    }

    @Override // s4.j
    public final void onComplete() {
        this.f11291a.onComplete();
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        boolean z2 = this.f11293c;
        s4.j jVar = this.f11291a;
        if (!z2 && !(th instanceof Exception)) {
            jVar.onError(th);
            return;
        }
        try {
            Object objApply = this.f11292b.apply(th);
            z4.b.a(objApply, "The resumeFunction returned a null MaybeSource");
            s4.k kVar = (s4.k) objApply;
            y4.a.c(this, null);
            ((s4.h) kVar).b(new android.support.v4.media.g(4, jVar, this));
        } catch (Throwable th2) {
            r2.q.y0(th2);
            jVar.onError(new v4.b(th, th2));
        }
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        this.f11291a.onSuccess(obj);
    }
}
