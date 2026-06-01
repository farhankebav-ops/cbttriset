package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class zzgoz {
    public static int zze(int i2, int i8) {
        if (i8 < 0) {
            throw new IllegalArgumentException("cannot store more than Integer.MAX_VALUE elements");
        }
        if (i8 <= i2) {
            return i2;
        }
        int i9 = i2 + (i2 >> 1) + 1;
        if (i9 < i8) {
            int iHighestOneBit = Integer.highestOneBit(i8 - 1);
            i9 = iHighestOneBit + iHighestOneBit;
        }
        if (i9 < 0) {
            return Integer.MAX_VALUE;
        }
        return i9;
    }

    public abstract zzgoz zzd(Object obj);
}
