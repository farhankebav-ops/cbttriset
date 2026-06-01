package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzlf {
    private static final zzuu zzu = new zzuu(new Object(), -1);
    public final zzbf zza;
    public final zzuu zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;

    @Nullable
    public final zzib zzf;
    public final boolean zzg;
    public final zzwv zzh;
    public final zzys zzi;
    public final List zzj;
    public final zzuu zzk;
    public final boolean zzl;
    public final int zzm;
    public final int zzn;
    public final zzav zzo;
    public final boolean zzp = false;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;
    public volatile long zzt;

    public zzlf(zzbf zzbfVar, zzuu zzuuVar, long j, long j3, int i2, @Nullable zzib zzibVar, boolean z2, zzwv zzwvVar, zzys zzysVar, List list, zzuu zzuuVar2, boolean z7, int i8, int i9, zzav zzavVar, long j8, long j9, long j10, long j11, boolean z8) {
        this.zza = zzbfVar;
        this.zzb = zzuuVar;
        this.zzc = j;
        this.zzd = j3;
        this.zze = i2;
        this.zzf = zzibVar;
        this.zzg = z2;
        this.zzh = zzwvVar;
        this.zzi = zzysVar;
        this.zzj = list;
        this.zzk = zzuuVar2;
        this.zzl = z7;
        this.zzm = i8;
        this.zzn = i9;
        this.zzo = zzavVar;
        this.zzq = j8;
        this.zzr = j9;
        this.zzs = j10;
        this.zzt = j11;
    }

    public static zzlf zza(zzys zzysVar) {
        zzbf zzbfVar = zzbf.zza;
        zzuu zzuuVar = zzu;
        return new zzlf(zzbfVar, zzuuVar, -9223372036854775807L, 0L, 1, null, false, zzwv.zza, zzysVar, zzgpe.zzi(), zzuuVar, false, 1, 0, zzav.zza, 0L, 0L, 0L, 0L, false);
    }

    public static zzuu zzb() {
        return zzu;
    }

    @CheckResult
    public final zzlf zzc(zzuu zzuuVar, long j, long j3, long j8, long j9, zzwv zzwvVar, zzys zzysVar, List list) {
        zzuu zzuuVar2 = this.zzk;
        boolean z2 = this.zzl;
        int i2 = this.zzm;
        int i8 = this.zzn;
        zzav zzavVar = this.zzo;
        long j10 = this.zzq;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        return new zzlf(this.zza, zzuuVar, j3, j8, this.zze, this.zzf, this.zzg, zzwvVar, zzysVar, list, zzuuVar2, z2, i2, i8, zzavVar, j10, j9, j, jElapsedRealtime, false);
    }

    @CheckResult
    public final zzlf zzd(zzbf zzbfVar) {
        return new zzlf(zzbfVar, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    @CheckResult
    public final zzlf zze(int i2) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, i2, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    @CheckResult
    public final zzlf zzf(@Nullable zzib zzibVar) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzibVar, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    @CheckResult
    public final zzlf zzg(boolean z2) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, z2, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    @CheckResult
    public final zzlf zzh(zzuu zzuuVar) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzuuVar, this.zzl, this.zzm, this.zzn, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    @CheckResult
    public final zzlf zzi(boolean z2, int i2, int i8) {
        return new zzlf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z2, i2, i8, this.zzo, this.zzq, this.zzr, this.zzs, this.zzt, false);
    }

    public final boolean zzj() {
        return this.zze == 3 && this.zzl && this.zzn == 0;
    }
}
