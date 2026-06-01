package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum EnumC1508dr {
    A04,
    A03,
    A02;

    public static byte[] A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 52);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{123, 118, 121, 122, -108, -124, -118, -119, -108, -124, -125, -108, -123, -127, 118, -114, -73, -68, -60, -63, -73, -80, -70, -77, -117, 126, -120, 126, 119, -127, 122};
    }

    static {
        A01();
    }
}
