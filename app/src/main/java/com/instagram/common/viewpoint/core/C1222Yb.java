package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Yb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1222Yb {
    public int A00;
    public XX A01;
    public InterfaceC1226Yf A02;
    public String A03;
    public String A04;
    public String A05;
    public String A06;
    public final C1477dL A0C;
    public boolean A0A = true;
    public boolean A0B = true;
    public boolean A09 = true;
    public boolean A07 = true;
    public boolean A08 = true;

    public C1222Yb(C1477dL c1477dL, InterfaceC1226Yf interfaceC1226Yf) {
        this.A0C = c1477dL;
        this.A02 = interfaceC1226Yf;
    }

    public final C1222Yb A0D(int i2) {
        this.A00 = i2;
        return this;
    }

    public final C1222Yb A0E(XX xx) {
        this.A01 = xx;
        return this;
    }

    public final C1222Yb A0F(String str) {
        this.A03 = str;
        return this;
    }

    public final C1222Yb A0G(String str) {
        this.A04 = str;
        return this;
    }

    public final C1222Yb A0H(String str) {
        this.A05 = str;
        return this;
    }

    public final C1222Yb A0I(String str) {
        this.A06 = str;
        return this;
    }

    public final C1222Yb A0J(boolean z2) {
        this.A09 = z2;
        return this;
    }

    public final C1222Yb A0K(boolean z2) {
        this.A0A = z2;
        return this;
    }

    public final C1222Yb A0L(boolean z2) {
        this.A0B = z2;
        return this;
    }

    public final C1223Yc A0M() {
        return new C1223Yc(this, null);
    }
}
