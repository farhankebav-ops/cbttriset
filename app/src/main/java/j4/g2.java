package j4;

import com.vungle.ads.internal.presenter.MRAIDPresenter;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g2 implements w {
    public static final i4.v0 E;
    public static final i4.v0 F;
    public static final i4.n1 G;
    public static final Random H;
    public final /* synthetic */ i4.c1 A;
    public final /* synthetic */ i4.d B;
    public final /* synthetic */ i4.q C;
    public final /* synthetic */ g0 D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i4.c1 f12204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f12205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.s1 f12206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f12207d;
    public final i4.a1 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final o4 f12208f;
    public final h1 g;
    public final boolean h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f12209i;
    public final g j;
    public final long k;
    public final long l;
    public final n4 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l1 f12210n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile j4 f12211o;
    public final AtomicBoolean p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f12212q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f12213r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e2.h f12214s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f12215t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public y f12216u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public r1 f12217v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public r1 f12218w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f12219x;
    public i4.n1 y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f12220z;

    static {
        i4.j jVar = i4.a1.f11818d;
        BitSet bitSet = i4.x0.f11971d;
        E = new i4.v0("grpc-previous-rpc-attempts", jVar);
        F = new i4.v0("grpc-retry-pushback-ms", jVar);
        G = i4.n1.f11914f.h("Stream thrown away because RetriableStream committed");
        H = new Random();
    }

    public g2(g0 g0Var, i4.c1 c1Var, i4.a1 a1Var, i4.d dVar, o4 o4Var, h1 h1Var, i4.q qVar) {
        this.D = g0Var;
        this.A = c1Var;
        this.B = dVar;
        this.C = qVar;
        q2 q2Var = (q2) g0Var.f12200b;
        g gVar = q2Var.T;
        long j = q2Var.U;
        long j3 = q2Var.V;
        Executor executor = dVar.f11842b;
        executor = executor == null ? q2Var.h : executor;
        ScheduledExecutorService scheduledExecutorService = q2Var.f12386f.f12326a.f12636d;
        n4 n4Var = (n4) g0Var.f12199a;
        this.f12206c = new i4.s1(new y3());
        this.f12209i = new Object();
        this.f12210n = new l1(0);
        this.f12211o = new j4(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);
        this.p = new AtomicBoolean();
        this.f12212q = new AtomicInteger();
        this.f12213r = new AtomicInteger();
        this.f12204a = c1Var;
        this.j = gVar;
        this.k = j;
        this.l = j3;
        this.f12205b = executor;
        this.f12207d = scheduledExecutorService;
        this.e = a1Var;
        this.f12208f = o4Var;
        if (o4Var != null) {
            this.f12219x = o4Var.f12353b;
        }
        this.g = h1Var;
        r2.q.y(o4Var == null || h1Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.h = h1Var != null;
        this.m = n4Var;
    }

    public static void c(g2 g2Var, Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            g2Var.q();
            return;
        }
        synchronized (g2Var.f12209i) {
            try {
                r1 r1Var = g2Var.f12218w;
                if (r1Var == null) {
                    return;
                }
                r1Var.f12408a = true;
                Future future = (Future) r1Var.f12410c;
                r1 r1Var2 = new r1(g2Var.f12209i);
                g2Var.f12218w = r1Var2;
                if (future != null) {
                    future.cancel(false);
                }
                r1Var2.a(g2Var.f12207d.schedule(new i0(22, g2Var, r1Var2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.w
    public final void a(int i2) {
        o(new c4(i2, 1));
    }

    @Override // j4.e5
    public final void b(i4.k kVar) {
        o(new a4(kVar, 0));
    }

    @Override // j4.w
    public final void d(i4.n1 n1Var) {
        m4 m4Var;
        m4 m4Var2 = new m4(0);
        m4Var2.f12322a = new e3(0);
        z3 z3VarF = f(m4Var2);
        if (z3VarF != null) {
            synchronized (this.f12209i) {
                this.f12211o = this.f12211o.e(m4Var2);
            }
            z3VarF.run();
            t(n1Var, x.f12538a, new i4.a1());
            return;
        }
        synchronized (this.f12209i) {
            try {
                if (this.f12211o.f12275c.contains(this.f12211o.f12277f)) {
                    m4Var = this.f12211o.f12277f;
                } else {
                    this.y = n1Var;
                    m4Var = null;
                }
                j4 j4Var = this.f12211o;
                this.f12211o = new j4(j4Var.f12274b, j4Var.f12275c, j4Var.f12276d, j4Var.f12277f, true, j4Var.f12273a, j4Var.h, j4Var.e);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (m4Var != null) {
            m4Var.f12322a.d(n1Var);
        }
    }

    @Override // j4.e5
    public final void e(o4.a aVar) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final z3 f(m4 m4Var) {
        List list;
        boolean z2;
        Collection collectionSingleton;
        Future future;
        Future future2;
        synchronized (this.f12209i) {
            try {
                if (this.f12211o.f12277f != null) {
                    return null;
                }
                Collection collection = this.f12211o.f12275c;
                j4 j4Var = this.f12211o;
                r2.q.H(j4Var.f12277f == null, "Already committed");
                List list2 = j4Var.f12274b;
                if (j4Var.f12275c.contains(m4Var)) {
                    list = null;
                    collectionSingleton = Collections.singleton(m4Var);
                    z2 = true;
                } else {
                    list = list2;
                    z2 = false;
                    collectionSingleton = Collections.EMPTY_LIST;
                }
                this.f12211o = new j4(list, collectionSingleton, j4Var.f12276d, m4Var, j4Var.g, z2, j4Var.h, j4Var.e);
                this.j.f12198a.addAndGet(-this.f12215t);
                r1 r1Var = this.f12217v;
                if (r1Var != null) {
                    r1Var.f12408a = true;
                    Future future3 = (Future) r1Var.f12410c;
                    this.f12217v = null;
                    future = future3;
                } else {
                    future = null;
                }
                r1 r1Var2 = this.f12218w;
                if (r1Var2 != null) {
                    r1Var2.f12408a = true;
                    Future future4 = (Future) r1Var2.f12410c;
                    this.f12218w = null;
                    future2 = future4;
                } else {
                    future2 = null;
                }
                return new z3(this, collection, m4Var, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // j4.e5
    public final void flush() {
        j4 j4Var = this.f12211o;
        if (j4Var.f12273a) {
            j4Var.f12277f.f12322a.flush();
        } else {
            o(new b4(0));
        }
    }

    public final m4 g(int i2, boolean z2) {
        AtomicInteger atomicInteger;
        int i8;
        do {
            atomicInteger = this.f12213r;
            i8 = atomicInteger.get();
            if (i8 < 0) {
                return null;
            }
        } while (!atomicInteger.compareAndSet(i8, i8 + 1));
        m4 m4Var = new m4(i2);
        e4 e4Var = new e4(new g4(this, m4Var));
        i4.a1 a1Var = new i4.a1();
        a1Var.d(this.e);
        if (i2 > 0) {
            a1Var.e(E, String.valueOf(i2));
        }
        i4.d dVar = this.B;
        dVar.getClass();
        List list = dVar.f11844d;
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(e4Var);
        i4.c cVarB = i4.d.b(dVar);
        cVarB.f11833d = Collections.unmodifiableList(arrayList);
        i4.d dVar2 = new i4.d(cVarB);
        i4.i[] iVarArrC = f1.c(dVar2, a1Var, i2, z2);
        i4.c1 c1Var = this.A;
        z zVarA = this.D.a(new q3(c1Var, a1Var, dVar2));
        i4.q qVar = this.C;
        i4.q qVarA = qVar.a();
        try {
            w wVarB = zVarA.b(c1Var, a1Var, dVar2, iVarArrC);
            qVar.c(qVarA);
            m4Var.f12322a = wVarB;
            return m4Var;
        } catch (Throwable th) {
            qVar.c(qVarA);
            throw th;
        }
    }

    @Override // j4.w
    public final void h(i4.t tVar) {
        o(new a4(tVar, 2));
    }

    @Override // j4.w
    public final void i(int i2) {
        o(new c4(i2, 0));
    }

    @Override // j4.e5
    public final boolean isReady() {
        Iterator it = this.f12211o.f12275c.iterator();
        while (it.hasNext()) {
            if (((m4) it.next()).f12322a.isReady()) {
                return true;
            }
        }
        return false;
    }

    @Override // j4.e5
    public final void j() {
        o(new b4(2));
    }

    @Override // j4.w
    public final void k(i4.r rVar) {
        o(new a4(rVar, 1));
    }

    @Override // j4.w
    public final void l() {
        o(new b4(1));
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058  */
    @Override // j4.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(j4.y r7) {
        /*
            r6 = this;
            r6.f12216u = r7
            i4.n1 r7 = r6.s()
            if (r7 == 0) goto Lc
            r6.d(r7)
            return
        Lc:
            java.lang.Object r7 = r6.f12209i
            monitor-enter(r7)
            j4.j4 r0 = r6.f12211o     // Catch: java.lang.Throwable -> L79
            java.util.List r0 = r0.f12274b     // Catch: java.lang.Throwable -> L79
            j4.i4 r1 = new j4.i4     // Catch: java.lang.Throwable -> L79
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L79
            r0.add(r1)     // Catch: java.lang.Throwable -> L79
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L79
            r7 = 0
            j4.m4 r0 = r6.g(r7, r7)
            if (r0 != 0) goto L24
            return
        L24:
            boolean r1 = r6.h
            if (r1 == 0) goto L75
            java.lang.Object r1 = r6.f12209i
            monitor-enter(r1)
            j4.j4 r2 = r6.f12211o     // Catch: java.lang.Throwable -> L56
            j4.j4 r2 = r2.a(r0)     // Catch: java.lang.Throwable -> L56
            r6.f12211o = r2     // Catch: java.lang.Throwable -> L56
            j4.j4 r2 = r6.f12211o     // Catch: java.lang.Throwable -> L56
            boolean r2 = r6.r(r2)     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L58
            j4.n4 r2 = r6.m     // Catch: java.lang.Throwable -> L56
            if (r2 == 0) goto L4c
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f12340d     // Catch: java.lang.Throwable -> L56
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L56
            int r2 = r2.f12338b     // Catch: java.lang.Throwable -> L56
            if (r3 <= r2) goto L4a
            r7 = 1
        L4a:
            if (r7 == 0) goto L58
        L4c:
            j4.r1 r7 = new j4.r1     // Catch: java.lang.Throwable -> L56
            java.lang.Object r2 = r6.f12209i     // Catch: java.lang.Throwable -> L56
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L56
            r6.f12218w = r7     // Catch: java.lang.Throwable -> L56
            goto L59
        L56:
            r7 = move-exception
            goto L73
        L58:
            r7 = 0
        L59:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            if (r7 == 0) goto L75
            java.util.concurrent.ScheduledExecutorService r1 = r6.f12207d
            j4.i0 r2 = new j4.i0
            r3 = 22
            r2.<init>(r3, r6, r7)
            j4.h1 r3 = r6.g
            long r3 = r3.f12238b
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.NANOSECONDS
            java.util.concurrent.ScheduledFuture r1 = r1.schedule(r2, r3, r5)
            r7.a(r1)
            goto L75
        L73:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L56
            throw r7
        L75:
            r6.p(r0)
            return
        L79:
            r0 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L79
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.g2.m(j4.y):void");
    }

    @Override // j4.w
    public final void n(l1 l1Var) {
        j4 j4Var;
        synchronized (this.f12209i) {
            l1Var.a(this.f12210n, "closed");
            j4Var = this.f12211o;
        }
        if (j4Var.f12277f != null) {
            l1 l1Var2 = new l1(0);
            j4Var.f12277f.f12322a.n(l1Var2);
            l1Var.a(l1Var2, "committed");
            return;
        }
        l1 l1Var3 = new l1(0);
        for (m4 m4Var : j4Var.f12275c) {
            l1 l1Var4 = new l1(0);
            m4Var.f12322a.n(l1Var4);
            l1Var3.f12300b.add(String.valueOf(l1Var4));
        }
        l1Var.a(l1Var3, MRAIDPresenter.OPEN);
    }

    public final void o(f4 f4Var) {
        Collection collection;
        synchronized (this.f12209i) {
            try {
                if (!this.f12211o.f12273a) {
                    this.f12211o.f12274b.add(f4Var);
                }
                collection = this.f12211o.f12275c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            f4Var.a((m4) it.next());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0039, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003b, code lost:
    
        r9.f12206c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0041, code lost:
    
        if (r4 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0043, code lost:
    
        r10.f12322a.m(new j4.g5(5, r9, r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004e, code lost:
    
        r0 = r10.f12322a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0054, code lost:
    
        if (r9.f12211o.f12277f != r10) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0056, code lost:
    
        r10 = r9.y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0059, code lost:
    
        r10 = j4.g2.G;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x005b, code lost:
    
        r0.d(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x008c, code lost:
    
        r2 = r3.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0091, code lost:
    
        if (r5 >= r2) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0093, code lost:
    
        r6 = r3.get(r5);
        r5 = r5 + 1;
        r6 = (j4.f4) r6;
        r6.a(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a0, code lost:
    
        if ((r6 instanceof j4.i4) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00a2, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a3, code lost:
    
        r6 = r9.f12211o;
        r8 = r6.f12277f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a7, code lost:
    
        if (r8 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a9, code lost:
    
        if (r8 == r10) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ae, code lost:
    
        if (r6.g == false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void p(j4.m4 r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r4 = r2
            r3 = r1
        L5:
            java.lang.Object r5 = r9.f12209i
            monitor-enter(r5)
            j4.j4 r6 = r9.f12211o     // Catch: java.lang.Throwable -> L12
            j4.m4 r7 = r6.f12277f     // Catch: java.lang.Throwable -> L12
            if (r7 == 0) goto L15
            if (r7 == r10) goto L15
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            goto L39
        L12:
            r10 = move-exception
            goto Lb3
        L15:
            boolean r7 = r6.g     // Catch: java.lang.Throwable -> L12
            if (r7 == 0) goto L1b
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            goto L39
        L1b:
            java.util.List r7 = r6.f12274b     // Catch: java.lang.Throwable -> L12
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L12
            if (r2 != r7) goto L5f
            j4.j4 r0 = r6.e(r10)     // Catch: java.lang.Throwable -> L12
            r9.f12211o = r0     // Catch: java.lang.Throwable -> L12
            boolean r0 = r9.isReady()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L31
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            return
        L31:
            a4.c r1 = new a4.c     // Catch: java.lang.Throwable -> L12
            r0 = 13
            r1.<init>(r9, r0)     // Catch: java.lang.Throwable -> L12
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
        L39:
            if (r1 == 0) goto L41
            i4.s1 r10 = r9.f12206c
            r10.execute(r1)
            return
        L41:
            if (r4 != 0) goto L4e
            j4.w r0 = r10.f12322a
            j4.g5 r1 = new j4.g5
            r2 = 5
            r1.<init>(r2, r9, r10)
            r0.m(r1)
        L4e:
            j4.w r0 = r10.f12322a
            j4.j4 r1 = r9.f12211o
            j4.m4 r1 = r1.f12277f
            if (r1 != r10) goto L59
            i4.n1 r10 = r9.y
            goto L5b
        L59:
            i4.n1 r10 = j4.g2.G
        L5b:
            r0.d(r10)
            return
        L5f:
            boolean r7 = r10.f12323b     // Catch: java.lang.Throwable -> L12
            if (r7 == 0) goto L65
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            return
        L65:
            int r7 = r2 + 128
            java.util.List r8 = r6.f12274b     // Catch: java.lang.Throwable -> L12
            int r8 = r8.size()     // Catch: java.lang.Throwable -> L12
            int r7 = java.lang.Math.min(r7, r8)     // Catch: java.lang.Throwable -> L12
            if (r3 != 0) goto L7f
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L12
            java.util.List r6 = r6.f12274b     // Catch: java.lang.Throwable -> L12
            java.util.List r2 = r6.subList(r2, r7)     // Catch: java.lang.Throwable -> L12
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L12
            goto L8b
        L7f:
            r3.clear()     // Catch: java.lang.Throwable -> L12
            java.util.List r6 = r6.f12274b     // Catch: java.lang.Throwable -> L12
            java.util.List r2 = r6.subList(r2, r7)     // Catch: java.lang.Throwable -> L12
            r3.addAll(r2)     // Catch: java.lang.Throwable -> L12
        L8b:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.size()
            r5 = r0
        L91:
            if (r5 >= r2) goto Lb0
            java.lang.Object r6 = r3.get(r5)
            int r5 = r5 + 1
            j4.f4 r6 = (j4.f4) r6
            r6.a(r10)
            boolean r6 = r6 instanceof j4.i4
            if (r6 == 0) goto La3
            r4 = 1
        La3:
            j4.j4 r6 = r9.f12211o
            j4.m4 r8 = r6.f12277f
            if (r8 == 0) goto Lac
            if (r8 == r10) goto Lac
            goto Lb0
        Lac:
            boolean r6 = r6.g
            if (r6 == 0) goto L91
        Lb0:
            r2 = r7
            goto L5
        Lb3:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L12
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.g2.p(j4.m4):void");
    }

    public final void q() {
        Future future;
        synchronized (this.f12209i) {
            try {
                r1 r1Var = this.f12218w;
                future = null;
                if (r1Var != null) {
                    r1Var.f12408a = true;
                    Future future2 = (Future) r1Var.f12410c;
                    this.f12218w = null;
                    future = future2;
                }
                j4 j4Var = this.f12211o;
                if (!j4Var.h) {
                    j4Var = new j4(j4Var.f12274b, j4Var.f12275c, j4Var.f12276d, j4Var.f12277f, j4Var.g, j4Var.f12273a, true, j4Var.e);
                }
                this.f12211o = j4Var;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    public final boolean r(j4 j4Var) {
        return j4Var.f12277f == null && j4Var.e < this.g.f12237a && !j4Var.h;
    }

    @Override // j4.e5
    public final void request() {
        j4 j4Var = this.f12211o;
        if (j4Var.f12273a) {
            j4Var.f12277f.f12322a.request();
        } else {
            o(new b4(3));
        }
    }

    public final i4.n1 s() {
        h hVar = ((q2) this.D.f12200b).F;
        synchronized (hVar.f12231a) {
            try {
                i4.n1 n1Var = (i4.n1) hVar.f12233c;
                if (n1Var != null) {
                    return n1Var;
                }
                ((HashSet) hVar.f12232b).add(this);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void t(i4.n1 n1Var, x xVar, i4.a1 a1Var) {
        this.f12214s = new e2.h(n1Var, xVar, a1Var);
        if (this.f12213r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f12206c.execute(new b(this, n1Var, xVar, a1Var, 2));
        }
    }

    public final void u(Object obj) {
        j4 j4Var = this.f12211o;
        if (j4Var.f12273a) {
            j4Var.f12277f.f12322a.e(this.f12204a.m(obj));
        } else {
            o(new d4(this, obj));
        }
    }
}
