package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class z extends AtomicInteger implements s4.g, o7.b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final y[] f11163q = new y[0];

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final y[] f11164r = new y[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.c f11166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11168d;
    public volatile a5.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11169f;
    public final l5.b g = new l5.b();
    public volatile boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f11170i;
    public final AtomicLong j;
    public o7.b k;
    public long l;
    public long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11171n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f11172o;
    public final int p;

    public z(s4.g gVar, r4.c cVar, int i2, int i8) {
        AtomicReference atomicReference = new AtomicReference();
        this.f11170i = atomicReference;
        this.j = new AtomicLong();
        this.f11165a = gVar;
        this.f11166b = cVar;
        this.f11167c = i2;
        this.f11168d = i8;
        this.p = Math.max(1, i2 >> 1);
        atomicReference.lazySet(f11163q);
    }

    public final boolean a() {
        if (this.h) {
            a5.g gVar = this.e;
            if (gVar != null) {
                gVar.clear();
                return true;
            }
        } else {
            if (this.g.get() == null) {
                return false;
            }
            a5.g gVar2 = this.e;
            if (gVar2 != null) {
                gVar2.clear();
            }
            l5.b bVar = this.g;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            if (thB != l5.c.f12823a) {
                this.f11165a.onError(thB);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.g
    public final void b(Object obj) {
        if (this.f11169f) {
            return;
        }
        try {
            Object objApply = this.f11166b.apply(obj);
            z4.b.a(objApply, "The mapper returned a null Publisher");
            o7.a aVar = (o7.a) objApply;
            if (!(aVar instanceof Callable)) {
                long j = this.l;
                this.l = 1 + j;
                y yVar = new y(this, j);
                AtomicReference atomicReference = this.f11170i;
                while (true) {
                    y[] yVarArr = (y[]) atomicReference.get();
                    if (yVarArr == f11164r) {
                        k5.f.a(yVar);
                        return;
                    }
                    int length = yVarArr.length;
                    y[] yVarArr2 = new y[length + 1];
                    System.arraycopy(yVarArr, 0, yVarArr2, 0, length);
                    yVarArr2[length] = yVar;
                    while (!atomicReference.compareAndSet(yVarArr, yVarArr2)) {
                        if (atomicReference.get() != yVarArr) {
                            break;
                        }
                    }
                    aVar.a(yVar);
                    return;
                }
            }
            try {
                Object objCall = ((Callable) aVar).call();
                if (objCall == null) {
                    if (this.f11167c == Integer.MAX_VALUE || this.h) {
                        return;
                    }
                    int i2 = this.f11172o + 1;
                    this.f11172o = i2;
                    int i8 = this.p;
                    if (i2 == i8) {
                        this.f11172o = 0;
                        this.k.c(i8);
                        return;
                    }
                    return;
                }
                if (get() == 0 && compareAndSet(0, 1)) {
                    long j3 = this.j.get();
                    a5.g gVarH = this.e;
                    if (j3 == 0 || !(gVarH == null || gVarH.isEmpty())) {
                        if (gVarH == null) {
                            gVarH = h();
                        }
                        if (!gVarH.offer(objCall)) {
                            onError(new IllegalStateException("Scalar queue full?!"));
                            return;
                        }
                    } else {
                        this.f11165a.b(objCall);
                        if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
                            this.j.decrementAndGet();
                        }
                        if (this.f11167c != Integer.MAX_VALUE && !this.h) {
                            int i9 = this.f11172o + 1;
                            this.f11172o = i9;
                            int i10 = this.p;
                            if (i9 == i10) {
                                this.f11172o = 0;
                                this.k.c(i10);
                            }
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                } else if (!h().offer(objCall)) {
                    onError(new IllegalStateException("Scalar queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
                g();
            } catch (Throwable th) {
                r2.q.y0(th);
                l5.b bVar = this.g;
                bVar.getClass();
                l5.c.a(bVar, th);
                d();
            }
        } catch (Throwable th2) {
            r2.q.y0(th2);
            this.k.cancel();
            onError(th2);
        }
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j)) {
            a.a.f(this.j, j);
            d();
        }
    }

    @Override // o7.b
    public final void cancel() {
        a5.g gVar;
        y[] yVarArr;
        if (this.h) {
            return;
        }
        this.h = true;
        this.k.cancel();
        AtomicReference atomicReference = this.f11170i;
        y[] yVarArr2 = (y[]) atomicReference.get();
        y[] yVarArr3 = f11164r;
        if (yVarArr2 != yVarArr3 && (yVarArr = (y[]) atomicReference.getAndSet(yVarArr3)) != yVarArr3) {
            for (y yVar : yVarArr) {
                yVar.getClass();
                k5.f.a(yVar);
            }
            l5.b bVar = this.g;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            if (thB != null && thB != l5.c.f12823a) {
                n7.b.F(thB);
            }
        }
        if (getAndIncrement() != 0 || (gVar = this.e) == null) {
            return;
        }
        gVar.clear();
    }

    public final void d() {
        if (getAndIncrement() == 0) {
            g();
        }
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.k, bVar)) {
            this.k = bVar;
            this.f11165a.f(this);
            if (this.h) {
                return;
            }
            int i2 = this.f11167c;
            if (i2 == Integer.MAX_VALUE) {
                bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                bVar.c(i2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x018f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 443
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.z.g():void");
    }

    public final a5.g h() {
        a5.g bVar = this.e;
        if (bVar == null) {
            bVar = this.f11167c == Integer.MAX_VALUE ? new h5.b(this.f11168d) : new h5.a(this.f11167c);
            this.e = bVar;
        }
        return bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(y yVar) {
        y[] yVarArr;
        while (true) {
            AtomicReference atomicReference = this.f11170i;
            y[] yVarArr2 = (y[]) atomicReference.get();
            int length = yVarArr2.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (yVarArr2[i2] == yVar) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                yVarArr = f11163q;
            } else {
                y[] yVarArr3 = new y[length - 1];
                System.arraycopy(yVarArr2, 0, yVarArr3, 0, i2);
                System.arraycopy(yVarArr2, i2 + 1, yVarArr3, i2, (length - i2) - 1);
                yVarArr = yVarArr3;
            }
            while (!atomicReference.compareAndSet(yVarArr2, yVarArr)) {
                if (atomicReference.get() != yVarArr2) {
                    break;
                }
            }
            return;
        }
    }

    @Override // s4.g
    public final void onComplete() {
        if (this.f11169f) {
            return;
        }
        this.f11169f = true;
        d();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.f11169f) {
            n7.b.F(th);
            return;
        }
        l5.b bVar = this.g;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
        } else {
            this.f11169f = true;
            d();
        }
    }
}
