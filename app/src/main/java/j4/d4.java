package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class d4 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f12160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g2 f12161b;

    public d4(g2 g2Var, Object obj) {
        this.f12161b = g2Var;
        this.f12160a = obj;
    }

    @Override // j4.f4
    public final void a(m4 m4Var) {
        m4Var.f12322a.e(this.f12161b.f12204a.m(this.f12160a));
        m4Var.f12322a.flush();
    }
}
