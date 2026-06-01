package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaog {
    public static int zza(byte[] bArr, int i2, int i8) {
        while (i2 < i8 && bArr[i2] != 71) {
            i2++;
        }
        return i2;
    }

    public static long zzb(zzeg zzegVar, int i2, int i8) {
        zzegVar.zzh(i2);
        if (zzegVar.zzd() < 5) {
            return -9223372036854775807L;
        }
        int iZzB = zzegVar.zzB();
        if ((8388608 & iZzB) != 0 || ((iZzB >> 8) & 8191) != i8 || (iZzB & 32) == 0 || zzegVar.zzs() < 7 || zzegVar.zzd() < 7 || (zzegVar.zzs() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        zzegVar.zzm(bArr, 0, 6);
        long j = bArr[0];
        long j3 = bArr[1];
        long j8 = bArr[2];
        long j9 = bArr[3] & 255;
        return ((j & 255) << 25) | ((j3 & 255) << 17) | ((j8 & 255) << 9) | (j9 + j9) | ((((long) bArr[4]) & 255) >> 7);
    }
}
