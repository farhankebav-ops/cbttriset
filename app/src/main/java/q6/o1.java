package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 extends u1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final v5.c f13576d;

    public o1(v5.h hVar, e6.p pVar) {
        super(hVar, false);
        this.f13576d = a.a.s(pVar, this, this);
    }

    @Override // q6.n1
    public final void T() {
        try {
            v6.a.h(q5.x.f13520a, a.a.I(this.f13576d));
        } catch (Throwable th) {
            resumeWith(r2.q.M(th));
            throw th;
        }
    }
}
