package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ER {
    public static byte[] A00;
    public static String[] A01 = {"hxRtgXLlXZBZOOikVlBghnrqRk8D", "kooIKi1fx1Hb2qPm3oF2lCQrgWRqeUq9", "tAS3MHwJkliRqJEhDeJC9YibHYE", "z1PlvRauaFfgQg02R7fRgUIUzlYZ", "X9uQKTEyJl", "tATbEztK", "lnp2iYjILHnNLb0EhQTEEhT3vvCpm0GE", "ASuPVfTQk0HiiSTBHvF2"};

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[1].charAt(21) == strArr[6].charAt(21)) {
                throw new RuntimeException();
            }
            A01[7] = "l0wMWtKaafBi6h";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 96);
            i10++;
        }
    }

    public static void A01() {
        A00 = new byte[]{-18, -31, -24, -31, -35, -17, -31, -32};
    }

    static {
        A01();
    }

    public static /* synthetic */ boolean A02(ER er) {
        throw new NullPointerException(A00(0, 8, 28));
    }
}
