package q5;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class s implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13515a;

    public /* synthetic */ s(long j) {
        this.f13515a = j;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = ((s) obj).f13515a;
        long j3 = this.f13515a ^ Long.MIN_VALUE;
        long j8 = j ^ Long.MIN_VALUE;
        if (j3 < j8) {
            return -1;
        }
        return j3 == j8 ? 0 : 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            return this.f13515a == ((s) obj).f13515a;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f13515a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long j = this.f13515a;
        if (j >= 0) {
            n7.b.i(10);
            String string = Long.toString(j, 10);
            kotlin.jvm.internal.k.d(string, "toString(...)");
            return string;
        }
        long j3 = 10;
        long j8 = ((j >>> 1) / j3) << 1;
        long j9 = j - (j8 * j3);
        if (j9 >= j3) {
            j9 -= j3;
            j8++;
        }
        n7.b.i(10);
        String string2 = Long.toString(j8, 10);
        kotlin.jvm.internal.k.d(string2, "toString(...)");
        n7.b.i(10);
        String string3 = Long.toString(j9, 10);
        kotlin.jvm.internal.k.d(string3, "toString(...)");
        return string2.concat(string3);
    }
}
