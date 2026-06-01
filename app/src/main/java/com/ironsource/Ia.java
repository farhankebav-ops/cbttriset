package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ia implements Qa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Ga f6984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6985b;

    public Ia(Ga strategy, boolean z2) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f6984a = strategy;
        this.f6985b = z2;
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
        Ga ga = this.f6984a;
        ga.a((Qa) new Ja(ga));
    }

    @Override // com.ironsource.Qa
    public void d() {
        this.f6985b = true;
    }

    @Override // com.ironsource.Qa
    public void e() {
        this.f6985b = false;
    }

    @Override // com.ironsource.L0
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f6984a.a("Received load success before load");
    }

    @Override // com.ironsource.Qa
    public void b() {
        M2 m2A = this.f6984a.j().a(true);
        m2A.a(this.f6984a.g());
        this.f6984a.a((Qa) new La(this.f6984a, m2A, this.f6985b));
    }

    @Override // com.ironsource.L0
    public void a(IronSourceError ironSourceError) {
        this.f6984a.a("Received load failed before load");
    }

    public /* synthetic */ Ia(Ga ga, boolean z2, int i2, kotlin.jvm.internal.f fVar) {
        this(ga, (i2 & 2) != 0 ? false : z2);
    }
}
