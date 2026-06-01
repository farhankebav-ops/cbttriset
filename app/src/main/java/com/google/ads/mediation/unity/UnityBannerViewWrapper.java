package com.google.ads.mediation.unity;

import androidx.annotation.NonNull;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.services.banners.BannerView;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class UnityBannerViewWrapper {
    private final BannerView bannerView;

    public UnityBannerViewWrapper(@NonNull BannerView bannerView) {
        this.bannerView = bannerView;
    }

    public BannerView getBannerView() {
        return this.bannerView;
    }

    public void load(UnityAdsLoadOptions unityAdsLoadOptions) {
        this.bannerView.load(unityAdsLoadOptions);
    }

    public void setListener(BannerView.IListener iListener) {
        this.bannerView.setListener(iListener);
    }
}
