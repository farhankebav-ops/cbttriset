package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbc {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final Long zzh;
    final Long zzi;
    final Long zzj;
    final Boolean zzk;

    public zzbc(String str, String str2, long j, long j3, long j8, long j9, long j10, Long l, Long l8, Long l9, Boolean bool) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkArgument(j >= 0);
        Preconditions.checkArgument(j3 >= 0);
        Preconditions.checkArgument(j8 >= 0);
        Preconditions.checkArgument(j10 >= 0);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j3;
        this.zze = j8;
        this.zzf = j9;
        this.zzg = j10;
        this.zzh = l;
        this.zzi = l8;
        this.zzj = l9;
        this.zzk = bool;
    }

    public final zzbc zza(long j) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }

    public final zzbc zzb(long j, long j3) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j, Long.valueOf(j3), this.zzi, this.zzj, this.zzk);
    }

    public final zzbc zzc(Long l, Long l8, Boolean bool) {
        return new zzbc(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l, l8, bool);
    }
}
