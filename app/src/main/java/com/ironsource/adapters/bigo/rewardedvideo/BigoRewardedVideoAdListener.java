package com.ironsource.adapters.bigo.rewardedvideo;

import com.ironsource.adapters.bigo.BigoAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class BigoRewardedVideoAdListener implements RewardAdInteractionListener, AdLoadListener<RewardVideoAd> {
    private final WeakReference<BigoRewardedVideoAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;

    public BigoRewardedVideoAdListener(WeakReference<BigoRewardedVideoAdapter> mAdapter, RewardedVideoSmashListener mListener) {
        k.e(mAdapter, "mAdapter");
        k.e(mListener, "mListener");
        this.mAdapter = mAdapter;
        this.mListener = mListener;
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdClicked();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdEnded();
        this.mListener.onRewardedVideoAdClosed();
        BigoRewardedVideoAdapter bigoRewardedVideoAdapter = this.mAdapter.get();
        if (bigoRewardedVideoAdapter != null) {
            bigoRewardedVideoAdapter.destroyRewardedVideoAd$bigoadapter_release();
        }
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdError(AdError error) {
        k.e(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose("Failed to load, errorCode = " + error.getCode() + ", errorMessage = " + error.getMessage());
        this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, error.getMessage()));
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdImpression() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdOpened();
    }

    @Override // sg.bigo.ads.api.AdInteractionListener
    public void onAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdStarted();
    }

    @Override // sg.bigo.ads.api.RewardAdInteractionListener
    public void onAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose();
        this.mListener.onRewardedVideoAdRewarded();
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onError(AdError error) {
        k.e(error, "error");
        IronLog.INTERNAL.verbose("onError code: " + error.getCode() + ", " + error.getMessage());
        this.mListener.onRewardedVideoAvailabilityChanged(false);
        this.mListener.onRewardedVideoLoadFailed(BigoAdapter.Companion.getLoadError(error));
    }

    @Override // sg.bigo.ads.api.AdLoadListener
    public void onAdLoaded(RewardVideoAd ad) {
        k.e(ad, "ad");
        IronLog.INTERNAL.verbose();
        BigoRewardedVideoAdapter bigoRewardedVideoAdapter = this.mAdapter.get();
        if (bigoRewardedVideoAdapter != null) {
            bigoRewardedVideoAdapter.setRewardedVideoAd$bigoadapter_release(ad);
        }
        BigoRewardedVideoAdapter bigoRewardedVideoAdapter2 = this.mAdapter.get();
        if (bigoRewardedVideoAdapter2 != null) {
            bigoRewardedVideoAdapter2.setRewardedVideoAdAvailability$bigoadapter_release(true);
        }
        this.mListener.onRewardedVideoAvailabilityChanged(true);
    }
}
