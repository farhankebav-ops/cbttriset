package com.facebook.ads;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public interface S2SRewardedInterstitialAdListener extends RewardedInterstitialAdListener {
    void onRewardServerFailed();

    void onRewardServerSuccess();
}
