package com.ironsource.adapters.vungle.rewardedvideo;

import com.google.android.gms.ads.internal.client.a;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.BaseAd;
import com.vungle.ads.RewardedAdListener;
import com.vungle.ads.VungleError;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import q5.i;
import r5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class VungleRewardedVideoAdListener implements RewardedAdListener {
    private final WeakReference<VungleRewardedVideoAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;
    private final String mPlacementId;

    public VungleRewardedVideoAdListener(WeakReference<VungleRewardedVideoAdapter> mAdapter, RewardedVideoSmashListener mListener, String mPlacementId) {
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
        this.mListener.onRewardedVideoAdClicked();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdEnd(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdEnded();
        this.mListener.onRewardedVideoAdClosed();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdFailedToLoad(BaseAd baseAd, VungleError adError) {
        k.e(baseAd, "baseAd");
        k.e(adError, "adError");
        a.t(androidx.camera.core.processing.util.a.s("placementId = ", adError.getCode(), this.mPlacementId, ", errorCode = ", ", errorMessage = "), adError.getMessage(), IronLog.ADAPTER_CALLBACK);
        VungleRewardedVideoAdapter vungleRewardedVideoAdapter = this.mAdapter.get();
        if (vungleRewardedVideoAdapter != null) {
            vungleRewardedVideoAdapter.setRewardedVideoAdAvailability$vungleadapter_release(this.mPlacementId, false);
        }
        String str = adError.getErrorMessage() + "( " + adError.getCode() + " )";
        IronSourceError ironSourceError = adError.getCode() == 10001 ? new IronSourceError(1058, str) : ErrorBuilder.buildLoadFailedError(str);
        this.mListener.onRewardedVideoAvailabilityChanged(false);
        this.mListener.onRewardedVideoLoadFailed(ironSourceError);
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
        IronSourceError ironSourceErrorBuildShowFailedError = ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, " reason = " + adError.getErrorMessage() + " errorCode = " + adError.getCode());
        k.d(ironSourceErrorBuildShowFailedError, "buildShowFailedError(\n  …   errorMessage\n        )");
        this.mListener.onRewardedVideoAdShowFailed(ironSourceErrorBuildShowFailedError);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdImpression(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdOpened();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLeftApplication(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdLoaded(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        VungleRewardedVideoAdapter vungleRewardedVideoAdapter = this.mAdapter.get();
        if (vungleRewardedVideoAdapter != null) {
            vungleRewardedVideoAdapter.setRewardedVideoAdAvailability$vungleadapter_release(this.mPlacementId, true);
        }
        String creativeId = baseAd.getCreativeId();
        a.r("placementId = ", this.mPlacementId, ", creativeId = ", creativeId, IronLog.ADAPTER_CALLBACK);
        if (creativeId == null || creativeId.length() == 0) {
            this.mListener.onRewardedVideoAvailabilityChanged(true);
        } else {
            this.mListener.onRewardedVideoAvailabilityChanged(true, x.e0(new i("creativeId", creativeId)));
        }
    }

    @Override // com.vungle.ads.RewardedAdListener
    public void onAdRewarded(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdRewarded();
    }

    @Override // com.vungle.ads.BaseAdListener
    public void onAdStart(BaseAd baseAd) {
        k.e(baseAd, "baseAd");
        a.p("placementId = ", this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdStarted();
    }
}
