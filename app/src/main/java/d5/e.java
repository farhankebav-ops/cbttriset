package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends AtomicInteger implements s4.g, o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o7.b f11078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f11080c = new AtomicReference();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicLong f11081d = new AtomicLong();
    public final AtomicLong e = new AtomicLong();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11082f;
    public boolean g;
    public final b h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f11083i;

    public e(b bVar) {
        this.h = bVar;
    }

    public final void a() {
        if (getAndIncrement() != 0) {
            return;
        }
        d();
    }

    @Override // s4.g
    public final void b(Object obj) {
        this.f11083i++;
        this.h.d(obj);
    }

    @Override // o7.b
    public final void c(long j) {
        if (!k5.f.d(j) || this.g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a.f(this.f11081d, j);
            a();
            return;
        }
        long j3 = this.f11079b;
        if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long jG = a.a.g(j3, j);
            this.f11079b = jG;
            if (jG == LocationRequestCompat.PASSIVE_INTERVAL) {
                this.g = true;
            }
        }
        o7.b bVar = this.f11078a;
        if (decrementAndGet() != 0) {
            d();
        }
        if (bVar != null) {
            bVar.c(j);
        }
    }

    @Override // o7.b
    public final void cancel() {
        if (this.f11082f) {
            return;
        }
        this.f11082f = true;
        a();
    }

    public final void d() {
        int iAddAndGet = 1;
        long jG = 0;
        o7.b bVar = null;
        do {
            o7.b bVar2 = (o7.b) this.f11080c.get();
            if (bVar2 != null) {
                bVar2 = (o7.b) this.f11080c.getAndSet(null);
            }
            long andSet = this.f11081d.get();
            if (andSet != 0) {
                andSet = this.f11081d.getAndSet(0L);
            }
            long andSet2 = this.e.get();
            if (andSet2 != 0) {
                andSet2 = this.e.getAndSet(0L);
            }
            o7.b bVar3 = this.f11078a;
            if (this.f11082f) {
                if (bVar3 != null) {
                    bVar3.cancel();
                    this.f11078a = null;
                }
                if (bVar2 != null) {
                    bVar2.cancel();
                }
            } else {
                long jG2 = this.f11079b;
                if (jG2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                    jG2 = a.a.g(jG2, andSet);
                    if (jG2 != LocationRequestCompat.PASSIVE_INTERVAL) {
                        jG2 -= andSet2;
                        if (jG2 < 0) {
                            n7.b.F(new s6.s(androidx.camera.core.processing.util.a.j("More produced than requested: ", jG2)));
                            jG2 = 0;
                        }
                    }
                    this.f11079b = jG2;
                }
                if (bVar2 != null) {
                    if (bVar3 != null) {
                        bVar3.cancel();
                    }
                    this.f11078a = bVar2;
                    if (jG2 != 0) {
                        jG = a.a.g(jG, jG2);
                        bVar = bVar2;
                    }
                } else if (bVar3 != null && andSet != 0) {
                    jG = a.a.g(jG, andSet);
                    bVar = bVar3;
                }
            }
            iAddAndGet = addAndGet(-iAddAndGet);
        } while (iAddAndGet != 0);
        if (jG != 0) {
            bVar.c(jG);
        }
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        h(bVar);
    }

    public final void g(long j) {
        if (this.g) {
            return;
        }
        if (get() != 0 || !compareAndSet(0, 1)) {
            a.a.f(this.e, j);
            a();
            return;
        }
        long j3 = this.f11079b;
        if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
            long j8 = j3 - j;
            if (j8 < 0) {
                n7.b.F(new s6.s(androidx.camera.core.processing.util.a.j("More produced than requested: ", j8)));
                j8 = 0;
            }
            this.f11079b = j8;
        }
        if (decrementAndGet() == 0) {
            return;
        }
        d();
    }

    public final void h(o7.b bVar) {
        if (this.f11082f) {
            bVar.cancel();
            return;
        }
        z4.b.a(bVar, "s is null");
        if (get() != 0 || !compareAndSet(0, 1)) {
            o7.b bVar2 = (o7.b) this.f11080c.getAndSet(bVar);
            if (bVar2 != null) {
                bVar2.cancel();
            }
            a();
            return;
        }
        o7.b bVar3 = this.f11078a;
        if (bVar3 != null) {
            bVar3.cancel();
        }
        this.f11078a = bVar;
        long j = this.f11079b;
        if (decrementAndGet() != 0) {
            d();
        }
        if (j != 0) {
            bVar.c(j);
        }
    }

    @Override // s4.g
    public final void onComplete() {
        long j = this.f11083i;
        if (j != 0) {
            this.f11083i = 0L;
            g(j);
        }
        b bVar = this.h;
        bVar.k = false;
        bVar.g();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        long j = this.f11083i;
        if (j != 0) {
            this.f11083i = 0L;
            g(j);
        }
        this.h.a(th);
    }
}
