package com.ironsource.mediationsdk.sdk;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface RewardedVideoSmashListener {
    void onRewardedVideoAdClicked();

    void onRewardedVideoAdClicked(Map<String, Object> map);

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdClosed(Map<String, Object> map);

    void onRewardedVideoAdEnded();

    void onRewardedVideoAdEnded(Map<String, Object> map);

    void onRewardedVideoAdOpened();

    void onRewardedVideoAdOpened(Map<String, Object> map);

    void onRewardedVideoAdRewarded();

    void onRewardedVideoAdRewarded(Map<String, Object> map);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError);

    void onRewardedVideoAdShowFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onRewardedVideoAdStarted();

    void onRewardedVideoAdStarted(Map<String, Object> map);

    void onRewardedVideoAdVisible();

    void onRewardedVideoAdVisible(Map<String, Object> map);

    void onRewardedVideoAvailabilityChanged(boolean z2);

    void onRewardedVideoAvailabilityChanged(boolean z2, Map<String, Object> map);

    void onRewardedVideoInitFailed(IronSourceError ironSourceError);

    void onRewardedVideoInitFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onRewardedVideoInitSuccess();

    void onRewardedVideoInitSuccess(Map<String, Object> map);

    void onRewardedVideoLoadFailed(IronSourceError ironSourceError);

    void onRewardedVideoLoadFailed(IronSourceError ironSourceError, Map<String, Object> map);

    void onRewardedVideoLoadSuccess();

    void onRewardedVideoLoadSuccess(Map<String, Object> map);
}
