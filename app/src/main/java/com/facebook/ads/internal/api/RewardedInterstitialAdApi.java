package com.facebook.ads.internal.api;

import androidx.annotation.Keep;
import androidx.annotation.UiThread;
import com.facebook.ads.Ad;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.FullScreenAd;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.proguard.annotations.DoNotStripAny;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
@DoNotStripAny
@UiThread
public interface RewardedInterstitialAdApi extends FullScreenAd {
    @Override // com.facebook.ads.FullScreenAd
    /* bridge */ /* synthetic */ Ad.LoadConfigBuilder buildLoadAdConfig();

    @Override // com.facebook.ads.FullScreenAd
    RewardedInterstitialAd.RewardedInterstitialAdLoadConfigBuilder buildLoadAdConfig();

    @Override // com.facebook.ads.FullScreenAd
    /* bridge */ /* synthetic */ FullScreenAd.ShowConfigBuilder buildShowAdConfig();

    @Override // com.facebook.ads.FullScreenAd
    RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder buildShowAdConfig();

    @Override // com.facebook.ads.Ad
    void destroy();

    @Override // com.facebook.ads.Ad
    String getPlacementId();

    int getVideoDuration();

    boolean isAdLoaded();

    @Override // com.facebook.ads.Ad
    void loadAd();

    void loadAd(RewardedInterstitialAd.RewardedInterstitialLoadAdConfig rewardedInterstitialLoadAdConfig);

    @Override // com.facebook.ads.Ad
    @Deprecated
    void setExtraHints(ExtraHints extraHints);

    @Override // com.facebook.ads.FullScreenAd
    boolean show();

    boolean show(RewardedInterstitialAd.RewardedInterstitialShowAdConfig rewardedInterstitialShowAdConfig);
}
