package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class EB extends AbstractRunnableC1164Vt {
    public final /* synthetic */ int A00;
    public final /* synthetic */ int A01;
    public final /* synthetic */ E1 A02;

    public EB(E1 e12, int i2, int i8) {
        this.A02 = e12;
        this.A00 = i2;
        this.A01 = i8;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A02.A0C.A02(new DL(this.A00, this.A01));
    }
}
