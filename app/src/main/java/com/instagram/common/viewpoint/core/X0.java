package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class X0 {
    public static byte[] A00;

    static {
        A02();
    }

    public static String A01(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A00 = new byte[]{-33, -41, -37, -39, -41, -39};
    }

    public static Bundle A00(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(AbstractC0964Nw.A01, A01(0, 6, 102));
        bundle.putString(AbstractC0964Nw.A00, str);
        return bundle;
    }
}
