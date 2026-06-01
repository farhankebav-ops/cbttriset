package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceRewardedAdListener implements ISDemandOnlyRewardedVideoListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClicked(@NonNull String str) {
        MediationRewardedAdCallback rewardedAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource rewarded ad clicked for instance ID: " + str);
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (rewardedAdCallback = fromAvailableInstances.getRewardedAdCallback()) == null) {
            return;
        }
        rewardedAdCallback.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdClosed(@NonNull String str) {
        MediationRewardedAdCallback rewardedAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource rewarded ad closed for instance ID: " + str);
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && (rewardedAdCallback = fromAvailableInstances.getRewardedAdCallback()) != null) {
            rewardedAdCallback.onAdClosed();
        }
        IronSourceRewardedAd.removeFromAvailableInstances(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.e(IronSourceConstants.TAG, adError.toString());
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && fromAvailableInstances.getMediationAdLoadCallback() != null) {
            fromAvailableInstances.getMediationAdLoadCallback().onFailure(adError);
        }
        IronSourceRewardedAd.removeFromAvailableInstances(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdLoadSuccess(@NonNull String str) {
        Log.d(IronSourceConstants.TAG, "IronSource rewarded ad loaded for instance ID: " + str);
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || fromAvailableInstances.getMediationAdLoadCallback() == null) {
            return;
        }
        fromAvailableInstances.setRewardedAdCallback(fromAvailableInstances.getMediationAdLoadCallback().onSuccess(fromAvailableInstances));
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdOpened(@NonNull String str) {
        MediationRewardedAdCallback rewardedAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource rewarded ad opened for instance ID: " + str);
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (rewardedAdCallback = fromAvailableInstances.getRewardedAdCallback()) == null) {
            return;
        }
        rewardedAdCallback.onAdOpened();
        rewardedAdCallback.onVideoStart();
        rewardedAdCallback.reportAdImpression();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdRewarded(@NonNull String str) {
        MediationRewardedAdCallback rewardedAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource rewarded ad received reward for instance ID: " + str);
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (rewardedAdCallback = fromAvailableInstances.getRewardedAdCallback()) == null) {
            return;
        }
        rewardedAdCallback.onVideoComplete();
        rewardedAdCallback.onUserEarnedReward();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener
    public void onRewardedVideoAdShowFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        MediationRewardedAdCallback rewardedAdCallback;
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.e(IronSourceConstants.TAG, adError.toString());
        IronSourceRewardedAd fromAvailableInstances = IronSourceRewardedAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && (rewardedAdCallback = fromAvailableInstances.getRewardedAdCallback()) != null) {
            rewardedAdCallback.onAdFailedToShow(adError);
        }
        IronSourceRewardedAd.removeFromAvailableInstances(str);
    }
}
