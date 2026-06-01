package com.instagram.common.viewpoint.core;

import com.google.common.primitives.ElementTypesAreNonnullByDefault;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network.dex */
@ElementTypesAreNonnullByDefault
public abstract class AD extends AbstractC2211q8 {
    public static byte[] A00;
    public static String[] A01 = {"siq85GDJwTeYE", "hCeAcOWL38esGxpCGhAcOByVvpt4rkG9", "m2sukptzj10OlAU9Tp5GtC3mJBPhtf8e", "xjjTaPx7kc7NMEZNqBPsTeRSC2dGu2kw", "w", "lzhISLab9GK0zTqogctfE75BYP1X9oPw", "tkIGufAtpO8Bl63czpB", ""};

    public static String A09(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            int i11 = bArrCopyOfRange[i10] ^ i9;
            if (A01[7].length() != 0) {
                throw new RuntimeException();
            }
            A01[7] = "";
            bArrCopyOfRange[i10] = (byte) (i11 ^ 72);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A00 = new byte[]{44, 22, 23, 67, 12, 5, 67, 17, 2, 13, 4, 6, 89, 67, 70, 16, 126, 122, 125, 51, 59, 54, 96, 58, 51, 126, 102, 96, 103, 51, 113, 118, 51, 127, 118, 96, 96, 51, 103, 123, 114, 125, 51, 124, 97, 51, 118, 98, 102, 114, 127, 51, 103, 124, 51, 126, 114, 107, 51, 59, 54, 96, 58};
    }

    static {
        A0B();
    }

    public static int A00(int value) {
        return value;
    }

    public static int A01(int a8, int b8) {
        if (a8 < b8) {
            return -1;
        }
        return a8 > b8 ? 1 : 0;
    }

    public static int A02(int value, int min, int max) {
        AbstractC1819jA.A0G(min <= max, A09(16, 47, 91), min, max);
        return Math.min(Math.max(value, min), max);
    }

    public static int A03(long value) {
        int i2 = (int) value;
        AbstractC1819jA.A0H(((long) i2) == value, A09(0, 16, 43), value);
        return i2;
    }

    public static int A04(long value) {
        if (value <= 2147483647L) {
            if (value < -2147483648L) {
                return Integer.MIN_VALUE;
            }
            return (int) value;
        }
        if (A01[7].length() != 0) {
            throw new RuntimeException();
        }
        A01[1] = "nVSCb9uBdS4Z5srNqmAxsZ9hxFd1bctQ";
        return Integer.MAX_VALUE;
    }

    public static int A05(int[] array, int target, int start, int end) {
        while (start < end) {
            int i2 = array[start];
            if (i2 == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int A06(int[] array, int target, int start, int end) {
        for (int i2 = end - 1; i2 >= start; i2--) {
            int i8 = array[i2];
            if (i8 == target) {
                return i2;
            }
        }
        return -1;
    }

    public static List<Integer> A0A(int... backingArray) {
        if (backingArray.length == 0) {
            return Collections.emptyList();
        }
        return new C2212q9(backingArray);
    }

    public static int[] A0C(Collection<? extends Number> collection) {
        if (collection instanceof C2212q9) {
            return ((C2212q9) collection).A04();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        int len = A01[1].charAt(22);
        if (len == 108) {
            throw new RuntimeException();
        }
        A01[1] = "hGECTcBTlZrQNB5F5BgF8ddu5i2bV8V4";
        for (int i2 = 0; i2 < length; i2++) {
            int len2 = ((Number) AbstractC1819jA.A04(array[i2])).intValue();
            iArr[i2] = len2;
        }
        return iArr;
    }
}
