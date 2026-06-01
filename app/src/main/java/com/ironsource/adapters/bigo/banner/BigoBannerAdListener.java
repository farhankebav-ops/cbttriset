package com.ironsource.adapters.bigo.banner;

import android.widget.FrameLayout;
import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.BannerAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoBannerAdListener implements AdInteractionListener, AdLoadListener<BannerAd> {
    private final WeakReference<BigoBannerAdapter> mAdapter;
    private final FrameLayout.LayoutParams mLayoutParams;
    private final BannerSmashListener mListener;

    public BigoBannerAdListener(WeakReference<BigoBannerAdapter> mAdapter, BannerSmashListener mListener, FrameLayout.LayoutParams mLayoutParams) {
        k.e(mAdapter, "mAdapter");
        k.e(mListener, "mListener");
        k.e(mLayoutParams, "mLayoutParams");
        this.mAdapter = mAdapter;
        this.mListener = mListener;
        this.mLayoutParams = mLayoutParams;
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdClicked();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdError(AdError error) {
        k.e(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to show, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        this.mListener.onBannerAdLoadFailed(BigoAdapter.Companion.getLoadError(error));
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdImpression() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdShown();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onError(AdError error) {
        k.e(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        this.mListener.onBannerAdLoadFailed(BigoAdapter.Companion.getLoadError(error));
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onAdLoaded(BannerAd ad) {
        k.e(ad, "ad");
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onBannerAdLoaded(ad.adView(), this.mLayoutParams);
        BigoBannerAdapter bigoBannerAdapter = this.mAdapter.get();
        if (bigoBannerAdapter != null) {
            bigoBannerAdapter.setBannerView$bigoadapter_release(ad);
        }
    }
}
