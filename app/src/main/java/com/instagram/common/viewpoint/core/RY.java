package com.instagram.common.viewpoint.core;

import com.facebook.ads.RewardedInterstitialAd;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RY implements RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder, RewardedInterstitialAd.RewardedInterstitialShowAdConfig {
    public final C1045Rb A00;

    public RY(C1045Rb c1045Rb) {
        this.A00 = c1045Rb;
    }

    public final C1045Rb A00() {
        return this.A00;
    }

    @Override // com.facebook.ads.RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder, com.facebook.ads.FullScreenAd.ShowConfigBuilder
    public final RewardedInterstitialAd.RewardedInterstitialShowAdConfig build() {
        return this;
    }

    @Override // com.facebook.ads.RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder
    public final RewardedInterstitialAd.RewardedInterstitialAdShowConfigBuilder withAppOrientation(int i2) {
        this.A00.withAppOrientation(i2);
        return this;
    }
}
