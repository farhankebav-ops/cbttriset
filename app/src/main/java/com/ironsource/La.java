package com.ironsource;

import com.ironsource.AbstractC2406k3;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class La implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f7090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final M2 f7091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7092c;

    public La(Ga strategy, M2 currentAdUnit, boolean z2) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        kotlin.jvm.internal.k.e(currentAdUnit, "currentAdUnit");
        this.f7090a = strategy;
        this.f7091b = currentAdUnit;
        this.f7092c = z2;
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
        this.f7091b.a(true);
        Ga ga = this.f7090a;
        ga.a((Qa) new Ja(ga));
    }

    @Override // com.ironsource.Qa
    public void d() {
        this.f7092c = true;
    }

    @Override // com.ironsource.Qa
    public void e() {
        this.f7092c = false;
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7090a.a(adUnitCallback, this.f7091b, (M2) null, new AbstractC2406k3.a(AbstractC2406k3.b.C0186b.f8819a), this.f7092c, (Long) null);
    }

    @Override // com.ironsource.Qa
    public void b() {
        this.f7090a.a("Loading an ad while loading");
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f7090a.a(ironSourceError, this.f7091b, (AbstractC2406k3) new AbstractC2406k3.a(AbstractC2406k3.b.a.f8818a), false, this.f7092c, (Long) null);
    }
}
