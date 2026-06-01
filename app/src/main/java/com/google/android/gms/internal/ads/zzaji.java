package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaji {
    public final zzajf zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzaji(zzajf zzajfVar, long[] jArr, int[] iArr, int i2, long[] jArr2, int[] iArr2, long j, int i8) {
        int length = iArr.length;
        int length2 = jArr2.length;
        zzgmd.zza(length == length2);
        zzgmd.zza(jArr.length == length2);
        int length3 = iArr2.length;
        zzgmd.zza(length3 == length2);
        this.zza = zzajfVar;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i2;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j;
        this.zzb = i8;
        if (length3 > 0) {
            int i9 = length3 - 1;
            iArr2[i9] = iArr2[i9] | 536870912;
        }
    }

    public final int zza(long j) {
        for (int iZzm = zzep.zzm(this.zzf, j, true, false); iZzm >= 0; iZzm--) {
            if ((this.zzg[iZzm] & 1) != 0) {
                return iZzm;
            }
        }
        return -1;
    }

    public final int zzb(long j) {
        long[] jArr = this.zzf;
        for (int iZzo = zzep.zzo(jArr, j, true, false); iZzo < jArr.length; iZzo++) {
            if ((this.zzg[iZzo] & 1) != 0) {
                return iZzo;
            }
        }
        return -1;
    }
}
