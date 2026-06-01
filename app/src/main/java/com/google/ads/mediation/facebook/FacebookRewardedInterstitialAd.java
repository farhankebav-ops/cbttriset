package com.google.ads.mediation.facebook;

import androidx.annotation.NonNull;
import com.facebook.ads.AdExperienceType;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class FacebookRewardedInterstitialAd extends FacebookRewardedAd {
    public FacebookRewardedInterstitialAd(MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        super(mediationAdLoadCallback, metaFactory);
    }

    @Override // com.google.ads.mediation.facebook.FacebookRewardedAd
    @NonNull
    public AdExperienceType getAdExperienceType() {
        return AdExperienceType.AD_EXPERIENCE_TYPE_REWARDED_INTERSTITIAL;
    }
}
