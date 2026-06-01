package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ov, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0987Ov implements X5 {
    public int A00;
    public final X5 A01;

    public C0987Ov(X5 x52, int i2) {
        this.A01 = x52;
        this.A00 = i2;
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void AGO(String str) {
        if (this.A00 > 0) {
            this.A01.AGO(str);
            this.A00--;
        }
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void flush() {
        this.A01.flush();
    }
}
