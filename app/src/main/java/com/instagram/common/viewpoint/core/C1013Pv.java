package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1013Pv {
    public static byte[] A06;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public AbstractC1024Qg A04;
    public AbstractC1024Qg A05;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A06 = new byte[]{118, 122, 60, 40, 53, 55, 2, 103, 14, 2, 68, 80, 77, 79, 123, 31, 76, 64, 14, 5, 23, 40, 15, 12, 4, 5, 18, 93, 86, 90, 14, 21, 34, 71, 71, 75, 31, 4, 50, 86, 109, 70, 79, 64, 73, 75, 103, 64, 72, 65, 85, 65, 66, 74, 102, 65, 66, 74, 75, 92, 19};
    }

    public C1013Pv(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2) {
        this.A05 = abstractC1024Qg;
        this.A04 = abstractC1024Qg2;
    }

    public C1013Pv(AbstractC1024Qg abstractC1024Qg, AbstractC1024Qg abstractC1024Qg2, int i2, int i8, int i9, int i10) {
        this(abstractC1024Qg, abstractC1024Qg2);
        this.A00 = i2;
        this.A01 = i8;
        this.A02 = i9;
        this.A03 = i10;
    }

    public final String toString() {
        return A00(40, 21, 109) + this.A05 + A00(16, 12, 35) + this.A04 + A00(0, 8, 25) + this.A00 + A00(8, 8, 97) + this.A01 + A00(28, 6, 57) + this.A02 + A00(34, 6, 40) + this.A03 + '}';
    }
}
