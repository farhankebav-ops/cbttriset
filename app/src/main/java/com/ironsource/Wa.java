package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Wa implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sa f7777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7778b;

    public Wa(Sa strategy, M2 adUnit) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(adUnit, "adUnit");
        this.f7777a = strategy;
        this.f7778b = adUnit;
    }

    @Override // com.ironsource.Xa
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7777a.a(adUnitCallback, this.f7778b);
        Sa sa = this.f7777a;
        sa.a(new Va(sa, this.f7778b));
    }

    @Override // com.ironsource.Xa
    public void b() {
        this.f7777a.a("Loading an ad while loading");
    }

    @Override // com.ironsource.Xa
    public void c() {
        this.f7778b.a(true);
        this.f7777a.a((M2) null);
        Sa sa = this.f7777a;
        sa.a(new Ua(sa));
    }

    @Override // com.ironsource.Xa
    public void a(IronSourceError ironSourceError) {
        this.f7777a.a(ironSourceError);
        this.f7778b.a(false);
        this.f7777a.a((M2) null);
        Sa sa = this.f7777a;
        sa.a(new Ua(sa));
    }
}
