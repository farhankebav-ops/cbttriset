package j4;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class h2 extends i4.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.c0 f12240d;
    public final i4.e e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Executor f12241f;
    public final i4.c1 g;
    public final i4.q h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i4.d f12242i;
    public i4.f j;

    public h2(i4.c0 c0Var, l2 l2Var, Executor executor, i4.c1 c1Var, i4.d dVar) {
        this.f12240d = c0Var;
        this.e = l2Var;
        this.g = c1Var;
        Executor executor2 = dVar.f11842b;
        executor = executor2 != null ? executor2 : executor;
        this.f12241f = executor;
        i4.c cVarB = i4.d.b(dVar);
        cVarB.f11831b = executor;
        this.f12242i = new i4.d(cVarB);
        this.h = i4.q.b();
    }

    @Override // i4.w, i4.f
    public final void a(String str, Throwable th) {
        i4.f fVar = this.j;
        if (fVar != null) {
            fVar.a(str, th);
        }
    }

    @Override // i4.f
    public final void q(i4.x xVar, i4.a1 a1Var) {
        i4.d dVar = this.f12242i;
        i4.c1 c1Var = this.g;
        r2.q.D(c1Var, "method");
        r2.q.D(dVar, "callOptions");
        android.support.v4.media.g gVarA = this.f12240d.a();
        i4.n1 n1Var = (i4.n1) gVarA.f3263b;
        if (!n1Var.f()) {
            this.f12241f.execute(new l0(this, xVar, f1.h(n1Var)));
            this.j = q2.i0;
            return;
        }
        w2 w2Var = (w2) gVarA.f3264c;
        u2 u2Var = (u2) w2Var.f12528b.get((String) c1Var.f11839d);
        if (u2Var == null) {
            u2Var = (u2) w2Var.f12529c.get((String) c1Var.e);
        }
        if (u2Var == null) {
            u2Var = w2Var.f12527a;
        }
        if (u2Var != null) {
            this.f12242i = this.f12242i.c(u2.g, u2Var);
        }
        i4.f fVarF = this.e.f(c1Var, this.f12242i);
        this.j = fVarF;
        fVarF.q(xVar, a1Var);
    }

    @Override // i4.w
    public final i4.f t() {
        return this.j;
    }
}
