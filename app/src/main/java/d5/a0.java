package d5;

import androidx.core.location.LocationRequestCompat;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a0 extends AtomicInteger implements s4.g, o7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s4.g f11052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11053b;
    public final x4.c g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o7.b f11057i;
    public volatile boolean j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f11054c = new AtomicLong();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u4.a f11055d = new u4.a(0);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l5.b f11056f = new l5.b();
    public final AtomicInteger e = new AtomicInteger(1);
    public final AtomicReference h = new AtomicReference();

    public a0(s4.g gVar, x4.c cVar, int i2) {
        this.f11052a = gVar;
        this.g = cVar;
        this.f11053b = i2;
    }

    public final void a() {
        h5.b bVar = (h5.b) this.h.get();
        if (bVar != null) {
            bVar.clear();
        }
    }

    @Override // s4.g
    public final void b(Object obj) {
        try {
            Object objApply = this.g.apply(obj);
            z4.b.a(objApply, "The mapper returned a null MaybeSource");
            s4.k kVar = (s4.k) objApply;
            this.e.getAndIncrement();
            e5.c cVar = new e5.c(this, 1);
            if (this.j || !this.f11055d.a(cVar)) {
                return;
            }
            ((s4.h) kVar).b(cVar);
        } catch (Throwable th) {
            r2.q.y0(th);
            this.f11057i.cancel();
            onError(th);
        }
    }

    @Override // o7.b
    public final void c(long j) {
        if (k5.f.d(j)) {
            a.a.f(this.f11054c, j);
            d();
        }
    }

    @Override // o7.b
    public final void cancel() {
        this.j = true;
        this.f11057i.cancel();
        this.f11055d.dispose();
    }

    public final void d() {
        if (getAndIncrement() == 0) {
            g();
        }
    }

    @Override // s4.g
    public final void f(o7.b bVar) {
        if (k5.f.e(this.f11057i, bVar)) {
            this.f11057i = bVar;
            this.f11052a.f(this);
            int i2 = this.f11053b;
            if (i2 == Integer.MAX_VALUE) {
                bVar.c(LocationRequestCompat.PASSIVE_INTERVAL);
            } else {
                bVar.c(i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0079, code lost:
    
        if (r10 != r6) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007d, code lost:
    
        if (r17.j == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007f, code lost:
    
        a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
    
        if (((java.lang.Throwable) r17.f11056f.get()) == null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008d, code lost:
    
        r2 = r17.f11056f;
        r2.getClass();
        r2 = l5.c.b(r2);
        a();
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a1, code lost:
    
        if (r2.get() != 0) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a3, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a5, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a6, code lost:
    
        r7 = (h5.b) r3.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00ac, code lost:
    
        if (r7 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        if (r7.isEmpty() == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b4, code lost:
    
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b5, code lost:
    
        if (r6 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b7, code lost:
    
        if (r13 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b9, code lost:
    
        r2 = r17.f11056f;
        r2.getClass();
        r2 = l5.c.b(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00c2, code lost:
    
        if (r2 == null) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00c4, code lost:
    
        r1.onError(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c7, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00c8, code lost:
    
        r1.onComplete();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00cb, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00ce, code lost:
    
        if (r10 == 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00d0, code lost:
    
        a.a.P(r17.f11054c, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00da, code lost:
    
        if (r17.f11053b == Integer.MAX_VALUE) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        r17.f11057i.c(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e1, code lost:
    
        r5 = addAndGet(-r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void g() {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: d5.a0.g():void");
    }

    public final h5.b h() {
        while (true) {
            AtomicReference atomicReference = this.h;
            h5.b bVar = (h5.b) atomicReference.get();
            if (bVar != null) {
                return bVar;
            }
            h5.b bVar2 = new h5.b(s4.d.f13683a);
            while (!atomicReference.compareAndSet(null, bVar2)) {
                if (atomicReference.get() != null) {
                    break;
                }
            }
            return bVar2;
        }
    }

    @Override // s4.g
    public final void onComplete() {
        this.e.decrementAndGet();
        d();
    }

    @Override // s4.g
    public final void onError(Throwable th) {
        this.e.decrementAndGet();
        l5.b bVar = this.f11056f;
        bVar.getClass();
        if (!l5.c.a(bVar, th)) {
            n7.b.F(th);
        } else {
            this.f11055d.dispose();
            d();
        }
    }
}
