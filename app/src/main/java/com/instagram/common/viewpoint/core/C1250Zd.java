package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Zd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1250Zd implements InterfaceC1089Su {
    public final SQ A00;

    public C1250Zd(SQ sq) {
        this.A00 = sq;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void A4A(Throwable th) {
        C1084Sp.A0E(th);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void A9v(String str) {
        C1123Ud.A08(this.A00, str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void A9w(String str) {
        C1123Ud.A09(this.A00, str);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void AAy(String str, int i2, C1091Sw c1091Sw) {
        C1084Sp.A06(this.A00, str, i2, c1091Sw);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void AAz(String str, int i2, C1091Sw c1091Sw) {
        C1084Sp.A06(this.A00, str, i2, c1091Sw);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void ABI(long j, long j3, long j8, long j9, int i2, Exception exc) {
        T0.A03(this.A00, j, j3, j8, j9, i2, exc);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void ABR(String str, int i2, C1091Sw c1091Sw) {
        C1084Sp.A07(this.A00, str, i2, c1091Sw);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void ABZ(String str, int i2, C1091Sw c1091Sw) {
        C1084Sp.A08(this.A00, str, i2, c1091Sw);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1089Su
    public final void ABq() {
        this.A00.A04().ABq();
    }
}
