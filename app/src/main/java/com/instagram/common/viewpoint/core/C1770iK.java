package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1770iK implements InterfaceC1048Re {
    public final /* synthetic */ C7B A00;
    public final /* synthetic */ boolean A01;

    public C1770iK(C7B c7b, boolean z2) {
        this.A00 = c7b;
        this.A01 = z2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACM() {
        if (!U7.A1o(this.A00.A04) || !this.A01) {
            this.A00.A0C.set(true);
            this.A00.A01.AF4(this.A00);
        } else {
            this.A00.A06 = AbstractC1389bu.A01(this.A00.A04, (AnonymousClass73) this.A00.A03, 0, new C1771iL(this));
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACN() {
        this.A00.A01.AF7(this.A00, AdError.CACHE_ERROR);
    }
}
