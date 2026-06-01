package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GU {
    public static byte[] A03;
    public static String[] A04 = {"HU4YGL7IwZePYHnBLI2PbuSTKGYLERhV", "fFsJPZ9", "v5n0jNlIC8VEk9kcmtdxoaJ1lX", "iKo8W6GX5Xgtq", "u9GtZMdpfWAUjc", "5VwMttC", "nQaWhqWLYmZyv", "CiiXTe9emjL8TKahiZ469ARUB1y9RvmO"};
    public final int A00;
    public final int A01;
    public final String A02;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 55);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{-73, -83, -81, -81, -60, -79, -127, -89, -71, -85, -88, -11, -14, 3, -66};
    }

    static {
        A02();
    }

    public GU(int i2, int i8, String str) {
        this.A01 = i2;
        this.A00 = i8;
        this.A02 = str;
    }

    public static GU A00(C4J c4j) {
        String strA01;
        c4j.A0g(2);
        int profileData = c4j.A0I();
        int i2 = profileData >> 1;
        int iA0I = ((profileData & 1) << 5) | ((c4j.A0I() >> 3) & 31);
        if (i2 == 4 || i2 == 5 || i2 == 7) {
            strA01 = A01(7, 4, 12);
        } else if (i2 == 8) {
            strA01 = A01(11, 4, 86);
        } else {
            int dvProfile = A04[2].length();
            if (dvProfile != 26) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[3] = "DwVGRWEQxSiyr";
            strArr[6] = "AkYplpXV9U4Nr";
            if (i2 == 9) {
                strA01 = A01(3, 4, 23);
            } else {
                return null;
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(strA01);
        String strA012 = A01(1, 2, 72);
        StringBuilder sbAppend2 = sbAppend.append(strA012).append(i2);
        if (iA0I >= 10) {
            strA012 = A01(0, 1, 82);
        }
        return new GU(i2, iA0I, sbAppend2.append(strA012).append(iA0I).toString());
    }
}
