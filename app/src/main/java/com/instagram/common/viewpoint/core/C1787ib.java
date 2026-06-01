package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ib, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1787ib extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C1785iZ A00;
    public final /* synthetic */ C5G A01;

    public C1787ib(C1785iZ c1785iZ, C5G c5g) {
        this.A00 = c1785iZ;
        this.A01 = c5g;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.A00.A0A();
        if (this.A00.A00.A0C != null) {
            this.A01.setAdViewabilityChecker(this.A00.A00.A0C);
            this.A00.A00.A0C.A0U();
        }
    }
}
