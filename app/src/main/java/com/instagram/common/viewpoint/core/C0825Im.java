package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Im, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C0825Im {
    public final int A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final C2154or A07;
    public final long[] A08;
    public final long[] A09;
    public final C0826In[] A0A;

    public C0825Im(int i2, int i8, long j, long j3, long j8, C2154or c2154or, int i9, C0826In[] c0826InArr, int i10, long[] jArr, long[] jArr2) {
        this.A00 = i2;
        this.A03 = i8;
        this.A06 = j;
        this.A05 = j3;
        this.A04 = j8;
        this.A07 = c2154or;
        this.A02 = i9;
        this.A0A = c0826InArr;
        this.A01 = i10;
        this.A08 = jArr;
        this.A09 = jArr2;
    }

    public final C0826In A00(int i2) {
        if (this.A0A == null) {
            return null;
        }
        return this.A0A[i2];
    }
}
