package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a4 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12118a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f12119b;

    public /* synthetic */ a4(Object obj, int i2) {
        this.f12118a = i2;
        this.f12119b = obj;
    }

    @Override // j4.f4
    public final void a(m4 m4Var) {
        switch (this.f12118a) {
            case 0:
                m4Var.f12322a.b((i4.k) this.f12119b);
                break;
            case 1:
                m4Var.f12322a.k((i4.r) this.f12119b);
                break;
            default:
                m4Var.f12322a.h((i4.t) this.f12119b);
                break;
        }
    }
}
