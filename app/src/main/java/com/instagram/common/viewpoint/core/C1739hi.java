package com.instagram.common.viewpoint.core;

import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1739hi implements InterfaceC1048Re {
    public final /* synthetic */ AbstractC1752hy A00;
    public final /* synthetic */ NG A01;
    public final /* synthetic */ NH A02;
    public final /* synthetic */ C1477dL A03;
    public final /* synthetic */ boolean A04;

    public C1739hi(NH nh, C1477dL c1477dL, boolean z2, AbstractC1752hy abstractC1752hy, NG ng) {
        this.A02 = nh;
        this.A03 = c1477dL;
        this.A04 = z2;
        this.A00 = abstractC1752hy;
        this.A01 = ng;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACM() {
        if (U7.A1l(this.A03) && this.A04) {
            this.A02.A02.add(AbstractC1389bu.A01(this.A03, this.A00, 1, new C1740hj(this)));
        } else {
            this.A01.ACG();
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1048Re
    public final void ACN() {
        this.A01.ACF(AdError.CACHE_ERROR);
    }
}
