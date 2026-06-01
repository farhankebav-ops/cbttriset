package com.instagram.common.viewpoint.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ph, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0999Ph extends AbstractRunnableC1164Vt {
    public static byte[] A01;
    public final /* synthetic */ VU A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-81, -78, -90, -92, -81, -94, -73, -85, -75, -78, -73, -73, -81, -88};
    }

    public C0999Ph(VU vu) {
        this.A00 = vu;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.A05.A08().A9v(A00(0, 14, 26));
    }
}
