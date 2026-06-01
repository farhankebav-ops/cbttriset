package q6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class k1 extends l {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final n1 f13560i;

    public k1(v5.c cVar, n1 n1Var) {
        super(1, cVar);
        this.f13560i = n1Var;
    }

    @Override // q6.l
    public final Throwable o(n1 n1Var) {
        Throwable thC;
        n1 n1Var2 = this.f13560i;
        n1Var2.getClass();
        Object obj = n1.f13574a.get(n1Var2);
        return (!(obj instanceof m1) || (thC = ((m1) obj).c()) == null) ? obj instanceof u ? ((u) obj).f13591a : n1Var.g() : thC;
    }

    @Override // q6.l
    public final String x() {
        return "AwaitContinuation";
    }
}
