package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ft, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0755Ft extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C4H A00;

    public C0755Ft(C4H c4h) {
        this.A00 = c4h;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (this.A00.A00 != null && this.A00.A00.A1L()) {
            ((G2) this.A00).A01 = true;
            this.A00.A08.setToolbarActionMode(8);
        }
    }
}
