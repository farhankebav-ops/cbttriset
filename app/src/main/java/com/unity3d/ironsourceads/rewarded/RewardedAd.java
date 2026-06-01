package com.unity3d.ironsourceads.rewarded;

import android.app.Activity;
import com.ironsource.Nd;
import com.ironsource.Od;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class RewardedAd implements Od {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Nd f10894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RewardedAdListener f10895b;

    public RewardedAd(Nd rewardedAdInternal) {
        k.e(rewardedAdInternal, "rewardedAdInternal");
        this.f10894a = rewardedAdInternal;
        rewardedAdInternal.a(this);
    }

    public final RewardedAdInfo getAdInfo() {
        return this.f10894a.b();
    }

    public final RewardedAdListener getListener() {
        return this.f10895b;
    }

    public final boolean isReadyToShow() {
        IronLog.API.info();
        return this.f10894a.d();
    }

    @Override // com.ironsource.Od
    public void onAdInstanceDidBecomeVisible() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdShown adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.Od
    public void onRewardedAdClicked() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdClicked adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdClicked(this);
        }
    }

    @Override // com.ironsource.Od
    public void onRewardedAdDismissed() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdDismissed adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdDismissed(this);
        }
    }

    @Override // com.ironsource.Od
    public void onRewardedAdFailedToShow(IronSourceError error) {
        k.e(error, "error");
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdFailedToShow error: " + error + " adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdFailedToShow(this, error);
        }
    }

    @Override // com.ironsource.Od
    public void onRewardedAdShown() {
        IronLog.CALLBACK.info("RewardedAdListener onRewardedAdShown adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onRewardedAdShown(this);
        }
    }

    @Override // com.ironsource.Od
    public void onUserEarnedReward() {
        IronLog.CALLBACK.info("RewardedAdListener onUserEarnedReward adInfo: " + getAdInfo());
        RewardedAdListener rewardedAdListener = this.f10895b;
        if (rewardedAdListener != null) {
            rewardedAdListener.onUserEarnedReward(this);
        }
    }

    public final void setListener(RewardedAdListener rewardedAdListener) {
        this.f10895b = rewardedAdListener;
    }

    public final void show(Activity activity) {
        k.e(activity, "activity");
        IronLog.API.info();
        this.f10894a.a(activity);
    }
}
