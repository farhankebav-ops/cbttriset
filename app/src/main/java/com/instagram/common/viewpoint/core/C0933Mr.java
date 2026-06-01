package com.instagram.common.viewpoint.core;

import java.io.Serializable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C0933Mr implements Serializable {
    public static final long serialVersionUID = -5352540727250859603L;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public long A06;
    public NB A07;
    public String A08;
    public String A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;

    public final C0933Mr A0D(int i2) {
        this.A02 = i2;
        return this;
    }

    public final C0933Mr A0E(int i2) {
        this.A03 = i2;
        return this;
    }

    public final C0933Mr A0F(int i2) {
        this.A04 = i2;
        return this;
    }

    public final C0933Mr A0G(int i2) {
        this.A05 = i2;
        return this;
    }

    public final C0933Mr A0H(int i2) {
        this.A00 = i2;
        return this;
    }

    public final C0933Mr A0I(int i2) {
        this.A01 = i2;
        return this;
    }

    public final C0933Mr A0J(long j) {
        this.A06 = j;
        return this;
    }

    public final C0933Mr A0K(NB nb) {
        this.A07 = nb;
        return this;
    }

    public final C0933Mr A0L(String str) {
        this.A09 = str;
        return this;
    }

    public final C0933Mr A0M(String str) {
        this.A08 = str;
        return this;
    }

    public final C0933Mr A0N(boolean z2) {
        this.A0A = z2;
        return this;
    }

    public final C0933Mr A0O(boolean z2) {
        this.A0B = z2;
        return this;
    }

    public final C0933Mr A0P(boolean z2) {
        this.A0C = z2;
        return this;
    }

    public final C0934Ms A0Q() {
        return new C0934Ms(this);
    }
}
