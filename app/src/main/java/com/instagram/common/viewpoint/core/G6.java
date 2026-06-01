package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class G6 implements InterfaceC1173Wc {
    public final /* synthetic */ int A00;
    public final /* synthetic */ AbstractRunnableC1164Vt A01;
    public final /* synthetic */ G2 A02;
    public final /* synthetic */ C0680Cw A03;

    public G6(G2 g22, int i2, C0680Cw c0680Cw, AbstractRunnableC1164Vt abstractRunnableC1164Vt) {
        this.A02 = g22;
        this.A00 = i2;
        this.A03 = c0680Cw;
        this.A01 = abstractRunnableC1164Vt;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void ACp() throws Throwable {
        this.A01.run();
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1173Wc
    public final void AEn(float f4) {
        this.A02.A08.setProgress(100.0f * (1.0f - (f4 / this.A00)));
        if (this.A03 != null) {
            C0680Cw c0680Cw = this.A03;
            float percentage = this.A00;
            c0680Cw.A07((int) ((percentage - f4) * 1000.0f));
        }
    }
}
