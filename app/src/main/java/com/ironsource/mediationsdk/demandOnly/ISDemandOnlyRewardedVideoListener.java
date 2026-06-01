package com.ironsource.mediationsdk.demandOnly;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface ISDemandOnlyRewardedVideoListener {
    void onRewardedVideoAdClicked(String str);

    void onRewardedVideoAdClosed(String str);

    void onRewardedVideoAdLoadFailed(String str, IronSourceError ironSourceError);

    void onRewardedVideoAdLoadSuccess(String str);

    void onRewardedVideoAdOpened(String str);

    void onRewardedVideoAdRewarded(String str);

    void onRewardedVideoAdShowFailed(String str, IronSourceError ironSourceError);
}
