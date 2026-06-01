package com.ironsource.adapters.facebook.interstitial;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookInterstitialAdListener implements InterstitialAdExtendedListener {
    private WeakReference<FacebookInterstitialAdapter> mAdapter;
    private boolean mDidCallClosed;
    private InterstitialSmashListener mListener;
    private String mPlacementId;

    public FacebookInterstitialAdListener(FacebookInterstitialAdapter facebookInterstitialAdapter, String str, InterstitialSmashListener interstitialSmashListener) {
        this.mAdapter = new WeakReference<>(facebookInterstitialAdapter);
        this.mListener = interstitialSmashListener;
        this.mPlacementId = str;
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mAdapter.get().mAdsAvailability.put(this.mPlacementId, Boolean.TRUE);
            this.mListener.onInterstitialAdReady();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, AdError adError) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mAdapter.get().mAdsAvailability.put(this.mPlacementId, Boolean.FALSE);
        IronSourceError ironSourceError = new IronSourceError(FacebookAdapter.isNoFillError(adError) ? 1158 : adError.getErrorCode(), adError.getErrorMessage());
        if (this.mAdapter.get().mPlacementIdToShowAttempts.get(this.mPlacementId).booleanValue()) {
            this.mListener.onInterstitialAdShowFailed(ironSourceError);
        } else {
            this.mListener.onInterstitialAdLoadFailed(ironSourceError);
        }
    }

    @Override // com.facebook.ads.InterstitialAdExtendedListener
    public void onInterstitialActivityDestroyed() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            if (this.mDidCallClosed) {
                return;
            }
            this.mListener.onInterstitialAdClosed();
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDismissed(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mDidCallClosed = true;
            this.mListener.onInterstitialAdClosed();
        }
    }

    @Override // com.facebook.ads.InterstitialAdListener
    public void onInterstitialDisplayed(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookInterstitialAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mDidCallClosed = false;
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdCompleted() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerFailed() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.facebook.ads.RewardedAdListener
    public void onRewardedAdServerSucceeded() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }
}
