package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class U0 {
    public final int A00;
    public final C1117Tx A01;

    public U0(int i2, C1117Tx c1117Tx) {
        this.A00 = i2;
        this.A01 = c1117Tx;
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() throws IOException {
        return this.A01.A05();
    }

    public final C1108To A02(int i2, byte[] bArr, int i8, int[] iArr, int i9) throws IOException {
        return this.A01.A06(i2, bArr, i8, iArr, i9);
    }

    public final void A03() throws IOException {
        this.A01.A07();
    }

    public final void A04() throws IOException {
        this.A01.A08();
    }

    public final boolean A05(byte[] bArr) throws IOException {
        return this.A01.A09(bArr);
    }
}
