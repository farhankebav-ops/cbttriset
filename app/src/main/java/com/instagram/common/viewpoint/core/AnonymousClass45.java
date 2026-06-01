package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.45, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass45 {
    public static byte[] A02;
    public int A00;
    public long[] A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 43);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-125, 119, -54, -64, -47, -68, 119, -64, -54, 119, -97, -60, -52, -73, -62, -65, -70, 118, -65, -60, -70, -69, -50, 118};
    }

    public AnonymousClass45() {
        this(32);
    }

    public AnonymousClass45(int i2) {
        this.A01 = new long[i2];
    }

    public final int A02() {
        return this.A00;
    }

    public final long A03(int i2) {
        if (i2 >= 0 && i2 < this.A00) {
            return this.A01[i2];
        }
        throw new IndexOutOfBoundsException(A00(10, 14, 43) + i2 + A00(0, 10, 44) + this.A00);
    }

    public final void A04(long j) {
        if (this.A00 == this.A01.length) {
            this.A01 = Arrays.copyOf(this.A01, this.A00 * 2);
        }
        long[] jArr = this.A01;
        int i2 = this.A00;
        this.A00 = i2 + 1;
        jArr[i2] = j;
    }

    public final long[] A05() {
        return Arrays.copyOf(this.A01, this.A00);
    }
}
