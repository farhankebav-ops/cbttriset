package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1727hU implements S7 {
    public final boolean A00;

    public abstract void A00();

    public abstract void A01(boolean z2);

    public AbstractC1727hU(boolean z2) {
        this.A00 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACh() {
        if (this.A00) {
            A00();
        } else {
            A01(false);
        }
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACq() {
        A01(true);
    }
}
