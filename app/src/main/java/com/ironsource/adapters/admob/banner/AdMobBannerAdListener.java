package com.ironsource.adapters.admob.banner;

import android.widget.FrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.admob.AdMobAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdMobBannerAdListener extends AdListener {
    private String mAdUnitId;
    private AdView mAdView;
    private BannerSmashListener mListener;

    public AdMobBannerAdListener(BannerSmashListener bannerSmashListener, String str, AdView adView) {
        this.mListener = bannerSmashListener;
        this.mAdUnitId = str;
        this.mAdView = adView;
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
        String string;
        IronSourceError ironSourceErrorBuildLoadFailedError;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, ironLog);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (loadAdError != null) {
            string = loadAdError.getMessage() + "( " + loadAdError.getCode() + " ) ";
            if (loadAdError.getCause() != null) {
                StringBuilder sbX = a1.a.x(string, " Caused by - ");
                sbX.append(loadAdError.getCause());
                string = sbX.toString();
            }
            ironSourceErrorBuildLoadFailedError = AdMobAdapter.isNoFillError(loadAdError.getCode()) ? new IronSourceError(606, string) : ErrorBuilder.buildLoadFailedError(string);
        } else {
            string = "Banner failed to load (loadAdError is null)";
            ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("Banner failed to load (loadAdError is null)");
        }
        ironLog.error(string + string);
        this.mListener.onBannerAdLoadFailed(ironSourceErrorBuildLoadFailedError);
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
    public void onAdLoaded() {
        a.t(new StringBuilder("adUnitId = "), this.mAdUnitId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            if (this.mAdView == null) {
                IronLog.INTERNAL.verbose("adView is null");
                return;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.gravity = 17;
            this.mListener.onBannerAdLoaded(this.mAdView, layoutParams);
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
}
