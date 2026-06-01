package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzahn extends zzacq implements zzahu {
    private final long zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;

    public zzahn(long j, long j3, int i2, int i8, boolean z2) {
        super(j, j3, i2, i8, false);
        this.zza = j3;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = j != -1 ? j : -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zze(long j) {
        return zzd(j);
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final long zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final int zzg() {
        return this.zzb;
    }

    public final zzahn zzh(long j) {
        return new zzahn(j, this.zza, this.zzb, this.zzc, false);
    }
}
