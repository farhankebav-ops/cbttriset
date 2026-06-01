package com.instagram.common.viewpoint.core;

import java.io.Serializable;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class O1 implements Serializable {
    public O0 A00;
    public O0 A01;

    public O1() {
        this(0.5d, 0.5d);
    }

    public O1(double d8) {
        this(d8, 0.5d);
    }

    public O1(double d8, double d9) {
        this.A00 = new O0(d8);
        this.A01 = new O0(d9);
        A02();
    }

    public final O0 A00() {
        return this.A00;
    }

    public final O0 A01() {
        return this.A01;
    }

    public final void A02() {
        this.A00.A07();
        this.A01.A07();
    }

    public final void A03() {
        this.A00.A08();
        this.A01.A08();
    }

    public final void A04(double d8, double d9) {
        this.A00.A09(d8, d9);
    }

    public final void A05(double d8, double d9) {
        this.A01.A09(d8, d9);
    }
}
