package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.g7, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1646g7 implements QI {
    public final /* synthetic */ C05246g A00;

    public C1646g7(C05246g c05246g) {
        this.A00 = c05246g;
    }

    @Override // com.instagram.common.viewpoint.core.QI
    public final void ACK(AbstractC1024Qg abstractC1024Qg) {
        abstractC1024Qg.A0d(true);
        if (abstractC1024Qg.A06 != null && abstractC1024Qg.A07 == null) {
            abstractC1024Qg.A06 = null;
        }
        abstractC1024Qg.A07 = null;
        if (!abstractC1024Qg.A0G() && !this.A00.A1x(abstractC1024Qg.A0H) && abstractC1024Qg.A0i()) {
            this.A00.removeDetachedView(abstractC1024Qg.A0H, false);
        }
    }
}
