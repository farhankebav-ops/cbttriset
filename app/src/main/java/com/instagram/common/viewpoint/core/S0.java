package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class S0 {
    public static S1 A00;
    public static boolean A01;
    public static byte[] A02;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-91, -88, -79, -90, -85, -80, -92, -75, -82};
    }

    static {
        A02();
        A01 = false;
        A00 = null;
    }

    public static void A01() {
        synchronized (S0.class) {
            if (A00 == null) {
                return;
            }
            C1091Sw c1091Sw = new C1091Sw(A00.AHr());
            c1091Sw.A05(1);
            C1451cu c1451cuA00 = SP.A00();
            if (c1451cuA00 != null) {
                c1451cuA00.A08().AAy(A00(0, 9, 49), 3401, c1091Sw);
            }
            A00.reset();
        }
    }

    public static void A03(long j) {
        if (j > 0) {
            A00 = new C1513dw();
            new S2(j);
        }
    }
}
