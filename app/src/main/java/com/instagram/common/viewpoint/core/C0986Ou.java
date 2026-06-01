package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0986Ou implements X5 {
    public final X4 A00;
    public final X5 A01;

    public C0986Ou(X5 x52, int i2, int i8) {
        this.A01 = x52;
        this.A00 = new X4(i2, i8);
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void AGO(String str) {
        this.A00.A04(str);
        if (this.A00.A02() != null && X7.A08(this.A00)) {
            this.A01.AGO(this.A00.A02());
        }
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void flush() {
        this.A00.A03();
        while (this.A00.A02() != null) {
            if (X7.A08(this.A00)) {
                this.A01.AGO(this.A00.A02());
            }
            this.A00.A03();
        }
    }
}
