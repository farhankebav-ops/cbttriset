package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public class GK {
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final long A05;
    public final long A06;
    public final long A07;

    public GK(long j, long j3, long j8, long j9, long j10, long j11, long j12) {
        this.A06 = j;
        this.A07 = j3;
        this.A03 = j8;
        this.A01 = j9;
        this.A02 = j10;
        this.A00 = j11;
        this.A05 = j12;
        this.A04 = A05(j3, j8, j9, j10, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A00() {
        return this.A00;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A01() {
        return this.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A02() {
        return this.A04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A03() {
        return this.A06;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long A04() {
        return this.A07;
    }

    public static long A05(long j, long j3, long j8, long bytesToSkip, long confidenceInterval, long j9) {
        if (bytesToSkip + 1 >= confidenceInterval || j3 + 1 >= j8) {
            return bytesToSkip;
        }
        long j10 = (long) ((j - j3) * ((confidenceInterval - bytesToSkip) / (j8 - j3)));
        return AbstractC04664a.A0T(((bytesToSkip + j10) - j9) - (j10 / 20), bytesToSkip, confidenceInterval - 1);
    }

    private void A0B() {
        this.A04 = A05(this.A07, this.A03, this.A01, this.A02, this.A00, this.A05);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(long j, long j3) {
        this.A01 = j;
        this.A00 = j3;
        A0B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(long j, long j3) {
        this.A03 = j;
        this.A02 = j3;
        A0B();
    }
}
