package com.google.ads.mediation.ironsource;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceInterstitialAdListener implements ISDemandOnlyInterstitialListener {
    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClicked(@NonNull String str) {
        MediationInterstitialAdCallback interstitialAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource interstitial ad clicked for instance ID: " + str);
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (interstitialAdCallback = fromAvailableInstances.getInterstitialAdCallback()) == null) {
            return;
        }
        interstitialAdCallback.reportAdClicked();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdClosed(@NonNull String str) {
        MediationInterstitialAdCallback interstitialAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource interstitial ad closed for instance ID: " + str);
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && (interstitialAdCallback = fromAvailableInstances.getInterstitialAdCallback()) != null) {
            interstitialAdCallback.onAdClosed();
        }
        IronSourceInterstitialAd.removeFromAvailableInstances(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdLoadFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(IronSourceConstants.TAG, adError.toString());
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && fromAvailableInstances.getMediationAdLoadCallback() != null) {
            fromAvailableInstances.getMediationAdLoadCallback().onFailure(adError);
        }
        IronSourceInterstitialAd.removeFromAvailableInstances(str);
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdOpened(@NonNull String str) {
        MediationInterstitialAdCallback interstitialAdCallback;
        Log.d(IronSourceConstants.TAG, "IronSource interstitial ad opened for instance ID: " + str);
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || (interstitialAdCallback = fromAvailableInstances.getInterstitialAdCallback()) == null) {
            return;
        }
        interstitialAdCallback.onAdOpened();
        interstitialAdCallback.reportAdImpression();
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdReady(@NonNull String str) {
        Log.d(IronSourceConstants.TAG, "IronSource interstitial ad is ready for instance ID: " + str);
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances == null || fromAvailableInstances.getMediationAdLoadCallback() == null) {
            return;
        }
        fromAvailableInstances.setInterstitialAdCallback(fromAvailableInstances.getMediationAdLoadCallback().onSuccess(fromAvailableInstances));
    }

    @Override // com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener
    public void onInterstitialAdShowFailed(@NonNull String str, @NonNull IronSourceError ironSourceError) {
        MediationInterstitialAdCallback interstitialAdCallback;
        AdError adError = new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN);
        Log.w(IronSourceConstants.TAG, adError.toString());
        IronSourceInterstitialAd fromAvailableInstances = IronSourceInterstitialAd.getFromAvailableInstances(str);
        if (fromAvailableInstances != null && (interstitialAdCallback = fromAvailableInstances.getInterstitialAdCallback()) != null) {
            interstitialAdCallback.onAdFailedToShow(adError);
        }
        IronSourceInterstitialAd.removeFromAvailableInstances(str);
    }
}
