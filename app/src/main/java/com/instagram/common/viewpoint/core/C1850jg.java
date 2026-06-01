package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.jg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1850jg extends GQ {
    public C1850jg(C4R c4r, long j, long j3) {
        super(new C1949lU(), new C1851jh(c4r), j, 0L, j + 1, 0L, j3, 188L, 1000);
    }

    public static int A00(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) | ((bArr[i2 + 1] & 255) << 16) | ((bArr[i2 + 2] & 255) << 8) | (bArr[i2 + 3] & 255);
    }
}
