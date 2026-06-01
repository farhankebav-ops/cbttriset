package com.instagram.common.viewpoint.core;

import com.google.errorprone.annotations.DoNotMock;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@DoNotMock
public abstract class AbstractC2015mZ<E> {
    public static byte[] A00;

    static {
        A05();
    }

    public static String A04(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 39);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{71, 69, 74, 74, 75, 80, 4, 87, 80, 75, 86, 65, 4, 73, 75, 86, 65, 4, 80, 76, 69, 74, 4, 105, 101, 124, 123, 114, 101, 104, 113, 97, 4, 65, 72, 65, 73, 65, 74, 80, 87};
    }

    public static int A03(int oldCapacity, int minCapacity) {
        if (minCapacity >= 0) {
            int newCapacity = (oldCapacity >> 1) + oldCapacity + 1;
            if (newCapacity < minCapacity) {
                newCapacity = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (newCapacity < 0) {
                return Integer.MAX_VALUE;
            }
            return newCapacity;
        }
        throw new AssertionError(A04(0, 41, 3));
    }
}
