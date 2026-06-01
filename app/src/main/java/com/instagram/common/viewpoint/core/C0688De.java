package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.De, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0688De extends AbstractC0966Nz {
    public final /* synthetic */ C0686Dc A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0688De(C0686Dc c0686Dc, double d8, double d9, double d10, boolean z2) {
        super(d8, d9, d10, z2);
        this.A00 = c0686Dc;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractC0966Nz
    public final void A00(boolean z2, boolean z7, O1 o12) {
        if ((!U7.A0z(this.A00.A0D) || !this.A00.A09) && z7) {
            this.A00.A09 = true;
            this.A00.A0R(this.A00.A0J, this.A00.A0J(EnumC1484dS.A03));
        }
    }
}
