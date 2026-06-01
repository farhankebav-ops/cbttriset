package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kU, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1900kU implements InterfaceC0835Iw {
    public long A00 = -1;
    public long A01 = -1;
    public C0768Gg A02;
    public C0769Gh A03;

    public C1900kU(C0769Gh c0769Gh, C0768Gg c0768Gg) {
        this.A03 = c0769Gh;
        this.A02 = c0768Gg;
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0835Iw
    public final InterfaceC0784Gw A5R() {
        C3M.A08(this.A00 != -1);
        return new C1940lK(this.A03, this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0835Iw
    public final long AGd(InterfaceC1943lN interfaceC1943lN) {
        if (this.A01 < 0) {
            return -1L;
        }
        long result = -(this.A01 + 2);
        this.A01 = -1L;
        return result;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0835Iw
    public final void AJR(long j) {
        long[] jArr = this.A02.A01;
        this.A01 = jArr[AbstractC04664a.A0L(jArr, j, true, true)];
    }
}
