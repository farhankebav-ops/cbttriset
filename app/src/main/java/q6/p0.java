package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p0 extends j1 {
    public final /* synthetic */ int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f13577f;

    public /* synthetic */ p0(Object obj, int i2) {
        this.e = i2;
        this.f13577f = obj;
    }

    @Override // q6.j1
    public final boolean i() {
        switch (this.e) {
        }
        return false;
    }

    @Override // q6.j1
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                ((o0) this.f13577f).dispose();
                break;
            case 1:
                ((e6.l) this.f13577f).invoke(th);
                break;
            default:
                k1 k1Var = (k1) this.f13577f;
                Object obj = n1.f13574a.get(h());
                if (!(obj instanceof u)) {
                    k1Var.resumeWith(c0.F(obj));
                } else {
                    k1Var.resumeWith(r2.q.M(((u) obj).f13591a));
                }
                break;
        }
    }
}
