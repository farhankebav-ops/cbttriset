package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1768iI implements InterfaceC1048Re {
    public final /* synthetic */ C7B A00;

    public C1768iI(C7B c7b) {
        this.A00 = c7b;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACM() {
        this.A00.A0C.set(true);
        this.A00.A01.AF4(this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACN() {
        this.A00.A01.AF7(this.A00, AdError.CACHE_ERROR);
    }
}
