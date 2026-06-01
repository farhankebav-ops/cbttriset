package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C05637t implements InterfaceC1916kk {
    public long A00;
    public final long A01;
    public final AnonymousClass45 A03 = new AnonymousClass45();
    public final AnonymousClass45 A02 = new AnonymousClass45();

    public C05637t(long j, long j3, long j8) {
        this.A00 = j;
        this.A01 = j8;
        this.A03.A04(0L);
        this.A02.A04(j3);
    }

    public final void A00(long j) {
        this.A00 = j;
    }

    public final void A01(long j, long j3) {
        if (A02(j)) {
            return;
        }
        this.A03.A04(j);
        this.A02.A04(j3);
    }

    public final boolean A02(long j) {
        long lastIndexedTimeUs = this.A03.A03(this.A03.A02() - 1);
        return j - lastIndexedTimeUs < 100000;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A7b() {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        int iA0C = AbstractC04664a.A0C(this.A03, j, true, true);
        C0785Gx c0785Gx = new C0785Gx(this.A03.A03(iA0C), this.A02.A03(iA0C));
        if (c0785Gx.A01 != j) {
            int targetIndex = this.A03.A02();
            if (iA0C != targetIndex - 1) {
                int targetIndex2 = iA0C + 1;
                long jA03 = this.A03.A03(targetIndex2);
                int targetIndex3 = iA0C + 1;
                C0785Gx nextSeekPoint = new C0785Gx(jA03, this.A02.A03(targetIndex3));
                return new C0783Gv(c0785Gx, nextSeekPoint);
            }
        }
        return new C0783Gv(c0785Gx);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1916kk
    public final long A99(long j) {
        return this.A03.A03(AbstractC04664a.A0C(this.A02, j, true, true));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
