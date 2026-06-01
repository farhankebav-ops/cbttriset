package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class J6 extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C0831Is A00;
    public final /* synthetic */ boolean A01;

    public J6(C0831Is c0831Is, boolean z2) {
        this.A00 = c0831Is;
        this.A01 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        AbstractC1207Xm abstractC1207XmA0C = this.A00.A0c.A0C();
        if (abstractC1207XmA0C == null) {
            return;
        }
        abstractC1207XmA0C.setPageDetailsVisible((this.A01 || abstractC1207XmA0C.A0B()) ? false : true);
        abstractC1207XmA0C.setToolbarActionMode(this.A00.getCloseButtonStyle());
    }
}
