package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cV, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1426cV {
    public String A02;
    public String A03;
    public String A04;
    public final C0938Mw A06;
    public final N9 A07;
    public final C1477dL A08;
    public C0940My A01 = C0940My.A01(null);
    public int A00 = 1000;
    public boolean A05 = false;

    public C1426cV(C1477dL c1477dL, C0938Mw c0938Mw, N9 n9) {
        this.A08 = c1477dL;
        this.A06 = c0938Mw;
        this.A07 = n9;
    }

    public final C1426cV A09(int i2) {
        this.A00 = i2;
        return this;
    }

    public final C1426cV A0A(C0940My c0940My) {
        this.A01 = c0940My;
        return this;
    }

    public final C1426cV A0B(String str) {
        this.A04 = str;
        return this;
    }

    public final C1426cV A0C(String str) {
        this.A02 = str;
        return this;
    }

    public final C1426cV A0D(String str) {
        this.A03 = str;
        return this;
    }

    public final C1426cV A0E(boolean z2) {
        this.A05 = z2;
        return this;
    }

    public final C1428cX A0F() {
        return new C1428cX(this, null);
    }
}
