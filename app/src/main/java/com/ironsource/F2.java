package com.ironsource;

import com.unity3d.ironsourceads.banner.BannerAdView;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class F2 implements E2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2495p1 f6745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f6746b;

    public F2(InterfaceC2495p1 analytics, Executor callbackExecutor) {
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(callbackExecutor, "callbackExecutor");
        this.f6745a = analytics;
        this.f6746b = callbackExecutor;
    }

    @Override // com.ironsource.E2
    public BannerAdView a(M9 adInstance, C2411k8 adContainer, W1 auctionDataReporter) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(adContainer, "adContainer");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        return new BannerAdView(new Q2(adInstance, adContainer, auctionDataReporter, this.f6745a, null, null, null, null, 240, null));
    }
}
