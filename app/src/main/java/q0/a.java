package q0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13368b;

    public a(int i2, long j) {
        if (i2 == 0) {
            throw new NullPointerException("Null status");
        }
        this.f13367a = i2;
        this.f13368b = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return c.a(this.f13367a, aVar.f13367a) && this.f13368b == aVar.f13368b;
    }

    public final int hashCode() {
        int iB = (c.b(this.f13367a) ^ 1000003) * 1000003;
        long j = this.f13368b;
        return iB ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i2 = this.f13367a;
        sb.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        return a1.a.p(sb, this.f13368b, "}");
    }
}
