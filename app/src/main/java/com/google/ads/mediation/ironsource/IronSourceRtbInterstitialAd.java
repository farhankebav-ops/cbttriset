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
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoader;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceRtbInterstitialAd implements MediationInterstitialAd, InterstitialAdLoaderListener, InterstitialAdListener {
    private InterstitialAd ad = null;

    @VisibleForTesting
    private MediationInterstitialAdCallback interstitialAdCallback;
    private final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback;

    public IronSourceRtbInterstitialAd(@NonNull MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mediationAdLoadCallback = mediationAdLoadCallback;
    }

    private void reportAdFailedToShow(@NonNull AdError adError) {
        Log.e(IronSourceConstants.TAG, adError.toString());
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback != null) {
            mediationInterstitialAdCallback.onAdFailedToShow(adError);
        }
    }

    public void loadRtbAd(@NonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration) {
        String string = mediationInterstitialAdConfiguration.getServerParameters().getString("instanceId", "");
        if (TextUtils.isEmpty(string)) {
            this.mediationAdLoadCallback.onFailure(IronSourceAdapterUtils.buildAdErrorAdapterDomain(101, "Missing or invalid instance ID."));
        } else {
            InterstitialAdLoader.loadAd(new InterstitialAdRequest.Builder(string, mediationInterstitialAdConfiguration.getBidResponse()).withExtraParams(a.c("google_watermark", mediationInterstitialAdConfiguration.getWatermark())).build(), this);
        }
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdClicked(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.reportAdClicked();
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdDismissed(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdClosed();
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdFailedToShow(@NonNull InterstitialAd interstitialAd, @NonNull IronSourceError ironSourceError) {
        reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorIronSourceDomain(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
    public void onInterstitialAdLoadFailed(@NonNull IronSourceError ironSourceError) {
        Log.e(IronSourceConstants.TAG, ironSourceError.toString());
        this.mediationAdLoadCallback.onFailure(IronSourceAdapterUtils.buildAdErrorIronSourceDomain(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage()));
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener
    public void onInterstitialAdLoaded(@NonNull InterstitialAd interstitialAd) {
        this.ad = interstitialAd;
        this.interstitialAdCallback = this.mediationAdLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ironsourceads.interstitial.InterstitialAdListener
    public void onInterstitialAdShown(@NonNull InterstitialAd interstitialAd) {
        MediationInterstitialAdCallback mediationInterstitialAdCallback = this.interstitialAdCallback;
        if (mediationInterstitialAdCallback == null) {
            return;
        }
        mediationInterstitialAdCallback.onAdOpened();
        this.interstitialAdCallback.reportAdImpression();
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAd
    public void showAd(@NonNull Context context) {
        if (this.ad == null) {
            reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorAdapterDomain(107, "ad is null"));
            return;
        }
        try {
            Log.d(IronSourceConstants.TAG, "Showing IronSource interstitial ad");
            this.ad.setListener(this);
            this.ad.show((Activity) context);
        } catch (ClassCastException unused) {
            reportAdFailedToShow(IronSourceAdapterUtils.buildAdErrorAdapterDomain(102, "IronSource requires an Activity context to load ads."));
        }
    }
}
