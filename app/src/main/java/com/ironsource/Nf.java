package com.ironsource;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.rewarded.LevelPlayReward;
import com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Nf implements LevelPlayRewardedAdListener {
    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdClicked(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed.a().a(new C2434ld(0, adInfo.getPlacementName(), false, "", 0, null), Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdClosed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed.a().b(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdDisplayFailed(LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(error, "error");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed edA = Ed.a();
        Pf pf = Pf.f7396a;
        edA.a(pf.a(error), pf.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdDisplayed(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed.a().c(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public final /* synthetic */ void onAdInfoChanged(LevelPlayAdInfo levelPlayAdInfo) {
        s3.a.d(this, levelPlayAdInfo);
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdLoadFailed(LevelPlayAdError error) {
        kotlin.jvm.internal.k.e(error, "error");
        Ed.a().a(Pf.f7396a.a(error));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdLoaded(LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed.a().d(Pf.f7396a.a(adInfo));
    }

    @Override // com.unity3d.mediation.rewarded.LevelPlayRewardedAdListener
    public void onAdRewarded(LevelPlayReward reward, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.k.e(reward, "reward");
        kotlin.jvm.internal.k.e(adInfo, "adInfo");
        Ed.a().b(new C2434ld(0, adInfo.getPlacementName(), false, reward.getName(), reward.getAmount(), null), Pf.f7396a.a(adInfo));
    }
}
