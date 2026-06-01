package q5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class q implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13513a;

    public /* synthetic */ q(int i2) {
        this.f13513a = i2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return kotlin.jvm.internal.k.g(this.f13513a ^ Integer.MIN_VALUE, ((q) obj).f13513a ^ Integer.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            return this.f13513a == ((q) obj).f13513a;
        }
        return false;
    }

    public final int hashCode() {
        return this.f13513a;
    }

    public final String toString() {
        return String.valueOf(((long) this.f13513a) & 4294967295L);
    }
}
