package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1772iM implements S7 {
    public final /* synthetic */ C7B A00;

    public C1772iM(C7B c7b) {
        this.A00 = c7b;
    }

    private void A00(boolean z2) {
        if (!z2) {
            this.A00.A01.AF7(this.A00, AdError.CACHE_ERROR);
        } else {
            this.A00.A0C.set(true);
            this.A00.A01.AF4(this.A00);
        }
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACh() {
        A00(false);
    }

    @Override // com.instagram.common.viewpoint.core.S7
    public final void ACq() {
        A00(true);
    }
}
