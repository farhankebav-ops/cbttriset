package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1631fr extends AbstractRunnableC1151Vg {
    public final /* synthetic */ C1630fq A00;

    public C1631fr(C1630fq c1630fq) {
        this.A00 = c1630fq;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1151Vg
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            this.A00.A01.A06().onLoggingImpression(this.A00.A01.A07());
        }
    }
}
