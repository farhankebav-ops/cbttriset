package com.ironsource;

import com.ironsource.AbstractC2406k3;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Pa implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f7383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final M2 f7385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7386d;

    public Pa(Ga strategy, M2 currentAdUnit, M2 reloadingAdUnit, long j) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        kotlin.jvm.internal.k.e(reloadingAdUnit, "reloadingAdUnit");
        this.f7383a = strategy;
        this.f7384b = currentAdUnit;
        this.f7385c = reloadingAdUnit;
        this.f7386d = j;
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
        this.f7384b.a(true);
        this.f7385c.a(true);
        Ga ga = this.f7383a;
        ga.a((Qa) new Ja(ga));
    }

    @Override // com.ironsource.Qa
    public void d() {
        Ga ga = this.f7383a;
        ga.a((Qa) new Ma(ga, this.f7384b));
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7383a.a(adUnitCallback, this.f7385c, this.f7384b, (AbstractC2406k3) new AbstractC2406k3.c(this.f7383a.p().a() - this.f7386d, AbstractC2406k3.d.C0187d.f8826a), false, Long.valueOf(this.f7386d));
    }

    @Override // com.ironsource.Qa
    public void b() {
        this.f7383a.a("Loading an ad while reloading after timer finished");
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f7383a.a(ironSourceError, this.f7384b, (AbstractC2406k3) new AbstractC2406k3.c(this.f7383a.p().a() - this.f7386d, AbstractC2406k3.d.c.f8825a), true, false, Long.valueOf(this.f7386d));
    }

    @Override // com.ironsource.Qa
    public void e() {
    }
}
