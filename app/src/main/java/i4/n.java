package i4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f11911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n1 f11912b;

    public n(m mVar, n1 n1Var) {
        this.f11911a = mVar;
        r2.q.D(n1Var, "status is null");
        this.f11912b = n1Var;
    }

    public static n a(m mVar) {
        r2.q.y(mVar != m.f11896c, "state is TRANSIENT_ERROR. Use forError() instead");
        return new n(mVar, n1.e);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f11911a.equals(nVar.f11911a) && this.f11912b.equals(nVar.f11912b);
    }

    public final int hashCode() {
        return this.f11911a.hashCode() ^ this.f11912b.hashCode();
    }

    public final String toString() {
        n1 n1Var = this.f11912b;
        boolean zF = n1Var.f();
        m mVar = this.f11911a;
        if (zF) {
            return mVar.toString();
        }
        return mVar + "(" + n1Var + ")";
    }
}
