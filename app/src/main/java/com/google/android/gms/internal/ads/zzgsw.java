package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgsw {
    public static long[] zza(long[]... jArr) {
        long length = 0;
        for (long[] jArr2 : jArr) {
            length += (long) jArr2.length;
        }
        int i2 = (int) length;
        zzgmd.zze(length == ((long) i2), "the total number of elements (%s) in the arrays must fit in an int", length);
        long[] jArr3 = new long[i2];
        int i8 = 0;
        for (long[] jArr4 : jArr) {
            int length2 = jArr4.length;
            System.arraycopy(jArr4, 0, jArr3, i8, length2);
            i8 += length2;
        }
        return jArr3;
    }
}
