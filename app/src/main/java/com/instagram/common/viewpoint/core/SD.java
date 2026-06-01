package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class SD {
    public static byte[] A09;
    public SL A01;
    public final int A04;
    public final int A05;
    public final String A06;
    public final String A07;
    public final String A08;
    public float A00 = -1.0f;
    public String A02 = A00(0, 4, 75);
    public boolean A03 = false;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A09, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A09 = new byte[]{7, 10, -4, -1};
    }

    public SD(String str, int i2, int i8, String str2, String str3) {
        this.A08 = str;
        this.A04 = i2;
        this.A05 = i8;
        this.A07 = str2;
        this.A06 = str3;
    }
}
