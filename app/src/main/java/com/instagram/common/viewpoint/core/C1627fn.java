package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1627fn extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C1626fm A00;
    public final /* synthetic */ C5G A01;

    public C1627fn(C1626fm c1626fm, C5G c5g) {
        this.A00 = c1626fm;
        this.A01 = c5g;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A01.setAdViewabilityChecker(this.A00.A02.A1B());
        this.A00.A02.A1f(true, true);
    }
}
