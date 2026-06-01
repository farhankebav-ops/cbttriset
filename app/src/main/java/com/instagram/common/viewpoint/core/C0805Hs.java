package com.instagram.common.viewpoint.core;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0805Hs extends AbstractC1549eW {
    public static byte[] A01;
    public final /* synthetic */ AbstractC0804Hr A00;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-37, -32, -39, -31, -26, -35, -36, -41, -39, -36, -41, -31, -26, -36, -35, -16};
    }

    public C0805Hs(AbstractC0804Hr abstractC0804Hr) {
        this.A00 = abstractC0804Hr;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1549eW
    public final void A03() {
        if (!this.A00.A0A.A07()) {
            this.A00.A0A.A05();
            if (!TextUtils.isEmpty(this.A00.A06.A25())) {
                Map<String, String> mapA05 = new C1262Zp().A03(this.A00.A0D).A02(this.A00.A0A).A04(this.A00.A06.A0u()).A05();
                mapA05.put(A00(0, 16, 42), A00(0, 0, 96) + this.A00.A02);
                this.A00.A08.AB5(this.A00.A06.A25(), mapA05);
                W2.A00(this.A00.A07).A0E(this.A00.A0C.A8d(), this.A00.A06.A25());
                N3.A07(this.A00.A06.A21(), this.A00.A07);
                this.A00.A07.A0F().A3D();
                if (!this.A00.A04) {
                    AbstractC0964Nw.A02(this.A00.A06.A0t(), X0.A00(this.A00.A06.A0v()));
                }
                if (!this.A00.A05) {
                    this.A00.A0B.A4b(this.A00.A0C.A88());
                }
            }
        }
    }
}
