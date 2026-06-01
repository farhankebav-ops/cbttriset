package j4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b1 extends i4.r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q2 f12127a;

    public b1(q2 q2Var) {
        this.f12127a = q2Var;
    }

    @Override // i4.e
    public final String e() {
        return this.f12127a.f12393t.e();
    }

    @Override // i4.e
    public final i4.f f(i4.c1 c1Var, i4.d dVar) {
        return this.f12127a.f12393t.f(c1Var, dVar);
    }

    public final String toString() {
        e2.i iVarY = a.a.Y(this);
        iVarY.c(this.f12127a, "delegate");
        return iVarY.toString();
    }
}
