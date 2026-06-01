package com.instagram.common.viewpoint.core;

import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2T {
    public static boolean A00;
    public static String A01;
    public static byte[] A02;
    public static String[] A03 = {"xIpC", "lOutcBeb", "y6lcWPY0M5vgnnr832pPoLFOGrBEwJN", "eNaaWw40USiw6vcri4oIxijcBQWus6T9", ExifInterface.LONGITUDE_WEST, "oHSXRLDm", "pbRsDBVUOoB3mv", "LvjaTOAqlauNDNt2xP6XrUFLIm1SBtnY"};
    public static final HashSet<String> A04;

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A03[0].length() == 28) {
            throw new RuntimeException();
        }
        A03[6] = "8";
        A02 = new byte[]{-61, -73, 49, 57, 57, 49, -8, 47, 66, 57, -8, 45, 57, 60, 47};
    }

    static {
        A02();
        A00 = true;
        A04 = new HashSet<>();
        A01 = A01(2, 13, 107);
    }

    public static synchronized String A00() {
        return A01;
    }

    public static synchronized void A03(String str) {
        if (A04.add(str)) {
            A01 += A01(0, 2, 56) + str;
        }
    }
}
