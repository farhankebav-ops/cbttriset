package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ha, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1733ha implements InterfaceC1048Re {
    public final /* synthetic */ NH A00;

    public C1733ha(NH nh) {
        this.A00 = nh;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACM() {
        this.A00.A04.ACG();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACN() {
        this.A00.A04.ACF(AdError.CACHE_ERROR);
    }
}
