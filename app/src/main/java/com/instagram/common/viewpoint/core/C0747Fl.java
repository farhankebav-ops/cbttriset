package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0747Fl implements InterfaceC1206Xl {
    public static String[] A01 = {"ziFc1AxLwl06l9cm2ro8EEkTqcfxuLTc", "Ot3h47XlIqwqlb0VDKX34tYNREgAb88h", "XErmhi3UBKLFfekLEXmFG5T5AXnu", "x4ahbzSdp8w2tJq97wkZytqruvrbxvGd", "5eNtQA6JlDjBFR49aczWqHsgt2phfPFu", "5gzf4", "tgwS2khKEZgsCudiehRL6tpdm2kFQW", "Wy"};
    public final /* synthetic */ C04573r A00;

    public C0747Fl(C04573r c04573r) {
        this.A00 = c04573r;
    }

    @Override // com.instagram.common.viewpoint.core.InterfaceC1206Xl
    public final void ACC(AbstractC1207Xm abstractC1207Xm) {
        if (abstractC1207Xm.getToolbarActionMode() == 8) {
            this.A00.A0e();
            return;
        }
        ((G2) this.A00).A06.A04(UZ.A07, null);
        if (this.A00.A0i()) {
            return;
        }
        InterfaceC1208Xn interfaceC1208Xn = ((G2) this.A00).A09;
        YY yy = ((G2) this.A00).A0A;
        if (A01[7].length() != 2) {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[4] = "aiGFPxx8CXfEdquuZVm2W5wuPm6cCNUb";
        strArr[3] = "iaZJUoQxe1noplKpEgf5PzuXPp1HxeHv";
        interfaceC1208Xn.A4b(yy.A7o());
    }
}
