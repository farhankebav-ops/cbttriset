package com.ironsource.adapters.vungle.interstitial;

import com.google.android.gms.ads.internal.client.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.vungle.ads.BaseAd;
import com.vungle.ads.InterstitialAdListener;
import com.vungle.ads.VungleError;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleInterstitialAdListener implements InterstitialAdListener {
    private final WeakReference<VungleInterstitialAdapter> mAdapter;
    private final InterstitialSmashListener mListener;
    private final String mPlacementId;

    public VungleInterstitialAdListener(WeakReference<VungleInterstitialAdapter> mAdapter, InterstitialSmashListener mListener, String mPlacementId) {
        k.e(mAdapter, "mAdapter");
        k.e(mListener, "mListener");
        k.e(mPlacementId, "mPlacementId");
        this.mAdapter = mAdapter;
        this.mListener = mListener;
        this.mPlacementId = mPlacementId;
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdClicked(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdClicked();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdClosed();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        a.t(androidx.camera.core.processing.util.a.s("placementId = ", adError.getCode(), this.mPlacementId, ", errorCode= ", " error = "), adError.getErrorMessage(), IronLog.ADAPTER_CALLBACK);
        VungleInterstitialAdapter vungleInterstitialAdapter = this.mAdapter.get();
        if (vungleInterstitialAdapter != null) {
            vungleInterstitialAdapter.setInterstitialAdAvailability$vungleadapter_release(this.mPlacementId, false);
        }
        String str = adError.getErrorMessage() + "( " + adError.getCode() + " )";
        this.mListener.onInterstitialAdLoadFailed(adError.getCode() == 10001 ? new IronSourceError(1158, str) : ErrorBuilder.buildLoadFailedError(str));
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToPlay(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        String str = this.mPlacementId;
        int code = adError.getCode();
        String message = adError.getMessage();
        StringBuilder sbS = androidx.camera.core.processing.util.a.s("placementId = ", code, str, ", errorCode = ", ", errorMessage = ");
        sbS.append(message);
        ironLog.verbose(sbS.toString());
        IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError("Interstitial", " reason = " + adError.getErrorMessage() + " errorCode = " + adError.getCode());
        k.d(ironSourceErrorBuildShowFailedError, "buildShowFailedError(\n  …   errorMessage\n        )");
        this.mListener.onInterstitialAdShowFailed(ironSourceErrorBuildShowFailedError);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdOpened();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        VungleInterstitialAdapter vungleInterstitialAdapter = this.mAdapter.get();
        if (vungleInterstitialAdapter != null) {
            vungleInterstitialAdapter.setInterstitialAdAvailability$vungleadapter_release(this.mPlacementId, true);
        }
        String creativeId = baseAd.getCreativeId();
        a.r("placementId = ", this.mPlacementId, ", creativeId = ", creativeId, IronLog.ADAPTER_CALLBACK);
        if (creativeId == null || creativeId.length() == 0) {
            this.mListener.onInterstitialAdReady();
        } else {
            this.mListener.onInterstitialAdReady(x.e0(new i("creativeId", creativeId)));
        }
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onInterstitialAdShowSucceeded();
    }
}
