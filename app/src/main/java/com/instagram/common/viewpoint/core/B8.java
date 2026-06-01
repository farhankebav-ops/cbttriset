package com.instagram.common.viewpoint.core;

import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B8 {
    public final BU A00;
    public final int A01;
    public final int A02;
    public final int A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final DownloadRequest A07;

    public B8(DownloadRequest downloadRequest, int i2, long j, long j3, long j8, int i8, int i9) {
        this(downloadRequest, i2, j, j3, j8, i8, i9, new BU());
    }

    public B8(DownloadRequest downloadRequest, int i2, long j, long j3, long j8, int i8, int i9, BU bu) {
        C3M.A01(bu);
        C3M.A07((i9 == 0) == (i2 != 4));
        if (i8 != 0) {
            C3M.A07((i2 == 2 || i2 == 0) ? false : true);
        }
        this.A07 = downloadRequest;
        this.A02 = i2;
        this.A05 = j;
        this.A06 = j3;
        this.A04 = j8;
        this.A03 = i8;
        this.A01 = i9;
        this.A00 = bu;
    }

    public final float A00() {
        return this.A00.A00;
    }

    public final long A01() {
        return this.A00.A01;
    }

    public final boolean A02() {
        return this.A02 == 3 || this.A02 == 4;
    }
}
