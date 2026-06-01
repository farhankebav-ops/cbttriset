package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1351bI extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C1451cu A00;

    public C1351bI(C1451cu c1451cu) {
        this.A00 = c1451cu;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        for (C1085Sq c1085Sq : C1084Sp.A02()) {
            C1084Sp.A0A(this.A00, c1085Sq.A02(), c1085Sq.A00(), c1085Sq.A01(), false);
        }
        C1084Sp.A02().clear();
    }
}
