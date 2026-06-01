package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class p1 extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f11928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a1 f11929b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f11930c;

    public p1(n1 n1Var, a1 a1Var) {
        super(n1.c(n1Var), n1Var.f11920c);
        this.f11928a = n1Var;
        this.f11929b = a1Var;
        this.f11930c = true;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this.f11930c ? super.fillInStackTrace() : this;
    }
}
