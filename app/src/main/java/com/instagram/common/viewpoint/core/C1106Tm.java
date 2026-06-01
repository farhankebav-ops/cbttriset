package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1106Tm {
    public static byte[] A02;
    public final int A00;
    public final int A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 34);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-85, -48, -40, -61, -50, -53, -58, -126, -53, -48, -58, -57, -38, -90, -57, -50, -42, -61, -126, -118, -121, -58, -114, -126, -53, -48, -58, -57, -38, -126, -97, -126, -121, -58, -117, -56, -53, -50, -57, -126, -118, -121, -58, -117, -126, -98, -126, -113, -109, -12, -9, -6, -13, -82, -53, -82, -77, -14, -82, -76, -76, -82, -9, -4, -14, -13, 6, -82, -53, -82, -77, -14, -47, -44, -41, -48, -117, -88, -88, -117, -104, -100, -117, -111, -111, -117, -44, -39, -49, -48, -29, -117, -88, -117, -112, -49};
    }

    public C1106Tm() {
        this(-1, -1);
    }

    public C1106Tm(int i2, int i8) {
        if (i2 < -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(35, 14, 64), Integer.valueOf(i2)));
        }
        if (i2 >= 0 && i8 < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(49, 23, 108), Integer.valueOf(i2), Integer.valueOf(i8)));
        }
        if (i2 == -1 && i8 != -1) {
            throw new IllegalArgumentException(String.format(Locale.US, A00(72, 24, 73), Integer.valueOf(i8)));
        }
        this.A00 = i2;
        this.A01 = i8;
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03() {
        return this.A01;
    }

    public final int A04(C1106Tm c1106Tm) {
        if (this.A00 != c1106Tm.A00) {
            return this.A00 - c1106Tm.A00;
        }
        return this.A01 - c1106Tm.A01;
    }

    public final C1106Tm A05(int i2) {
        if (this.A01 + i2 >= 0) {
            return new C1106Tm(this.A00, this.A01 + i2);
        }
        throw new IllegalArgumentException(String.format(Locale.US, A00(0, 35, 64), Integer.valueOf(i2), Integer.valueOf(this.A01)));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C1106Tm)) {
            return false;
        }
        C1106Tm c1106Tm = (C1106Tm) obj;
        return c1106Tm.A00 == this.A00 && c1106Tm.A01 == this.A01;
    }

    public final int hashCode() {
        return (this.A00 * 2) + (this.A01 * 3);
    }
}
