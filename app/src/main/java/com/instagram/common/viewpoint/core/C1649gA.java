package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gA, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1649gA implements InterfaceC1031Qn {
    public final /* synthetic */ C05246g A00;

    public C1649gA(C05246g c05246g) {
        this.A00 = c05246g;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1031Qn
    public final void AGP(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        this.A00.A1l(abstractC1024Qg, qj, qj2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1031Qn
    public final void AGR(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        this.A00.A0r.A0Y(abstractC1024Qg);
        this.A00.A1m(abstractC1024Qg, qj, qj2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1031Qn
    public final void AGT(AbstractC1024Qg abstractC1024Qg, QJ qj, QJ qj2) {
        abstractC1024Qg.A0d(false);
        if (this.A00.A0C) {
            if (this.A00.A05.A0R(abstractC1024Qg, abstractC1024Qg, qj, qj2)) {
                this.A00.A1O();
            }
        } else {
            if (!this.A00.A05.A0Q(abstractC1024Qg, qj, qj2)) {
                return;
            }
            this.A00.A1O();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1031Qn
    public final void AJo(AbstractC1024Qg abstractC1024Qg) {
        this.A00.A06.A1F(abstractC1024Qg.A0H, this.A00.A0r);
    }
}
