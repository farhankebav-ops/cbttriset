package com.unity3d.ads.beta;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface BannerShowListener {
    void unityAdsBannerDidClick(BannerAd bannerAd);

    void unityAdsBannerDidFailShow(BannerAd bannerAd, UnityAdsError unityAdsError);

    void unityAdsBannerImpression(BannerAd bannerAd);
}
