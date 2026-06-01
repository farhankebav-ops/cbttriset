package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c0 extends k5.a implements s4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11067a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x4.c f11068b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11069c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11070d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o7.b f11071f;
    public a5.h g;
    public volatile boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f11072i;
    public Iterator k;
    public int l;
    public int m;
    public final AtomicReference j = new AtomicReference();
    public final AtomicLong e = new AtomicLong();

    public c0(s4.g gVar, r4.c cVar, int i2) {
        this.f11067a = gVar;
        this.f11068b = cVar;
        this.f11069c = i2;
        this.f11070d = i2 - (i2 >> 2);
    }

    @Override // s4.g
    public final void b(Object obj) {
        if (this.h) {
            return;
        }
        if (this.m != 0 || this.g.offer(obj)) {
            h();
        } else {
            onError(new v4.c("Queue is full?!"));
        }
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j)) {
            a.a.f(this.e, j);
            h();
        }
    }

    @Override // o7.b
    public final void cancel() {
        if (this.f11072i) {
            return;
        }
        this.f11072i = true;
        this.f11071f.cancel();
        if (getAndIncrement() == 0) {
            this.g.clear();
        }
    }

    @Override // a5.h
    public final void clear() {
        this.k = null;
        this.g.clear();
    }

    @Override // a5.d
    public final int d(int i2) {
        return this.m == 1 ? 1 : 0;
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11071f, bVar)) {
            this.f11071f = bVar;
            if (bVar instanceof a5.e) {
                a5.e eVar = (a5.e) bVar;
                int iD = eVar.d(3);
                if (iD == 1) {
                    this.m = iD;
                    this.g = eVar;
                    this.h = true;
                    this.f11067a.f(this);
                    return;
                }
                if (iD == 2) {
                    this.m = iD;
                    this.g = eVar;
                    this.f11067a.f(this);
                    bVar.c(this.f11069c);
                    return;
                }
            }
            this.g = new h5.a(this.f11069c);
            this.f11067a.f(this);
            bVar.c(this.f11069c);
        }
    }

    public final boolean g(boolean z2, boolean z7, s4.g gVar, a5.h hVar) {
        if (this.f11072i) {
            this.k = null;
            hVar.clear();
            return true;
        }
        if (!z2) {
            return false;
        }
        if (((Throwable) this.j.get()) == null) {
            if (!z7) {
                return false;
            }
            gVar.onComplete();
            return true;
        }
        Throwable thB = l5.c.b(this.j);
        this.k = null;
        hVar.clear();
        gVar.onError(thB);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h() {
        int i2;
        if (getAndIncrement() != 0) {
            return;
        }
        s4.g gVar = this.f11067a;
        a5.h hVar = this.g;
        boolean z2 = false;
        int i8 = 1;
        byte b8 = this.m != 1;
        Iterator it = this.k;
        int iAddAndGet = 1;
        while (true) {
            if (it == null) {
                boolean z7 = this.h;
                try {
                    Object objPoll = hVar.poll();
                    if (g(z7, objPoll == null ? i8 : z2 ? 1 : 0, gVar, hVar)) {
                        return;
                    }
                    if (objPoll != null) {
                        try {
                            it = ((Iterable) this.f11068b.apply(objPoll)).iterator();
                            if (it.hasNext()) {
                                this.k = it;
                            } else {
                                if (b8 != false) {
                                    int i9 = this.l + i8;
                                    if (i9 == this.f11070d) {
                                        this.l = z2 ? 1 : 0;
                                        this.f11071f.c(i9);
                                    } else {
                                        this.l = i9;
                                    }
                                }
                                it = null;
                            }
                        } catch (Throwable th) {
                            r2.q.y0(th);
                            this.f11071f.cancel();
                            l5.c.a(this.j, th);
                            gVar.onError(l5.c.b(this.j));
                            return;
                        }
                    }
                } catch (Throwable th2) {
                    r2.q.y0(th2);
                    this.f11071f.cancel();
                    l5.c.a(this.j, th2);
                    Throwable thB = l5.c.b(this.j);
                    this.k = null;
                    hVar.clear();
                    gVar.onError(thB);
                    return;
                }
            }
            if (it != null) {
                long j = this.e.get();
                long j3 = 0;
                while (true) {
                    if (j3 == j) {
                        i2 = i8;
                        break;
                    }
                    if (g(this.h, z2, gVar, hVar)) {
                        return;
                    }
                    try {
                        Object next = it.next();
                        i2 = i8;
                        z4.b.a(next, "The iterator returned a null value");
                        gVar.b(next);
                        if (g(this.h, z2, gVar, hVar)) {
                            return;
                        }
                        j3++;
                        try {
                            if (it.hasNext()) {
                                i8 = i2;
                            } else {
                                if (b8 != false) {
                                    int i10 = this.l + 1;
                                    if (i10 == this.f11070d) {
                                        this.l = z2 ? 1 : 0;
                                        this.f11071f.c(i10);
                                    } else {
                                        this.l = i10;
                                    }
                                }
                                this.k = null;
                                it = null;
                            }
                        } catch (Throwable th3) {
                            r2.q.y0(th3);
                            this.k = null;
                            this.f11071f.cancel();
                            l5.c.a(this.j, th3);
                            gVar.onError(l5.c.b(this.j));
                            return;
                        }
                    } catch (Throwable th4) {
                        r2.q.y0(th4);
                        this.k = null;
                        this.f11071f.cancel();
                        l5.c.a(this.j, th4);
                        gVar.onError(l5.c.b(this.j));
                        return;
                    }
                }
                if (j3 == j) {
                    if (g(this.h, (hVar.isEmpty() && it == null) ? i2 : 0, gVar, hVar)) {
                        return;
                    }
                }
                if (j3 != 0 && j != LocationRequestCompat.PASSIVE_INTERVAL) {
                    this.e.addAndGet(-j3);
                }
                if (it != null) {
                }
                i8 = i2;
                z2 = false;
            } else {
                i2 = i8;
            }
            iAddAndGet = addAndGet(-iAddAndGet);
            if (iAddAndGet == 0) {
                return;
            }
            i8 = i2;
            z2 = false;
        }
    }

    @Override // a5.h
    public final boolean isEmpty() {
        return this.k == null && this.g.isEmpty();
    }

    @Override // s4.g
    public final void onComplete() {
        if (this.h) {
            return;
        }
        this.h = true;
        h();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        if (this.h || !l5.c.a(this.j, th)) {
            n7.b.F(th);
        } else {
            this.h = true;
            h();
        }
    }

    @Override // a5.h
    public final Object poll() {
        Iterator it = this.k;
        while (true) {
            if (it == null) {
                Object objPoll = this.g.poll();
                if (objPoll != null) {
                    it = ((Iterable) this.f11068b.apply(objPoll)).iterator();
                    if (it.hasNext()) {
                        this.k = it;
                        break;
                    }
                    it = null;
                } else {
                    return null;
                }
            } else {
                break;
            }
        }
        Object next = it.next();
        z4.b.a(next, "The iterator returned a null value");
        if (!it.hasNext()) {
            this.k = null;
        }
        return next;
    }
}
