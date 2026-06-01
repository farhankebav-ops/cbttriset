package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzajf {
    public final int zza;
    public final int zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final zzv zzg;
    public final int zzh;

    @Nullable
    public final long[] zzi;

    @Nullable
    public final long[] zzj;
    public final int zzk;

    @Nullable
    private final zzajg[] zzl;

    public zzajf(int i2, int i8, long j, long j3, long j8, long j9, zzv zzvVar, int i9, @Nullable zzajg[] zzajgVarArr, int i10, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = j;
        this.zzd = j3;
        this.zze = j8;
        this.zzf = j9;
        this.zzg = zzvVar;
        this.zzh = i9;
        this.zzl = zzajgVarArr;
        this.zzk = i10;
        this.zzi = jArr;
        this.zzj = jArr2;
    }

    @Nullable
    public final zzajg zza(int i2) {
        return this.zzl[i2];
    }

    public final zzajf zzb(zzv zzvVar) {
        return new zzajf(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, zzvVar, this.zzh, this.zzl, this.zzk, this.zzi, this.zzj);
    }
}
