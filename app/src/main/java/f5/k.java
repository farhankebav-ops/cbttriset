package f5;

import com.google.firebase.inappmessaging.internal.s;
import java.util.concurrent.atomic.AtomicInteger;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k extends AtomicInteger implements u4.b, s4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.b f11398a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f11400c;
    public u4.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11402f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5.b f11399b = new l5.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.a f11401d = new u4.a(0);

    public k(s4.b bVar, s sVar) {
        this.f11398a = bVar;
        this.f11400c = sVar;
        lazySet(1);
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (y4.a.f(this.e, bVar)) {
            this.e = bVar;
            this.f11398a.a(this);
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        try {
            Object objApply = this.f11400c.apply(obj);
            z4.b.a(objApply, "The mapper returned a null CompletableSource");
            s4.c cVar = (s4.c) objApply;
            getAndIncrement();
            e5.c cVar2 = new e5.c(this, 3);
            if (this.f11402f || !this.f11401d.a(cVar2)) {
                return;
            }
            ((s4.a) cVar).d(cVar2);
        } catch (Throwable th) {
            q.y0(th);
            this.e.dispose();
            onError(th);
        }
    }

    @Override // u4.b
    public final void dispose() {
        this.f11402f = true;
        this.e.dispose();
        this.f11401d.dispose();
    }

    @Override // s4.m
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            l5.b bVar = this.f11399b;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            s4.b bVar2 = this.f11398a;
            if (thB != null) {
                bVar2.onError(thB);
            } else {
                bVar2.onComplete();
            }
        }
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        l5.b bVar = this.f11399b;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        dispose();
        if (getAndSet(0) > 0) {
            this.f11398a.onError(l5.c.b(bVar));
        }
    }
}
