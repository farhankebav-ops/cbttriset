package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.MediaView;
import com.facebook.ads.RewardedVideoAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MetaFactory {
    public InterstitialAd createInterstitialAd(Context context, String str) {
        return new InterstitialAd(context, str);
    }

    public MediaView createMediaView(Context context) {
        return new MediaView(context);
    }

    public AdView createMetaAdView(Context context, String str, String str2) throws Exception {
        return new AdView(context, str, str2);
    }

    public RewardedVideoAd createRewardedAd(Context context, String str) {
        return new RewardedVideoAd(context, str);
    }
}
