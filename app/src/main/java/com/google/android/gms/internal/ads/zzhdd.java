package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhdd {
    public static void zza(long[] jArr, long[] jArr2, int i2) {
        for (int i8 = 0; i8 < 10; i8++) {
            int i9 = (int) jArr[i8];
            jArr[i8] = ((-i2) & (((int) jArr2[i8]) ^ i9)) ^ i9;
        }
    }
}
