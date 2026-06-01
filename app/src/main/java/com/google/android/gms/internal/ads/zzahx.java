package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahx implements zzahu {
    private final long zza;
    private final int zzb;
    private final long zzc;
    private final int zzd;
    private final long zze;
    private final long zzf;

    @Nullable
    private final long[] zzg;

    private zzahx(long j, int i2, long j3, int i8, long j8, @Nullable long[] jArr) {
        this.zza = j;
        this.zzb = i2;
        this.zzc = j3;
        this.zzd = i8;
        this.zze = j8;
        this.zzg = jArr;
        this.zzf = j8 != -1 ? j + j8 : -1L;
    }

    @Nullable
    public static zzahx zzd(zzahw zzahwVar, long j) {
        long jZzb = zzahwVar.zzb();
        if (jZzb == -9223372036854775807L) {
            return null;
        }
        zzadw zzadwVar = zzahwVar.zza;
        return new zzahx(j, zzadwVar.zzc, jZzb, zzadwVar.zzf, zzahwVar.zzc, zzahwVar.zzf);
    }

    private final long zzh(int i2) {
        return (this.zzc * ((long) i2)) / 100;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final boolean zzb() {
        return this.zzg != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final zzaeb zzc(long j) {
        if (!zzb()) {
            zzaee zzaeeVar = new zzaee(0L, this.zza + ((long) this.zzb));
            return new zzaeb(zzaeeVar, zzaeeVar);
        }
        long j3 = this.zzc;
        String str = zzep.zza;
        long jMax = Math.max(0L, Math.min(j, j3));
        double d8 = (jMax * 100.0d) / j3;
        double d9 = 0.0d;
        if (d8 > 0.0d) {
            if (d8 >= 100.0d) {
                d9 = 256.0d;
            } else {
                int i2 = (int) d8;
                long[] jArr = this.zzg;
                jArr.getClass();
                double d10 = jArr[i2];
                d9 = (((i2 == 99 ? 256.0d : jArr[i2 + 1]) - d10) * (d8 - ((double) i2))) + d10;
            }
        }
        long j8 = this.zze;
        zzaee zzaeeVar2 = new zzaee(jMax, this.zza + Math.max(this.zzb, Math.min(Math.round((d9 / 256.0d) * j8), j8 - 1)));
        return new zzaeb(zzaeeVar2, zzaeeVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zze(long j) {
        if (!zzb()) {
            return 0L;
        }
        long j3 = j - this.zza;
        if (j3 <= this.zzb) {
            return 0L;
        }
        long[] jArr = this.zzg;
        jArr.getClass();
        double d8 = (j3 * 256.0d) / this.zze;
        int iZzm = zzep.zzm(jArr, (long) d8, true, true);
        long jZzh = zzh(iZzm);
        long j8 = jArr[iZzm];
        int i2 = iZzm + 1;
        long jZzh2 = zzh(i2);
        return Math.round((j8 == (iZzm == 99 ? 256L : jArr[i2]) ? 0.0d : (d8 - j8) / (r0 - j8)) * (jZzh2 - jZzh)) + jZzh;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zzf() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final int zzg() {
        return this.zzd;
    }
}
