package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static int f1663;

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static final Object f1664 = new Object();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static int f1665;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static int f1666;

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static int m1894(int i2) {
        int[][] iArr = a.f57.f59;
        return ((iArr[0][i2 >>> 24] + iArr[1][(i2 >>> 16) & 255]) ^ iArr[2][(i2 >>> 8) & 255]) + iArr[3][i2 & 255];
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static void m1895(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i8 = iArr[i2];
            iArr[i2] = iArr[(iArr.length - i2) - 1];
            iArr[(iArr.length - i2) - 1] = i8;
        }
    }
}
