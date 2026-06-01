package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceBannerAdListener implements ISDemandOnlyBannerListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdClicked(@NonNull String str) {
        MediationBannerAdCallback bannerAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource banner ad clicked for instance ID: " + str);
        IronSourceBannerAd fromAvailableInstances = IronSourceBannerAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (bannerAdCallback = fromAvailableInstances.getBannerAdCallback()) == null) {
            return;
        }
        bannerAdCallback.onAdOpened();
        bannerAdCallback.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLeftApplication(@NonNull String str) {
        MediationBannerAdCallback bannerAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource banner ad has caused user to leave the application for instance ID: " + str);
        IronSourceBannerAd fromAvailableInstances = IronSourceBannerAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (bannerAdCallback = fromAvailableInstances.getBannerAdCallback()) == null) {
            return;
        }
        bannerAdCallback.onAdLeftApplication();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(IronSourceConstants.TAG, adError.toString());
        IronSourceBannerAd fromAvailableInstances = IronSourceBannerAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null) {
            return;
        }
        MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback = fromAvailableInstances.getAdLoadCallback();
        if (adLoadCallback != null) {
            adLoadCallback.onFailure(adError);
        }
        if (ironSourceError.getErrorCode() == 1050 || ironSourceError.getErrorCode() == 619) {
            return;
        }
        IronSourceBannerAd.removeFromAvailableInstances(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdLoaded(@NonNull String str) {
        Log.d(IronSourceConstants.TAG, "IronSource banner ad loaded for instance ID: " + str);
        IronSourceBannerAd fromAvailableInstances = IronSourceBannerAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || fromAvailableInstances.getIronSourceAdView() == null) {
            return;
        }
        fromAvailableInstances.getIronSourceAdView().addView(fromAvailableInstances.getIronSourceBannerLayout());
        if (fromAvailableInstances.getAdLoadCallback() != null) {
            fromAvailableInstances.setBannerAdCallback(fromAvailableInstances.getAdLoadCallback().onSuccess(fromAvailableInstances));
        }
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener
    public void onBannerAdShown(@NonNull String str) {
        MediationBannerAdCallback bannerAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource banner ad shown for instance ID: " + str);
        IronSourceBannerAd fromAvailableInstances = IronSourceBannerAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && (bannerAdCallback = fromAvailableInstances.getBannerAdCallback()) != null) {
            bannerAdCallback.reportAdImpression();
        }
        IronSourceBannerAd.clearAllAvailableInstancesExceptOne(str);
    }
}
