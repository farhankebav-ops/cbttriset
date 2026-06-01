package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class l4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g5 f12305b;

    public /* synthetic */ l4(g5 g5Var, int i2) {
        this.f12304a = i2;
        this.f12305b = g5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f12304a) {
            case 0:
                g2 g2Var = (g2) this.f12305b.f12230c;
                g2Var.f12220z = true;
                y yVar = g2Var.f12216u;
                e2.h hVar = g2Var.f12214s;
                yVar.c((i4.n1) hVar.f11231a, (x) hVar.f11232b, (i4.a1) hVar.f11233c);
                break;
            default:
                g2 g2Var2 = (g2) this.f12305b.f12230c;
                if (!g2Var2.f12220z) {
                    g2Var2.f12216u.o();
                }
                break;
        }
    }
}
