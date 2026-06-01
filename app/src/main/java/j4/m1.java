package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class m1 extends e2.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f12312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i4.d0 f12313d;

    public /* synthetic */ m1(i4.d0 d0Var, int i2) {
        this.f12312c = i2;
        this.f12313d = d0Var;
    }

    @Override // e2.b
    public final void a() {
        switch (this.f12312c) {
            case 0:
                t1 t1Var = (t1) this.f12313d;
                ((p2) t1Var.f12460d.f12230c).m.Y.c(t1Var, true);
                break;
            case 1:
                ((q2) this.f12313d).h();
                break;
            default:
                ((k4.n) this.f12313d).h.b(true);
                break;
        }
    }

    @Override // e2.b
    public final void b() {
        switch (this.f12312c) {
            case 0:
                t1 t1Var = (t1) this.f12313d;
                ((p2) t1Var.f12460d.f12230c).m.Y.c(t1Var, false);
                break;
            case 1:
                q2 q2Var = (q2) this.f12313d;
                if (!q2Var.G.get()) {
                    q2Var.j();
                    break;
                }
                break;
            default:
                ((k4.n) this.f12313d).h.b(false);
                break;
        }
    }
}
