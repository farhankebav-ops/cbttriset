package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hL, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1718hL implements InterfaceC0921Me {
    public C1020Qc A00;

    public final void A00(C1020Qc c1020Qc) {
        this.A00 = c1020Qc;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0921Me
    public final void AEG(C1773iN c1773iN) {
        if (this.A00 != null && this.A00.A16() != null) {
            this.A00.A16().ACD();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0921Me
    public final void AEI(C1773iN c1773iN) {
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0921Me
    public final void AEK(C1773iN c1773iN, V1 v12) {
    }
}
