package com.ironsource.adapters.facebook.banner;

import android.widget.FrameLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdView;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookBannerAdListener implements AdListener {
    private final WeakReference<FacebookBannerAdapter> mAdapter;
    private final FrameLayout.LayoutParams mBannerLayoutParams;
    private final BannerSmashListener mListener;
    private final String mPlacementId;

    public FacebookBannerAdListener(FacebookBannerAdapter facebookBannerAdapter, FrameLayout.LayoutParams layoutParams, String str, BannerSmashListener bannerSmashListener) {
        this.mAdapter = new WeakReference<>(facebookBannerAdapter);
        this.mListener = bannerSmashListener;
        this.mPlacementId = str;
        this.mBannerLayoutParams = layoutParams;
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookBannerAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        AdView adView = this.mAdapter.get().mPlacementIdToAd.get(this.mPlacementId);
        if (adView != null) {
            this.mListener.onBannerAdLoaded(adView, this.mBannerLayoutParams);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, AdError adError) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(FacebookAdapter.isNoFillError(adError) ? 606 : adError.getErrorCode(), adError.getErrorMessage()));
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
