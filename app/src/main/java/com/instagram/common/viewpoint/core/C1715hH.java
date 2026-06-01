package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1715hH implements InterfaceC0924Mh {
    public static byte[] A02;
    public static String[] A03 = {"prnrxiqBIRUWmtrywfPqKqEQqhVy", "ZIMYOFT0ZsWMsvQaDuWdcBD1JUfFlpFK", "eDL3S9t0lib8FebdadRdAEhF6DEMjh5k", "bs6kAZMpX5XJVmB6S4pTEB090dM9ax0i", "QHqe8jS5x4PwEQqsnwl", "gxNXj6OyEOj3k7PGi9sSLvTTkEfltc4s", "tcOGThQLxe2W2uuyyUr03jLhoPapxorM", "Kh0wErWL647o91YILjhTKlO7bRERsR4e"};
    public final /* synthetic */ C05356r A00;
    public final /* synthetic */ Runnable A01;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 23);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A03[4].length() == 18) {
            throw new RuntimeException();
        }
        A03[7] = "PFnJtf9LUj4qa4JPPUOTumvSeGZYJypM";
        A02 = new byte[]{9, 8, 0, 92, 15, 13, 92, 1, 118, 65, 83, 69, 86, 64, 65, 64, 4, 114, 77, 64, 65, 75, 4, 77, 73, 84, 86, 65, 87, 87, 77, 75, 74, 4, 66, 77, 86, 65, 64, 64, 65, 125, 74, 88, 78, 93, 75, 74, 75, 121, 70, 75, 74, 64, 110, 75, 99, 64, 72, 72, 70, 65, 72, 102, 66, 95, 93, 74, 92, 92, 70, 64, 65};
    }

    static {
        A01();
    }

    public C1715hH(C05356r c05356r, Runnable runnable) {
        this.A00 = c05356r;
        this.A01 = runnable;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF1(AbstractC1760iA abstractC1760iA) {
        this.A00.A07.A06();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF2(AbstractC1760iA abstractC1760iA) {
        this.A00.A07.A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF3(AbstractC1760iA abstractC1760iA) {
        this.A00.A07.A0C();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF4(AbstractC1760iA abstractC1760iA) {
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A01 = abstractC1760iA;
        this.A00.A0L();
        if (this.A00.A07 != null) {
            this.A00.A07.A0F(abstractC1760iA);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF5(AbstractC1760iA abstractC1760iA) {
        VF.A05(A00(39, 34, 56), A00(8, 31, 51), A00(0, 8, 47));
        this.A00.A07.A0D();
        this.A00.A0O();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF6(AbstractC1760iA abstractC1760iA) {
        this.A00.A07.A08();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void AF7(AbstractC1760iA abstractC1760iA, AdError adError) {
        this.A00.A0H().removeCallbacks(this.A01);
        this.A00.A0B.A0F().A5Y(adError.getErrorCode(), adError.getErrorMessage());
        if (AdError.AD_PRESENTATION_ERROR.equals(adError) && U7.A1t(this.A00.A0B)) {
            this.A00.A07.A0G(V1.A00(AdErrorType.AD_PRESENTATION_ERROR));
        } else if (AdError.NO_FILL.equals(adError)) {
            this.A00.A07.A0G(V1.A00(AdErrorType.NO_FILL));
        } else {
            this.A00.A07.A0G(V1.A00(AdErrorType.INTERNAL_ERROR));
        }
        this.A00.A0Q(abstractC1760iA);
        if (A03[7].charAt(7) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[1] = "5mDNAkmPsKXxtvZqFgypt4QK4uBiUiuf";
        strArr[2] = "5tmiAUheAxojxdkmR27o6gIBrLCMojmA";
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void onRewardedVideoActivityDestroyed() {
        this.A00.A07.A09();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0924Mh
    public final void onRewardedVideoClosed() {
        this.A00.A07.A0A();
    }
}
