package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1734hb implements NP {
    public final /* synthetic */ NH A00;

    public C1734hb(NH nh) {
        this.A00 = nh;
    }

    @Override // com.instagram.common.viewpoint.core.NP
    public final void AEZ(AdError adError) {
        this.A00.A04.ACF(AdError.CACHE_ERROR);
    }

    @Override // com.instagram.common.viewpoint.core.NP
    public final void AEa() {
        this.A00.A04.ACG();
    }
}
