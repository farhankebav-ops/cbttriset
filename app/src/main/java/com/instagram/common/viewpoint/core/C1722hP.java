package com.instagram.common.viewpoint.core;

import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hP, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1722hP extends AbstractRunnableC1164Vt {
    public final /* synthetic */ C1778iS A00;
    public final /* synthetic */ NU A01;
    public final /* synthetic */ C05426y A02;

    public C1722hP(C05426y c05426y, NU nu, C1778iS c1778iS) {
        this.A02 = c05426y;
        this.A01 = nu;
        this.A00 = c1778iS;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A02.A0T(this.A01);
        this.A02.A0Q(this.A00);
        this.A02.A00 = null;
        V1 v1A00 = V1.A00(AdErrorType.INTERSTITIAL_AD_TIMEOUT);
        this.A02.A0B.A0F().A5Y(v1A00.A03().getErrorCode(), v1A00.A04());
        this.A02.A07.A0G(v1A00);
    }
}
