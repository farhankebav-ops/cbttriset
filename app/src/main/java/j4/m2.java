package j4;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m2 extends i4.f {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final k0 f12314r;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledFuture f12315d;
    public final Executor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i4.q f12316f;
    public volatile boolean g;
    public i4.x h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i4.f f12317i;
    public i4.n1 j;
    public List k;
    public m0 l;
    public final i4.q m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final i4.c1 f12318n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.d f12319o;
    public final long p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final /* synthetic */ n2 f12320q;

    static {
        Logger.getLogger(m2.class.getName());
        f12314r = new k0(0);
    }

    public m2(n2 n2Var, i4.q qVar, i4.c1 c1Var, i4.d dVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        this.f12320q = n2Var;
        q2 q2Var = n2Var.f12334d;
        Logger logger = q2.f12378c0;
        Executor executor = dVar.f11842b;
        executor = executor == null ? q2Var.h : executor;
        o2 o2Var = q2Var.g;
        i4.r rVar = dVar.f11841a;
        this.k = new ArrayList();
        r2.q.D(executor, "callExecutor");
        this.e = executor;
        r2.q.D(o2Var, "scheduler");
        i4.q qVarB = i4.q.b();
        this.f12316f = qVarB;
        qVarB.getClass();
        if (rVar == null) {
            scheduledFutureSchedule = null;
        } else {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            long jA = rVar.a();
            long jAbs = Math.abs(jA);
            TimeUnit timeUnit2 = TimeUnit.SECONDS;
            long nanos = jAbs / timeUnit2.toNanos(1L);
            long jAbs2 = Math.abs(jA) % timeUnit2.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            if (jA < 0) {
                sb.append("ClientCall started after CallOptions deadline was exceeded. Deadline has been exceeded for ");
            } else {
                sb.append("Deadline CallOptions will be exceeded in ");
            }
            sb.append(nanos);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
            sb.append("s. ");
            scheduledFutureSchedule = o2Var.f12350a.schedule(new i0(0, this, sb), jA, timeUnit);
        }
        this.f12315d = scheduledFutureSchedule;
        this.m = qVar;
        this.f12318n = c1Var;
        this.f12319o = dVar;
        q2Var.X.getClass();
        this.p = System.nanoTime();
    }

    @Override // i4.f
    public final void a(String str, Throwable th) {
        i4.n1 n1Var = i4.n1.f11914f;
        i4.n1 n1VarH = str != null ? n1Var.h(str) : n1Var.h("Call cancelled without message");
        if (th != null) {
            n1VarH = n1VarH.g(th);
        }
        t(n1VarH, false);
    }

    @Override // i4.f
    public final void g() {
        u(new j0(this, 1));
    }

    @Override // i4.f
    public final void m() {
        if (this.g) {
            this.f12317i.m();
        } else {
            u(new j0(this, 0));
        }
    }

    @Override // i4.f
    public final void o(Object obj) {
        if (this.g) {
            this.f12317i.o(obj);
        } else {
            u(new i0(2, this, obj));
        }
    }

    @Override // i4.f
    public final void q(i4.x xVar, i4.a1 a1Var) {
        i4.n1 n1Var;
        boolean z2;
        r2.q.H(this.h == null, "already started");
        synchronized (this) {
            try {
                this.h = xVar;
                n1Var = this.j;
                z2 = this.g;
                if (!z2) {
                    m0 m0Var = new m0(xVar);
                    this.l = m0Var;
                    xVar = m0Var;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (n1Var != null) {
            this.e.execute(new l0(this, xVar, n1Var));
        } else if (z2) {
            this.f12317i.q(xVar, a1Var);
        } else {
            u(new a4.b(this, xVar, a1Var, 4));
        }
    }

    public final void t(i4.n1 n1Var, boolean z2) {
        i4.x xVar;
        synchronized (this) {
            try {
                i4.f fVar = this.f12317i;
                boolean z7 = true;
                if (fVar == null) {
                    k0 k0Var = f12314r;
                    if (fVar != null) {
                        z7 = false;
                    }
                    r2.q.G(fVar, "realCall already set to %s", z7);
                    ScheduledFuture scheduledFuture = this.f12315d;
                    if (scheduledFuture != null) {
                        scheduledFuture.cancel(false);
                    }
                    this.f12317i = k0Var;
                    xVar = this.h;
                    this.j = n1Var;
                    z7 = false;
                } else if (z2) {
                    return;
                } else {
                    xVar = null;
                }
                if (z7) {
                    u(new i0(1, this, n1Var));
                } else {
                    if (xVar != null) {
                        this.e.execute(new l0(this, xVar, n1Var));
                    }
                    v();
                }
                this.f12320q.f12334d.m.execute(new j0(this, 2));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12317i, "realCall");
        return iVarY.toString();
    }

    public final void u(Runnable runnable) {
        synchronized (this) {
            try {
                if (this.g) {
                    runnable.run();
                } else {
                    this.k.add(runnable);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r0.hasNext() == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void v() {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L5:
            monitor-enter(r3)
            java.util.List r1 = r3.k     // Catch: java.lang.Throwable -> L24
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L24
            if (r1 == 0) goto L26
            r0 = 0
            r3.k = r0     // Catch: java.lang.Throwable -> L24
            r0 = 1
            r3.g = r0     // Catch: java.lang.Throwable -> L24
            j4.m0 r0 = r3.l     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            if (r0 == 0) goto L23
            java.util.concurrent.Executor r1 = r3.e
            j4.t r2 = new j4.t
            r2.<init>(r3, r0)
            r1.execute(r2)
        L23:
            return
        L24:
            r0 = move-exception
            goto L44
        L26:
            java.util.List r1 = r3.k     // Catch: java.lang.Throwable -> L24
            r3.k = r0     // Catch: java.lang.Throwable -> L24
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            java.util.Iterator r0 = r1.iterator()
        L2f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L3f
            java.lang.Object r2 = r0.next()
            java.lang.Runnable r2 = (java.lang.Runnable) r2
            r2.run()
            goto L2f
        L3f:
            r1.clear()
            r0 = r1
            goto L5
        L44:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L24
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.m2.v():void");
    }

    public final void w() {
        t tVar;
        i4.q qVarA = this.m.a();
        try {
            i4.d dVar = this.f12319o;
            e2.f fVar = i4.i.f11873a;
            this.f12320q.f12334d.X.getClass();
            i4.f fVarG = this.f12320q.g(this.f12318n, dVar.c(fVar, Long.valueOf(System.nanoTime() - this.p)));
            synchronized (this) {
                try {
                    i4.f fVar2 = this.f12317i;
                    if (fVar2 != null) {
                        tVar = null;
                    } else {
                        r2.q.G(fVar2, "realCall already set to %s", fVar2 == null);
                        ScheduledFuture scheduledFuture = this.f12315d;
                        if (scheduledFuture != null) {
                            scheduledFuture.cancel(false);
                        }
                        this.f12317i = fVarG;
                        tVar = new t(this, this.f12316f);
                    }
                } finally {
                }
            }
            if (tVar == null) {
                this.f12320q.f12334d.m.execute(new j0(this, 2));
                return;
            }
            q2 q2Var = this.f12320q.f12334d;
            Executor executor = this.f12319o.f11842b;
            if (executor == null) {
                executor = q2Var.h;
            }
            executor.execute(new i0(20, this, tVar));
        } finally {
            this.m.c(qVarA);
        }
    }
}
