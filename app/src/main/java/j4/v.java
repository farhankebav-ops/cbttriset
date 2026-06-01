package j4;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v extends i4.f {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Logger f12493s = Logger.getLogger(v.class.getName());

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final double f12494t;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.c1 f12495d;
    public final Executor e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12496f;
    public final h g;
    public final i4.q h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile ScheduledFuture f12497i;
    public final boolean j;
    public i4.d k;
    public w l;
    public volatile boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f12498n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12499o;
    public final g0 p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ScheduledExecutorService f12500q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i4.t f12501r = i4.t.f11955d;

    static {
        "gzip".getBytes(Charset.forName("US-ASCII"));
        f12494t = TimeUnit.SECONDS.toNanos(1L) * 1.0d;
    }

    public v(i4.c1 c1Var, Executor executor, i4.d dVar, g0 g0Var, ScheduledExecutorService scheduledExecutorService, h hVar) {
        i4.l lVar = i4.l.f11889b;
        this.f12495d = c1Var;
        Serializable serializable = c1Var.f11839d;
        System.identityHashCode(this);
        r4.b.f13625a.getClass();
        if (executor == j2.n.f12086a) {
            this.e = new t4();
            this.f12496f = true;
        } else {
            this.e = new w4(executor);
            this.f12496f = false;
        }
        this.g = hVar;
        this.h = i4.q.b();
        i4.b1 b1Var = (i4.b1) c1Var.f11838c;
        this.j = b1Var == i4.b1.f11827a || b1Var == i4.b1.f11828b;
        this.k = dVar;
        this.p = g0Var;
        this.f12500q = scheduledExecutorService;
    }

    @Override // i4.f
    public final void a(String str, Throwable th) {
        r4.b.c();
        try {
            r4.b.a();
            t(str, th);
            r4.b.f13625a.getClass();
        } catch (Throwable th2) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    @Override // i4.f
    public final void g() {
        r4.b.c();
        try {
            r4.b.a();
            r2.q.H(this.l != null, "Not started");
            r2.q.H(!this.f12498n, "call was cancelled");
            r2.q.H(!this.f12499o, "call already half-closed");
            this.f12499o = true;
            this.l.l();
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // i4.f
    public final void m() {
        r4.b.c();
        try {
            r4.b.a();
            r2.q.H(this.l != null, "Not started");
            this.l.request();
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // i4.f
    public final void o(Object obj) {
        r4.b.c();
        try {
            r4.b.a();
            v(obj);
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Override // i4.f
    public final void q(i4.x xVar, i4.a1 a1Var) {
        r4.b.c();
        try {
            r4.b.a();
            w(xVar, a1Var);
            r4.b.f13625a.getClass();
        } catch (Throwable th) {
            try {
                r4.b.f13625a.getClass();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void t(String str, Throwable th) {
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            f12493s.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.f12498n) {
            return;
        }
        this.f12498n = true;
        try {
            if (this.l != null) {
                i4.n1 n1Var = i4.n1.f11914f;
                i4.n1 n1VarH = str != null ? n1Var.h(str) : n1Var.h("Call cancelled without message");
                if (th != null) {
                    n1VarH = n1VarH.g(th);
                }
                this.l.d(n1VarH);
            }
            u();
        } catch (Throwable th2) {
            u();
            throw th2;
        }
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12495d, "method");
        return iVarY.toString();
    }

    public final void u() {
        this.h.getClass();
        ScheduledFuture scheduledFuture = this.f12497i;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    public final void v(Object obj) {
        r2.q.H(this.l != null, "Not started");
        r2.q.H(!this.f12498n, "call was cancelled");
        r2.q.H(!this.f12499o, "call was half-closed");
        try {
            w wVar = this.l;
            if (wVar instanceof g2) {
                ((g2) wVar).u(obj);
            } else {
                wVar.e(this.f12495d.m(obj));
            }
            if (this.j) {
                return;
            }
            this.l.flush();
        } catch (Error e) {
            this.l.d(i4.n1.f11914f.h("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e4) {
            this.l.d(i4.n1.f11914f.g(e4).h("Failed to stream message"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w(i4.x xVar, i4.a1 a1Var) {
        char c7;
        e2.f fVar;
        i4.d dVar;
        w g2Var;
        i4.j jVar = i4.j.f11874b;
        int i2 = 0;
        r2.q.H(this.l == null, "Already started");
        r2.q.H(!this.f12498n, "call was cancelled");
        this.h.getClass();
        i4.d dVar2 = this.k;
        e2.f fVar2 = u2.g;
        u2 u2Var = (u2) dVar2.a(fVar2);
        if (u2Var == null) {
            c7 = 1;
            fVar = fVar2;
        } else {
            Integer num = u2Var.f12489d;
            Integer num2 = u2Var.f12488c;
            Long l = u2Var.f12486a;
            if (l != null) {
                long jLongValue = l.longValue();
                TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                if (timeUnit == null) {
                    i4.j jVar2 = i4.r.f11941d;
                    throw new NullPointerException("units");
                }
                i4.r rVar = new i4.r(timeUnit.toNanos(jLongValue));
                i4.d dVar3 = this.k;
                i4.r rVar2 = dVar3.f11841a;
                if (rVar2 != null) {
                    i4.j jVar3 = rVar.f11943a;
                    if (jVar3 != rVar2.f11943a) {
                        throw new AssertionError("Tickers (" + jVar3 + " and " + rVar2.f11943a + ") don't match. Custom Ticker should only be used in tests!");
                    }
                    c7 = 1;
                    fVar = fVar2;
                    if (rVar.f11944b - rVar2.f11944b < 0) {
                    }
                } else {
                    c7 = 1;
                    fVar = fVar2;
                }
                dVar3.getClass();
                i4.c cVarB = i4.d.b(dVar3);
                cVarB.f11830a = rVar;
                this.k = new i4.d(cVarB);
            } else {
                c7 = 1;
                fVar = fVar2;
            }
            Boolean bool = u2Var.f12487b;
            if (bool != null) {
                if (bool.booleanValue()) {
                    i4.d dVar4 = this.k;
                    dVar4.getClass();
                    i4.c cVarB2 = i4.d.b(dVar4);
                    cVarB2.e = Boolean.TRUE;
                    dVar = new i4.d(cVarB2);
                } else {
                    i4.d dVar5 = this.k;
                    dVar5.getClass();
                    i4.c cVarB3 = i4.d.b(dVar5);
                    cVarB3.e = Boolean.FALSE;
                    dVar = new i4.d(cVarB3);
                }
                this.k = dVar;
            }
            if (num2 != null) {
                i4.d dVar6 = this.k;
                Integer num3 = dVar6.f11845f;
                if (num3 != null) {
                    int iMin = Math.min(num3.intValue(), num2.intValue());
                    r2.q.v(iMin, "invalid maxsize %s", iMin >= 0 ? c7 : 0);
                    i4.c cVarB4 = i4.d.b(dVar6);
                    cVarB4.f11834f = Integer.valueOf(iMin);
                    this.k = new i4.d(cVarB4);
                } else {
                    int iIntValue = num2.intValue();
                    r2.q.v(iIntValue, "invalid maxsize %s", iIntValue >= 0 ? c7 : 0);
                    i4.c cVarB5 = i4.d.b(dVar6);
                    cVarB5.f11834f = num2;
                    this.k = new i4.d(cVarB5);
                }
            }
            if (num != null) {
                i4.d dVar7 = this.k;
                Integer num4 = dVar7.g;
                if (num4 != null) {
                    int iMin2 = Math.min(num4.intValue(), num.intValue());
                    r2.q.v(iMin2, "invalid maxsize %s", iMin2 >= 0 ? c7 : 0);
                    i4.c cVarB6 = i4.d.b(dVar7);
                    cVarB6.g = Integer.valueOf(iMin2);
                    this.k = new i4.d(cVarB6);
                } else {
                    int iIntValue2 = num.intValue();
                    r2.q.v(iIntValue2, "invalid maxsize %s", iIntValue2 >= 0 ? c7 : 0);
                    i4.c cVarB7 = i4.d.b(dVar7);
                    cVarB7.g = num;
                    this.k = new i4.d(cVarB7);
                }
            }
        }
        this.k.getClass();
        i4.t tVar = this.f12501r;
        a1Var.a(f1.h);
        a1Var.a(f1.f12186d);
        i4.x0 x0Var = f1.e;
        a1Var.a(x0Var);
        byte[] bArr = tVar.f11957b;
        if (bArr.length != 0) {
            a1Var.e(x0Var, bArr);
        }
        a1Var.a(f1.f12187f);
        a1Var.a(f1.g);
        i4.r rVar3 = this.k.f11841a;
        this.h.getClass();
        i4.r rVar4 = rVar3 == null ? null : rVar3;
        if (rVar4 == null || !rVar4.isExpired()) {
            this.h.getClass();
            i4.r rVar5 = this.k.f11841a;
            Logger logger = f12493s;
            if (logger.isLoggable(Level.FINE) && rVar4 != null && rVar4.equals(null)) {
                TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
                long jMax = Math.max(0L, rVar4.a());
                Locale locale = Locale.US;
                StringBuilder sb = new StringBuilder("Call timeout set to '" + jMax + "' ns, due to context deadline.");
                if (rVar5 == null) {
                    sb.append(" Explicit call timeout was not set.");
                } else {
                    sb.append(" Explicit call timeout was '" + rVar5.a() + "' ns.");
                }
                logger.fine(sb.toString());
            }
            g0 g0Var = this.p;
            i4.c1 c1Var = this.f12495d;
            i4.d dVar8 = this.k;
            i4.q qVar = this.h;
            if (((q2) g0Var.f12200b).W) {
                u2 u2Var2 = (u2) dVar8.a(fVar);
                g2Var = new g2(g0Var, c1Var, a1Var, dVar8, u2Var2 == null ? null : u2Var2.e, u2Var2 == null ? null : u2Var2.f12490f, qVar);
            } else {
                z zVarA = g0Var.a(new q3(c1Var, a1Var, dVar8));
                i4.q qVarA = qVar.a();
                try {
                    g2Var = zVarA.b(c1Var, a1Var, dVar8, f1.c(dVar8, a1Var, 0, false));
                } finally {
                    qVar.c(qVarA);
                }
            }
            this.l = g2Var;
        } else {
            i4.i[] iVarArrC = f1.c(this.k, a1Var, 0, false);
            i4.r rVar6 = this.k.f11841a;
            this.h.getClass();
            String str = rVar6 == null ? "Context" : "CallOptions";
            Long l8 = (Long) this.k.a(i4.i.f11873a);
            TimeUnit timeUnit3 = TimeUnit.NANOSECONDS;
            double dA = rVar4.a();
            double d8 = f12494t;
            Double dValueOf = Double.valueOf(dA / d8);
            Double dValueOf2 = Double.valueOf(l8 == null ? 0.0d : l8.longValue() / d8);
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[c7] = dValueOf;
            objArr[2] = dValueOf2;
            this.l = new y0(i4.n1.h.h(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", objArr)), x.f12538a, iVarArrC);
        }
        if (this.f12496f) {
            this.l.j();
        }
        this.k.getClass();
        Integer num5 = this.k.f11845f;
        if (num5 != null) {
            this.l.i(num5.intValue());
        }
        Integer num6 = this.k.g;
        if (num6 != null) {
            this.l.a(num6.intValue());
        }
        if (rVar4 != null) {
            this.l.k(rVar4);
        }
        this.l.b(jVar);
        this.l.h(this.f12501r);
        h hVar = this.g;
        ((c2) hVar.f12232b).a();
        ((e3) hVar.f12231a).p();
        w wVar = this.l;
        e2.h hVar2 = new e2.h();
        hVar2.f11233c = this;
        hVar2.f11231a = xVar;
        wVar.m(hVar2);
        this.h.getClass();
        Logger logger2 = i4.q.f11931a;
        if (rVar4 != null) {
            this.h.getClass();
            if (!rVar4.equals(null) && this.f12500q != null) {
                TimeUnit timeUnit4 = TimeUnit.NANOSECONDS;
                long jA = rVar4.a();
                this.f12497i = this.f12500q.schedule(new b2(new u(this, jA, i2)), jA, timeUnit4);
            }
        }
        if (this.m) {
            u();
        }
    }
}
