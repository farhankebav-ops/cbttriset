package q5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class v implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final short f13518a;

    public /* synthetic */ v(short s7) {
        this.f13518a = s7;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f13518a & 65535, ((v) obj).f13518a & 65535);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            return this.f13518a == ((v) obj).f13518a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f13518a;
    }

    public final String toString() {
        return String.valueOf(this.f13518a & 65535);
    }
}
