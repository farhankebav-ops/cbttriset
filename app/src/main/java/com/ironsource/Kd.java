package com.ironsource;

import com.unity3d.ironsourceads.rewarded.RewardedAd;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Kd implements InterfaceC2260c0<RewardedAd> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2495p1 f7062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f7063b;

    public Kd(InterfaceC2495p1 analytics, Executor callbackExecutor) {
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(callbackExecutor, "callbackExecutor");
        this.f7062a = analytics;
        this.f7063b = callbackExecutor;
    }

    @Override // com.ironsource.InterfaceC2260c0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public RewardedAd a(M9 adInstance, W1 auctionDataReporter) {
        kotlin.jvm.internal.k.e(adInstance, "adInstance");
        kotlin.jvm.internal.k.e(auctionDataReporter, "auctionDataReporter");
        return new RewardedAd(new Nd(adInstance, new C2242b0(new Cc()), auctionDataReporter, this.f7062a, null, null, null, null, Ld.f7093a, 240, null));
    }
}
