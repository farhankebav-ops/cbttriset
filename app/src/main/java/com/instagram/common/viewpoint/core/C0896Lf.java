package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lf, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0896Lf implements InterfaceC1206Xl {
    public static String[] A01 = {"dAENZa04S5kpLZ1505OVGzU", "BCWAX", "x4EBtM5L1", "d5mzvX7vdf5oGTbdkf23a85QS6J33UuP", "T3xMk8xyeuXfnP2cHDF22zgmf4sSWk7a", "D6RnJQb1nSkQk7teZoJG77p", "lMrZ8D5HcAsH09zpnUIM78ubrFXrhoz6", "r7D6OIPJDO7XxyVdFUwVLtQI1zZlrgYr"};
    public final /* synthetic */ C0893Lc A00;

    public C0896Lf(C0893Lc c0893Lc) {
        this.A00 = c0893Lc;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1206Xl
    public final void ACC(AbstractC1207Xm abstractC1207Xm) {
        if (this.A00.A0W() && !this.A00.A0V.get()) {
            this.A00.A0T.A07(this.A00);
            return;
        }
        C0893Lc c0893Lc = this.A00;
        if (A01[4].charAt(5) == '8') {
            A01[1] = "011C";
            if (!c0893Lc.A0X || this.A00.A0V.get() || !this.A00.A0V()) {
                this.A00.A0N.A04(UZ.A07, null);
                if (this.A00.A0J.A0P()) {
                    this.A00.A0L.A0F().ADk();
                }
                InterfaceC1208Xn interfaceC1208Xn = this.A00.A0Q;
                C0893Lc c0893Lc2 = this.A00;
                if (A01[2].length() == 9) {
                    A01[6] = "SsRiNY9tvP3hEWy4eyTF9NsffnrPtCfL";
                    interfaceC1208Xn.A4b(c0893Lc2.A0R.A7o());
                    return;
                }
            } else {
                this.A00.A0a.setToolbarActionMode(0);
                this.A00.A0L();
                return;
            }
        }
        throw new RuntimeException();
    }
}
