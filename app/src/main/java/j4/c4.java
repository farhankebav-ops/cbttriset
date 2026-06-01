package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class c4 implements f4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12145b;

    public /* synthetic */ c4(int i2, int i8) {
        this.f12144a = i8;
        this.f12145b = i2;
    }

    @Override // j4.f4
    public final void a(m4 m4Var) {
        switch (this.f12144a) {
            case 0:
                m4Var.f12322a.i(this.f12145b);
                break;
            default:
                m4Var.f12322a.a(this.f12145b);
                break;
        }
    }
}
