package com.ironsource.adapters.vungle.banner;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.BannerAdListener;
import com.vungle.ads.BaseAd;
import com.vungle.ads.VungleBannerView;
import com.vungle.ads.VungleError;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleBannerAdListener implements BannerAdListener {
    private final VungleBannerView bannerView;
    private final BannerSmashListener mListener;
    private final String mPlacementId;

    public VungleBannerAdListener(BannerSmashListener mListener, String mPlacementId, VungleBannerView bannerView) {
        k.e(mListener, "mListener");
        k.e(mPlacementId, "mPlacementId");
        k.e(bannerView, "bannerView");
        this.mListener = mListener;
        this.mPlacementId = mPlacementId;
        this.bannerView = bannerView;
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onBannerAdClicked();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        String str = this.mPlacementId;
        int code = adError.getCode();
        String message = adError.getMessage();
        StringBuilder sbS = androidx.camera.core.processing.util.a.s("placementId = ", code, str, ", errorCode = ", ", errorMessage = ");
        sbS.append(message);
        ironLog.verbose(sbS.toString());
        String str2 = adError.getErrorMessage() + "( " + adError.getCode() + " )";
        this.mListener.onBannerAdLoadFailed(adError.getCode() == 10001 ? new IronSourceError(606, str2) : ErrorBuilder.buildLoadFailedError(str2));
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        String str = this.mPlacementId;
        int code = adError.getCode();
        a.t(androidx.camera.core.processing.util.a.s("placementId = ", code, str, ", errorCode = ", ", errorMessage = "), adError.getErrorMessage(), ironLog);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onBannerAdShown();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onBannerAdLeftApplication();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, this.bannerView.getAdViewSize().getWidth()), AdapterUtils.dpToPixels(applicationContext, this.bannerView.getAdViewSize().getHeight()), 17);
        String creativeId = baseAd.getCreativeId();
        a.r("placementId = ", this.mPlacementId, ", creativeId = ", creativeId, IronLog.ADAPTER_CALLBACK);
        if (creativeId == null || creativeId.length() == 0) {
            this.mListener.onBannerAdLoaded(this.bannerView, layoutParams);
        } else {
            this.mListener.onBannerAdLoaded(this.bannerView, layoutParams, x.e0(new i("creativeId", creativeId)));
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }
}
