package com.instagram.common.viewpoint.core;

import android.util.Log;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XG {
    public static byte[] A00;
    public static String[] A01 = {"kzsYhm9LKsU0BkYF5GBD4cHOfO5I2S", "FiiX6q", "juV27aOscABEXHLMFQmBucT", "1EXxaj", "f1sOyyKe81qkTfSynlEtElAllv4GRKo", "lzeqJRba", "GXB72S", "F9UQYukVDOEwI1lxcupNtKixpZh4OtVr"};
    public static final XF A02 = null;

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A00 = new byte[]{64, 75, 86, 3, 23, 8, 20, 21, 18, 16, 50, 61, 116, 39, 115, 53, 60, 33, 62, 50, 39, 115, 39, 58, 62, 54, 125};
    }

    static {
        A08();
    }

    public static long A00() {
        if (A02 != null) {
            return A02.A5f();
        }
        return System.currentTimeMillis();
    }

    public static long A01(long j) {
        return A02(j, System.currentTimeMillis());
    }

    public static long A02(long j, long j3) {
        if (j == -1) {
            return -1L;
        }
        return j3 - j;
    }

    public static String A03(double d8) throws Exception {
        try {
            return String.format(Locale.US, A04(0, 4, 115), Double.valueOf(d8));
        } catch (Exception e) {
            String simpleName = XG.class.getSimpleName();
            if (A01[3].length() == 20) {
                Exception e4 = new RuntimeException();
                throw e4;
            }
            A01[0] = "ylDYykVZ0MQgZWbzvTC4Y0QCoTAruV";
            Log.e(simpleName, A04(9, 18, 69), e);
            return A04(4, 5, 48);
        }
    }

    public static String A05(long j) {
        return String.valueOf(A01(j));
    }

    @Deprecated
    public static String A06(long j) {
        return A03(j / 1000.0d);
    }

    public static String A07(long j) {
        return Long.toString(j);
    }
}
