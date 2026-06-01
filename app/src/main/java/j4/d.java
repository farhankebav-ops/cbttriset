package j4;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends z4 implements w {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Logger f12150i = Logger.getLogger(d.class.getName());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g5 f12151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c1 f12152d;
    public final boolean e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f12153f;
    public i4.a1 g;
    public volatile boolean h;

    public d(w1.f fVar, d5 d5Var, g5 g5Var, i4.a1 a1Var, i4.d dVar, boolean z2) {
        r2.q.D(a1Var, "headers");
        r2.q.D(g5Var, "transportTracer");
        this.f12151c = g5Var;
        this.e = !Boolean.TRUE.equals(dVar.a(f1.f12189n));
        this.f12153f = z2;
        if (z2) {
            this.f12152d = new a(this, a1Var, d5Var);
        } else {
            this.f12152d = new d3(this, fVar, d5Var);
            this.g = a1Var;
        }
    }

    @Override // j4.w
    public final void a(int i2) {
        this.f12152d.a(i2);
    }

    @Override // j4.w
    public final void d(i4.n1 n1Var) {
        r2.q.y(!n1Var.f(), "Should not cancel with OK status");
        this.h = true;
        a4.a aVar = ((k4.k) this).f12653o;
        aVar.getClass();
        r4.b.c();
        try {
            synchronized (((k4.k) aVar.f3216b).f12652n.f12648w) {
                ((k4.k) aVar.f3216b).f12652n.m(n1Var, true, null);
            }
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

    @Override // j4.w
    public final void h(i4.t tVar) {
        k4.j jVar = ((k4.k) this).f12652n;
        r2.q.H(jVar.j == null, "Already called start");
        r2.q.D(tVar, "decompressorRegistry");
        jVar.k = tVar;
    }

    @Override // j4.w
    public final void i(int i2) {
        ((k4.k) this).f12652n.f12134a.f12109b = i2;
    }

    @Override // j4.e5
    public final boolean isReady() {
        return ((k4.k) this).f12652n.e() && !this.h;
    }

    @Override // j4.w
    public final void k(i4.r rVar) {
        i4.a1 a1Var = this.g;
        i4.v0 v0Var = f1.f12185c;
        a1Var.a(v0Var);
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.g.e(v0Var, Long.valueOf(Math.max(0L, rVar.a())));
    }

    @Override // j4.w
    public final void l() {
        k4.k kVar = (k4.k) this;
        if (kVar.f12652n.f12140n) {
            return;
        }
        kVar.f12652n.f12140n = true;
        this.f12152d.close();
    }

    @Override // j4.w
    public final void m(y yVar) {
        k4.k kVar = (k4.k) this;
        k4.j jVar = kVar.f12652n;
        r2.q.H(jVar.j == null, "Already called setListener");
        r2.q.D(yVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        jVar.j = yVar;
        if (this.f12153f) {
            return;
        }
        kVar.f12653o.n(this.g, null);
        this.g = null;
    }

    @Override // j4.w
    public final void n(l1 l1Var) {
        l1Var.a(((k4.k) this).p.f11822a.get(i4.f.f11857a), "remote_addr");
    }

    public final void t(k4.u uVar, boolean z2, boolean z7, int i2) {
        l7.j jVar;
        r2.q.y(uVar != null || z2, "null frame before EOS");
        a4.a aVar = ((k4.k) this).f12653o;
        aVar.getClass();
        r4.b.c();
        try {
            if (uVar == null) {
                jVar = k4.k.f12651r;
            } else {
                jVar = uVar.f12688a;
                int i8 = (int) jVar.f12868b;
                if (i8 > 0) {
                    k4.k.u((k4.k) aVar.f3216b, i8);
                }
            }
            synchronized (((k4.k) aVar.f3216b).f12652n.f12648w) {
                k4.j.l(((k4.k) aVar.f3216b).f12652n, jVar, z2, z7);
                g5 g5Var = ((k4.k) aVar.f3216b).f12151c;
                if (i2 == 0) {
                    g5Var.getClass();
                } else {
                    g5Var.getClass();
                    ((e3) g5Var.f12229b).p();
                }
            }
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
}
