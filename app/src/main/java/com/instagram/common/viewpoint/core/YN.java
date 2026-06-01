package com.instagram.common.viewpoint.core;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class YN implements InterfaceC1554eb {
    public static byte[] A01;
    public final C1451cu A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 74);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{82, 39, 76, 72, 39, 90, 101, 101, 102, 39, 88, 101, 127, 126, 99, 100, 109, 39, 94, 101, 97, 111, 100, 12, 10, 28, 11, 84, 24, 30, 28, 23, 13};
    }

    public YN(C1451cu c1451cu) {
        this.A00 = c1451cu;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1554eb
    public final Map<String, String> A6Y(boolean z2) {
        HashMap map = new HashMap();
        if (!AbstractC1061Rr.A00().A04()) {
            map.put(A00(0, 23, 64), TY.A00().A01(this.A00, true).A04());
        }
        map.put(A00(23, 10, 51), AbstractC1096Tb.A06(new T6(this.A00), this.A00, z2));
        return map;
    }
}
