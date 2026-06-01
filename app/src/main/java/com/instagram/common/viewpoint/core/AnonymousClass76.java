package com.instagram.common.viewpoint.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.76, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract /* synthetic */ class AnonymousClass76 {
    public static int A00(int i2) {
        return A06(i2, 0, 0);
    }

    public static int A01(int i2) {
        return i2 & 24;
    }

    public static int A02(int i2) {
        return i2 & 384;
    }

    public static int A03(int i2) {
        return i2 & 7;
    }

    public static int A04(int i2) {
        return i2 & 64;
    }

    public static int A05(int i2) {
        return i2 & 32;
    }

    public static int A06(int i2, int i8, int i9) {
        return A07(i2, i8, i9, 0, 128);
    }

    public static int A07(int i2, int i8, int i9, int i10, int i11) {
        return i2 | i8 | i9 | i10 | i11;
    }
}
