package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0694Dk extends AbstractC1100Tf<DQ> {
    public final /* synthetic */ C04483i A00;

    public C0694Dk(C04483i c04483i) {
        this.A00 = c04483i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final void A03(DQ dq) {
        if (!this.A00.A02) {
            this.A00.A02 = true;
        } else {
            this.A00.A0d();
        }
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC1100Tf
    public final Class<DQ> A01() {
        return DQ.class;
    }
}
