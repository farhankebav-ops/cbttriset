package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public enum XD {
    A08(0),
    A07(0),
    A06(1),
    A03(2),
    A04(3),
    A05(4);

    public static byte[] A01;
    public final int A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-63, -61, -74, -67, -64, -71, -45, -90, -69, -47, -45, -58, -51, -48, -55, -29, -73, -53, -97, -95, -108, -101, -98, -105, -79, -122, -103, -74, -72, -85, -78, -75, -82, -56, -78, -73, -67, -82, -69, -73, -82, -67, 127, -128, 127, 118, -67, -74, -77, -74, -73, -65, -74};
    }

    static {
        A01();
    }

    XD(int i2) {
        this.A00 = i2;
    }
}
