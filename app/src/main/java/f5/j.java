package f5;

import com.google.firebase.inappmessaging.internal.s;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j extends b5.a implements s4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11393a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s f11395c;
    public u4.b e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11397f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l5.b f11394b = new l5.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.a f11396d = new u4.a(0);

    public j(s4.m mVar, s sVar) {
        this.f11393a = mVar;
        this.f11395c = sVar;
        lazySet(1);
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (y4.a.f(this.e, bVar)) {
            this.e = bVar;
            this.f11393a.a(this);
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        try {
            Object objApply = this.f11395c.apply(obj);
            z4.b.a(objApply, "The mapper returned a null CompletableSource");
            s4.c cVar = (s4.c) objApply;
            getAndIncrement();
            e5.c cVar2 = new e5.c(this, 2);
            if (this.f11397f || !this.f11396d.a(cVar2)) {
                return;
            }
            ((s4.a) cVar).d(cVar2);
        } catch (Throwable th) {
            q.y0(th);
            this.e.dispose();
            onError(th);
        }
    }

    @Override // a5.d
    public final int d(int i2) {
        return 2;
    }

    @Override // u4.b
    public final void dispose() {
        this.f11397f = true;
        this.e.dispose();
        this.f11396d.dispose();
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return true;
    }

    @Override // s4.m
    public final void onComplete() {
        if (decrementAndGet() == 0) {
            l5.b bVar = this.f11394b;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            s4.m mVar = this.f11393a;
            if (thB != null) {
                mVar.onError(thB);
            } else {
                mVar.onComplete();
            }
        }
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        l5.b bVar = this.f11394b;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        dispose();
        if (getAndSet(0) > 0) {
            this.f11393a.onError(l5.c.b(bVar));
        }
    }

    @Override // a5.h
    public final Object poll() {
        return null;
    }

    @Override // a5.h
    public final void clear() {
    }
}
