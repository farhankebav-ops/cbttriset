package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G0 implements InterfaceC1424cT {
    public final /* synthetic */ int A00;
    public final /* synthetic */ C0760Fy A01;

    public G0(C0760Fy c0760Fy, int i2) {
        this.A01 = c0760Fy;
        this.A00 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void ABr() {
        this.A01.A0E();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void ACZ() {
        this.A01.A0V(false, this.A00);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void ACy(int i2) {
        C0760Fy.A02(this.A01, i2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void ADI(float f4) {
        if (!this.A01.A08) {
            this.A01.A0J(f4);
        }
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void AFE(boolean z2) {
        this.A01.A0U(z2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void AFg(String str) {
        this.A01.A0D.A0F().A3S(str);
        this.A01.A0I.A4b(this.A01.A0J.A7t());
        this.A01.A0K(3);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void AJr() {
        this.A01.setUnskippableSecondsComplete(false);
        this.A01.A0H.setProgressImmediate(0.0f);
        this.A01.A0H.setToolbarActionMode(2);
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1424cT
    public final void AJs(float f4) {
        this.A01.A0H.setProgress(100.0f * f4);
    }
}
