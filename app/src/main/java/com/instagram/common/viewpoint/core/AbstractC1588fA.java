package com.instagram.common.viewpoint.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC1588fA {
    public static byte[] A00;

    static {
        A03();
    }

    public static String A02(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 49);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A00 = new byte[]{0, 58, 59, 111, 32, 41, 111, 61, 46, 33, 40, 42, 117, 111, 106, 60};
    }

    public static char A00(byte b12, byte b22) {
        return (char) ((b12 << 8) | (b22 & 255));
    }

    public static char A01(long value) {
        char c7 = (char) value;
        AbstractC1819jA.A0H(((long) c7) == value, A02(0, 16, 126), value);
        return c7;
    }

    public static boolean A04(char[] array, char target) {
        for (char c7 : array) {
            if (c7 == target) {
                return true;
            }
        }
        return false;
    }
}
