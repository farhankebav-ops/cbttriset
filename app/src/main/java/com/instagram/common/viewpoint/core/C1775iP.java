package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1775iP implements S7 {
    public static byte[] A04;
    public final /* synthetic */ MX A00;
    public final /* synthetic */ C7K A01;
    public final /* synthetic */ C6M A02;
    public final /* synthetic */ Y9 A03;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A04 = new byte[]{-109, -82, -74, -71, -78, -79, 109, -63, -68, 109, -79, -68, -60, -69, -71, -68, -82, -79, 109, -82, 109, -70, -78, -79, -74, -82, 123};
    }

    public C1775iP(C7K c7k, Y9 y9, MX mx, C6M c6m) {
        this.A01 = c7k;
        this.A03 = y9;
        this.A00 = mx;
        this.A02 = c6m;
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACh() {
        AdErrorType adErrorType = AdErrorType.CACHE_FAILURE_ERROR;
        String strA00 = A00(0, 27, 69);
        this.A02.A0F().A3F(XG.A01(this.A01.A00), adErrorType.getErrorCode(), strA00);
        this.A00.ADj(this.A01, V1.A01(adErrorType, strA00));
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACq() {
        this.A03.A0J();
        this.A00.ACc(this.A01, this.A03);
        this.A02.A0F().A4G(this.A01.A01 != null);
    }
}
