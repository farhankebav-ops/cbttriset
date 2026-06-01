package com.instagram.common.viewpoint.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Km, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0877Km {
    public final int A00;
    public final long A01;

    public C0877Km(int i2, long j) {
        this.A00 = i2;
        this.A01 = j;
    }

    public static C0877Km A00(InterfaceC1943lN interfaceC1943lN, C4J c4j) throws IOException {
        interfaceC1943lN.AG9(c4j.A0l(), 0, 8);
        c4j.A0f(0);
        int iA0C = c4j.A0C();
        long size = c4j.A0O();
        return new C0877Km(iA0C, size);
    }
}
