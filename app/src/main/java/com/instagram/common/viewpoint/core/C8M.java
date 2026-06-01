package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8M, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8M extends Exception {
    public static byte[] A03;
    public final int A00;
    public final C2154or A01;
    public final boolean A02;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-26, 26, 9, 14, 20, -7, 23, 6, 8, 16, -59, 28, 23, 14, 25, 10, -59, 11, 6, 14, 17, 10, 9, -33, -59};
    }

    public C8M(int i2, C2154or c2154or, boolean z2) {
        super(A00(0, 25, 91) + i2);
        this.A02 = z2;
        this.A00 = i2;
        this.A01 = c2154or;
    }
}
