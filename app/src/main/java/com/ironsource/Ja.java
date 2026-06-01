package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ja implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f7015a;

    public Ja(Ga strategy) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f7015a = strategy;
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void a() {
        mh.a(this);
    }

    @Override // com.ironsource.L0
    public final /* synthetic */ void b(C2544s0 c2544s0) {
        mh.b(this, c2544s0);
    }

    @Override // com.ironsource.Qa
    public void c() {
        this.f7015a.a("Destroying a destroyed ad");
    }

    @Override // com.ironsource.Qa
    public void d() {
        this.f7015a.a("Pausing auto refresh on a destroyed ad");
    }

    @Override // com.ironsource.Qa
    public void e() {
        this.f7015a.a("Resuming auto refresh on a destroyed ad");
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7015a.a("Received load success on a destroyed ad");
    }

    @Override // com.ironsource.Qa
    public void b() {
        this.f7015a.a("Loading a destroyed ad");
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f7015a.a("Received load failed on a destroyed ad");
    }
}
