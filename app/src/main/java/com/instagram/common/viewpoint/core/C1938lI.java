package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lI, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1938lI implements InterfaceC0784Gw {
    public final long A00;
    public final C0783Gv A01;

    public C1938lI(long j) {
        this(j, 0L);
    }

    public C1938lI(long j, long j3) {
        this.A00 = j;
        this.A01 = new C0783Gv(j3 == 0 ? C0785Gx.A04 : new C0785Gx(0L, j3));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A00;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        return this.A01;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return false;
    }
}
