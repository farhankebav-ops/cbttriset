package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class VL extends AbstractRunnableC1164Vt {
    public final /* synthetic */ VJ A00;

    public VL(VJ vj) {
        this.A00 = vj;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() throws Exception {
        VJ.A00(this.A00);
        if (this.A00.A01 > 0) {
            try {
                Thread.sleep(this.A00.A01);
            } catch (InterruptedException unused) {
            }
        }
        this.A00.A0B();
    }
}
