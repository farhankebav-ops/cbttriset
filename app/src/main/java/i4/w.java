package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class w extends f {
    @Override // i4.f
    public void a(String str, Throwable th) {
        t().a(str, th);
    }

    @Override // i4.f
    public final void g() {
        t().g();
    }

    @Override // i4.f
    public final void m() {
        t().m();
    }

    @Override // i4.f
    public final void o(Object obj) {
        t().o(obj);
    }

    public abstract f t();

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(t(), "delegate");
        return iVarY.toString();
    }
}
