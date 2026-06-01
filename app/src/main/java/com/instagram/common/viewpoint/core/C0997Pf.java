package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0997Pf extends AbstractRunnableC1164Vt {
    public final /* synthetic */ long A00;
    public final /* synthetic */ VR A01;
    public final /* synthetic */ VU A02;
    public final /* synthetic */ String A03;

    public C0997Pf(VU vu, String str, long j, VR vr) {
        this.A02 = vu;
        this.A03 = str;
        this.A00 = j;
        this.A01 = vr;
    }

    @Override // com.instagram.common.viewpoint.core.AbstractRunnableC1164Vt
    public final void A07() {
        this.A02.A0N(this.A03, this.A00, this.A01);
    }
}
