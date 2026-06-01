package com.instagram.common.viewpoint.core;

import android.os.Bundle;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.S2SRewardedVideoAdExtendedListener;
import com.ironsource.C2473ne;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1682gj extends AbstractC0958Nq implements S2SRewardedVideoAdExtendedListener {
    public static byte[] A02;
    public final C1695gw A00;
    public final C1685gm A01;

    static {
        A01();
    }

    public static String A00(int i2, int i8, int i9) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i2, i2 + i8);
        for (int i10 = 0; i10 < bArrCopyOfRange.length; i10++) {
            bArrCopyOfRange[i10] = (byte) ((bArrCopyOfRange[i10] - i9) - 4);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A02 = new byte[]{-57, -52, -46, -35, -61, -48, -48, -51, -48, -35, -63, -51, -62, -61, -35, -55, -61, -41, -73, -68, -62, -51, -64, -60, -51, -60, -73, -78, -77, -67, -51, -78, -61, -64, -81, -62, -73, -67, -68, -51, -71, -77, -57, 114, 117, 116, 109, -123, 111, 116, 124, 103, 114, 111, 106, 103, 122, 111, 117, 116, -123, 122, 111, 115, 107, -123, 113, 107, 127, -107, -106, -108, -95, -121, -108, -108, -111, -108, -95, -113, -121, -107, -107, -125, -119, -121, -95, -115, -121, -101};
    }

    public C1682gj(String str, InterfaceC0960Ns interfaceC0960Ns, C1695gw c1695gw, C1685gm c1685gm) {
        super(str, interfaceC0960Ns);
        this.A00 = c1695gw;
        this.A01 = c1685gm;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
        super.A00.AED(2104, super.A01, null);
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        Bundle bundle = new Bundle();
        bundle.putLong(A00(43, 26, 34), this.A00.A0F());
        bundle.putInt(A00(18, 25, 106), this.A01.A00);
        super.A00.AED(2100, super.A01, bundle);
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        Bundle bundle = new Bundle();
        bundle.putString(A00(69, 21, 62), adError.getErrorMessage());
        bundle.putInt(A00(0, 18, Sdk.SDKError.Reason.INVALID_ADS_ENDPOINT_VALUE), adError.getErrorCode());
        super.A00.AED(2103, super.A01, bundle);
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
        super.A00.AED(2105, super.A01, null);
    }

    @Override // com.facebook.ads.S2SRewardedVideoAdListener
    public final void onRewardServerFailed() {
        super.A00.AED(3002, super.A01, null);
    }

    @Override // com.facebook.ads.S2SRewardedVideoAdListener
    public final void onRewardServerSuccess() {
        super.A00.AED(3001, super.A01, null);
    }

    @Override // com.facebook.ads.RewardedVideoAdExtendedListener
    public final void onRewardedVideoActivityDestroyed() {
        super.A00.AED(2106, super.A01, null);
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoClosed() {
        super.A00.AED(C2473ne.h, super.A01, null);
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        super.A00.AED(3000, super.A01, null);
    }
}
