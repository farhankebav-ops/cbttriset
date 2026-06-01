package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.iz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1809iz implements InterfaceC04854t {
    public InterfaceC0904Ln A02;
    public long A01 = 5242880;
    public int A00 = 20480;

    public final C1809iz A00(InterfaceC0904Ln interfaceC0904Ln) {
        this.A02 = interfaceC0904Ln;
        return this;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC04854t
    public final C1808iy A59() {
        return new C1808iy((InterfaceC0904Ln) C3M.A01(this.A02), this.A01, this.A00);
    }
}
