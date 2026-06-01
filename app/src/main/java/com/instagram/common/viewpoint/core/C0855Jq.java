package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0855Jq implements InterfaceC1173Wc {
    public final /* synthetic */ C04955d A00;

    public C0855Jq(C04955d c04955d) {
        this.A00 = c04955d;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        this.A00.A0B = false;
        if (this.A00.A06 != null) {
            this.A00.A06.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        if (this.A00.A06 != null) {
            this.A00.A06.setProgressImmediate(100.0f * (1.0f - (f4 / this.A00.getAdInfo().A0K().A00())));
        }
    }
}
