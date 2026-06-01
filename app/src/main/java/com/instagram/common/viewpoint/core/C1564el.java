package com.instagram.common.viewpoint.core;

import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.el, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1564el {
    public int A00;
    public int A01;
    public int A02;
    public InterfaceC1554eb A03;
    public Map<String, String> A04;
    public final int A05;
    public final int A06;

    public C1564el(int i2, int i8, int i9, int i10, int i11, Map<String, String> requestHeaders, InterfaceC1554eb interfaceC1554eb) {
        this.A06 = i2;
        this.A00 = i8;
        this.A02 = i9;
        this.A05 = i10;
        this.A01 = i11;
        this.A04 = requestHeaders;
        this.A03 = interfaceC1554eb;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final int A02() {
        return this.A02;
    }

    public final int A03() {
        return this.A05;
    }

    public final int A04() {
        return this.A06;
    }

    public final InterfaceC1554eb A05() {
        return this.A03;
    }

    public final Map<String, String> A06() {
        return this.A04;
    }
}
