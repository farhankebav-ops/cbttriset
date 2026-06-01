package e5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q extends AtomicReference implements s4.j, u4.b, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.j f11287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s4.p f11288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object f11289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Throwable f11290d;

    public q(s4.j jVar, s4.p pVar) {
        this.f11287a = jVar;
        this.f11288b = pVar;
    }

    @Override // s4.j, s4.r
    public final void a(u4.b bVar) {
        if (y4.a.e(this, bVar)) {
            this.f11287a.a(this);
        }
    }

    @Override // u4.b
    public final void dispose() {
        y4.a.a(this);
    }

    @Override // s4.j
    public final void onComplete() {
        y4.a.c(this, this.f11288b.b(this));
    }

    @Override // s4.j, s4.r
    public final void onError(Throwable th) {
        this.f11290d = th;
        y4.a.c(this, this.f11288b.b(this));
    }

    @Override // s4.j, s4.r
    public final void onSuccess(Object obj) {
        this.f11289c = obj;
        y4.a.c(this, this.f11288b.b(this));
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable th = this.f11290d;
        s4.j jVar = this.f11287a;
        if (th != null) {
            this.f11290d = null;
            jVar.onError(th);
            return;
        }
        Object obj = this.f11289c;
        if (obj == null) {
            jVar.onComplete();
        } else {
            this.f11289c = null;
            jVar.onSuccess(obj);
        }
    }
}
