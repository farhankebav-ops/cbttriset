package com.ironsource;

import com.unity3d.ironsourceads.interstitial.InterstitialAd;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.ironsource.s9, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2553s9 implements InterfaceC2260c0<InterstitialAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2495p1 f9821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f9822b;

    public C2553s9(InterfaceC2495p1 analytics, Executor callbackExecutor) {
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(callbackExecutor, "callbackExecutor");
        this.f9821a = analytics;
        this.f9822b = callbackExecutor;
    }

    @Override // com.ironsource.InterfaceC2260c0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public InterstitialAd a(M9 adInstance, W1 auctionDataReporter) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        return new InterstitialAd(new C2587u9(adInstance, new C2242b0(new Cc()), auctionDataReporter, this.f9821a, null, null, null, null, C2570t9.f10301a, 240, null));
    }
}
