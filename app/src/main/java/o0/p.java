package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f13159a;

    public p(s sVar) {
        b0 b0Var = b0.f13113a;
        this.f13159a = sVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c0)) {
            return false;
        }
        if (!this.f13159a.equals(((p) ((c0) obj)).f13159a)) {
            return false;
        }
        Object obj2 = b0.f13113a;
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        return ((this.f13159a.hashCode() ^ 1000003) * 1000003) ^ b0.f13113a.hashCode();
    }

    public final String toString() {
        return "ComplianceData{privacyContext=" + this.f13159a + ", productIdOrigin=" + b0.f13113a + "}";
    }
}
