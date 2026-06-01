package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Va implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sa f7740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7741b;

    public Va(Sa strategy, M2 adUnit) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f7740a = strategy;
        this.f7741b = adUnit;
    }

    @Override // com.ironsource.Xa
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7740a.a("Ad unit is already loaded");
    }

    @Override // com.ironsource.Xa
    public void b() {
        this.f7740a.a("Loading a loaded ad");
    }

    @Override // com.ironsource.Xa
    public void c() {
        this.f7741b.a(true);
        this.f7740a.a((M2) null);
        Sa sa = this.f7740a;
        sa.a(new Ua(sa));
    }

    @Override // com.ironsource.Xa
    public void a(IronSourceError ironSourceError) {
        this.f7740a.a("Ad unit is already loaded");
    }
}
