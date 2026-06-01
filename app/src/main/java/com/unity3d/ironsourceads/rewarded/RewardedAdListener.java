package com.unity3d.ironsourceads.rewarded;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface RewardedAdListener {
    void onRewardedAdClicked(RewardedAd rewardedAd);

    void onRewardedAdDismissed(RewardedAd rewardedAd);

    void onRewardedAdFailedToShow(RewardedAd rewardedAd, IronSourceError ironSourceError);

    void onRewardedAdShown(RewardedAd rewardedAd);

    void onUserEarnedReward(RewardedAd rewardedAd);
}
