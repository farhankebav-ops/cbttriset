package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class HP implements InterfaceC1173Wc {
    public final /* synthetic */ C04794n A00;

    public HP(C04794n c04794n) {
        this.A00 = c04794n;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        this.A00.A0M.ACy(this.A00.A0C);
        this.A00.A0M.ACZ();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        int i2;
        float totalForce = (this.A00.A0C - f4) + (this.A00.A0a ? 0 : this.A00.A0P.getDuration());
        if (this.A00.A0a) {
            i2 = this.A00.A0C;
        } else {
            i2 = this.A00.A0B;
        }
        float seenTime = i2;
        this.A00.A0M.AJs(totalForce / seenTime);
    }
}
