package com.instagram.common.viewpoint.core;

import androidx.work.WorkRequest;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kW, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1902kW implements InterfaceC0784Gw {
    public final /* synthetic */ C1901kV A00;

    public C1902kW(C1901kV c1901kV) {
        this.A00 = c1901kV;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A00.A0B.A05(this.A00.A07);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        long jA06 = this.A00.A0B.A06(j);
        long j3 = this.A00.A09;
        long j8 = this.A00.A08;
        long targetGranule = this.A00.A09;
        long j9 = (j8 - targetGranule) * jA06;
        long targetGranule2 = this.A00.A07;
        long estimatedPosition = AbstractC04664a.A0T((j3 + (j9 / targetGranule2)) - WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, this.A00.A09, this.A00.A08 - 1);
        return new C0783Gv(new C0785Gx(j, estimatedPosition));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
