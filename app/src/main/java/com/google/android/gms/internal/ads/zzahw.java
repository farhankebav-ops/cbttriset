package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahw {
    public final zzadw zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;
    public final int zze;

    @Nullable
    public final long[] zzf;

    private zzahw(zzadw zzadwVar, long j, long j3, @Nullable long[] jArr, int i2, int i8) {
        this.zza = new zzadw(zzadwVar);
        this.zzb = j;
        this.zzc = j3;
        this.zzf = jArr;
        this.zzd = i2;
        this.zze = i8;
    }

    public static zzahw zza(zzadw zzadwVar, zzeg zzegVar) {
        long[] jArr;
        int i2;
        int i8;
        int iZzB = zzegVar.zzB();
        int iZzH = (iZzB & 1) != 0 ? zzegVar.zzH() : -1;
        long jZzz = (iZzB & 2) != 0 ? zzegVar.zzz() : -1L;
        if ((iZzB & 4) == 4) {
            jArr = new long[100];
            for (int i9 = 0; i9 < 100; i9++) {
                jArr[i9] = zzegVar.zzs();
            }
        } else {
            jArr = null;
        }
        long[] jArr2 = jArr;
        if ((iZzB & 8) != 0) {
            zzegVar.zzk(4);
        }
        if (zzegVar.zzd() >= 24) {
            zzegVar.zzk(21);
            int iZzx = zzegVar.zzx();
            i8 = iZzx & 4095;
            i2 = iZzx >> 12;
        } else {
            i2 = -1;
            i8 = -1;
        }
        return new zzahw(zzadwVar, iZzH, jZzz, jArr2, i2, i8);
    }

    public final long zzb() {
        long j = this.zzb;
        if (j == -1 || j == 0) {
            return -9223372036854775807L;
        }
        return zzep.zzr((j * ((long) r4.zzg)) - 1, this.zza.zzd);
    }
}
