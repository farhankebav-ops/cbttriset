package com.ironsource.adapters.bigo.interstitial;

import com.ironsource.Mf;
import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.InterstitialAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoInterstitialAdListener implements AdInteractionListener, AdLoadListener<InterstitialAd> {
    private final WeakReference<BigoInterstitialAdapter> mAdapter;
    private final InterstitialSmashListener mListener;

    public BigoInterstitialAdListener(WeakReference<BigoInterstitialAdapter> mAdapter, InterstitialSmashListener mListener) {
        k.e(mAdapter, "mAdapter");
        k.e(mListener, "mListener");
        this.mAdapter = mAdapter;
        this.mListener = mListener;
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClicked();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdClosed();
        BigoInterstitialAdapter bigoInterstitialAdapter = this.mAdapter.get();
        if (bigoInterstitialAdapter != null) {
            bigoInterstitialAdapter.destroyInterstitialAd$bigoadapter_release();
        }
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdError(AdError error) {
        k.e(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", error.getMessage()));
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdImpression() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onError(AdError error) {
        k.e(error, "error");
        IronLog.INTERNAL.verbose("onError code: " + error.getCode() + ", " + error.getMessage());
        this.mListener.onInterstitialAdLoadFailed(BigoAdapter.Companion.getLoadError(error));
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onAdLoaded(InterstitialAd ad) {
        k.e(ad, "ad");
        IronLog.INTERNAL.verbose(Mf.j);
        BigoInterstitialAdapter bigoInterstitialAdapter = this.mAdapter.get();
        if (bigoInterstitialAdapter != null) {
            bigoInterstitialAdapter.setInterstitialAd$bigoadapter_release(ad);
        }
        BigoInterstitialAdapter bigoInterstitialAdapter2 = this.mAdapter.get();
        if (bigoInterstitialAdapter2 != null) {
            bigoInterstitialAdapter2.setInterstitialAdAvailability$bigoadapter_release(true);
        }
        this.mListener.onInterstitialAdReady();
    }
}
