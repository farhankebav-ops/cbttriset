package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iH, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1767iH implements NP {
    public final /* synthetic */ C7B A00;

    public C1767iH(C7B c7b) {
        this.A00 = c7b;
    }

    @Override // com.instagram.common.viewpoint.core.NP
    public final void AEZ(AdError adError) {
        this.A00.A01.AF7(this.A00, adError);
    }

    @Override // com.instagram.common.viewpoint.core.NP
    public final void AEa() {
        this.A00.A0C.set(true);
        this.A00.A01.AF4(this.A00);
    }
}
