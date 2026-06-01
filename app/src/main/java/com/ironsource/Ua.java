package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ua implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sa f7674a;

    public Ua(Sa strategy) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f7674a = strategy;
    }

    @Override // com.ironsource.Xa
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7674a.a("Received load success on a destroyed ad");
    }

    @Override // com.ironsource.Xa
    public void b() {
        this.f7674a.a("Loading a destroyed ad");
    }

    @Override // com.ironsource.Xa
    public void c() {
        this.f7674a.a("Destroying a destroyed ad");
    }

    @Override // com.ironsource.Xa
    public void a(IronSourceError ironSourceError) {
        this.f7674a.a("Received load failed on a destroyed ad");
    }
}
