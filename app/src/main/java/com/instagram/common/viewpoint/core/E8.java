package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class E8 extends AbstractRunnableC1164Vt {
    public final /* synthetic */ E1 A00;

    public E8(E1 e12) {
        this.A00 = e12;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A00.getEventBus().A02(E1.A0E());
    }
}
