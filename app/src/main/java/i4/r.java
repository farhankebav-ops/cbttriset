package i4;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class r implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final j f11941d = new j(3);
    public static final long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final long f11942f;
    public static final long g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f11943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f11944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f11945c;

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        e = nanos;
        f11942f = -nanos;
        g = TimeUnit.SECONDS.toNanos(1L);
    }

    public r(long j) {
        j jVar = f11941d;
        long jNanoTime = System.nanoTime();
        this.f11943a = jVar;
        long jMin = Math.min(e, Math.max(f11942f, j));
        this.f11944b = jNanoTime + jMin;
        this.f11945c = jMin <= 0;
    }

    public final long a() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        this.f11943a.getClass();
        long jNanoTime = System.nanoTime();
        if (!this.f11945c && this.f11944b - jNanoTime <= 0) {
            this.f11945c = true;
        }
        return timeUnit.convert(this.f11944b - jNanoTime, timeUnit);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        r rVar = (r) obj;
        j jVar = rVar.f11943a;
        j jVar2 = this.f11943a;
        if (jVar2 == jVar) {
            long j = this.f11944b - rVar.f11944b;
            if (j < 0) {
                return -1;
            }
            return j > 0 ? 1 : 0;
        }
        throw new AssertionError("Tickers (" + jVar2 + " and " + rVar.f11943a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        j jVar = rVar.f11943a;
        j jVar2 = this.f11943a;
        if (jVar2 != null ? jVar2 == jVar : jVar == null) {
            return this.f11944b == rVar.f11944b;
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.asList(this.f11943a, Long.valueOf(this.f11944b)).hashCode();
    }

    public final boolean isExpired() {
        if (!this.f11945c) {
            long j = this.f11944b;
            this.f11943a.getClass();
            if (j - System.nanoTime() > 0) {
                return false;
            }
            this.f11945c = true;
        }
        return true;
    }

    public final String toString() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long jA = a();
        long jAbs = Math.abs(jA);
        long j = g;
        long j3 = jAbs / j;
        long jAbs2 = Math.abs(jA) % j;
        StringBuilder sb = new StringBuilder();
        if (jA < 0) {
            sb.append('-');
        }
        sb.append(j3);
        if (jAbs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        }
        sb.append("s from now");
        j jVar = f11941d;
        j jVar2 = this.f11943a;
        if (jVar2 != jVar) {
            sb.append(" (ticker=" + jVar2 + ")");
        }
        return sb.toString();
    }
}
