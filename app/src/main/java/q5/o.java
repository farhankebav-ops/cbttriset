package q5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class o implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte f13511a;

    public /* synthetic */ o(byte b8) {
        this.f13511a = b8;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f13511a & 255, ((o) obj).f13511a & 255);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof o) {
            return this.f13511a == ((o) obj).f13511a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f13511a;
    }

    public final String toString() {
        return String.valueOf(this.f13511a & 255);
    }
}
