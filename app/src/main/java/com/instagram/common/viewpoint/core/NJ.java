package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class NJ implements InterfaceC1173Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ NI A01;

    public NJ(NI ni, int i2) {
        this.A01 = ni;
        this.A00 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() {
        this.A01.A03 = false;
        this.A01.A0V();
        this.A01.A0E.setToolbarActionMode(this.A01.getCloseButtonStyle());
        if (this.A01.A07 && this.A01.A06 != null) {
            this.A01.A06.A05();
            this.A01.A09.A4b(new LX().A6d());
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        this.A01.A0E.setProgress(100.0f * (1.0f - (f4 / this.A00)));
    }
}
