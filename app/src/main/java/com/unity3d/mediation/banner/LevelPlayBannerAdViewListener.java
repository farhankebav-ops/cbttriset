package com.unity3d.mediation.banner;

import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public interface LevelPlayBannerAdViewListener {
    void onAdClicked(LevelPlayAdInfo levelPlayAdInfo);

    void onAdCollapsed(LevelPlayAdInfo levelPlayAdInfo);

    void onAdDisplayFailed(LevelPlayAdInfo levelPlayAdInfo, LevelPlayAdError levelPlayAdError);

    void onAdDisplayed(LevelPlayAdInfo levelPlayAdInfo);

    void onAdExpanded(LevelPlayAdInfo levelPlayAdInfo);

    void onAdLeftApplication(LevelPlayAdInfo levelPlayAdInfo);

    void onAdLoadFailed(LevelPlayAdError levelPlayAdError);

    void onAdLoaded(LevelPlayAdInfo levelPlayAdInfo);
}
