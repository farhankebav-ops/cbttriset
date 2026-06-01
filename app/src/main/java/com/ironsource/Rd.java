package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAd;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Rd implements T<RewardedAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tf f7566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RewardedAdLoaderListener f7567b;

    public Rd(Tf threadManager, RewardedAdLoaderListener publisherListener) {
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        this.f7566a = threadManager;
        this.f7567b = publisherListener;
    }

    @Override // com.ironsource.T
    public void a(RewardedAd adObject) {
        kotlin.jvm.internal.k.e(adObject, "adObject");
        this.f7566a.a(new ti(11, adObject, this));
    }

    @Override // com.ironsource.T
    public void b(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        IronLog.CALLBACK.info("RewardedAdLoaderListener.onRewardedAdLoadFailed error: " + error);
        this.f7566a.a(new ti(10, this, error));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(RewardedAd adObject, Rd this$0) {
        kotlin.jvm.internal.k.e(adObject, "$adObject");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("RewardedAdLoaderListener.onRewardedAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.f7567b.onRewardedAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(Rd this$0, IronSourceError error) {
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(error, "$error");
        this$0.f7567b.onRewardedAdLoadFailed(error);
    }
}
