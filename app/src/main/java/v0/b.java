package v0;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f17568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f17570c;

    public b(long j, long j3, Set set) {
        this.f17568a = j;
        this.f17569b = j3;
        this.f17570c = set;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f17568a == bVar.f17568a && this.f17569b == bVar.f17569b && this.f17570c.equals(bVar.f17570c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f17568a;
        int i2 = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        long j3 = this.f17569b;
        return ((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ this.f17570c.hashCode();
    }

    public final String toString() {
        return "ConfigValue{delta=" + this.f17568a + ", maxAllowedDelay=" + this.f17569b + ", flags=" + this.f17570c + "}";
    }
}
