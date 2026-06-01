package j4;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g5 implements y, w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final e3 f12227d = new e3(20);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12230c;

    public /* synthetic */ g5(int i2, Object obj, Object obj2) {
        this.f12228a = i2;
        this.f12230c = obj;
        this.f12229b = obj2;
    }

    @Override // j4.w
    public void a(int i2) {
        ((w) this.f12229b).a(i2);
    }

    @Override // j4.e5
    public void b(i4.k kVar) {
        ((w) this.f12229b).b(kVar);
    }

    @Override // j4.y
    public void c(i4.n1 n1Var, x xVar, i4.a1 a1Var) {
        boolean z2;
        h4 h4Var;
        g2 g2Var;
        r1 r1Var;
        switch (this.f12228a) {
            case 2:
                h hVar = ((o1) ((g5) this.f12230c).f12230c).f12349b;
                if (n1Var.f()) {
                    ((c2) hVar.f12233c).a();
                } else {
                    ((c2) hVar.f12234d).a();
                }
                ((y) this.f12229b).c(n1Var, xVar, a1Var);
                return;
            default:
                Integer numValueOf = -1;
                synchronized (((g2) this.f12230c).f12209i) {
                    g2 g2Var2 = (g2) this.f12230c;
                    g2Var2.f12211o = g2Var2.f12211o.d((m4) this.f12229b);
                    ((g2) this.f12230c).f12210n.f12300b.add(String.valueOf(n1Var.f11918a));
                    break;
                }
                if (((g2) this.f12230c).f12213r.decrementAndGet() == Integer.MIN_VALUE) {
                    ((g2) this.f12230c).f12206c.execute(new l4(this, 0));
                    return;
                }
                m4 m4Var = (m4) this.f12229b;
                if (m4Var.f12324c) {
                    g2 g2Var3 = (g2) this.f12230c;
                    z3 z3VarF = g2Var3.f(m4Var);
                    if (z3VarF != null) {
                        g2Var3.f12205b.execute(z3VarF);
                    }
                    if (((g2) this.f12230c).f12211o.f12277f == ((m4) this.f12229b)) {
                        ((g2) this.f12230c).t(n1Var, xVar, a1Var);
                        return;
                    }
                    return;
                }
                x xVar2 = x.f12541d;
                if (xVar == xVar2 && ((g2) this.f12230c).f12212q.incrementAndGet() > 1000) {
                    g2 g2Var4 = (g2) this.f12230c;
                    z3 z3VarF2 = g2Var4.f((m4) this.f12229b);
                    if (z3VarF2 != null) {
                        g2Var4.f12205b.execute(z3VarF2);
                    }
                    if (((g2) this.f12230c).f12211o.f12277f == ((m4) this.f12229b)) {
                        ((g2) this.f12230c).t(i4.n1.l.h("Too many transparent retries. Might be a bug in gRPC").g(n1Var.a()), xVar, a1Var);
                        return;
                    }
                    return;
                }
                if (((g2) this.f12230c).f12211o.f12277f == null) {
                    if (xVar == xVar2 || (xVar == x.f12539b && ((g2) this.f12230c).p.compareAndSet(false, true))) {
                        m4 m4VarG = ((g2) this.f12230c).g(((m4) this.f12229b).f12325d, true);
                        if (m4VarG == null) {
                            return;
                        }
                        g2 g2Var5 = (g2) this.f12230c;
                        if (g2Var5.h) {
                            synchronized (g2Var5.f12209i) {
                                g2 g2Var6 = (g2) this.f12230c;
                                g2Var6.f12211o = g2Var6.f12211o.c((m4) this.f12229b, m4VarG);
                                break;
                            }
                        }
                        ((g2) this.f12230c).f12205b.execute(new k4(this, m4VarG, 1));
                        return;
                    }
                    if (xVar == x.f12540c) {
                        g2 g2Var7 = (g2) this.f12230c;
                        if (g2Var7.h) {
                            g2Var7.q();
                        }
                    } else {
                        ((g2) this.f12230c).p.set(true);
                        g2 g2Var8 = (g2) this.f12230c;
                        if (g2Var8.h) {
                            String str = (String) a1Var.c(g2.F);
                            if (str != null) {
                                try {
                                    numValueOf = Integer.valueOf(str);
                                    break;
                                } catch (NumberFormatException unused) {
                                }
                            } else {
                                numValueOf = null;
                            }
                            g2 g2Var9 = (g2) this.f12230c;
                            boolean zContains = g2Var9.g.f12239c.contains(n1Var.f11918a);
                            boolean z7 = (g2Var9.m == null || (!zContains && (numValueOf == null || numValueOf.intValue() >= 0))) ? false : !g2Var9.m.a();
                            if (zContains && !z7 && !n1Var.f() && numValueOf != null && numValueOf.intValue() > 0) {
                                numValueOf = 0;
                            }
                            boolean z8 = zContains && !z7;
                            if (z8) {
                                g2.c((g2) this.f12230c, numValueOf);
                            }
                            synchronized (((g2) this.f12230c).f12209i) {
                                try {
                                    g2 g2Var10 = (g2) this.f12230c;
                                    g2Var10.f12211o = g2Var10.f12211o.b((m4) this.f12229b);
                                    if (z8) {
                                        g2 g2Var11 = (g2) this.f12230c;
                                        if (!g2Var11.r(g2Var11.f12211o)) {
                                            if (!((g2) this.f12230c).f12211o.f12276d.isEmpty()) {
                                            }
                                        }
                                        return;
                                    }
                                } finally {
                                }
                            }
                        } else {
                            o4 o4Var = g2Var8.f12208f;
                            long nanos = 0;
                            if (o4Var == null) {
                                h4Var = new h4(false, 0L);
                            } else {
                                boolean zContains2 = o4Var.f12356f.contains(n1Var.f11918a);
                                String str2 = (String) a1Var.c(g2.F);
                                if (str2 != null) {
                                    try {
                                        numValueOf = Integer.valueOf(str2);
                                        break;
                                    } catch (NumberFormatException unused2) {
                                    }
                                } else {
                                    numValueOf = null;
                                }
                                boolean z9 = (g2Var8.m == null || (!zContains2 && (numValueOf == null || numValueOf.intValue() >= 0))) ? false : !g2Var8.m.a();
                                if (g2Var8.f12208f.f12352a <= ((m4) this.f12229b).f12325d + 1 || z9) {
                                    z2 = false;
                                    h4Var = new h4(z2, nanos);
                                } else {
                                    if (numValueOf == null) {
                                        if (zContains2) {
                                            nanos = (long) (g2.H.nextDouble() * g2Var8.f12219x);
                                            double d8 = g2Var8.f12219x;
                                            o4 o4Var2 = g2Var8.f12208f;
                                            g2Var8.f12219x = Math.min((long) (d8 * o4Var2.f12355d), o4Var2.f12354c);
                                            z2 = true;
                                        }
                                        z2 = false;
                                    } else {
                                        if (numValueOf.intValue() >= 0) {
                                            nanos = TimeUnit.MILLISECONDS.toNanos(numValueOf.intValue());
                                            g2Var8.f12219x = g2Var8.f12208f.f12353b;
                                            z2 = true;
                                        }
                                        z2 = false;
                                    }
                                    h4Var = new h4(z2, nanos);
                                }
                            }
                            if (h4Var.f12245a) {
                                m4 m4VarG2 = ((g2) this.f12230c).g(((m4) this.f12229b).f12325d + 1, false);
                                if (m4VarG2 == null) {
                                    return;
                                }
                                synchronized (((g2) this.f12230c).f12209i) {
                                    g2Var = (g2) this.f12230c;
                                    r1Var = new r1(g2Var.f12209i);
                                    g2Var.f12217v = r1Var;
                                    break;
                                }
                                r1Var.a(g2Var.f12207d.schedule(new k4(this, m4VarG2, 0), h4Var.f12246b, TimeUnit.NANOSECONDS));
                                return;
                            }
                        }
                    }
                }
                g2 g2Var12 = (g2) this.f12230c;
                z3 z3VarF3 = g2Var12.f((m4) this.f12229b);
                if (z3VarF3 != null) {
                    g2Var12.f12205b.execute(z3VarF3);
                }
                if (((g2) this.f12230c).f12211o.f12277f == ((m4) this.f12229b)) {
                    ((g2) this.f12230c).t(n1Var, xVar, a1Var);
                    return;
                }
                return;
        }
    }

    @Override // j4.w
    public void d(i4.n1 n1Var) {
        ((w) this.f12229b).d(n1Var);
    }

    @Override // j4.e5
    public void e(o4.a aVar) {
        ((w) this.f12229b).e(aVar);
    }

    @Override // j4.y
    public void f(i4.a1 a1Var) {
        int i2;
        int i8;
        switch (this.f12228a) {
            case 2:
                ((y) this.f12229b).f(a1Var);
                break;
            default:
                if (((m4) this.f12229b).f12325d > 0) {
                    i4.v0 v0Var = g2.E;
                    a1Var.a(v0Var);
                    a1Var.e(v0Var, String.valueOf(((m4) this.f12229b).f12325d));
                }
                g2 g2Var = (g2) this.f12230c;
                m4 m4Var = (m4) this.f12229b;
                i4.v0 v0Var2 = g2.E;
                z3 z3VarF = g2Var.f(m4Var);
                if (z3VarF != null) {
                    g2Var.f12205b.execute(z3VarF);
                }
                if (((g2) this.f12230c).f12211o.f12277f == ((m4) this.f12229b)) {
                    n4 n4Var = ((g2) this.f12230c).m;
                    if (n4Var != null) {
                        AtomicInteger atomicInteger = n4Var.f12340d;
                        do {
                            i2 = atomicInteger.get();
                            i8 = n4Var.f12337a;
                            if (i2 == i8) {
                            }
                        } while (!atomicInteger.compareAndSet(i2, Math.min(n4Var.f12339c + i2, i8)));
                    }
                    ((g2) this.f12230c).f12206c.execute(new i0(23, this, a1Var));
                }
                break;
        }
    }

    @Override // j4.e5
    public void flush() {
        ((w) this.f12229b).flush();
    }

    @Override // j4.y
    public void g(a4.a aVar) {
        switch (this.f12228a) {
            case 2:
                ((y) this.f12229b).g(aVar);
                break;
            default:
                j4 j4Var = ((g2) this.f12230c).f12211o;
                r2.q.H(j4Var.f12277f != null, "Headers should be received prior to messages.");
                if (j4Var.f12277f == ((m4) this.f12229b)) {
                    ((g2) this.f12230c).f12206c.execute(new i0(24, this, aVar));
                } else {
                    Logger logger = f1.f12183a;
                    while (true) {
                        InputStream inputStreamK = aVar.k();
                        if (inputStreamK != null) {
                            f1.b(inputStreamK);
                        }
                    }
                }
                break;
        }
    }

    @Override // j4.w
    public void h(i4.t tVar) {
        ((w) this.f12229b).h(tVar);
    }

    @Override // j4.w
    public void i(int i2) {
        ((w) this.f12229b).i(i2);
    }

    @Override // j4.e5
    public boolean isReady() {
        return ((w) this.f12229b).isReady();
    }

    @Override // j4.e5
    public void j() {
        ((w) this.f12229b).j();
    }

    @Override // j4.w
    public void k(i4.r rVar) {
        ((w) this.f12229b).k(rVar);
    }

    @Override // j4.w
    public void l() {
        ((w) this.f12229b).l();
    }

    @Override // j4.w
    public void m(y yVar) {
        h hVar = ((o1) this.f12230c).f12349b;
        ((c2) hVar.f12232b).a();
        ((e3) hVar.f12231a).p();
        ((w) this.f12229b).m(new g5(2, this, yVar));
    }

    @Override // j4.w
    public void n(l1 l1Var) {
        ((w) this.f12229b).n(l1Var);
    }

    @Override // j4.y
    public void o() {
        switch (this.f12228a) {
            case 2:
                ((y) this.f12229b).o();
                break;
            default:
                g2 g2Var = (g2) this.f12230c;
                if (g2Var.isReady()) {
                    g2Var.f12206c.execute(new l4(this, 1));
                    break;
                }
                break;
        }
    }

    @Override // j4.e5
    public void request() {
        ((w) this.f12229b).request();
    }

    public String toString() {
        switch (this.f12228a) {
            case 2:
                e2.i iVarY = a.a.Y(this);
                iVarY.c((y) this.f12229b, "delegate");
                return iVarY.toString();
            case 3:
                e2.i iVarY2 = a.a.Y(this);
                iVarY2.c((w) this.f12229b, "delegate");
                return iVarY2.toString();
            default:
                return super.toString();
        }
    }

    public g5() {
        this.f12228a = 0;
        e3 e3Var = e3.f12177c;
        this.f12230c = z4.c();
        this.f12229b = e3Var;
    }

    public g5(String str) {
        this.f12228a = 1;
        i4.q0 q0VarB = i4.q0.b();
        r2.q.D(q0VarB, "registry");
        this.f12229b = q0VarB;
        r2.q.D(str, "defaultPolicy");
        this.f12230c = str;
    }
}
