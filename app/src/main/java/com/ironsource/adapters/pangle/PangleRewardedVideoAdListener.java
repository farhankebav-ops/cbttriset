package com.ironsource.adapters.pangle;

import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class PangleRewardedVideoAdListener implements PAGRewardedAdLoadListener, PAGRewardedAdInteractionListener {
    private final WeakReference<PangleAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;
    private final String mSlotId;

    public PangleRewardedVideoAdListener(RewardedVideoSmashListener rewardedVideoSmashListener, WeakReference<PangleAdapter> weakReference, String mSlotId) {
        k.e(mSlotId, "mSlotId");
        this.mListener = rewardedVideoSmashListener;
        this.mAdapter = weakReference;
        this.mSlotId = mSlotId;
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdClicked() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdDismissed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdEnded();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdClosed();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
    public void onAdShowed() {
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoAdStarted();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.vCE
    public void onError(int i2, String message) {
        PangleAdapter pangleAdapter;
        k.e(message, "message");
        com.google.android.gms.ads.internal.client.a.t(androidx.camera.core.processing.util.a.s("Failed to load slotId = ", i2, this.mSlotId, ", error code = ", ", message = "), message, IronLog.ADAPTER_CALLBACK);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter = weakReference.get()) != null) {
            pangleAdapter.setRewardedVideoAdAvailability$pangleadapter_release(this.mSlotId, false);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        }
        if (i2 == 20001) {
            i2 = 1058;
        }
        RewardedVideoSmashListener rewardedVideoSmashListener2 = this.mListener;
        if (rewardedVideoSmashListener2 != null) {
            rewardedVideoSmashListener2.onRewardedVideoLoadFailed(new IronSourceError(i2, message));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
    public void onUserEarnedReward(PAGRewardItem rewardedAd) {
        k.e(rewardedAd, "rewardedAd");
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        String str = this.mSlotId;
        int rewardAmount = rewardedAd.getRewardAmount();
        com.google.android.gms.ads.internal.client.a.t(androidx.camera.core.processing.util.a.s("onUserEarnedReward - slotId = ", rewardAmount, str, ", reward amount = ", ", reward name = "), rewardedAd.getRewardName(), ironLog);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAdRewarded();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener
    public void onUserEarnedRewardFail(int i2, String message) {
        k.e(message, "message");
        com.google.android.gms.ads.internal.client.a.t(androidx.camera.core.processing.util.a.s("Failed to reward slotId = ", i2, this.mSlotId, ", error code = ", ", message = "), message, IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
    public void onAdLoaded(PAGRewardedAd rewardedAd) {
        PangleAdapter pangleAdapter;
        PangleAdapter pangleAdapter2;
        k.e(rewardedAd, "rewardedAd");
        com.google.android.gms.ads.internal.client.a.p("slotId = ", this.mSlotId, IronLog.ADAPTER_CALLBACK);
        WeakReference<PangleAdapter> weakReference = this.mAdapter;
        if (weakReference != null && (pangleAdapter2 = weakReference.get()) != null) {
            pangleAdapter2.setRewardedVideoAd$pangleadapter_release(this.mSlotId, rewardedAd);
        }
        WeakReference<PangleAdapter> weakReference2 = this.mAdapter;
        if (weakReference2 != null && (pangleAdapter = weakReference2.get()) != null) {
            pangleAdapter.setRewardedVideoAdAvailability$pangleadapter_release(this.mSlotId, true);
        }
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener != null) {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }
}
