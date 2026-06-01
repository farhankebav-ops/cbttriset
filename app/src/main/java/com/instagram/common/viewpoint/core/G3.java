package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G3 implements InterfaceC1206Xl {
    public final /* synthetic */ G2 A00;

    public G3(G2 g22) {
        this.A00 = g22;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1206Xl
    public final void ACC(AbstractC1207Xm abstractC1207Xm) {
        if (abstractC1207Xm.getToolbarActionMode() == 8) {
            this.A00.A0e();
            return;
        }
        this.A00.A06.A04(UZ.A07, null);
        if (this.A00.A0i()) {
            return;
        }
        this.A00.A09.A4b(this.A00.A0A.A7o());
    }
}
