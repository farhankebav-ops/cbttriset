package q4;

import i4.l0;
import i4.m0;
import i4.n1;
import i4.o0;
import i4.p0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends o0 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final j4.i f13436o = new j4.i(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f13437f;
    public final a g;
    public p0 h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o0 f13438i;
    public p0 j;
    public o0 k;
    public i4.m l;
    public m0 m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f13439n;

    public e(a aVar) {
        c cVar = new c(this);
        this.f13437f = cVar;
        this.f13438i = cVar;
        this.k = cVar;
        this.g = aVar;
    }

    @Override // i4.o0
    public final boolean b() {
        return g().b();
    }

    @Override // i4.o0
    public final void c(n1 n1Var) {
        g().c(n1Var);
    }

    @Override // i4.o0
    public final void d(l0 l0Var) {
        g().d(l0Var);
    }

    @Override // i4.o0
    public final void e() {
        g().e();
    }

    @Override // i4.o0
    public final void f() {
        this.k.f();
        this.f13438i.f();
    }

    public final o0 g() {
        o0 o0Var = this.k;
        return o0Var == this.f13437f ? this.f13438i : o0Var;
    }

    public final void h() {
        this.g.n(this.l, this.m);
        this.f13438i.f();
        this.f13438i = this.k;
        this.h = this.j;
        this.k = this.f13437f;
        this.j = null;
    }

    public final void i(p0 p0Var) {
        r2.q.D(p0Var, "newBalancerFactory");
        if (p0Var.equals(this.j)) {
            return;
        }
        this.k.f();
        this.k = this.f13437f;
        this.j = null;
        this.l = i4.m.f11894a;
        this.m = f13436o;
        if (p0Var.equals(this.h)) {
            return;
        }
        d dVar = new d(this);
        o0 o0VarB = p0Var.b(dVar);
        dVar.f13434b = o0VarB;
        this.k = o0VarB;
        this.j = p0Var;
        if (this.f13439n) {
            return;
        }
        h();
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(g(), "delegate");
        return iVarY.toString();
    }
}
