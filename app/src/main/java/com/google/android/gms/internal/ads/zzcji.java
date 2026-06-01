package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcji {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzcji(int i2, int i8, int i9) {
        this.zzc = i2;
        this.zzb = i8;
        this.zza = i9;
    }

    public static zzcji zza(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        return zzrVar.zzd ? new zzcji(3, 0, 0) : zzrVar.zzi ? new zzcji(2, 0, 0) : zzrVar.zzh ? new zzcji(0, 0, 0) : new zzcji(1, zzrVar.zzf, zzrVar.zzc);
    }

    public static zzcji zzb() {
        return new zzcji(0, 0, 0);
    }

    public static zzcji zzc(int i2, int i8) {
        return new zzcji(1, i2, i8);
    }

    public static zzcji zzd() {
        return new zzcji(4, 0, 0);
    }

    public static zzcji zze() {
        return new zzcji(5, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 2;
    }

    public final boolean zzg() {
        return this.zzc == 3;
    }

    public final boolean zzh() {
        return this.zzc == 0;
    }

    public final boolean zzi() {
        return this.zzc == 4;
    }

    public final boolean zzj() {
        return this.zzc == 5;
    }
}
