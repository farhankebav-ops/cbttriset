package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class b4 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12133a;

    @Override // j4.f4
    public final void a(m4 m4Var) {
        switch (this.f12133a) {
            case 0:
                m4Var.f12322a.flush();
                break;
            case 1:
                m4Var.f12322a.l();
                break;
            case 2:
                m4Var.f12322a.j();
                break;
            default:
                m4Var.f12322a.request();
                break;
        }
    }
}
