package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.d1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1458d1 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 71);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-102, -110, -106, -108, -110, -108, -45, -30, -30, -47, -32, -45, -33, -41, -10, -9, 8, -5, -11, -9, -15, -1, 1, -10, -9, -2, -39, -36, -48, -50, -39, -46, -65, -61, 38, 42, 22, 45, 28, 41, -10, -25, -8, -6, -12, -21, -8, -27, -21, -12, -22, -10, -11, -17, -12, -6, -31, -35, -46, -22, -46, -45, -35, -42, -48, -33, -46, -34, -42, -56, -72, -57, -70, -70, -61, -76, -67, -70, -66, -68, -67, -55, 22, 6, 21, 8, 8, 17, 2, 26, 12, 7, 23, 11, -19, -34, -27, -39, -16, -33, -20, -19, -29, -23, -24, -1, -15, -1, -1, -11, -5, -6, -21, -11, -16};
    }

    public static Map<String, String> A01(SQ sq, String str, String str2) {
        HashMap map = new HashMap();
        T6 t62 = new T6(sq);
        int i2 = sq.getResources().getDisplayMetrics().widthPixels;
        int i8 = sq.getResources().getDisplayMetrics().heightPixels;
        map.put(A00(105, 10, 69), sq.A09().A02());
        map.put(A00(56, 13, 42), str2);
        map.put(A00(40, 16, 63), str);
        map.put(A00(14, 12, 75), String.valueOf(t62.A09()));
        map.put(A00(82, 12, 92), String.valueOf((int) (i2 / AbstractC1180Wl.A02)));
        map.put(A00(69, 13, 14), String.valueOf((int) (i8 / AbstractC1180Wl.A02)));
        map.put(A00(32, 2, 9), sq.A05().A9K());
        map.put(A00(34, 6, 112), T6.A04);
        map.put(A00(26, 6, 38), Locale.getDefault().toString());
        map.put(A00(94, 11, 51), A00(0, 6, 29));
        map.put(A00(6, 8, 43), t62.A05());
        return map;
    }
}
