package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EF extends AbstractRunnableC1164Vt {
    public final /* synthetic */ E1 A00;

    public EF(E1 e12) {
        this.A00 = e12;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.A04) {
            C1099Te c1099Te = this.A00.A0C;
            final int currentPositionInMillis = this.A00.getCurrentPositionInMillis();
            c1099Te.A02(new DY(currentPositionInMillis) { // from class: com.facebook.ads.redexgen.X.3Q
            });
            this.A00.A08.postDelayed(this, this.A00.A01);
        }
    }
}
