package com.instagram.common.viewpoint.core;

import android.content.Intent;
import android.util.Log;
import android.view.WindowManager;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.UUID;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1778iS implements MP, NG {
    public static byte[] A0B;
    public static String[] A0C = {"Tri2", "1D6RXHNY", "CY2J", "FG3HLf7FRck3Q4", "aTw9XxKg19aD2PWH35UjlgQd", "aN0Sboz7ddtAAnQUWG6qQ4oJRDDzSUBt", "pWs", "z"};
    public long A00;
    public RewardData A01;
    public InterfaceC0917Ma A02;
    public C0918Mb A03;
    public NH A04;
    public C1477dL A05;
    public String A06;
    public String A07;
    public String A08;
    public boolean A09;
    public final String A0A = UUID.randomUUID().toString();

    public static String A03(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0B, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 84);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0B = new byte[]{-37, -7, 6, -65, 12, -72, 11, 12, -7, 10, 12, -72, -39, 13, -4, 1, -3, 6, -5, -3, -26, -3, 12, 15, 7, 10, 3, -39, -5, 12, 1, 14, 1, 12, 17, -58, -72, -27, -7, 3, -3, -72, 11, 13, 10, -3, -72, 12, 0, -7, 12, -72, 1, 12, -65, 11, -72, 1, 6, -72, 17, 7, 13, 10, -72, -39, 6, -4, 10, 7, 1, -4, -27, -7, 6, 1, -2, -3, 11, 12, -58, 16, 5, 4, -72, -2, 1, 4, -3, -58, -16, -20, -21, 31, 14, 19, 15, 24, 13, 15, -8, 15, 30, 33, 25, 28, 21, -55, -48, -35, -50, -48, -46, -29, -40, -27, -40, -29, -24, -1, -9, -10, -5, -13, 6, -5, 1, 0, -42, -13, 6, -13, 16, 12, 1, 3, 5, 13, 5, 14, 20, -23, 4, -55, -53, -66, -67, -66, -65, -62, -57, -66, -67, -88, -53, -62, -66, -57, -51, -70, -51, -62, -56, -57, -92, -66, -46, -7, -20, -8, -4, -20, -6, -5, -37, -16, -12, -20, -6, -13, -18, -10, -6, -22, -50, -23, 34, 21, 17, 35, 0, 37, 28, 17, 12, -2, 3, -7, 4, 12};
    }

    static {
        A05();
    }

    private int A00() {
        WindowManager windowManager = (WindowManager) this.A05.getSystemService(A03(194, 6, 65));
        int rotation = windowManager.getDefaultDisplay().getRotation();
        EnumC1266Zt enumC1266ZtA02 = A02();
        if (enumC1266ZtA02 == EnumC1266Zt.A05) {
            String[] strArr = A0C;
            String str = strArr[4];
            String str2 = strArr[7];
            int rotation2 = str.length();
            if (rotation2 != str2.length()) {
                String[] strArr2 = A0C;
                strArr2[6] = "b7o";
                strArr2[3] = "Q7inAkPu5HYVeU";
                return -1;
            }
        } else if (enumC1266ZtA02 == EnumC1266Zt.A03) {
            switch (rotation) {
                case 2:
                case 3:
                    int rotation3 = A0C[1].length();
                    if (rotation3 != 29) {
                        String[] strArr3 = A0C;
                        strArr3[6] = "bcp";
                        strArr3[3] = "BEZRNTMscmchpM";
                        return 8;
                    }
                    break;
                default:
                    return 0;
            }
        } else {
            switch (rotation) {
                case 2:
                    return 9;
                default:
                    String[] strArr4 = A0C;
                    String str3 = strArr4[4];
                    String str4 = strArr4[7];
                    int rotation4 = str3.length();
                    if (rotation4 == str4.length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr5 = A0C;
                    strArr5[0] = "VdY7";
                    strArr5[2] = "KFhl";
                    return 1;
            }
        }
        throw new RuntimeException();
    }

    private final EnumC1147Vb A01() {
        return this.A04.A0E();
    }

    private EnumC1266Zt A02() {
        return this.A04.A0F();
    }

    private void A04() {
        this.A09 = true;
    }

    private void A06(Intent intent) {
        this.A04.A0I(intent, this.A01, C1474dI.A03(this.A01, this.A0A, this.A06));
    }

    private final void A07(C1477dL c1477dL, InterfaceC0917Ma interfaceC0917Ma, NU nu, EnumSet<CacheFlag> cacheFlags, String str) {
        NH nh = new NH(c1477dL, nu, this, str);
        AbstractC0930Mo abstractC0930MoA0D = nh.A0D();
        if (U7.A0v(c1477dL) && (abstractC0930MoA0D instanceof AbstractC1752hy) && ML.A06(this.A05, ML.A01(c1477dL, nu.A03(), ((AbstractC1752hy) abstractC0930MoA0D).A25()), c1477dL.A0A())) {
            this.A05.A0F().A4u();
            this.A02.ADc(this, AdError.NO_FILL);
        } else {
            this.A04 = nh;
            A08(nh.A0E());
            nh.A0J(c1477dL, cacheFlags);
        }
    }

    private void A08(EnumC1147Vb enumC1147Vb) {
        if (enumC1147Vb.equals(EnumC1147Vb.A04)) {
            this.A05.A0F().AJ9(LT.A05);
            return;
        }
        if (enumC1147Vb.equals(EnumC1147Vb.A0A)) {
            this.A05.A0F().AJ9(LT.A04);
            return;
        }
        if (enumC1147Vb.equals(EnumC1147Vb.A0B)) {
            this.A05.A0F().AJ9(LT.A0B);
            return;
        }
        if (enumC1147Vb.equals(EnumC1147Vb.A0D)) {
            this.A05.A0F().AJ9(LT.A0D);
            return;
        }
        if (enumC1147Vb.equals(EnumC1147Vb.A0C)) {
            this.A05.A0F().AJ9(LT.A0C);
            return;
        }
        if (!enumC1147Vb.equals(EnumC1147Vb.A06)) {
            return;
        }
        if (this.A04.A0K()) {
            this.A05.A0F().AJ9(LT.A08);
            return;
        }
        if ((A09() instanceof AbstractC1752hy) && this.A04.A0L((AbstractC1752hy) A09())) {
            LH lhA0F = this.A05.A0F();
            if (A0C[1].length() == 29) {
                throw new RuntimeException();
            }
            String[] strArr = A0C;
            strArr[6] = "5zP";
            strArr[3] = "kcwn0HZtMTZNOx";
            lhA0F.AJ9(LT.A0A);
            return;
        }
        this.A05.A0F().AJ9(LT.A09);
    }

    public final AbstractC0930Mo A09() {
        return this.A04.A0D();
    }

    public final void A0A(C1477dL c1477dL, InterfaceC0917Ma interfaceC0917Ma, NU nu, EnumSet<CacheFlag> enumSet, String str, String str2, RewardData rewardData) {
        this.A05 = c1477dL;
        this.A02 = interfaceC0917Ma;
        this.A08 = nu.A02();
        this.A06 = this.A08 != null ? this.A08.split(A03(107, 1, 22))[0] : A03(0, 0, 85);
        this.A00 = nu.A00();
        this.A07 = str2;
        this.A01 = rewardData;
        A07(c1477dL, interfaceC0917Ma, nu, enumSet, str);
    }

    public final boolean A0B() {
        if (!this.A09) {
            if (this.A02 != null) {
                this.A02.ADc(this, AdError.SHOW_CALLED_BEFORE_LOAD_ERROR);
            }
            return false;
        }
        AdActivityIntent adActivityIntentA05 = WB.A05(this.A05);
        adActivityIntentA05.putExtra(A03(143, 24, 5), A00());
        adActivityIntentA05.putExtra(A03(178, 8, 49), this.A0A);
        adActivityIntentA05.putExtra(A03(Sdk.SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE, 11, 76), this.A08);
        adActivityIntentA05.putExtra(A03(167, 11, 51), this.A00);
        EnumC1147Vb enumC1147VbA01 = A01();
        A08(enumC1147VbA01);
        adActivityIntentA05.putExtra(A03(186, 8, 88), enumC1147VbA01);
        if (this.A07 != null) {
            adActivityIntentA05.putExtra(A03(Sdk.SDKError.Reason.JSON_ENCODE_ERROR_VALUE, 13, 62), this.A07);
        }
        A06(adActivityIntentA05);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            String[] strArr = A0C;
            if (strArr[4].length() == strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "Sc68";
            strArr2[2] = "wieN";
            adActivityIntentA05.addFlags(268435456);
        }
        try {
            ActivityUtils.A03(this.A05);
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!WB.A0I(this.A05, adActivityIntentA05)) {
                    this.A05.A0F().AHS();
                    if (this.A02 != null) {
                        this.A02.ADc(this, AdError.AD_PRESENTATION_ERROR);
                    }
                    return false;
                }
                return true;
            }
            WB.A0B(this.A05, adActivityIntentA05);
            return true;
        } catch (W9 e) {
            Throwable cause = e.getCause();
            W9 cause2 = e;
            if (cause != null) {
                cause2 = e.getCause();
            }
            this.A05.A08().AAy(A03(108, 11, 27), AbstractC1090Sv.A0D, new C1091Sw(cause2));
            Log.e(A03(90, 17, 86), A03(0, 90, 68), cause2);
            return false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final String A7G() {
        return this.A04.A0G();
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final AdPlacementType A8c() {
        return AdPlacementType.INTERSTITIAL;
    }

    @Override // com.instagram.common.viewpoint.core.NG
    public final void ACF(AdError adError) {
        if (this.A02 != null) {
            this.A02.ADc(this, adError);
        }
    }

    @Override // com.instagram.common.viewpoint.core.NG
    public final void ACG() {
        A04();
        this.A02.ADb(this);
    }

    @Override // com.instagram.common.viewpoint.core.NG
    public final void AGo() {
        this.A03 = new C0918Mb(this.A05, this.A0A, this, this.A02);
        this.A03.A02();
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final boolean AJa() {
        return true;
    }

    @Override // com.instagram.common.viewpoint.core.NG
    public final void AJm() {
        if (this.A03 != null) {
            C0918Mb c0918Mb = this.A03;
            String[] strArr = A0C;
            if (strArr[0].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0C;
            strArr2[0] = "DiF0";
            strArr2[2] = "lQT3";
            c0918Mb.A03();
        }
    }

    @Override // com.instagram.common.viewpoint.core.MP
    public final void onDestroy() {
        if (this.A04 != null) {
            this.A04.A0H();
        }
    }
}
