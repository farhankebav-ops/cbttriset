package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0908Lr implements InterfaceC1288aH {
    public final /* synthetic */ C0893Lc A00;

    public C0908Lr(C0893Lc c0893Lc) {
        this.A00 = c0893Lc;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1288aH
    public final void ACI() {
        if (this.A00.A0V()) {
            this.A00.A0L();
            this.A00.A0a.setToolbarActionMessage("");
            this.A00.A0a.setToolbarActionMode(0);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1288aH
    public final void AE7() {
        this.A00.A0F = false;
        this.A00.A0O.A07();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1288aH
    public final void AE8() {
        this.A00.A0F = true;
        this.A00.A0O.A06();
    }
}
