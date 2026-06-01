package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahp implements zzahu {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;

    private zzahp(long[] jArr, long[] jArr2, long j) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = j == -9223372036854775807L ? zzep.zzq(jArr2[jArr2.length - 1]) : j;
    }

    public static zzahp zzd(long j, zzagt zzagtVar, long j3) {
        int[] iArr = zzagtVar.zzd;
        int length = iArr.length;
        int i2 = length + 1;
        long[] jArr = new long[i2];
        long[] jArr2 = new long[i2];
        jArr[0] = j;
        long j8 = 0;
        jArr2[0] = 0;
        for (int i8 = 1; i8 <= length; i8++) {
            int i9 = i8 - 1;
            j += (long) (zzagtVar.zzb + iArr[i9]);
            j8 += (long) (zzagtVar.zzc + zzagtVar.zze[i9]);
            jArr[i8] = j;
            jArr2[i8] = j8;
        }
        return new zzahp(jArr, jArr2, j3);
    }

    private static Pair zzh(long j, long[] jArr, long[] jArr2) {
        int iZzm = zzep.zzm(jArr, j, true, true);
        long j3 = jArr[iZzm];
        long j8 = jArr2[iZzm];
        int i2 = iZzm + 1;
        if (i2 == jArr.length) {
            return Pair.create(Long.valueOf(j3), Long.valueOf(j8));
        }
        return Pair.create(Long.valueOf(j), Long.valueOf(((long) ((jArr[i2] == j3 ? 0.0d : (j - j3) / (r6 - j3)) * (jArr2[i2] - j8))) + j8));
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        String str = zzep.zza;
        Pair pairZzh = zzh(zzep.zzp(Math.max(0L, Math.min(j, this.zzc))), this.zzb, this.zza);
        zzaee zzaeeVar = new zzaee(zzep.zzq(((Long) pairZzh.first).longValue()), ((Long) pairZzh.second).longValue());
        return new zzaeb(zzaeeVar, zzaeeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zze(long j) {
        return zzep.zzq(((Long) zzh(j, this.zza, this.zzb).second).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zzf() {
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final int zzg() {
        return -2147483647;
    }
}
