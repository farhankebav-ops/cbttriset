package f5;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h extends AtomicInteger implements u4.b, s4.m {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final g[] f11383o = new g[0];
    public static final g[] p = new g[0];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.m f11384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.camera.camera2.internal.compat.workaround.c f11385b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f11387d;
    public volatile a5.g e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f11388f;
    public volatile boolean h;
    public u4.b j;
    public long k;
    public long l;
    public int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f11390n;
    public final l5.b g = new l5.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11386c = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicReference f11389i = new AtomicReference(f11383o);

    public h(s4.m mVar, androidx.camera.camera2.internal.compat.workaround.c cVar, int i2) {
        this.f11384a = mVar;
        this.f11385b = cVar;
        this.f11387d = i2;
    }

    @Override // s4.m
    public final void a(u4.b bVar) {
        if (y4.a.f(this.j, bVar)) {
            this.j = bVar;
            this.f11384a.a(this);
        }
    }

    @Override // s4.m
    public final void b(Object obj) {
        if (this.f11388f) {
            return;
        }
        try {
            s4.l lVar = (s4.l) this.f11385b.apply(obj);
            if (this.f11386c != Integer.MAX_VALUE) {
                synchronized (this) {
                    try {
                        int i2 = this.f11390n;
                        if (i2 == this.f11386c) {
                            throw null;
                        }
                        this.f11390n = i2 + 1;
                    } finally {
                    }
                }
            }
            h(lVar);
        } catch (Throwable th) {
            q.y0(th);
            this.j.dispose();
            onError(th);
        }
    }

    public final boolean c() {
        if (!this.h) {
            if (((Throwable) this.g.get()) == null) {
                return false;
            }
            d();
            l5.b bVar = this.g;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            if (thB != l5.c.f12823a) {
                this.f11384a.onError(thB);
            }
        }
        return true;
    }

    public final boolean d() {
        g[] gVarArr;
        this.j.dispose();
        AtomicReference atomicReference = this.f11389i;
        g[] gVarArr2 = (g[]) atomicReference.get();
        g[] gVarArr3 = p;
        if (gVarArr2 == gVarArr3 || (gVarArr = (g[]) atomicReference.getAndSet(gVarArr3)) == gVarArr3) {
            return false;
        }
        for (g gVar : gVarArr) {
            gVar.getClass();
            y4.a.a(gVar);
        }
        return true;
    }

    @Override // u4.b
    public final void dispose() {
        if (this.h) {
            return;
        }
        this.h = true;
        if (d()) {
            l5.b bVar = this.g;
            bVar.getClass();
            Throwable thB = l5.c.b(bVar);
            if (thB == null || thB == l5.c.f12823a) {
                return;
            }
            n7.b.F(thB);
        }
    }

    public final void e() {
        if (getAndIncrement() == 0) {
            f();
        }
    }

    public final void f() {
        s4.m mVar = this.f11384a;
        int iAddAndGet = 1;
        while (!c()) {
            a5.g gVar = this.e;
            if (gVar != null) {
                while (!c()) {
                    Object objPoll = gVar.poll();
                    if (objPoll != null) {
                        mVar.b(objPoll);
                    } else if (objPoll == null) {
                    }
                }
                return;
            }
            boolean z2 = this.f11388f;
            a5.g gVar2 = this.e;
            g[] gVarArr = (g[]) this.f11389i.get();
            int length = gVarArr.length;
            if (this.f11386c != Integer.MAX_VALUE) {
                synchronized (this) {
                    throw null;
                }
            }
            if (z2 && ((gVar2 == null || gVar2.isEmpty()) && length == 0)) {
                l5.b bVar = this.g;
                bVar.getClass();
                Throwable thB = l5.c.b(bVar);
                if (thB != l5.c.f12823a) {
                    if (thB == null) {
                        mVar.onComplete();
                        return;
                    } else {
                        mVar.onError(thB);
                        return;
                    }
                }
                return;
            }
            boolean z7 = false;
            if (length != 0) {
                long j = this.l;
                int i2 = this.m;
                if (length <= i2 || gVarArr[i2].f11379a != j) {
                    if (length <= i2) {
                        i2 = 0;
                    }
                    for (int i8 = 0; i8 < length && gVarArr[i2].f11379a != j; i8++) {
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                    }
                    this.m = i2;
                    this.l = gVarArr[i2].f11379a;
                }
                int i9 = 0;
                boolean z8 = false;
                while (i9 < length) {
                    if (c()) {
                        return;
                    }
                    g gVar3 = gVarArr[i2];
                    while (!c()) {
                        a5.h hVar = gVar3.f11382d;
                        if (hVar != null) {
                            do {
                                try {
                                    Object objPoll2 = hVar.poll();
                                    if (objPoll2 != null) {
                                        mVar.b(objPoll2);
                                    } else if (objPoll2 == null) {
                                    }
                                } catch (Throwable th) {
                                    q.y0(th);
                                    y4.a.a(gVar3);
                                    l5.b bVar2 = this.g;
                                    bVar2.getClass();
                                    l5.c.a(bVar2, th);
                                    if (c()) {
                                        return;
                                    }
                                    g(gVar3);
                                    i9++;
                                    z8 = true;
                                }
                            } while (!c());
                            return;
                        }
                        boolean z9 = gVar3.f11381c;
                        a5.h hVar2 = gVar3.f11382d;
                        if (z9 && (hVar2 == null || hVar2.isEmpty())) {
                            g(gVar3);
                            if (c()) {
                                return;
                            } else {
                                z8 = true;
                            }
                        }
                        i2++;
                        if (i2 == length) {
                            i2 = 0;
                        }
                        i9++;
                    }
                    return;
                }
                this.m = i2;
                this.l = gVarArr[i2].f11379a;
                z7 = z8;
            }
            if (!z7) {
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            } else if (this.f11386c != Integer.MAX_VALUE) {
                synchronized (this) {
                    throw null;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(g gVar) {
        g[] gVarArr;
        while (true) {
            AtomicReference atomicReference = this.f11389i;
            g[] gVarArr2 = (g[]) atomicReference.get();
            int length = gVarArr2.length;
            if (length == 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    i2 = -1;
                    break;
                } else if (gVarArr2[i2] == gVar) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                gVarArr = f11383o;
            } else {
                g[] gVarArr3 = new g[length - 1];
                System.arraycopy(gVarArr2, 0, gVarArr3, 0, i2);
                System.arraycopy(gVarArr2, i2 + 1, gVarArr3, i2, (length - i2) - 1);
                gVarArr = gVarArr3;
            }
            while (!atomicReference.compareAndSet(gVarArr2, gVarArr)) {
                if (atomicReference.get() != gVarArr2) {
                    break;
                }
            }
            return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h(s4.l lVar) {
        if (!(lVar instanceof Callable)) {
            long j = this.k;
            this.k = 1 + j;
            g gVar = new g(this, j);
            AtomicReference atomicReference = this.f11389i;
            while (true) {
                g[] gVarArr = (g[]) atomicReference.get();
                if (gVarArr == p) {
                    y4.a.a(gVar);
                    return;
                }
                int length = gVarArr.length;
                g[] gVarArr2 = new g[length + 1];
                System.arraycopy(gVarArr, 0, gVarArr2, 0, length);
                gVarArr2[length] = gVar;
                while (!atomicReference.compareAndSet(gVarArr, gVarArr2)) {
                    if (atomicReference.get() != gVarArr) {
                        break;
                    }
                }
                lVar.c(gVar);
                return;
            }
        }
        try {
            Object objCall = ((Callable) lVar).call();
            if (objCall != null) {
                if (get() == 0 && compareAndSet(0, 1)) {
                    this.f11384a.b(objCall);
                    if (decrementAndGet() != 0) {
                        f();
                    }
                } else {
                    a5.g bVar = this.e;
                    if (bVar == null) {
                        bVar = this.f11386c == Integer.MAX_VALUE ? new h5.b(this.f11387d) : new h5.a(this.f11386c);
                        this.e = bVar;
                    }
                    if (bVar.offer(objCall)) {
                        if (getAndIncrement() != 0) {
                            return;
                        }
                        f();
                    } else {
                        onError(new IllegalStateException("Scalar queue full?!"));
                    }
                }
            }
        } catch (Throwable th) {
            q.y0(th);
            l5.b bVar2 = this.g;
            bVar2.getClass();
            l5.c.a(bVar2, th);
            e();
        }
        if (this.f11386c == Integer.MAX_VALUE) {
            return;
        }
        synchronized (this) {
            throw null;
        }
    }

    @Override // s4.m
    public final void onComplete() {
        if (this.f11388f) {
            return;
        }
        this.f11388f = true;
        e();
    }

    @Override // s4.m
    public final void onError(Throwable th) {
        if (this.f11388f) {
            n7.b.F(th);
            return;
        }
        l5.b bVar = this.g;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
        } else {
            this.f11388f = true;
            e();
        }
    }
}
