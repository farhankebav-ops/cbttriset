package m0;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12920a;

    public c(String str) {
        if (str == null) {
            throw new NullPointerException("name is null");
        }
        this.f12920a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return this.f12920a.equals(((c) obj).f12920a);
    }

    public final int hashCode() {
        return this.f12920a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return a1.a.r(new StringBuilder("Encoding{name=\""), this.f12920a, "\"}");
    }
}
