package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class a1 implements f0 {
    @Override // i4.d0
    public final i4.e0 a() {
        return e().a();
    }

    @Override // j4.y2
    public final Runnable c(x2 x2Var) {
        return e().c(x2Var);
    }

    @Override // j4.y2
    public void d(i4.n1 n1Var) {
        e().d(n1Var);
    }

    public abstract f0 e();

    @Override // j4.f0
    public final i4.b getAttributes() {
        return e().getAttributes();
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(e(), "delegate");
        return iVarY.toString();
    }
}
