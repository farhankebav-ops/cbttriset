package f5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g extends AtomicReference implements s4.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f11380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile a5.h f11382d;
    public int e;

    public g(h hVar, long j) {
        this.f11379a = j;
        this.f11380b = hVar;
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (y4.a.e(this, bVar) && (bVar instanceof a5.c)) {
            a5.c cVar = (a5.c) bVar;
            int iD = cVar.d(7);
            if (iD == 1) {
                this.e = iD;
                this.f11382d = cVar;
                this.f11381c = true;
                this.f11380b.e();
                return;
            }
            if (iD == 2) {
                this.e = iD;
                this.f11382d = cVar;
            }
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        if (this.e != 0) {
            this.f11380b.e();
            return;
        }
        h hVar = this.f11380b;
        if (hVar.get() == 0 && hVar.compareAndSet(0, 1)) {
            hVar.f11384a.b(obj);
            if (hVar.decrementAndGet() == 0) {
                return;
            }
        } else {
            a5.h bVar = this.f11382d;
            if (bVar == null) {
                bVar = new h5.b(hVar.f11387d);
                this.f11382d = bVar;
            }
            bVar.offer(obj);
            if (hVar.getAndIncrement() != 0) {
                return;
            }
        }
        hVar.f();
    }

    @Override // s4.m
    public final void onComplete() {
        this.f11381c = true;
        this.f11380b.e();
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        l5.b bVar = this.f11380b.g;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        h hVar = this.f11380b;
        hVar.getClass();
        hVar.d();
        this.f11381c = true;
        this.f11380b.e();
    }
}
