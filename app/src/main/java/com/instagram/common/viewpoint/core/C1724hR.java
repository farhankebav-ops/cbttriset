package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hR, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1724hR extends AbstractRunnableC1164Vt {
    public final /* synthetic */ AbstractC1723hQ A00;
    public final /* synthetic */ V1 A01;

    public C1724hR(AbstractC1723hQ abstractC1723hQ, V1 v12) {
        this.A00 = abstractC1723hQ;
        this.A01 = v12;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.A0B.A0F().A5Y(this.A01.A03().getErrorCode(), this.A01.A04());
        if (this.A00.A07 != null) {
            this.A00.A07.A0G(this.A01);
        }
    }
}
