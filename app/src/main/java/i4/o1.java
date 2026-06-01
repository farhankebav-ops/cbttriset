package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o1 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n1 f11926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11927b;

    public o1(n1 n1Var) {
        super(n1.c(n1Var), n1Var.f11920c);
        this.f11926a = n1Var;
        this.f11927b = true;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this.f11927b ? super.fillInStackTrace() : this;
    }
}
