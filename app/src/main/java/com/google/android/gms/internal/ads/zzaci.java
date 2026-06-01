package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaci {
    private final long zza;
    private final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    public zzaci(long j, long j3, long j8, long j9, long j10, long j11, long j12) {
        this.zza = j;
        this.zzb = j3;
        this.zze = j9;
        this.zzf = j10;
        this.zzg = j11;
        this.zzc = j12;
        this.zzh = zza(j3, 0L, j9, j10, j11, j12);
    }

    public static long zza(long j, long j3, long j8, long j9, long j10, long j11) {
        if (j9 + 1 >= j10 || 1 + j3 >= j8) {
            return j9;
        }
        long j12 = (long) (((j10 - j9) / (j8 - j3)) * (j - j3));
        String str = zzep.zza;
        return Math.max(j9, Math.min(((j9 + j12) - j11) - (j12 / 20), j10 - 1));
    }

    private final void zzi() {
        this.zzh = zza(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }

    public final /* synthetic */ long zzb() {
        return this.zzf;
    }

    public final /* synthetic */ long zzc() {
        return this.zzg;
    }

    public final /* synthetic */ long zzd() {
        return this.zzb;
    }

    public final /* synthetic */ long zze() {
        return this.zza;
    }

    public final /* synthetic */ void zzf(long j, long j3) {
        this.zzd = j;
        this.zzf = j3;
        zzi();
    }

    public final /* synthetic */ void zzg(long j, long j3) {
        this.zze = j;
        this.zzg = j3;
        zzi();
    }

    public final /* synthetic */ long zzh() {
        return this.zzh;
    }
}
