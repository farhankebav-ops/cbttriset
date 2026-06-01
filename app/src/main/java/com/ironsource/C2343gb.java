package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import com.unity3d.mediation.rewarded.LevelPlayReward;

/* JADX INFO: renamed from: com.ironsource.gb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2343gb {

    /* JADX INFO: renamed from: com.ironsource.gb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2289db {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayInterstitialAdListener f8611a;

        public a(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
            this.f8611a = levelPlayInterstitialAdListener;
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdClicked(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdClicked() adInfo: " + adInfo);
            this.f8611a.onAdClicked(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdClosed(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdClosed() adInfo: " + adInfo);
            this.f8611a.onAdClosed(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(error, "error");
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdDisplayFailed() adInfo: " + adInfo + " error: " + error);
            this.f8611a.onAdDisplayFailed(error, adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdDisplayed(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdDisplayed() adInfo: " + adInfo);
            this.f8611a.onAdDisplayed(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdInfoChanged() adInfo: " + adInfo);
            this.f8611a.onAdInfoChanged(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdLoadFailed(LevelPlayAdError error) {
            kotlin.jvm.internal.k.e(error, "error");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdLoaded() error: " + error);
            this.f8611a.onAdLoadFailed(error);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdLoaded(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayInterstitialAdListener.onAdLoaded() adInfo: " + adInfo);
            this.f8611a.onAdLoaded(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public final /* synthetic */ void onAdRewarded(LevelPlayReward levelPlayReward, LevelPlayAdInfo levelPlayAdInfo) {
            fi.a(this, levelPlayReward, levelPlayAdInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC2289db b(LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        return new a(levelPlayInterstitialAdListener);
    }
}
