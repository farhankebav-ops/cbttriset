package com.ironsource.adapters.admob.banner;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.nativead.NativeAd;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobNativeBannerAdListener extends AdListener implements NativeAd.OnNativeAdLoadedListener {
    private final String mAdUnitId;
    private final WeakReference<AdMobBannerAdapter> mBannerAdapter;
    private final ISBannerSize mBannerSize;
    private final BannerSmashListener mListener;
    private final NativeTemplateType mTemplateType;

    public AdMobNativeBannerAdListener(AdMobBannerAdapter adMobBannerAdapter, BannerSmashListener bannerSmashListener, String str, ISBannerSize iSBannerSize, NativeTemplateType nativeTemplateType) {
        this.mBannerAdapter = new WeakReference<>(adMobBannerAdapter);
        this.mListener = bannerSmashListener;
        this.mAdUnitId = str;
        this.mBannerSize = iSBannerSize;
        this.mTemplateType = nativeTemplateType;
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClicked() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdClosed() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdFailedToLoad(LoadAdError loadAdError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, ironLog);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        String string = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
        if (loadAdError.getCause() != null) {
            StringBuilder sbX = a1.a.x(string, " Caused by - ");
            sbX.append(loadAdError.getCause());
            string = sbX.toString();
        }
        IronSourceError ironSourceError = AdMobAdapter.isNoFillError(loadAdError.getCode()) ? new IronSourceError(606, string) : ErrorBuilder.buildLoadFailedError(string);
        ironLog.error(string + string);
        this.mListener.onBannerAdLoadFailed(ironSourceError);
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdImpression() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    @Override // com.google.android.gms.ads.AdListener
    public void onAdOpened() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenPresented();
        }
    }

    @Override // com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener
    public void onNativeAdLoaded(final NativeAd nativeAd) {
        IronLog.ADAPTER_CALLBACK.verbose("adUnitId = " + this.mAdUnitId);
        AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.admob.banner.AdMobNativeBannerAdListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (AdMobNativeBannerAdListener.this.mListener == null) {
                    IronLog.INTERNAL.verbose("listener is null");
                    return;
                }
                if (AdMobNativeBannerAdListener.this.mBannerAdapter == null || AdMobNativeBannerAdListener.this.mBannerAdapter.get() == null) {
                    IronLog.INTERNAL.verbose("adapter is null");
                    return;
                }
                AdMobNativeBannerViewHandler adMobNativeBannerViewHandler = new AdMobNativeBannerViewHandler(AdMobNativeBannerAdListener.this.mBannerSize, AdMobNativeBannerAdListener.this.mTemplateType, ContextProvider.getInstance().getApplicationContext());
                new AdMobNativeBannerViewBinder().bindView(nativeAd, adMobNativeBannerViewHandler.getNativeAdView(), AdMobNativeBannerAdListener.this.mTemplateType);
                ((AdMobBannerAdapter) AdMobNativeBannerAdListener.this.mBannerAdapter.get()).mAdUnitIdToNativeBannerAd.put(AdMobNativeBannerAdListener.this.mAdUnitId, nativeAd);
                AdMobNativeBannerAdListener.this.mListener.onBannerAdLoaded(adMobNativeBannerViewHandler.getNativeAdView(), adMobNativeBannerViewHandler.getLayoutParams());
            }
        });
    }
}
