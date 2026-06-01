package i6;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12038a;

    static {
        Integer num = b6.a.f4147a;
        f12038a = (num == null || num.intValue() >= 34) ? new j6.a() : new c();
    }

    public abstract int a(int i2);

    public abstract int b();

    public abstract int c(int i2);

    public abstract long d();

    public long e(long j, long j3) {
        long jD;
        long j8;
        long jA;
        int iB;
        if (j3 <= j) {
            throw new IllegalArgumentException(("Random range is empty: [" + Long.valueOf(j) + ", " + Long.valueOf(j3) + ").").toString());
        }
        long j9 = j3 - j;
        if (j9 > 0) {
            if (((-j9) & j9) == j9) {
                int i2 = (int) j9;
                int i8 = (int) (j9 >>> 32);
                if (i2 != 0) {
                    iB = a(31 - Integer.numberOfLeadingZeros(i2));
                } else if (i8 == 1) {
                    iB = b();
                } else {
                    jA = (((long) a(31 - Integer.numberOfLeadingZeros(i8))) << 32) + (4294967295L & ((long) b()));
                }
                jA = ((long) iB) & 4294967295L;
            } else {
                do {
                    jD = d() >>> 1;
                    j8 = jD % j9;
                } while ((j9 - 1) + (jD - j8) < 0);
                jA = j8;
            }
            return j + jA;
        }
        while (true) {
            long jD2 = d();
            if (j <= jD2 && jD2 < j3) {
                return jD2;
            }
        }
    }
}
