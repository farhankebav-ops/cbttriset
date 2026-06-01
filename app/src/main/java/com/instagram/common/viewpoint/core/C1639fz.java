package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1639fz extends QT {
    public boolean A00 = false;
    public final /* synthetic */ AbstractC1638fy A01;

    public C1639fz(AbstractC1638fy abstractC1638fy) {
        this.A01 = abstractC1638fy;
    }

    @Override // com.instagram.common.viewpoint.core.QT
    public final void A0L(C05246g c05246g, int i2) {
        super.A0L(c05246g, i2);
        if (i2 == 0 && this.A00) {
            this.A00 = false;
            this.A01.A0F();
        }
    }

    @Override // com.instagram.common.viewpoint.core.QT
    public final void A0M(C05246g c05246g, int i2, int i8) {
        if (i2 != 0 || i8 != 0) {
            this.A00 = true;
        }
    }
}
