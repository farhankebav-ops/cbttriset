package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaac {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final void zza() {
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zzb() {
        return this.zzd > 15 && this.zzh == 0;
    }

    public final boolean zzc() {
        long j = this.zzd;
        if (j == 0) {
            return false;
        }
        return this.zzg[(int) ((j - 1) % 15)];
    }

    public final long zzd() {
        return this.zzf;
    }

    public final long zze() {
        long j = this.zze;
        if (j == 0) {
            return 0L;
        }
        return this.zzf / j;
    }

    public final void zzf(long j) {
        long j3 = this.zzd;
        if (j3 == 0) {
            this.zza = j;
        } else if (j3 == 1) {
            long j8 = j - this.zza;
            this.zzb = j8;
            this.zzf = j8;
            this.zze = 1L;
        } else {
            long j9 = j - this.zzc;
            int i2 = (int) (j3 % 15);
            if (Math.abs(j9 - this.zzb) <= 1000000) {
                this.zze++;
                this.zzf += j9;
                boolean[] zArr = this.zzg;
                if (zArr[i2]) {
                    zArr[i2] = false;
                    this.zzh--;
                }
            } else {
                boolean[] zArr2 = this.zzg;
                if (!zArr2[i2]) {
                    zArr2[i2] = true;
                    this.zzh++;
                }
            }
        }
        this.zzd++;
        this.zzc = j;
    }
}
