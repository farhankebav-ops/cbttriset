package com.google.ads.mediation.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoader;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceRtbRewardedAd implements MediationRewardedAd, RewardedAdLoaderListener, RewardedAdListener {
    private RewardedAd ad = null;
    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback;

    @VisibleForTesting
    private MediationRewardedAdCallback mediationRewardedAdCallback;

    public IronSourceRtbRewardedAd(@NonNull MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    private void reportAdFailedToShow(@NonNull AdError adError) {
        Log.w(IronSourceConstants.TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        }
    }

    public void loadRtbAd(@NonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration) {
        String string = mediationRewardedAdConfiguration.getServerParameters().getString("instanceId", "");
        if (TextUtils.isEmpty(string)) {
            this.mediationAdLoadCallback.onFailure(IronSourceAdapterUtils.buildAdErrorAdapterDomain(101, "Missing or invalid instance ID."));
        } else {
            RewardedAdLoader.loadAd(new RewardedAdRequest.Builder(string, mediationRewardedAdConfiguration.getBidResponse()).withExtraParams(a.c("google_watermark", mediationRewardedAdConfiguration.getWatermark())).build(), this);
        }
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdClicked(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.reportAdClicked();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdDismissed(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdClosed();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdFailedToShow(@NonNull RewardedAd rewardedAd, @NonNull IronSourceError ironSourceError) {
        reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorIronSourceDomain(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
    public void onRewardedAdLoadFailed(@NonNull IronSourceError ironSourceError) {
        this.mediationAdLoadCallback.onFailure(IronSourceAdapterUtils.buildAdErrorIronSourceDomain(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener
    public void onRewardedAdLoaded(@NonNull RewardedAd rewardedAd) {
        this.ad = rewardedAd;
        this.mediationRewardedAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onRewardedAdShown(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onAdOpened();
        this.mediationRewardedAdCallback.onVideoStart();
        this.mediationRewardedAdCallback.reportAdImpression();
    }

    @Override // com.unity3d.ironsourceads.rewarded.RewardedAdListener
    public void onUserEarnedReward(@NonNull RewardedAd rewardedAd) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mediationRewardedAdCallback;
        if (mediationRewardedAdCallback == null) {
            return;
        }
        mediationRewardedAdCallback.onVideoComplete();
        this.mediationRewardedAdCallback.onUserEarnedReward();
    }

    @Override // com.google.android.gms.ads.mediation.MediationRewardedAd
    public void showAd(@NonNull Context context) {
        if (this.ad == null) {
            reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorAdapterDomain(107, "ad is null"));
            return;
        }
        try {
            Log.d(IronSourceConstants.TAG, "Showing IronSource rewarded ad");
            this.ad.setListener(this);
            this.ad.show((Activity) context);
        } catch (ClassCastException unused) {
            reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorAdapterDomain(102, "IronSource requires an Activity context to load ads."));
        }
    }
}
