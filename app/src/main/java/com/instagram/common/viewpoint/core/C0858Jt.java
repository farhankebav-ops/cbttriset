package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0858Jt implements InterfaceC1173Wc {
    public final /* synthetic */ C04975f A00;

    public C0858Jt(C04975f c04975f) {
        this.A00 = c04975f;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        this.A00.A02 = false;
        if (this.A00.A07 != null) {
            this.A00.A07.setToolbarActionMode(this.A00.getCloseButtonStyle());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        if (this.A00.A07 != null) {
            this.A00.A07.setProgressImmediate(100.0f * (1.0f - (f4 / this.A00.getAdInfo().A0K().A00())));
        }
    }
}
