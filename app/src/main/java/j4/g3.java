package j4;

import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class g3 implements i4.n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i4.n f12221a = i4.n.a(i4.m.f11897d);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j3 f12222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ k3 f12223c;

    public g3(k3 k3Var) {
        this.f12223c = k3Var;
    }

    @Override // i4.n0
    public final void a(i4.n nVar) {
        k3.f12286o.log(Level.FINE, "Received health status {0} for subchannel {1}", new Object[]{nVar, this.f12222b.f12269a});
        this.f12221a = nVar;
        k3 k3Var = this.f12223c;
        if (k3Var.h.c() && ((j3) k3Var.g.get(k3Var.h.a())).f12271c == this) {
            k3Var.j(this.f12222b);
        }
    }
}
