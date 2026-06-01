package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oy, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0990Oy implements X5 {
    public int A00;
    public final X5 A01;
    public final X5 A02;

    public C0990Oy(X5 x52, int i2, X5 x53) {
        this.A01 = x52;
        this.A00 = i2;
        this.A02 = x53;
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void AGO(String str) {
        if (this.A00 > 0) {
            this.A01.AGO(str);
            this.A01.flush();
            this.A00--;
            return;
        }
        this.A02.AGO(str);
    }

    @Override // com.instagram.common.viewpoint.core.X5
    public final void flush() {
        this.A02.flush();
    }
}
