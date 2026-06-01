package com.ironsource;

import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.w5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2617w5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC2495p1 f10478a;

    public C2617w5(InterfaceC2495p1 analytics, String adRequestAdId, InterfaceC2676zd adRequestProviderName) {
        kotlin.jvm.internal.k.e(analytics, "analytics");
        kotlin.jvm.internal.k.e(adRequestAdId, "adRequestAdId");
        kotlin.jvm.internal.k.e(adRequestProviderName, "adRequestProviderName");
        this.f10478a = analytics;
        analytics.a(new C2422l1.s(adRequestProviderName.value()), new C2422l1.b(adRequestAdId));
    }

    public final void a() {
        InterfaceC2369i1.c.f8699a.a().a(this.f10478a);
    }

    public final void a(IronSourceError error) {
        kotlin.jvm.internal.k.e(error, "error");
        InterfaceC2369i1.c.f8699a.a(new C2422l1.j(error.getErrorCode()), new C2422l1.k(error.getErrorMessage()), new C2422l1.f(0L)).a(this.f10478a);
    }
}
