package o6;

import androidx.core.location.LocationRequestCompat;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class f implements e, Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13217a;

    public static long a(long j) {
        long jB = d.b();
        c unit = c.f13210b;
        k.e(unit, "unit");
        return (1 | (j - 1)) == LocationRequestCompat.PASSIVE_INTERVAL ? a.j(n7.b.y(j)) : n7.b.M(jB, j, unit);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long jY;
        f other = (f) obj;
        k.e(other, "other");
        long j = other.f13217a;
        int i2 = d.f13216b;
        c unit = c.f13210b;
        k.e(unit, "unit");
        long j3 = (j - 1) | 1;
        long j8 = this.f13217a;
        if (j3 != LocationRequestCompat.PASSIVE_INTERVAL) {
            jY = (1 | (j8 - 1)) == LocationRequestCompat.PASSIVE_INTERVAL ? n7.b.y(j8) : n7.b.M(j8, j, unit);
        } else if (j8 == j) {
            int i8 = a.f13207d;
            jY = 0;
        } else {
            jY = a.j(n7.b.y(j));
        }
        return a.c(jY, 0L);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f13217a == ((f) obj).f13217a;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f13217a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        return "ValueTimeMark(reading=" + this.f13217a + ')';
    }
}
