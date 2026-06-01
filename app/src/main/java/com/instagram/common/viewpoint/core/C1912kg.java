package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1912kg implements IL {
    public int A00;
    public int A01;
    public final int A02;
    public final int A03;
    public final C4J A04;

    public C1912kg(C1914ki c1914ki) {
        this.A04 = c1914ki.A00;
        this.A04.A0f(12);
        this.A02 = this.A04.A0L() & 255;
        this.A03 = this.A04.A0L();
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int A82() {
        return -1;
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int A8n() {
        return this.A03;
    }

    @Override // com.instagram.common.viewpoint.core.IL
    public final int AGi() {
        if (this.A02 == 8) {
            return this.A04.A0I();
        }
        if (this.A02 == 16) {
            return this.A04.A0M();
        }
        int i2 = this.A01;
        this.A01 = i2 + 1;
        if (i2 % 2 == 0) {
            this.A00 = this.A04.A0I();
            return (this.A00 & 240) >> 4;
        }
        return this.A00 & 15;
    }
}
