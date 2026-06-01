package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class x extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f13182a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i0 f13183b;

    public x(j0 j0Var, i0 i0Var) {
        this.f13182a = j0Var;
        this.f13183b = i0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k0) {
            k0 k0Var = (k0) obj;
            j0 j0Var = this.f13182a;
            if (j0Var != null ? j0Var.equals(((x) k0Var).f13182a) : ((x) k0Var).f13182a == null) {
                i0 i0Var = this.f13183b;
                if (i0Var != null ? i0Var.equals(((x) k0Var).f13183b) : ((x) k0Var).f13183b == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        j0 j0Var = this.f13182a;
        int iHashCode = ((j0Var == null ? 0 : j0Var.hashCode()) ^ 1000003) * 1000003;
        i0 i0Var = this.f13183b;
        return (i0Var != null ? i0Var.hashCode() : 0) ^ iHashCode;
    }

    public final String toString() {
        return "NetworkConnectionInfo{networkType=" + this.f13182a + ", mobileSubtype=" + this.f13183b + "}";
    }
}
