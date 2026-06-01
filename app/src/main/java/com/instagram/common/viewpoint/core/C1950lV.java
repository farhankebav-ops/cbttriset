package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1950lV implements InterfaceC0784Gw {
    public final long A00;
    public final long A01;
    public final long A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final GL A06;

    public C1950lV(GL gl, long j, long j3, long j8, long j9, long j10, long j11) {
        this.A06 = gl;
        this.A03 = j;
        this.A05 = j3;
        this.A02 = j8;
        this.A04 = j9;
        this.A01 = j10;
        this.A00 = j11;
    }

    public final long A05(long j) {
        return this.A06.AJf(j);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final long A7l() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final C0783Gv A8t(long j) {
        return new C0783Gv(new C0785Gx(j, GK.A05(this.A06.AJf(j), this.A05, this.A02, this.A04, this.A01, this.A00)));
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC0784Gw
    public final boolean AAa() {
        return true;
    }
}
