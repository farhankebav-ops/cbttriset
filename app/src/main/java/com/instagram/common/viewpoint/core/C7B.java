package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7B extends AbstractC1760iA {
    public static SF A0D;
    public static byte[] A0E;
    public static String[] A0F = {"g9SdUg6XNSnvVCS02jX19aczyGq48qDV", "lGSQ9LsgX83H3UqklEPZgAjaPEKabNT0", "y0oXMo4BXc2on8MNFvJxgBv", "Ulfd9L14l0ScyK0QB689zsPu0EZ5wfqr", "W3xKKEfUMxBXJmvfztSkCM8j4ls7Vw3H", "lNYBpqeQZYlfeCveDiVEAZh", "rx8", "elj"};
    public long A00;
    public InterfaceC0924Mh A01;
    public C0925Mi A02;
    public AbstractC0930Mo A03;
    public C1477dL A04;
    public EnumC1147Vb A05;
    public C1388bt A06;
    public String A07;
    public String A08;
    public String A09;
    public String A0A;
    public final String A0B = UUID.randomUUID().toString();
    public final AtomicBoolean A0C = new AtomicBoolean();

    public static String A05(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 51);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A09() {
        A0E = new byte[]{-98, -16, -14, -14, -12, -5, -12, 1, -2, -4, -12, 3, -12, 1, -18, 1, -2, 3, -16, 3, -8, -2, -3, -58, -45, -60, -58, -56, -39, -50, -37, -50, -39, -34, 1, 6, -1, 7, 12, 3, 2, -33, 2, -30, -1, 18, -1, -32, 19, 12, 2, 10, 3, 29, 21, 20, 25, 17, 36, 25, 31, 30, -12, 17, 36, 17, 16, 12, 1, 3, 5, 13, 5, 14, 20, -23, 4, -68, -66, -79, -80, -79, -78, -75, -70, -79, -80, -101, -66, -75, -79, -70, -64, -83, -64, -75, -69, -70, -105, -79, -59, -17, -30, -18, -14, -30, -16, -15, -47, -26, -22, -30, -2, -15, 3, -19, -2, -16, -33, -15, -2, 2, -15, -2, -31, -34, -40, -13, -26, -8, -30, -13, -27, -26, -27, -41, -22, -27, -26, -16, -62, -27, -59, -30, -11, -30, -61, -10, -17, -27, -19, -26, 28, 15, 33, 11, 28, 14, 15, 14, 9, 32, 19, 14, 15, 25, -61, -68, -73, -65, -61, -77, -105, -78, -4, -17, -21, -3, -38, -1, -10, -21};
    }

    static {
        A09();
    }

    private void A07() {
        OO.A00(this.A04).A06(this.A02, this.A02.A00());
    }

    private void A08() {
        if (this.A02 != null) {
            try {
                OO.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A0A(Intent intent) {
        int i2 = super.A00;
        String strA05 = A05(77, 24, 25);
        if (i2 != -1 && Settings.System.getInt(this.A04.getContentResolver(), A05(1, 22, 92), 0) != 1) {
            int i8 = super.A00;
            String[] strArr = A0F;
            if (strArr[4].charAt(19) == strArr[0].charAt(19)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "RWC7frN5DjKRH0uo4BJmLzj";
            strArr2[2] = "FPcb0UYEDF6wwONX6Ty9E2F";
            intent.putExtra(strA05, i8);
            return;
        }
        C1477dL c1477dL = this.A04;
        String[] strArr3 = A0F;
        if (strArr3[7].length() == strArr3[6].length()) {
            String[] strArr4 = A0F;
            strArr4[5] = "O4w3do1khQsKhsE3USwlJ7C";
            strArr4[2] = "rALKIAVwphrvKmHx0hqaLzY";
            if (U7.A0h(c1477dL)) {
                return;
            }
        } else if (U7.A0h(c1477dL)) {
            return;
        }
        intent.putExtra(strA05, 6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(final C1477dL c1477dL, final C1750hw c1750hw, final int i2) {
        if (i2 >= c1750hw.A1u()) {
            return;
        }
        final AnonymousClass73 anonymousClass73 = (AnonymousClass73) c1750hw.A1x(i2);
        A0D = new SF(c1477dL);
        A0D.A0e(new C1120Ua(anonymousClass73.A25(), c1477dL.A0A()));
        NS.A02(c1477dL, A0D, anonymousClass73);
        final boolean z2 = i2 == 0;
        A0D.A0X(new AbstractC1727hU(z2) { // from class: com.facebook.ads.redexgen.X.7C
            @Override // com.instagram.common.viewpoint.core.AbstractC1727hU
            public final void A00() {
                this.A01.A01.AF7(this.A01, AdError.CACHE_ERROR);
            }

            @Override // com.instagram.common.viewpoint.core.AbstractC1727hU
            public final void A01(boolean z7) {
                C7B.A0D = null;
                if (z7) {
                    c1477dL.A01().AIU(anonymousClass73.A25(), c1750hw.A1y());
                }
                if (i2 == 0) {
                    this.A01.A0C.set(true);
                    this.A01.A01.AF4(this.A01);
                }
                this.A01.A0C(c1477dL, c1750hw, i2 + 1);
            }
        }, new S8(anonymousClass73.A17(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE), i2));
    }

    private void A0D(boolean z2) {
        if (this.A05 == EnumC1147Vb.A0F) {
            A0F(z2);
            return;
        }
        if (this.A05 == EnumC1147Vb.A0H) {
            A0G(z2);
        } else if (this.A05 == EnumC1147Vb.A0G) {
            A0E(z2);
        } else {
            A0G(z2);
        }
    }

    private void A0E(boolean z2) {
        SF sf = new SF(this.A04);
        boolean z7 = U7.A2A(this.A04) && C1049Rf.A0A(this.A03.A1C());
        if (z7) {
            C1049Rf unifiedAssetsLoader = new C1049Rf(sf, this.A03.A1C(), this.A03.A0v(), this.A03.A17(), z7, new C1768iI(this));
            sf.A0e(new C1120Ua(((AbstractC1752hy) this.A03).A25(), this.A04.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        NR.A02(this.A04, (AbstractC1752hy) this.A03, z2, new C1767iH(this));
    }

    private void A0F(boolean z2) {
        SF sf = new SF(this.A04);
        sf.A0e(new C1120Ua(((AbstractC1752hy) this.A03).A25(), this.A04.A0A()));
        NS.A03(this.A04, sf, (AnonymousClass73) this.A03);
        sf.A0X(new C1772iM(this), new S8(this.A03.A17(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)));
    }

    private void A0G(boolean z2) {
        boolean z7 = false;
        if (this.A03.A1T()) {
            C1750hw c1750hw = (C1750hw) this.A03;
            for (int i2 = 0; i2 < c1750hw.A1u(); i2++) {
                if (TextUtils.isEmpty(c1750hw.A1x(i2).A20().A0H().A09())) {
                    this.A01.AF7(this, AdError.INTERNAL_ERROR);
                    return;
                }
            }
            A0C(this.A04, c1750hw, 0);
            return;
        }
        SF sf = new SF(this.A04);
        sf.A0e(new C1120Ua(((AbstractC1752hy) this.A03).A25(), this.A04.A0A()));
        if (U7.A2A(this.A04) && C1049Rf.A0A(this.A03.A1C())) {
            z7 = true;
        }
        boolean zA1Y = this.A03.A1Y();
        if (z7) {
            C1049Rf unifiedAssetsLoader = new C1049Rf(sf, this.A03.A1C(), this.A03.A0v(), this.A03.A17(), z7, new C1770iK(this, zA1Y));
            unifiedAssetsLoader.A0B();
            return;
        }
        AnonymousClass73 anonymousClass73 = (AnonymousClass73) this.A03;
        if (TextUtils.isEmpty(anonymousClass73.A20().A0H().A09())) {
            if (this.A05 == EnumC1147Vb.A0I) {
                this.A04.A0F().ADm();
            }
            this.A01.AF7(this, AdError.INTERNAL_ERROR);
        } else {
            NS.A02(this.A04, sf, anonymousClass73);
            sf.A0X(new C7E(this, z2, zA1Y, anonymousClass73, this), new S8(anonymousClass73.A17(), A05(152, 14, Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE)));
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1760iA
    public final int A0H() {
        if (this.A03 == null) {
            return -1;
        }
        return this.A03.A0m();
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1760iA
    public final AbstractC0930Mo A0I() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1760iA
    public final boolean A0J() {
        if (!this.A0C.get()) {
            return false;
        }
        this.A03.A1E(super.A01);
        String strA03 = C1474dI.A03(super.A02, this.A0B, this.A07);
        this.A03.A1F(super.A02);
        this.A03.A1J(strA03);
        AdActivityIntent adActivityIntentA05 = WB.A05(this.A04);
        adActivityIntentA05.putExtra(A05(174, 8, 83), this.A05);
        adActivityIntentA05.putExtra(A05(127, 25, 78), this.A03);
        adActivityIntentA05.putExtra(A05(34, 19, 107), this.A03);
        adActivityIntentA05.putExtra(A05(166, 8, 27), this.A0B);
        if (strA03 != null) {
            adActivityIntentA05.putExtra(A05(112, 15, 89), strA03);
        }
        adActivityIntentA05.putExtra(A05(66, 11, 109), this.A0A);
        adActivityIntentA05.putExtra(A05(101, 11, 74), this.A00);
        if (this.A09 != null) {
            adActivityIntentA05.putExtra(A05(53, 13, Sdk.SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE), this.A09);
        }
        A0A(adActivityIntentA05);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            adActivityIntentA05.setFlags(adActivityIntentA05.getFlags() | 268435456);
        }
        ActivityUtils.A03(this.A04);
        try {
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!WB.A0I(this.A04, adActivityIntentA05)) {
                    this.A04.A0F().AHS();
                    if (this.A01 != null) {
                        this.A01.AF7(this, AdError.AD_PRESENTATION_ERROR);
                    }
                    return false;
                }
                return true;
            }
            WB.A0B(this.A04, adActivityIntentA05);
            return true;
        } catch (W9 e) {
            String[] strArr = A0F;
            if (strArr[1].charAt(25) != strArr[3].charAt(25)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[7] = "zr3";
            strArr2[6] = "zCM";
            Throwable cause = e.getCause();
            W9 cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            this.A04.A08().AAy(A05(23, 11, 50), AbstractC1090Sv.A01, new C1091Sw(cause2));
            return true;
        }
    }

    public final void A0K(C1477dL c1477dL, InterfaceC0924Mh interfaceC0924Mh, NU nu, boolean z2, String str, String str2) {
        String strA05;
        this.A0C.set(false);
        this.A04 = c1477dL;
        this.A01 = interfaceC0924Mh;
        this.A0A = nu.A02();
        this.A00 = nu.A00();
        this.A09 = str2;
        if (this.A0A != null) {
            String str3 = this.A0A;
            String strA052 = A05(0, 1, 12);
            String[] strArr = A0F;
            if (strArr[7].length() == strArr[6].length()) {
                String[] strArr2 = A0F;
                strArr2[7] = "x5W";
                strArr2[6] = "dMK";
                strA05 = str3.split(strA052)[0];
            }
            throw new RuntimeException();
        }
        strA05 = A05(0, 0, 100);
        this.A07 = strA05;
        this.A03 = AbstractC0930Mo.A03(nu.A03(), this.A04);
        this.A03.A1H(str);
        this.A03.A1D(nu.A01().A06());
        if (this.A03.A1T()) {
            this.A08 = ((C1750hw) this.A03).A20();
        } else {
            this.A08 = ((AbstractC1752hy) this.A03).A25();
        }
        if (this.A03.A1Y()) {
            this.A05 = EnumC1147Vb.A08;
            if (this.A03.A1P()) {
                this.A04.A0F().AJ9(LT.A08);
            } else {
                this.A04.A0F().AJ9(LT.A0A);
            }
        } else {
            switch (this.A03.A0l()) {
                case 0:
                    this.A05 = EnumC1147Vb.A0H;
                    this.A04.A0F().AJ9(LT.A0D);
                    break;
                case 1:
                    this.A05 = EnumC1147Vb.A0G;
                    this.A04.A0F().AJ9(LT.A0C);
                    break;
                case 2:
                    this.A05 = EnumC1147Vb.A05;
                    this.A04.A0F().AJ9(LT.A05);
                    break;
                case 3:
                    this.A05 = EnumC1147Vb.A0F;
                    this.A04.A0F().AJ9(LT.A04);
                    break;
                case 4:
                    this.A05 = EnumC1147Vb.A0I;
                    this.A04.A0F().AJ9(LT.A0E);
                    break;
            }
        }
        if (U7.A0v(c1477dL)) {
            AbstractC0930Mo abstractC0930Mo = this.A03;
            String[] strArr3 = A0F;
            if (strArr3[4].charAt(19) != strArr3[0].charAt(19)) {
                String[] strArr4 = A0F;
                strArr4[4] = "c2SjyVfNFMTSQhwflPzyjFy3Fjr2snH4";
                strArr4[0] = "k4vT1WhZbJ1Mlr1eks5fTJscMmdnfo8D";
                if (abstractC0930Mo.A1T()) {
                    C1750hw c1750hw = (C1750hw) this.A03;
                    for (int iA1u = c1750hw.A1u() - 1; iA1u >= 0; iA1u--) {
                        AbstractC1752hy abstractC1752hyA1x = c1750hw.A1x(iA1u);
                        if (ML.A06(this.A04, ML.A01(c1477dL, abstractC1752hyA1x.A1C(), abstractC1752hyA1x.A25()), c1477dL.A0A())) {
                            this.A04.A0F().A4u();
                            c1750hw.A22(iA1u);
                            return;
                        }
                    }
                    if (c1750hw.A1u() == 0) {
                        this.A01.AF7(this, AdError.NO_FILL);
                        return;
                    }
                } else if (ML.A06(this.A04, ML.A01(c1477dL, nu.A03(), ((AbstractC1752hy) this.A03).A25()), c1477dL.A0A())) {
                    this.A04.A0F().A4u();
                    this.A01.AF7(this, AdError.NO_FILL);
                    return;
                }
            }
            throw new RuntimeException();
        }
        this.A02 = new C0925Mi(this.A0B, this, interfaceC0924Mh);
        A07();
        A0D(z2);
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final String A7G() {
        return this.A08;
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final boolean AJa() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final void onDestroy() {
        A08();
    }
}
