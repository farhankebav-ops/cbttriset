package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.e1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1518e1 {
    A03,
    A02,
    A05,
    A04;

    public static byte[] A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 120);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{28, 19, 20, 16, 28, 9, 24, 25, 107, 100, 99, 103, 107, 126, 99, 100, 109, 107, 124, 111, 124, 107, 106, 124, 102, 120, 119, 112, 116, 120, 109, 124, 125, 91, 76, 95, 76, 91, 90, 76, 86, 72, 71, 64, 68, 72, 93, 64, 71, 78};
    }

    static {
        A01();
    }
}
