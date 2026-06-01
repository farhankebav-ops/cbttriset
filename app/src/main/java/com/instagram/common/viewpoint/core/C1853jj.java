package com.instagram.common.viewpoint.core;

import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1853jj implements KW {
    public C2154or A00;
    public C4R A01;
    public H1 A02;

    public C1853jj(String str) {
        this.A00 = new C2D().A11(str).A14();
    }

    @EnsuresNonNull({"timestampAdjuster", "output"})
    private void A00() {
        C3M.A02(this.A01);
    }

    @Override // com.instagram.common.viewpoint.core.KW
    public final void A52(C4J c4j) {
        A00();
        long jA03 = this.A01.A03();
        long jA04 = this.A01.A04();
        if (jA03 == -9223372036854775807L || jA04 == -9223372036854775807L) {
            return;
        }
        if (jA04 != this.A00.A0M) {
            this.A00 = this.A00.A07().A0s(jA04).A14();
            this.A02.A6W(this.A00);
        }
        int iA07 = c4j.A07();
        this.A02.AI7(c4j, iA07);
        this.A02.AIA(jA03, 1, iA07, 0, null);
    }

    @Override // com.instagram.common.viewpoint.core.KW
    public final void AA2(C4R c4r, GY gy, C0869Ke c0869Ke) {
        this.A01 = c4r;
        c0869Ke.A05();
        this.A02 = gy.AJh(c0869Ke.A03(), 5);
        this.A02.A6W(this.A00);
    }
}
