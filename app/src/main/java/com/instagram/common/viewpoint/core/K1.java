package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class K1 extends AbstractRunnableC1164Vt {
    public final /* synthetic */ AbstractC1282aB A00;

    public K1(AbstractC1282aB abstractC1282aB) {
        this.A00 = abstractC1282aB;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.setPressed(false);
        this.A00.postOnAnimationDelayed(this.A00.A09, this.A00.A08);
    }
}
