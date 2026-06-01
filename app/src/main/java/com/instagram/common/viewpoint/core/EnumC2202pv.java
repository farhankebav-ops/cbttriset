package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pv, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC2202pv {
    A02,
    A03,
    A04;

    public static byte[] A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{79, 68, 87, 68, 83, 94, 83, 68, 70, 72, 82, 85, 68, 83, 68, 69, 115, 100, 102, 104, 114, 117, 100, 115, 100, 101, 14, 21, 9, 30, 28, 18, 8, 15, 30, 9, 30, 31};
    }

    static {
        A01();
    }
}
