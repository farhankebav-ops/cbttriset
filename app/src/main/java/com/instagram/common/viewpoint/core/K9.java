package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K9 extends AbstractRunnableC1164Vt {
    public final /* synthetic */ AbstractC1282aB A00;

    public K9(AbstractC1282aB abstractC1282aB) {
        this.A00 = abstractC1282aB;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        if (!this.A00.isPressed()) {
            this.A00.setPressed(true);
            this.A00.postOnAnimationDelayed(this.A00.A0A, 250L);
        } else {
            this.A00.postDelayed(this, this.A00.A08);
        }
    }
}
