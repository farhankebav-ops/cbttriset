package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;

/* JADX INFO: renamed from: com.ironsource.y9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2655y9 implements T<InterstitialAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Tf f10559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterstitialAdLoaderListener f10560b;

    public C2655y9(Tf threadManager, InterstitialAdLoaderListener publisherListener) {
        kotlin.jvm.internal.k.e(threadManager, "threadManager");
        kotlin.jvm.internal.k.e(publisherListener, "publisherListener");
        this.f10559a = threadManager;
        this.f10560b = publisherListener;
    }

    @Override // com.ironsource.T
    public void a(InterstitialAd adObject) {
        kotlin.jvm.internal.k.e(adObject, "adObject");
        this.f10559a.a(new ti(29, adObject, this));
    }

    @Override // com.ironsource.T
    public void b(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        this.f10559a.a(new bj(0, error, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterstitialAd adObject, C2655y9 this$0) {
        kotlin.jvm.internal.k.e(adObject, "$adObject");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("InterstitialAdLoaderListener.onInterstitialAdLoaded adInfo: " + adObject.getAdInfo());
        this$0.f10560b.onInterstitialAdLoaded(adObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(IronSourceError error, C2655y9 this$0) {
        kotlin.jvm.internal.k.e(error, "$error");
        kotlin.jvm.internal.k.e(this$0, "this$0");
        IronLog.CALLBACK.info("InterstitialAdLoaderListener.onInterstitialAdLoadFailed error: " + error);
        this$0.f10560b.onInterstitialAdLoadFailed(error);
    }
}
