package com.google.ads.mediation.ironsource;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.processing.util.a;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.banner.BannerAdLoader;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import com.unity3d.ironsourceads.banner.BannerAdView;
import com.unity3d.ironsourceads.banner.BannerAdViewListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IronSourceRtbBannerAd implements MediationBannerAd, BannerAdLoaderListener, BannerAdViewListener {

    @VisibleForTesting
    private MediationBannerAdCallback adLifecycleCallback;
    private final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback;
    private FrameLayout ironSourceAdView;

    public IronSourceRtbBannerAd(@NonNull MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.adLoadCallback = mediationAdLoadCallback;
    }

    @Override // com.google.android.gms.ads.mediation.MediationBannerAd
    @NonNull
    public View getView() {
        return this.ironSourceAdView;
    }

    public void loadRtbAd(@NonNull MediationBannerAdConfiguration mediationBannerAdConfiguration) {
        String string = mediationBannerAdConfiguration.getServerParameters().getString("instanceId", "");
        if (TextUtils.isEmpty(string)) {
            this.adLoadCallback.onFailure(IronSourceAdapterUtils.buildAdErrorAdapterDomain(101, "Missing or invalid instance ID."));
            return;
        }
        Bundle bundleC = a.c("google_watermark", mediationBannerAdConfiguration.getWatermark());
        Context context = mediationBannerAdConfiguration.getContext();
        BannerAdRequest bannerAdRequestBuild = new BannerAdRequest.Builder(context, string, mediationBannerAdConfiguration.getBidResponse(), IronSourceAdapterUtils.getAdSizeFromGoogleAdSize(context, mediationBannerAdConfiguration.getAdSize())).withExtraParams(bundleC).build();
        this.ironSourceAdView = new FrameLayout(context);
        BannerAdLoader.loadAd(bannerAdRequestBuild, this);
    }

    @Override // com.unity3d.ironsourceads.banner.BannerAdViewListener
    public void onBannerAdClicked(@NonNull BannerAdView bannerAdView) {
        MediationBannerAdCallback mediationBannerAdCallback = this.adLifecycleCallback;
        if (mediationBannerAdCallback == null) {
            return;
        }
        mediationBannerAdCallback.onAdOpened();
        this.adLifecycleCallback.reportAdClicked();
    }

    @Override // com.unity3d.ironsourceads.banner.BannerAdLoaderListener
    public void onBannerAdLoadFailed(@NonNull IronSourceError ironSourceError) {
        if (this.adLoadCallback == null) {
            return;
        }
        this.adLoadCallback.onFailure(new AdError(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage(), IronSourceMediationAdapter.IRONSOURCE_SDK_ERROR_DOMAIN));
    }

    @Override // com.unity3d.ironsourceads.banner.BannerAdLoaderListener
    public void onBannerAdLoaded(@NonNull BannerAdView bannerAdView) {
        if (this.ironSourceAdView == null || this.adLoadCallback == null) {
            return;
        }
        bannerAdView.setListener(this);
        this.ironSourceAdView.addView(bannerAdView);
        this.adLifecycleCallback = this.adLoadCallback.onSuccess(this);
    }

    @Override // com.unity3d.ironsourceads.banner.BannerAdViewListener
    public void onBannerAdShown(@NonNull BannerAdView bannerAdView) {
        MediationBannerAdCallback mediationBannerAdCallback = this.adLifecycleCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }
}
