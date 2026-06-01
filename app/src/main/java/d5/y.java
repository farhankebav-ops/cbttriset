package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class y extends AtomicReference implements s4.g, u4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f11158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f11159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11161d;
    public volatile boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile a5.h f11162f;
    public long g;
    public int h;

    public y(z zVar, long j) {
        this.f11158a = j;
        this.f11159b = zVar;
        int i2 = zVar.f11168d;
        this.f11161d = i2;
        this.f11160c = i2 >> 2;
    }

    public final void a(long j) {
        if (this.h != 1) {
            long j3 = this.g + j;
            if (j3 < this.f11160c) {
                this.g = j3;
            } else {
                this.g = 0L;
                ((o7.b) get()).c(j3);
            }
        }
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.h == 2) {
            this.f11159b.d();
            return;
        }
        z zVar = this.f11159b;
        if (zVar.get() == 0 && zVar.compareAndSet(0, 1)) {
            long j = zVar.j.get();
            a5.h aVar = this.f11162f;
            if (j == 0 || !(aVar == null || aVar.isEmpty())) {
                if (aVar == null && (aVar = this.f11162f) == null) {
                    aVar = new h5.a(zVar.f11168d);
                    this.f11162f = aVar;
                }
                if (!aVar.offer(obj)) {
                    zVar.onError(new v4.c("Inner queue full?!"));
                    return;
                }
            } else {
                zVar.f11165a.b(obj);
                if (j != LocationRequestCompat.PASSIVE_INTERVAL) {
                    zVar.j.decrementAndGet();
                }
                a(1L);
            }
            if (zVar.decrementAndGet() == 0) {
                return;
            }
        } else {
            a5.h aVar2 = this.f11162f;
            if (aVar2 == null) {
                aVar2 = new h5.a(zVar.f11168d);
                this.f11162f = aVar2;
            }
            if (!aVar2.offer(obj)) {
                zVar.onError(new v4.c("Inner queue full?!"));
                return;
            } else if (zVar.getAndIncrement() != 0) {
                return;
            }
        }
        zVar.g();
    }

    @Override // u4.b
    public final void dispose() {
        k5.f.a(this);
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.b(this, bVar)) {
            if (bVar instanceof a5.e) {
                a5.e eVar = (a5.e) bVar;
                int iD = eVar.d(7);
                if (iD == 1) {
                    this.h = iD;
                    this.f11162f = eVar;
                    this.e = true;
                    this.f11159b.d();
                    return;
                }
                if (iD == 2) {
                    this.h = iD;
                    this.f11162f = eVar;
                }
            }
            bVar.c(this.f11161d);
        }
    }

    @Override // s4.g
    public final void onComplete() {
        this.e = true;
        this.f11159b.d();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        lazySet(k5.f.f12707a);
        z zVar = this.f11159b;
        l5.b bVar = zVar.g;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
            return;
        }
        this.e = true;
        zVar.k.cancel();
        for (y yVar : (y[]) zVar.f11170i.getAndSet(z.f11164r)) {
            yVar.getClass();
            k5.f.a(yVar);
        }
        zVar.d();
    }
}
