package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;

/* JADX INFO: renamed from: com.ironsource.rb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2538rb {

    /* JADX INFO: renamed from: com.ironsource.rb$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class a implements InterfaceC2289db {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LevelPlayRewardedAdListener f9768a;

        public a(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
            this.f9768a = levelPlayRewardedAdListener;
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdClicked(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdClicked() adInfo: " + adInfo);
            this.f9768a.onAdClicked(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdClosed(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdClosed() adInfo: " + adInfo);
            this.f9768a.onAdClosed(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(error, "error");
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdDisplayFailed() adInfo: " + adInfo + " error: " + error);
            this.f9768a.onAdDisplayFailed(error, adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdDisplayed(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdDisplayed() adInfo: " + adInfo);
            this.f9768a.onAdDisplayed(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdInfoChanged(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdInfoChanged() adInfo: " + adInfo);
            this.f9768a.onAdInfoChanged(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdLoadFailed(LevelPlayAdError error) {
            kotlin.jvm.internal.k.e(error, "error");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdLoadFailed() error: " + error);
            this.f9768a.onAdLoadFailed(error);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdLoaded(LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdLoaded() adInfo: " + adInfo);
            this.f9768a.onAdLoaded(adInfo);
        }

        @Override // com.ironsource.InterfaceC2289db
        public void onAdRewarded(LevelPlayReward reward, LevelPlayAdInfo adInfo) {
            kotlin.jvm.internal.k.e(reward, "reward");
            kotlin.jvm.internal.k.e(adInfo, "adInfo");
            IronLog.CALLBACK.info("LevelPlayRewardedAdListener.onAdRewarded() reward: " + reward + " adInfo: " + adInfo);
            this.f9768a.onAdRewarded(reward, adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC2289db b(LevelPlayRewardedAdListener levelPlayRewardedAdListener) {
        return new a(levelPlayRewardedAdListener);
    }
}
