package com.instagram.common.viewpoint.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ah, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1314ah {
    public boolean A00;
    public View A03;
    public MH A04;
    public C1120Ua A05;
    public C1020Qc A06;
    public InterfaceC1190Wv A07;
    public AbstractC1207Xm A08;
    public AbstractC1207Xm A09;
    public InterfaceC1424cT A0A;
    public C0680Cw A0B;
    public String A0C;
    public final View A0D;
    public final AbstractC1752hy A0E;
    public final C1477dL A0F;
    public final US A0G;
    public final XH A0H;
    public final InterfaceC1208Xn A0I;
    public final C1550eX A0J;
    public int A02 = 0;
    public int A01 = 1;

    public C1314ah(C1477dL c1477dL, US us, InterfaceC1208Xn interfaceC1208Xn, AbstractC1752hy abstractC1752hy, View view, C1550eX c1550eX, XH xh) {
        this.A0F = c1477dL;
        this.A0G = us;
        this.A0I = interfaceC1208Xn;
        this.A0E = abstractC1752hy;
        this.A0D = view;
        this.A0J = c1550eX;
        this.A0H = xh;
    }

    public final C1314ah A0J(int i2) {
        this.A01 = i2;
        return this;
    }

    public final C1314ah A0K(int i2) {
        this.A02 = i2;
        return this;
    }

    public final C1314ah A0L(View view) {
        this.A03 = view;
        return this;
    }

    public final C1314ah A0M(MH mh) {
        this.A04 = mh;
        return this;
    }

    public final C1314ah A0N(C1120Ua c1120Ua) {
        this.A05 = c1120Ua;
        return this;
    }

    public final C1314ah A0O(C1020Qc c1020Qc) {
        this.A06 = c1020Qc;
        return this;
    }

    public final C1314ah A0P(InterfaceC1190Wv interfaceC1190Wv) {
        this.A07 = interfaceC1190Wv;
        return this;
    }

    public final C1314ah A0Q(AbstractC1207Xm abstractC1207Xm) {
        this.A08 = abstractC1207Xm;
        return this;
    }

    public final C1314ah A0R(AbstractC1207Xm abstractC1207Xm) {
        this.A09 = abstractC1207Xm;
        return this;
    }

    public final C1314ah A0S(InterfaceC1424cT interfaceC1424cT) {
        this.A0A = interfaceC1424cT;
        return this;
    }

    public final C1314ah A0T(C0680Cw c0680Cw) {
        this.A0B = c0680Cw;
        return this;
    }

    public final C1314ah A0U(String str) {
        this.A0C = str;
        return this;
    }

    public final C1314ah A0V(boolean z2) {
        this.A00 = z2;
        return this;
    }

    public final C1315ai A0W() {
        return new C1315ai(this);
    }
}
