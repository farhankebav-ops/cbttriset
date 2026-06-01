package j4;

import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a3 f12134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f12135b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g5 f12136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a3 f12137d;
    public int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f12138f;
    public boolean g;
    public final d5 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f12139i;
    public y j;
    public i4.t k;
    public boolean l;
    public b m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile boolean f12140n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f12141o;
    public boolean p;

    public c(int i2, d5 d5Var, g5 g5Var) {
        r2.q.D(g5Var, "transportTracer");
        this.f12136c = g5Var;
        a3 a3Var = new a3(this, i2, d5Var, g5Var);
        this.f12137d = a3Var;
        this.f12134a = a3Var;
        this.k = i4.t.f11955d;
        this.l = false;
        this.h = d5Var;
    }

    public abstract void a(int i2);

    public final void b(i4.n1 n1Var, x xVar, i4.a1 a1Var) {
        if (this.f12139i) {
            return;
        }
        this.f12139i = true;
        d5 d5Var = this.h;
        if (d5Var.f12163b.compareAndSet(false, true)) {
            for (i4.i iVar : d5Var.f12162a) {
                iVar.m(n1Var);
            }
        }
        if (this.f12136c != null) {
            n1Var.f();
        }
        this.j.c(n1Var, xVar, a1Var);
    }

    public abstract void c(boolean z2);

    public final void d(i4.a1 a1Var) throws EOFException {
        i4.j jVar = i4.j.f11874b;
        r2.q.H(!this.f12141o, "Received headers on closed stream");
        for (i4.i iVar : this.h.f12162a) {
            iVar.b();
        }
        String str = (String) a1Var.c(f1.f12186d);
        if (str != null) {
            i4.s sVar = (i4.s) this.k.f11956a.get(str);
            i4.k kVar = sVar != null ? sVar.f11949a : null;
            if (kVar == null) {
                ((k4.j) this).n(i4.n1.l.h("Can't find decompressor for ".concat(str)).a());
                return;
            } else if (kVar != jVar) {
                a3 a3Var = this.f12134a;
                a3Var.getClass();
                r2.q.H(true, "Already set full stream decompressor");
                a3Var.e = kVar;
            }
        }
        this.j.f(a1Var);
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f12135b) {
            try {
                z2 = this.f12138f && this.e < 32768 && !this.g;
            } finally {
            }
        }
        return z2;
    }

    public final void f() {
        boolean zE;
        synchronized (this.f12135b) {
            zE = e();
        }
        if (zE) {
            this.j.o();
        }
    }

    public final void g(i4.n1 n1Var, x xVar, boolean z2, i4.a1 a1Var) {
        r2.q.D(n1Var, "status");
        if (!this.f12141o || z2) {
            this.f12141o = true;
            this.p = n1Var.f();
            synchronized (this.f12135b) {
                try {
                    this.g = true;
                } catch (Throwable th) {
                    th = th;
                    while (true) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
            }
            if (this.l) {
                this.m = null;
                b(n1Var, xVar, a1Var);
                return;
            }
            this.m = new b(this, n1Var, xVar, a1Var, 0);
            if (z2) {
                this.f12134a.close();
                return;
            }
            a3 a3Var = this.f12134a;
            if (a3Var.isClosed()) {
                return;
            }
            if (a3Var.l.f12168c == 0) {
                a3Var.close();
            } else {
                a3Var.f12116q = true;
            }
        }
    }

    public final void h(i4.n1 n1Var, boolean z2, i4.a1 a1Var) {
        g(n1Var, x.f12538a, z2, a1Var);
    }
}
