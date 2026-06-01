package o0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m f13158a;

    public o(m mVar) {
        this.f13158a = mVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        Object obj2 = z.f13184a;
        if (obj2.equals(obj2)) {
            return this.f13158a.equals(((o) a0Var).f13158a);
        }
        return false;
    }

    public final int hashCode() {
        return ((z.f13184a.hashCode() ^ 1000003) * 1000003) ^ this.f13158a.hashCode();
    }

    public final String toString() {
        return "ClientInfo{clientType=" + z.f13184a + ", androidClientInfo=" + this.f13158a + "}";
    }
}
