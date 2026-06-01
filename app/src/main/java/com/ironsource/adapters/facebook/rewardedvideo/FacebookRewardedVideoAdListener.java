package com.ironsource.adapters.facebook.rewardedvideo;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.RewardedVideoAdExtendedListener;
import com.google.android.gms.ads.internal.client.a;
import com.ironsource.adapters.facebook.FacebookAdapter;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FacebookRewardedVideoAdListener implements RewardedVideoAdExtendedListener {
    private WeakReference<FacebookRewardedVideoAdapter> mAdapter;
    private boolean mDidCallClosed;
    private RewardedVideoSmashListener mListener;
    private String mPlacementId;

    public FacebookRewardedVideoAdListener(FacebookRewardedVideoAdapter facebookRewardedVideoAdapter, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        this.mAdapter = new WeakReference<>(facebookRewardedVideoAdapter);
        this.mPlacementId = str;
        this.mListener = rewardedVideoSmashListener;
    }

    @Override // com.facebook.ads.AdListener
    public void onAdClicked(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onAdLoaded(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookRewardedVideoAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mAdapter.get().mAdsAvailability.put(this.mPlacementId, Boolean.TRUE);
            this.mListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onError(Ad ad, AdError adError) {
        IronLog.ADAPTER_CALLBACK.verbose("placementId = " + this.mPlacementId + " error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookRewardedVideoAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mAdapter.get().mAdsAvailability.put(this.mPlacementId, Boolean.FALSE);
        IronSourceError ironSourceError = new IronSourceError(FacebookAdapter.isNoFillError(adError) ? 1058 : adError.getErrorCode(), adError.getErrorMessage());
        if (this.mAdapter.get().mPlacementIdToShowAttempts.get(this.mPlacementId).booleanValue()) {
            this.mListener.onRewardedVideoAdShowFailed(ironSourceError);
        } else {
            this.mListener.onRewardedVideoAvailabilityChanged(false);
            this.mListener.onRewardedVideoLoadFailed(ironSourceError);
        }
    }

    @Override // com.facebook.ads.AdListener
    public void onLoggingImpression(Ad ad) {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookRewardedVideoAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        this.mDidCallClosed = false;
        this.mListener.onRewardedVideoAdOpened();
        this.mListener.onRewardedVideoAdStarted();
    }

    @Override // com.facebook.ads.RewardedVideoAdExtendedListener
    public void onRewardedVideoActivityDestroyed() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookRewardedVideoAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            if (this.mDidCallClosed) {
                return;
            }
            this.mListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoClosed() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookRewardedVideoAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mDidCallClosed = true;
            this.mListener.onRewardedVideoAdClosed();
        }
    }

    @Override // com.facebook.ads.RewardedVideoAdListener
    public void onRewardedVideoCompleted() {
        a.t(new StringBuilder("placementId = "), this.mPlacementId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdEnded();
            this.mListener.onRewardedVideoAdRewarded();
        }
    }
}
