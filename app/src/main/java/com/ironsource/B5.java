package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class B5 implements Cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RewardedAdRequest f6371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Rd f6372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2495p1 f6373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final IronSourceError f6374d;

    public B5(RewardedAdRequest adRequest, Rd adLoadTaskListener, InterfaceC2495p1 analytics, IronSourceError error) {
        kotlin.jvm.internal.k.e(adRequest, "adRequest");
        kotlin.jvm.internal.k.e(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(error, "error");
        this.f6371a = adRequest;
        this.f6372b = adLoadTaskListener;
        this.f6373c = analytics;
        this.f6374d = error;
    }

    public final IronSourceError a() {
        return this.f6374d;
    }

    @Override // com.ironsource.Cb
    public void start() {
        C2617w5 c2617w5 = new C2617w5(this.f6373c, this.f6371a.getAdId$mediationsdk_release(), this.f6371a.getProviderName$mediationsdk_release());
        c2617w5.a();
        c2617w5.a(this.f6374d);
        this.f6372b.b(this.f6374d);
    }
}
