package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdView;

/* JADX INFO: renamed from: com.ironsource.f3, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2317f3 implements T<BannerAdView> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tf f8518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BannerAdLoaderListener f8519b;

    public C2317f3(Tf threadManager, BannerAdLoaderListener publisherListener) {
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        this.f8518a = threadManager;
        this.f8519b = publisherListener;
    }

    @Override // com.ironsource.T
    public void a(BannerAdView adObject) {
        kotlin.jvm.internal.k.e(adObject, "adObject");
        this.f8518a.a(new ti(15, adObject, this));
    }

    @Override // com.ironsource.T
    public void b(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f8518a.a(new ti(16, error, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(BannerAdView adObject, C2317f3 this$0) {
        kotlin.jvm.internal.k.e(adObject, "$adObject");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("BannerAdLoaderListener.onBannerAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.f8519b.onBannerAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error, C2317f3 this$0) {
        kotlin.jvm.internal.k.e(error, "$error");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("BannerAdLoaderListener.onBannerAdLoadFailed error: " + error);
        this$0.f8519b.onBannerAdLoadFailed(error);
    }
}
