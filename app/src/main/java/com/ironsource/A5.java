package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class A5 implements Cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterstitialAdRequest f6322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2655y9 f6323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2495p1 f6324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IronSourceError f6325d;

    public A5(InterstitialAdRequest adRequest, C2655y9 adLoadTaskListener, InterfaceC2495p1 analytics, IronSourceError error) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(error, "error");
        this.f6322a = adRequest;
        this.f6323b = adLoadTaskListener;
        this.f6324c = analytics;
        this.f6325d = error;
    }

    public final IronSourceError a() {
        return this.f6325d;
    }

    @Override // com.ironsource.Cb
    public void start() {
        C2617w5 c2617w5 = new C2617w5(this.f6324c, this.f6322a.getAdId$mediationsdk_release(), this.f6322a.getProviderName$mediationsdk_release());
        c2617w5.a();
        c2617w5.a(this.f6325d);
        this.f6323b.b(this.f6325d);
    }
}
