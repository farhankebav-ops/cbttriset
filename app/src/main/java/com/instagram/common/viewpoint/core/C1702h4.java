package com.instagram.common.viewpoint.core;

import android.view.View;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.h4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1702h4 extends MQ {
    public static byte[] A01;
    public static String[] A02 = {"swComlxz6aoGHqKS8LOj1g5iAOstdInC", "iLoXwxITRpbgZFbT1koR1uJW4vvDXY2W", "MpkXHfR6HdYIg9t449R", "HQI6v11U6roDlbOuDHGyMjhCWVrAbgmk", "qsbQ14vrFuO8q1N0nwgFIOsRNgh3HWyt", "NXqrvE65RyYHWICx", "E9yzS8MfEszoKvwo", "osh9YHk0bwFUuMRHqHbnPk"};
    public final /* synthetic */ C1698gz A00;

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] ^ i9) ^ 98);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{97, 112, 105, 47, 35, 34, 56, 62, 35, 32, 32, 41, 62, 108, 37, 63, 108, 34, 57, 32, 32};
    }

    static {
        A01();
    }

    public C1702h4(C1698gz c1698gz) {
        this.A00 = c1698gz;
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A02() {
        if (this.A00.A01 == null) {
            this.A00.A04 = false;
            this.A00.A07.onInterstitialActivityDestroyed();
        }
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A04() {
        if (this.A00.A01 != null) {
            this.A00.A01.show();
            return;
        }
        this.A00.A04 = false;
        if (this.A00.A03 != null && U7.A26(this.A00.A06)) {
            this.A00.A03.A0S(new C1703h5(this));
            this.A00.A03.A0N();
            this.A00.A03.A0K();
            this.A00.A03 = null;
        }
        this.A00.A07.onInterstitialDismissed(this.A00.A08.A6c());
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A05() {
        this.A00.A07.onInterstitialDisplayed(this.A00.A08.A6c());
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A06() {
        this.A00.A07.onRewardedAdServerFailed();
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A07() {
        this.A00.A07.onRewardedAdServerSucceeded();
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A08() {
        this.A00.A07.onRewardedAdCompleted();
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0C() {
        this.A00.A06.A0F().A3C();
        this.A00.A07.onAdClicked(this.A00.A08.A6c());
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0D() {
        this.A00.A07.onLoggingImpression(this.A00.A08.A6c());
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0E(View view) {
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0F(MP mp) {
        if (this.A00.A03 != null) {
            this.A00.A05 = true;
            this.A00.A02 = this.A00.A03.A0I();
            if (!(this.A00.A02 instanceof AbstractC1752hy)) {
                InterstitialAdExtendedListener interstitialAdExtendedListener = this.A00.A07;
                String[] strArr = A02;
                if (strArr[0].charAt(8) == strArr[3].charAt(8)) {
                    String[] strArr2 = A02;
                    strArr2[6] = "JHAXxmwzHKs3NajX";
                    strArr2[5] = "FHZeNyejFCAXh3Vz";
                    interstitialAdExtendedListener.onAdLoaded(this.A00.A08.A6c());
                    return;
                }
            } else {
                AbstractC1752hy abstractC1752hy = (AbstractC1752hy) this.A00.A02;
                if (abstractC1752hy.A1x() > 0) {
                    WR wr = new WR();
                    if (wr.A09(this.A00.A06, this.A00.A08.A08(), abstractC1752hy.A1x())) {
                        wr.A08(this.A00.A06, true);
                        this.A00.A01 = wr.A06(this.A00.A06, this.A00.A08.A0A(), this.A00.A08.A08());
                    } else {
                        C1698gz c1698gz = this.A00;
                        if (A02[1].charAt(2) != 'w') {
                            A02[7] = "alFbtn3b1";
                            wr.A08(c1698gz.A06, false);
                        } else {
                            String[] strArr3 = A02;
                            strArr3[6] = "OkLAbmcEeyte5Vfo";
                            strArr3[5] = "zgaU15rF2mVDrexS";
                            wr.A08(c1698gz.A06, false);
                        }
                    }
                }
                C1698gz c1698gz2 = this.A00;
                if (A02[1].charAt(2) != 'w') {
                    A02[1] = "23I4hcZMgJ395X2lYna8PMjzW0ozt3hz";
                    if (c1698gz2.A01 != null) {
                        abstractC1752hy.A2A(true);
                        InterstitialAd.InterstitialLoadAdConfig loadAdConfig = this.A00.A01.buildLoadAdConfig().withAdListener(new C0945Nd(this, abstractC1752hy)).withCacheFlags(this.A00.A08.A0B()).withRewardData(this.A00.A08.A03()).build();
                        this.A00.A01.loadAd(loadAdConfig);
                        return;
                    }
                    C1698gz c1698gz3 = this.A00;
                    String[] strArr4 = A02;
                    if (strArr4[0].charAt(8) != strArr4[3].charAt(8)) {
                        c1698gz3.A07.onAdLoaded(this.A00.A08.A6c());
                        return;
                    } else {
                        A02[2] = "joZPUUFug9Ts";
                        c1698gz3.A07.onAdLoaded(this.A00.A08.A6c());
                        return;
                    }
                }
            }
            throw new RuntimeException();
        }
        this.A00.A06.A08().AAy(A00(0, 3, 98), AbstractC1090Sv.A0N, new C1091Sw(A00(3, 18, 46)));
    }

    @Override // com.instagram.common.viewpoint.core.MQ
    public final void A0G(V1 v12) {
        this.A00.A06.A0F().A3F(XG.A01(this.A00.A00), v12.A03().getErrorCode(), v12.A04());
        this.A00.A07.onError(this.A00.A08.A6c(), WT.A00(v12));
    }
}
