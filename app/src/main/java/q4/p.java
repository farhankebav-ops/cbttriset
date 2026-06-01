package q4;

import i4.a1;
import i4.n1;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p extends i4.i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i4.i f13471b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r f13472c;

    public p(r rVar, i4.i iVar) {
        this.f13472c = rVar;
        this.f13471b = iVar;
    }

    @Override // i4.i
    public final void a() {
        this.f13471b.a();
    }

    @Override // i4.i
    public final void b() {
        this.f13471b.b();
    }

    @Override // i4.i
    public final void c(int i2) {
        this.f13471b.c(i2);
    }

    @Override // i4.i
    public final void d(int i2, long j) {
        this.f13471b.d(i2, j);
    }

    @Override // i4.i
    public final void e(a1 a1Var) {
        this.f13471b.e(a1Var);
    }

    @Override // i4.i
    public final void f(long j) {
        this.f13471b.f(j);
    }

    @Override // i4.i
    public final void g(long j) {
        this.f13471b.g(j);
    }

    @Override // i4.i
    public final void h() {
        this.f13471b.h();
    }

    @Override // i4.i
    public final void i(int i2) {
        this.f13471b.i(i2);
    }

    @Override // i4.i
    public final void j(int i2, long j, long j3) {
        this.f13471b.j(i2, j, j3);
    }

    @Override // i4.i
    public final void k(long j) {
        this.f13471b.k(j);
    }

    @Override // i4.i
    public final void l(long j) {
        this.f13471b.l(j);
    }

    @Override // i4.i
    public final void m(n1 n1Var) {
        k kVar = this.f13472c.f13474a;
        boolean zF = n1Var.f();
        o oVar = kVar.f13453a;
        if (oVar.e != null || oVar.f13470f != null) {
            if (zF) {
                ((AtomicLong) kVar.f13454b.f3263b).getAndIncrement();
            } else {
                ((AtomicLong) kVar.f13454b.f3264c).getAndIncrement();
            }
        }
        this.f13471b.m(n1Var);
    }

    @Override // i4.i
    public final void n(i4.b bVar, a1 a1Var) {
        this.f13471b.n(bVar, a1Var);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f13471b, "delegate");
        return iVarY.toString();
    }
}
