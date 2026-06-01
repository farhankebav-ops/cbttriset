package com.ironsource.adqualitysdk.sdk.i;

/* JADX INFO: loaded from: classes5.dex */
public final class i {

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static final Object f2441 = new Object();

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static int f2442;

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static int f2443;

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static char[] m2497(long j, char[] cArr, int i2) {
        int length = cArr.length;
        char[] cArr2 = new char[length];
        int i8 = 0;
        int i9 = 4;
        for (int i10 = 0; i10 < cArr.length; i10++) {
            if ((((j >>> i10) & 1) != i2 || i8 >= 4) && i9 < length) {
                cArr2[i9] = cArr[i10];
                i9++;
            } else {
                cArr2[i8] = cArr[i10];
                i8++;
            }
        }
        return cArr2;
    }
}
