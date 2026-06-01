package j4;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class j2 extends i4.x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h f12267a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q2 f12268b;

    public j2(q2 q2Var) {
        this.f12268b = q2Var;
    }

    @Override // i4.x
    public final i4.f a(i4.j0 j0Var) {
        q2 q2Var = this.f12268b;
        q2Var.m.d();
        r2.q.H(!q2Var.H, "Channel is being terminated");
        return new p2(q2Var, j0Var);
    }

    @Override // i4.x
    public final i4.f b() {
        return this.f12268b.N;
    }

    @Override // i4.x
    public final ScheduledExecutorService c() {
        return this.f12268b.g;
    }

    @Override // i4.x
    public final i4.s1 e() {
        return this.f12268b.m;
    }

    @Override // i4.x
    public final void k() {
        i4.s1 s1Var = this.f12268b.m;
        s1Var.d();
        s1Var.execute(new a4.c(this, 8));
    }

    @Override // i4.x
    public final void n(i4.m mVar, i4.m0 m0Var) {
        i4.s1 s1Var = this.f12268b.m;
        s1Var.d();
        r2.q.D(mVar, "newState");
        r2.q.D(m0Var, "newPicker");
        s1Var.execute(new a4.b(this, m0Var, mVar, 6));
    }
}
