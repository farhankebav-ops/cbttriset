package com.instagram.common.viewpoint.core;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ne, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0946Ne implements RewardedVideoAdListener {
    public final /* synthetic */ C1697gy A00;

    public C0946Ne(C1697gy c1697gy) {
        this.A00 = c1697gy;
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdClicked(Ad ad) {
    }

    @Override // com.facebook.ads.AdListener
    public final void onAdLoaded(Ad ad) {
        this.A00.A00.A08.onAdLoaded(this.A00.A00.A09.A6c());
    }

    @Override // com.facebook.ads.AdListener
    public final void onError(Ad ad, AdError adError) {
        this.A00.A00.A03 = null;
        ((AbstractC1752hy) this.A00.A00.A04).A2A(false);
        this.A00.A00.A08.onAdLoaded(this.A00.A00.A09.A6c());
    }

    @Override // com.facebook.ads.AdListener
    public final void onLoggingImpression(Ad ad) {
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoClosed() {
        this.A00.A00.A08.onRewardedVideoClosed();
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public final void onRewardedVideoCompleted() {
        this.A00.A00.A08.onRewardedVideoCompleted();
    }
}
