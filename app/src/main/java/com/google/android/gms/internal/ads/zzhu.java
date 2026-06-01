package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzhu {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    public /* synthetic */ zzhu(float f4, float f8, long j, float f9, long j3, long j8, float f10, byte[] bArr) {
        this.zza = j3;
        this.zzb = j8;
    }

    private final void zzf() {
        long j;
        long j3 = this.zzc;
        if (j3 != -9223372036854775807L) {
            j = this.zzd;
            if (j == -9223372036854775807L) {
                long j8 = this.zzf;
                if (j8 != -9223372036854775807L && j3 < j8) {
                    j3 = j8;
                }
                j = this.zzg;
                if (j == -9223372036854775807L || j3 <= j) {
                    j = j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        if (this.zze == j) {
            return;
        }
        this.zze = j;
        this.zzh = j;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    private static long zzg(long j, long j3, float f4) {
        return (long) ((j3 * 9.999871E-4f) + (j * 0.999f));
    }

    public final void zza(zzaf zzafVar) {
        long j = zzafVar.zza;
        this.zzc = zzep.zzq(-9223372036854775807L);
        this.zzf = zzep.zzq(-9223372036854775807L);
        this.zzg = zzep.zzq(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzf();
    }

    public final void zzb(long j) {
        this.zzd = j;
        zzf();
    }

    public final void zzc() {
        long j = this.zzh;
        if (j == -9223372036854775807L) {
            return;
        }
        long j3 = j + this.zzb;
        this.zzh = j3;
        long j8 = this.zzg;
        if (j8 != -9223372036854775807L && j3 > j8) {
            this.zzh = j8;
        }
        this.zzl = -9223372036854775807L;
    }

    public final float zzd(long j, long j3) {
        long jMax;
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j8 = j - j3;
        long j9 = this.zzm;
        if (j9 == -9223372036854775807L) {
            this.zzm = j8;
            this.zzn = 0L;
        } else {
            long jMax2 = Math.max(j8, zzg(j9, j8, 0.999f));
            this.zzm = jMax2;
            this.zzn = zzg(this.zzn, Math.abs(j8 - jMax2), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j10 = (this.zzn * 3) + this.zzm;
        if (this.zzh > j10) {
            long jZzq = zzep.zzq(1000L);
            float f4 = this.zzk - 1.0f;
            float f8 = this.zzi - 1.0f;
            long j11 = this.zze;
            float f9 = jZzq;
            long j12 = this.zzh - (((long) (f4 * f9)) + ((long) (f8 * f9)));
            long[] jArr = {j10, j11, j12};
            jMax = jArr[0];
            for (int i2 = 1; i2 < 3; i2++) {
                long j13 = jArr[i2];
                if (j13 > jMax) {
                    jMax = j13;
                }
            }
            this.zzh = jMax;
        } else {
            long jMax3 = j - ((long) (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f));
            long j14 = this.zzh;
            String str = zzep.zza;
            jMax = Math.max(j14, Math.min(jMax3, j10));
            this.zzh = jMax;
            long j15 = this.zzg;
            if (j15 != -9223372036854775807L && jMax > j15) {
                this.zzh = j15;
                jMax = j15;
            }
        }
        long j16 = j - jMax;
        if (Math.abs(j16) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float fMax = Math.max(this.zzj, Math.min((j16 * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = fMax;
        return fMax;
    }

    public final long zze() {
        return this.zzh;
    }
}
