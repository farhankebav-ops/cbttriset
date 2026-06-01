package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7n, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05577n implements InterfaceC1916kk {
    public static byte[] A06;
    public static String[] A07 = {"QubeI9WU03qBZcNvE4IUkWvlw0NRrBK6", "F1d068LLA73yClDAGmhas6o", "9YpbVeLOd0f6m", "7Ycu3nAZXESMUbUrutcG9271koISuOhT", "QjcyZL4t35rbWMpE5hp6oYgD7sVhkS0D", "M48I8dHdEQTg0rHaHaNT6qI1", "cVfJzOsNywAlxLknvQSr1dDTMZn5TIAU", "kJeh17rnzHgOQ2HfO7oDpw4wPPnH7lFe"};
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long[] A05;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C05577n A01(long j, long j3, C0773Gl c0773Gl, C4J c4j) {
        int iA0L;
        int i2 = c0773Gl.A04;
        int i8 = c0773Gl.A03;
        int iA0C = c4j.A0C();
        if ((iA0C & 1) != 1 || (iA0L = c4j.A0L()) == 0) {
            return null;
        }
        long jA0U = AbstractC04664a.A0U(iA0L, ((long) i2) * 1000000, i8);
        if ((iA0C & 6) != 6) {
            return new C05577n(j3, c0773Gl.A02, jA0U);
        }
        long jA0Q = c4j.A0Q();
        long[] jArr = new long[100];
        for (int i9 = 0; i9 < 100; i9++) {
            jArr[i9] = c4j.A0I();
        }
        if (j != -1 && j != j3 + jA0Q) {
            AnonymousClass44.A07(A02(27, 10, 78), A02(2, 25, 105) + j + A02(0, 2, 40) + (j3 + jA0Q));
        }
        return new C05577n(j3, c0773Gl.A02, jA0U, jA0Q, jArr);
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A07;
            if (strArr[1].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            A07[2] = "La6";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 30);
            i10++;
        }
    }

    public static void A03() {
        A06 = new byte[]{114, 102, -33, -48, -43, -50, -89, -21, -24, -5, -24, -89, -6, -16, 1, -20, -89, -12, -16, -6, -12, -24, -5, -22, -17, -63, -89, -60, -43, -38, -45, -65, -47, -47, -41, -47, -34};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        double d8;
        if (!AAa()) {
            return new C0783Gv(new C0785Gx(0L, this.A03 + ((long) this.A00)));
        }
        long jA0T = AbstractC04664a.A0T(j, 0L, this.A04);
        double d9 = (jA0T * 100.0d) / this.A04;
        if (d9 <= 0.0d) {
            d8 = 0.0d;
        } else if (d9 >= 100.0d) {
            d8 = 256.0d;
        } else {
            int i2 = (int) d9;
            double d10 = ((long[]) C3M.A02(this.A05))[i2];
            d8 = (((i2 == 99 ? 256.0d : r9[i2 + 1]) - d10) * (d9 - ((double) i2))) + d10;
        }
        return new C0783Gv(new C0785Gx(jA0T, this.A03 + AbstractC04664a.A0T(Math.round((d8 / 256.0d) * this.A02), this.A00, this.A02 - 1)));
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A99(long j) {
        long j3 = j - this.A03;
        if (!AAa() || j3 <= this.A00) {
            return 0L;
        }
        long[] jArr = (long[]) C3M.A02(this.A05);
        double d8 = (j3 * 256.0d) / this.A02;
        int iA0L = AbstractC04664a.A0L(jArr, (long) d8, true, true);
        long jA00 = A00(iA0L);
        long j8 = jArr[iA0L];
        long jA002 = A00(iA0L + 1);
        long j9 = iA0L == 99 ? 256L : jArr[iA0L + 1];
        String[] strArr = A07;
        if (strArr[0].charAt(4) == strArr[4].charAt(4)) {
            throw new RuntimeException();
        }
        A07[6] = "PlWtaQzxKmV3LAe12cSeUsJTirSwbfkK";
        return Math.round((jA002 - jA00) * (j8 == j9 ? 0.0d : (d8 - j8) / (j9 - j8))) + jA00;
    }

    static {
        A03();
    }

    public C05577n(long j, int i2, long j3) {
        this(j, i2, j3, -1L, null);
    }

    public C05577n(long j, int i2, long j3, long j8, long[] jArr) {
        this.A03 = j;
        this.A00 = i2;
        this.A04 = j3;
        this.A05 = jArr;
        this.A02 = j8;
        this.A01 = j8 != -1 ? j + j8 : -1L;
    }

    private long A00(int i2) {
        return (this.A04 * ((long) i2)) / 100;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A7b() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A04;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return this.A05 != null;
    }
}
