package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0737Fb extends AbstractRunnableC1164Vt {
    public static byte[] A01;
    public final /* synthetic */ C04573r A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 95);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-67, -48, -53, -52, -42, -121, -34, -56, -38, -121, -43, -52, -35, -52, -39, -121, -41, -39, -52, -41, -56, -39, -52, -53};
    }

    public C0737Fb(C04573r c04573r) {
        this.A00 = c04573r;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.A0E) {
            this.A00.A0R(A00(0, 24, 8));
        }
    }
}
