package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FN implements InterfaceC1435ce {
    public final /* synthetic */ C04573r A00;

    public FN(C04573r c04573r) {
        this.A00 = c04573r;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1435ce
    public final void A9d() {
        if (this.A00.A03 instanceof C04955d) {
            ((C04955d) this.A00.A03).A1W();
            C1120Ua.A02(UZ.A0e, null, ((G2) this.A00).A02.A25(), ((G2) this.A00).A04.A0A());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1435ce
    public final void AJF() {
        if (this.A00.A03 instanceof C04955d) {
            ((C04955d) this.A00.A03).A1a(this.A00.A0M);
            C1120Ua.A02(UZ.A0e, null, ((G2) this.A00).A02.A25(), ((G2) this.A00).A04.A0A());
        }
        this.A00.A0k();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1435ce
    public final void AJT() {
        this.A00.A0c();
        if (this.A00.A03 instanceof C04955d) {
            ((C04955d) this.A00.A03).getAdDetailsView().setVisibility(8);
        }
    }
}
