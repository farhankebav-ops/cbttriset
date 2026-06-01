package q4;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends i4.f {
    @Override // i4.f
    public final List c() {
        return t().c();
    }

    @Override // i4.f
    public final i4.f e() {
        return t().e();
    }

    @Override // i4.f
    public final Object f() {
        return t().f();
    }

    @Override // i4.f
    public final void n() {
        t().n();
    }

    @Override // i4.f
    public void p() {
        t().p();
    }

    @Override // i4.f
    public void s(List list) {
        t().s(list);
    }

    public abstract i4.f t();

    public String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(t(), "delegate");
        return iVarY.toString();
    }
}
