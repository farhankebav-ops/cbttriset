package com.instagram.common.viewpoint.core;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class M3 {
    public final long A00;
    public final long A01;

    public M3(long j, long j3) {
        this.A01 = j;
        this.A00 = j3;
    }

    public final boolean A00(long j, long j3) {
        return this.A00 == -1 ? j >= this.A01 : j3 != -1 && this.A01 <= j && j + j3 <= this.A01 + this.A00;
    }

    public final boolean A01(long j, long j3) {
        return this.A01 <= j ? this.A00 == -1 || this.A01 + this.A00 > j : j3 == -1 || j + j3 > this.A01;
    }
}
