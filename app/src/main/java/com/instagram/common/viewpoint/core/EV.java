package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EV implements InterfaceC1575ew {
    public final /* synthetic */ C1474dI A00;

    public EV(C1474dI c1474dI) {
        this.A00 = c1474dI;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1575ew
    public final void AGQ() {
        if (this.A00.A02 != null) {
            this.A00.A02.A4b(this.A00.A03.A8w());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1575ew
    public final void AGS(C1577ey c1577ey) {
        if (this.A00.A02 == null) {
            return;
        }
        if (c1577ey != null && c1577ey.A00()) {
            this.A00.A02.A4b(this.A00.A03.A8x());
        } else {
            this.A00.A02.A4b(this.A00.A03.A8w());
        }
    }
}
