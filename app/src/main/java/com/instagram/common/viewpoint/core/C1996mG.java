package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mG, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1996mG implements EN {
    public long A00;
    public long A01;
    public C1996mG A02;
    public EM A03;

    public C1996mG(long j, int i2) {
        A02(j, i2);
    }

    public final int A00(long j) {
        return ((int) (j - this.A01)) + this.A03.A00;
    }

    public final C1996mG A01() {
        this.A03 = null;
        C1996mG c1996mG = this.A02;
        this.A02 = null;
        return c1996mG;
    }

    public final void A02(long j, int i2) {
        C3M.A08(this.A03 == null);
        this.A01 = j;
        this.A00 = ((long) i2) + j;
    }

    public final void A03(EM em, C1996mG c1996mG) {
        this.A03 = em;
        this.A02 = c1996mG;
    }

    @Override // com.instagram.common.viewpoint.core.EN
    public final EM A6m() {
        return (EM) C3M.A01(this.A03);
    }

    @Override // com.instagram.common.viewpoint.core.EN
    public final C1996mG AC3() {
        if (this.A02 == null || this.A02.A03 == null) {
            return null;
        }
        return this.A02;
    }
}
