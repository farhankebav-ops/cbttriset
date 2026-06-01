package com.ironsource;

import com.ironsource.C2422l1;
import com.ironsource.InterfaceC2369i1;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: renamed from: com.ironsource.y5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2651y5 implements Cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IronSourceError f10545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2317f3 f10546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InterfaceC2495p1 f10547c;

    public C2651y5(IronSourceError error, C2317f3 adLoadTaskListener, InterfaceC2495p1 analytics) {
        kotlin.jvm.internal.k.e(error, "error");
        kotlin.jvm.internal.k.e(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.k.e(analytics, "analytics");
        this.f10545a = error;
        this.f10546b = adLoadTaskListener;
        this.f10547c = analytics;
    }

    public final IronSourceError a() {
        return this.f10545a;
    }

    @Override // com.ironsource.Cb
    public void start() {
        InterfaceC2369i1.c.a aVar = InterfaceC2369i1.c.f8699a;
        aVar.a().a(this.f10547c);
        aVar.a(new C2422l1.j(this.f10545a.getErrorCode()), new C2422l1.k(this.f10545a.getErrorMessage()), new C2422l1.f(0L)).a(this.f10547c);
        this.f10546b.b(this.f10545a);
    }
}
