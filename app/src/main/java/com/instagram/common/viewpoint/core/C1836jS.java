package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1836jS implements InterfaceC0784Gw {
    public final int A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final C0876Kl A04;

    public C1836jS(C0876Kl c0876Kl, int i2, long j, long j3) {
        this.A04 = c0876Kl;
        this.A00 = i2;
        this.A03 = j;
        this.A01 = (j3 - j) / ((long) c0876Kl.A02);
        this.A02 = A00(this.A01);
    }

    private long A00(long j) {
        return AbstractC04664a.A0U(j * ((long) this.A00), 1000000L, this.A04.A04);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A02;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        long jA0T = AbstractC04664a.A0T((((long) this.A04.A04) * j) / (((long) this.A00) * 1000000), 0L, this.A01 - 1);
        long j3 = this.A03 + (((long) this.A04.A02) * jA0T);
        long jA00 = A00(jA0T);
        C0785Gx c0785Gx = new C0785Gx(jA00, j3);
        if (jA00 >= j || jA0T == this.A01 - 1) {
            return new C0783Gv(c0785Gx);
        }
        long j8 = 1 + jA0T;
        return new C0783Gv(c0785Gx, new C0785Gx(A00(j8), this.A03 + (((long) this.A04.A02) * j8)));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
