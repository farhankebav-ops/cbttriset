package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class LQ implements ZZ {
    public final /* synthetic */ ZO A00;

    public LQ(ZO zo) {
        this.A00 = zo;
    }

    @Override // com.instagram.common.viewpoint.core.ZZ
    public final void ACa(boolean z2) {
        this.A00.A0D(z2);
        if (!this.A00.A0C || this.A00.A00 == null) {
            return;
        }
        this.A00.A00.setEnabled(z2);
        this.A00.A00.setAlpha(z2 ? 1.0f : 0.3f);
    }

    @Override // com.instagram.common.viewpoint.core.ZZ
    public final void ADJ(boolean z2) {
        this.A00.A0D(z2);
        if (!this.A00.A0C || this.A00.A02 == null) {
            return;
        }
        this.A00.A02.setEnabled(z2);
        this.A00.A02.setAlpha(z2 ? 1.0f : 0.3f);
    }
}
