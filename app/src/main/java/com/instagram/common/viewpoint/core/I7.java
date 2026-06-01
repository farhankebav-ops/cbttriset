package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class I7 extends AbstractRunnableC1164Vt {
    public static byte[] A02;
    public final /* synthetic */ C1380bl A00;
    public final /* synthetic */ C3Q A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-103, -52, -67, -67, -68, -55, -64, -59, -66, 119, -64, -59, -69, -68, -67, -64, -59, -64, -53, -68, -61, -48};
    }

    public I7(C1380bl c1380bl, C3Q c3q) {
        this.A00 = c1380bl;
        this.A01 = c3q;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (this.A00.A0D.getState() != EnumC1547eU.A02 || this.A00.A0D.getCurrentPositionInMillis() != A00()) {
            return;
        }
        this.A00.A0I(A00(0, 22, 47));
    }
}
