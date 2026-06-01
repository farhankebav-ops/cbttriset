package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class JZ extends AbstractRunnableC1164Vt {
    public final /* synthetic */ JU A00;

    public JZ(JU ju) {
        this.A00 = ju;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.A0e) {
            XP.A0D(1000, this.A00.A0O);
        }
        this.A00.postDelayed(this, 2000L);
    }
}
