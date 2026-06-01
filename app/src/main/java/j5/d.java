package j5;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import k5.f;
import s4.g;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d extends AtomicInteger implements g, o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f12586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5.b f12587b = new l5.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f12588c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f12589d = new AtomicReference();
    public final AtomicBoolean e = new AtomicBoolean();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f12590f;

    public d(g gVar) {
        this.f12586a = gVar;
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (get() == 0 && compareAndSet(0, 1)) {
            g gVar = this.f12586a;
            gVar.b(obj);
            if (decrementAndGet() != 0) {
                l5.b bVar = this.f12587b;
                bVar.getClass();
                Throwable thB = l5.c.b(bVar);
                if (thB != null) {
                    gVar.onError(thB);
                } else {
                    gVar.onComplete();
                }
            }
        }
    }

    @Override // o7.b
    public final void c(long j) {
        if (j <= 0) {
            cancel();
            onError(new IllegalArgumentException(androidx.camera.core.processing.util.a.j("§3.9 violated: positive request amount required but it was ", j)));
            return;
        }
        AtomicReference atomicReference = this.f12589d;
        o7.b bVar = (o7.b) atomicReference.get();
        if (bVar != null) {
            bVar.c(j);
            return;
        }
        if (f.d(j)) {
            AtomicLong atomicLong = this.f12588c;
            a.a.f(atomicLong, j);
            o7.b bVar2 = (o7.b) atomicReference.get();
            if (bVar2 != null) {
                long andSet = atomicLong.getAndSet(0L);
                if (andSet != 0) {
                    bVar2.c(andSet);
                }
            }
        }
    }

    @Override // o7.b
    public final void cancel() {
        if (this.f12590f) {
            return;
        }
        f.a(this.f12589d);
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (!this.e.compareAndSet(false, true)) {
            bVar.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
            return;
        }
        this.f12586a.f(this);
        if (f.b(this.f12589d, bVar)) {
            long andSet = this.f12588c.getAndSet(0L);
            if (andSet != 0) {
                bVar.c(andSet);
            }
        }
    }

    @Override // s4.g
    public final void onComplete() {
        this.f12590f = true;
        g gVar = this.f12586a;
        l5.b bVar = this.f12587b;
        if (getAndIncrement() == 0) {
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            if (thB != null) {
                gVar.onError(thB);
            } else {
                gVar.onComplete();
            }
        }
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        this.f12590f = true;
        g gVar = this.f12586a;
        l5.b bVar = this.f12587b;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
        } else if (getAndIncrement() == 0) {
            gVar.onError(l5.c.b(bVar));
        }
    }
}
