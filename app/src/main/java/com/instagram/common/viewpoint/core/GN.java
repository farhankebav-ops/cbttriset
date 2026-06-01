package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class GN {
    public static final GN A03 = new GN(-3, -9223372036854775807L, -1);
    public final int A00;
    public final long A01;
    public final long A02;

    public GN(int i2, long j, long j3) {
        this.A00 = i2;
        this.A02 = j;
        this.A01 = j3;
    }

    public static GN A03(long j) {
        return new GN(0, -9223372036854775807L, j);
    }

    public static GN A04(long j, long j3) {
        return new GN(-1, j, j3);
    }

    public static GN A05(long j, long j3) {
        return new GN(-2, j, j3);
    }
}
