package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g8, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1647g8 implements InterfaceC1000Pi {
    public static byte[] A01;
    public final /* synthetic */ C05246g A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 107);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-10, 0, -9};
    }

    public C1647g8(C05246g c05246g) {
        this.A00 = c05246g;
    }

    private final void A02(C1001Pj c1001Pj) {
        throw new NullPointerException(A00(0, 3, 40));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1000Pi
    public final void AD2(C1001Pj c1001Pj) {
        A02(c1001Pj);
        throw null;
    }
}
