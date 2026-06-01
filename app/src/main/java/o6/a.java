package o6;

import androidx.core.location.LocationRequestCompat;
import kotlin.jvm.internal.k;
import n6.m;
import okhttp3.internal.http2.Http2Connection;
import r2.q;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f13205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final long f13206c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f13207d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13208a;

    static {
        int i2 = b.f13209a;
        f13205b = q.P(4611686018427387903L);
        f13206c = q.P(-4611686018427387903L);
    }

    public static final long a(long j, long j3) {
        long j8 = 1000000;
        long j9 = j3 / j8;
        long j10 = j + j9;
        if (-4611686018426L > j10 || j10 >= 4611686018427L) {
            return q.P(q.J(j10, -4611686018427387903L, 4611686018427387903L));
        }
        return q.R((j10 * j8) + (j3 - (j9 * j8)));
    }

    public static final void b(StringBuilder sb, int i2, int i8, int i9, String str, boolean z2) {
        sb.append(i2);
        if (i8 != 0) {
            sb.append('.');
            String strD0 = m.D0(i9, String.valueOf(i8));
            int i10 = -1;
            int length = strD0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i11 = length - 1;
                    if (strD0.charAt(length) != '0') {
                        i10 = length;
                        break;
                    } else if (i11 < 0) {
                        break;
                    } else {
                        length = i11;
                    }
                }
            }
            int i12 = i10 + 1;
            if (z2 || i12 >= 3) {
                sb.append((CharSequence) strD0, 0, ((i10 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) strD0, 0, i12);
            }
        }
        sb.append(str);
    }

    public static int c(long j, long j3) {
        long j8 = j ^ j3;
        if (j8 >= 0 && (((int) j8) & 1) != 0) {
            int i2 = (((int) j) & 1) - (((int) j3) & 1);
            return j < 0 ? -i2 : i2;
        }
        if (j < j3) {
            return -1;
        }
        return j == j3 ? 0 : 1;
    }

    public static final long d(long j) {
        return ((((int) j) & 1) != 1 || f(j)) ? i(j, c.f13211c) : j >> 1;
    }

    public static final int e(long j) {
        if (f(j)) {
            return 0;
        }
        return (int) ((((int) j) & 1) == 1 ? ((j >> 1) % ((long) 1000)) * ((long) 1000000) : (j >> 1) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS));
    }

    public static final boolean f(long j) {
        return j == f13205b || j == f13206c;
    }

    public static final long g(long j, long j3) {
        if (f(j)) {
            if (!f(j3) || (j3 ^ j) >= 0) {
                return j;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (f(j3)) {
            return j3;
        }
        int i2 = ((int) j) & 1;
        if (i2 != (((int) j3) & 1)) {
            return i2 == 1 ? a(j >> 1, j3 >> 1) : a(j3 >> 1, j >> 1);
        }
        long j8 = (j >> 1) + (j3 >> 1);
        return i2 == 0 ? (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) ? q.P(j8 / ((long) 1000000)) : q.R(j8) : q.Q(j8);
    }

    public static final double h(long j, c unit) {
        k.e(unit, "unit");
        if (j == f13205b) {
            return Double.POSITIVE_INFINITY;
        }
        if (j == f13206c) {
            return Double.NEGATIVE_INFINITY;
        }
        return a.a.p(j >> 1, (((int) j) & 1) == 0 ? c.f13210b : c.f13211c, unit);
    }

    public static final long i(long j, c unit) {
        k.e(unit, "unit");
        if (j == f13205b) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j == f13206c) {
            return Long.MIN_VALUE;
        }
        return a.a.q(j >> 1, (((int) j) & 1) == 0 ? c.f13210b : c.f13211c, unit);
    }

    public static final long j(long j) {
        long j3 = ((-(j >> 1)) << 1) + ((long) (((int) j) & 1));
        int i2 = b.f13209a;
        return j3;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return c(this.f13208a, ((a) obj).f13208a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f13208a == ((a) obj).f13208a;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f13208a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long j;
        int i2;
        long j3 = this.f13208a;
        if (j3 == 0) {
            return "0s";
        }
        if (j3 == f13205b) {
            return "Infinity";
        }
        if (j3 == f13206c) {
            return "-Infinity";
        }
        int i8 = 0;
        boolean z2 = j3 < 0;
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append('-');
        }
        if (j3 < 0) {
            j3 = j(j3);
        }
        long jI = i(j3, c.g);
        int i9 = f(j3) ? 0 : (int) (i(j3, c.f13213f) % ((long) 24));
        if (f(j3)) {
            j = 0;
            i2 = 0;
        } else {
            j = 0;
            i2 = (int) (i(j3, c.e) % ((long) 60));
        }
        int i10 = f(j3) ? 0 : (int) (i(j3, c.f13212d) % ((long) 60));
        int iE = e(j3);
        boolean z7 = jI != j;
        boolean z8 = i9 != 0;
        boolean z9 = i2 != 0;
        boolean z10 = (i10 == 0 && iE == 0) ? false : true;
        if (z7) {
            sb.append(jI);
            sb.append('d');
            i8 = 1;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(i9);
            sb.append('h');
            i8 = i11;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i12 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(i2);
            sb.append('m');
            i8 = i12;
        }
        if (z10) {
            int i13 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            if (i10 != 0 || z7 || z8 || z9) {
                b(sb, i10, iE, 9, "s", false);
            } else if (iE >= 1000000) {
                b(sb, iE / 1000000, iE % 1000000, 6, "ms", false);
            } else if (iE >= 1000) {
                b(sb, iE / 1000, iE % 1000, 3, "us", false);
            } else {
                sb.append(iE);
                sb.append("ns");
            }
            i8 = i13;
        }
        if (z2 && i8 > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
