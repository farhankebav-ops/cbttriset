package com.ironsource.adapters.ironsource;

import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import com.ironsource.Lc;
import com.ironsource.M9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceRewardedVideoListener implements Lc {
    public final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String mDemandSourceName;
    boolean mIsRvDemandOnly;
    RewardedVideoSmashListener mListener;

    public IronSourceRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener, String str, boolean z2) {
        this.mDemandSourceName = str;
        this.mListener = rewardedVideoSmashListener;
        this.mIsRvDemandOnly = z2;
    }

    @Override // com.ironsource.Lc
    public void onInterstitialAdRewarded(String str, int i2) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        StringBuilder sb = new StringBuilder();
        a.A(sb, this.mDemandSourceName, " rewardedVideoListener demandSourceId=", str, " amount=");
        sb.append(i2);
        ironLog.verbose(sb.toString());
        this.mListener.onRewardedVideoAdRewarded();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClick() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdClicked();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialClose() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdClosed();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener eventName = " + str);
        if ("impressions".equals(str)) {
            this.mListener.onRewardedVideoAdVisible();
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitFailed(String str) {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialInitSuccess() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + " rewardedVideoListener " + str);
        this.mListener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError(str));
        if (this.mIsRvDemandOnly) {
            return;
        }
        this.mListener.onRewardedVideoAvailabilityChanged(false);
    }

    @Override // com.ironsource.Lc
    public void onInterstitialLoadSuccess(M9 m9) {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
        if (this.mIsRvDemandOnly) {
            this.mListener.onRewardedVideoLoadSuccess();
        } else {
            this.mListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    @Override // com.ironsource.Lc
    public void onInterstitialOpen() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
        this.mListener.onRewardedVideoAdOpened();
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose(this.mDemandSourceName + "rewardedVideoListener " + str);
        this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str));
    }

    @Override // com.ironsource.Lc
    public void onInterstitialShowSuccess() {
        com.google.android.gms.ads.internal.client.a.u(new StringBuilder(), this.mDemandSourceName, " rewardedVideoListener", IronLog.ADAPTER_CALLBACK);
    }
}
