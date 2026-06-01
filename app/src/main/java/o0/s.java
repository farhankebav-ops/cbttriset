package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f13163a;

    public s(r rVar) {
        this.f13163a = rVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        return this.f13163a.equals(((s) ((f0) obj)).f13163a);
    }

    public final int hashCode() {
        return this.f13163a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "ExternalPrivacyContext{prequest=" + this.f13163a + "}";
    }
}
