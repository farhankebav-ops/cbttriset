package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1780iU extends AbstractC1549eW {
    public static byte[] A01;
    public final /* synthetic */ C7L A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 19);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{78, 77, 66, 66, 73, 94};
    }

    public C1780iU(C7L c7l) {
        this.A00 = c7l;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1549eW
    public final void A03() {
        if (!this.A00.A07.A07()) {
            this.A00.A07.A05();
            this.A00.A04.A0F().A4I(this.A00.A02 != null);
            this.A00.A04.A0F().A3D();
            AbstractC0964Nw.A02(this.A00.A03.A0t(), X0.A00(A00(0, 6, 63)));
            this.A00.A05.AB5(this.A00.A03.A25(), new C1262Zp().A03(this.A00.A0C).A02(this.A00.A07).A04(this.A00.A03.A0u()).A05());
            if (U7.A19(this.A00.A04)) {
                W2.A00(this.A00.A04).A0E(AdPlacementType.BANNER.toString(), this.A00.A03.A25());
            }
            N3.A07(this.A00.A03 == null ? null : this.A00.A03.A21(), this.A00.A04);
            this.A00.A0C.A0V();
        }
    }
}
