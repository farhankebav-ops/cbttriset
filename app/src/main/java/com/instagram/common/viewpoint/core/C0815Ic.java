package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ic, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0815Ic {
    public static byte[] A05;
    public static String[] A06 = {"OUufb3XpwzKYnlflZdZ6sRl07O4y2xde", "sKTdS4Xom3soESmXE0UV17qKIdPOParu", "kk23Dr8l3bATGrEguhsdZQtf", "3jRjB5CH7VItg40f0wyJnaKmLrgr1NBM", "BH8vD2JIXWvofCU6hHaybnU4mVSHqFOc", "vohsQcTTzwLv029o6bcJNqcBVW1DxWoo", "Jn5KmPxuP80vuetXL26eN8MkgXOAz5Tn", "UdULkD"};
    public int A00;
    public final H1 A01;
    public final H2 A02;
    public final C0825Im A03;
    public final C0828Ip A04;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i2, i2 + i8);
        int i10 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[1].charAt(29) == strArr[4].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "SmGAr1wQXpWbqjnIPPUcEk3V";
            strArr2[7] = "BndLoX";
            if (i10 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 105);
            i10++;
        }
    }

    public static void A01() {
        A05 = new byte[]{-20, 0, -17, -12, -6, -70, -1, -3, 0, -16, -72, -13, -17};
    }

    static {
        A01();
    }

    public C0815Ic(C0825Im c0825Im, C0828Ip c0828Ip, H1 h12) {
        H2 h22;
        this.A03 = c0825Im;
        this.A04 = c0828Ip;
        this.A01 = h12;
        if (A00(0, 13, 34).equals(c0825Im.A07.A0W)) {
            h22 = new H2();
        } else {
            h22 = null;
        }
        this.A02 = h22;
    }
}
