package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class FI implements InterfaceC1368bZ {
    public final /* synthetic */ FH A00;

    public FI(FH fh) {
        this.A00 = fh;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1368bZ
    public final void AFm(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1368bZ
    public final void AFo(View view) {
        AbstractC0830Ir abstractC0830Ir = (AbstractC0830Ir) view;
        abstractC0830Ir.A1R();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC0830Ir.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
