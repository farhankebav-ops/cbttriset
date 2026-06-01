package com.ironsource.adapters.unityads;

import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class UnityAdsBannerAdListener implements BannerView.IListener {
    private final WeakReference<UnityAdsAdapter> mAdapter;
    private final BannerSmashListener mListener;
    private final String mPlacementId;

    public UnityAdsBannerAdListener(BannerSmashListener bannerSmashListener, WeakReference<UnityAdsAdapter> weakReference, String mPlacementId) {
        k.e(mPlacementId, "mPlacementId");
        this.mListener = bannerSmashListener;
        this.mAdapter = weakReference;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerClick(BannerView bannerView) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        UnityAdsAdapter unityAdsAdapter;
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        String str = ((weakReference == null || (unityAdsAdapter = weakReference.get()) == null) ? null : unityAdsAdapter.getProviderName()) + " banner, onAdLoadFailed placementId " + this.mPlacementId + " with error: " + (bannerErrorInfo != null ? bannerErrorInfo.errorMessage : null);
        IronSourceError ironSourceError = (bannerErrorInfo != null ? bannerErrorInfo.errorCode : null) == BannerErrorCode.NO_FILL ? new IronSourceError(606, str) : ErrorBuilder.buildLoadFailedError(str);
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceError);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLoadFailed(ironSourceError);
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLeftApplication(BannerView bannerView) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerLoaded(BannerView bannerView) {
        BannerSmashListener bannerSmashListener;
        FrameLayout.LayoutParams layoutParamsCreateLayoutParams;
        UnityAdsAdapter unityAdsAdapter;
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (bannerView == null || (bannerSmashListener = this.mListener) == null) {
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || (unityAdsAdapter = weakReference.get()) == null) {
            layoutParamsCreateLayoutParams = null;
        } else {
            UnityBannerSize size = bannerView.getSize();
            k.d(size, "bannerView.size");
            layoutParamsCreateLayoutParams = unityAdsAdapter.createLayoutParams(size);
        }
        bannerSmashListener.onBannerAdLoaded(bannerView, layoutParamsCreateLayoutParams);
    }

    @Override // com.unity3d.services.banners.BannerView.IListener
    public void onBannerShown(BannerView bannerView) {
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
