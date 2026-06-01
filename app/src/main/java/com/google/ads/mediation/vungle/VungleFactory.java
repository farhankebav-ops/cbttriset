package com.google.ads.mediation.vungle;

import android.content.Context;
import com.vungle.ads.AdConfig;
import com.vungle.ads.InterstitialAd;
import com.vungle.ads.NativeAd;
import com.vungle.ads.RewardedAd;
import com.vungle.ads.VungleAdSize;
import com.vungle.ads.VungleBannerView;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class VungleFactory {
    public final AdConfig createAdConfig() {
        return new AdConfig();
    }

    public final VungleBannerView createBannerAd(Context context, String placementId, VungleAdSize adSize) {
        k.e(context, "context");
        k.e(placementId, "placementId");
        k.e(adSize, "adSize");
        return new VungleBannerView(context, placementId, adSize);
    }

    public final InterstitialAd createInterstitialAd(Context context, String placementId, AdConfig adConfig) {
        k.e(context, "context");
        k.e(placementId, "placementId");
        k.e(adConfig, "adConfig");
        return new InterstitialAd(context, placementId, adConfig);
    }

    public final NativeAd createNativeAd(Context context, String placementId) {
        k.e(context, "context");
        k.e(placementId, "placementId");
        return new NativeAd(context, placementId);
    }

    public final RewardedAd createRewardedAd(Context context, String placementId, AdConfig adConfig) {
        k.e(context, "context");
        k.e(placementId, "placementId");
        k.e(adConfig, "adConfig");
        return new RewardedAd(context, placementId, adConfig);
    }
}
