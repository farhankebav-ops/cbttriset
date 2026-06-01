package q4;

import i4.j0;
import i4.m0;
import i4.s1;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a extends i4.x {
    @Override // i4.x
    public i4.f a(j0 j0Var) {
        return o().a(j0Var);
    }

    @Override // i4.x
    public final i4.f b() {
        return o().b();
    }

    @Override // i4.x
    public final ScheduledExecutorService c() {
        return o().c();
    }

    @Override // i4.x
    public final s1 e() {
        return o().e();
    }

    @Override // i4.x
    public final void k() {
        o().k();
    }

    @Override // i4.x
    public void n(i4.m mVar, m0 m0Var) {
        o().n(mVar, m0Var);
    }

    public abstract i4.x o();

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(o(), "delegate");
        return iVarY.toString();
    }
}
