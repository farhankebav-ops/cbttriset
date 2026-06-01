package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Ta implements Xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Sa f7629a;

    public Ta(Sa strategy) {
        kotlin.jvm.internal.k.e(strategy, "strategy");
        this.f7629a = strategy;
    }

    @Override // com.ironsource.Xa
    public void a(C2544s0 adUnitCallback) {
        kotlin.jvm.internal.k.e(adUnitCallback, "adUnitCallback");
        this.f7629a.a("Received load success before load called");
    }

    @Override // com.ironsource.Xa
    public void b() {
        M2 m2A = this.f7629a.i().a(true);
        this.f7629a.a(m2A);
        Sa sa = this.f7629a;
        sa.a(new Wa(sa, m2A));
        m2A.a(this.f7629a.g());
    }

    @Override // com.ironsource.Xa
    public void c() {
        M2 m2K = this.f7629a.k();
        if (m2K != null) {
            m2K.a(false);
        }
        this.f7629a.a((M2) null);
        Sa sa = this.f7629a;
        sa.a(new Ua(sa));
    }

    @Override // com.ironsource.Xa
    public void a(IronSourceError ironSourceError) {
        this.f7629a.a("Received load failed before load called");
    }
}
