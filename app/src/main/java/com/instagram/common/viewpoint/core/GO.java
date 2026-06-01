package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GO extends AbstractRunnableC1164Vt {
    public static byte[] A01;
    public final /* synthetic */ C4K A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 14);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{67, 124, 113, 112, 122, 53, 98, 116, 102, 53, 123, 112, 99, 112, 103, 53, 101, 103, 112, 101, 116, 103, 112, 113};
    }

    public GO(C4K c4k) {
        this.A00 = c4k;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.A0J) {
            this.A00.A0V.AFg(A00(0, 24, 27));
        }
    }
}
