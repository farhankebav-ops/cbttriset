package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaii implements zzaie {
    private final zzeg zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzaii(zzev zzevVar) {
        zzeg zzegVar = zzevVar.zza;
        this.zza = zzegVar;
        zzegVar.zzh(12);
        this.zzc = zzegVar.zzH() & 255;
        this.zzb = zzegVar.zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zzb() {
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzaie
    public final int zzc() {
        int i2 = this.zzc;
        if (i2 == 8) {
            return this.zza.zzs();
        }
        if (i2 == 16) {
            return this.zza.zzt();
        }
        int i8 = this.zzd;
        this.zzd = i8 + 1;
        if (i8 % 2 != 0) {
            return this.zze & 15;
        }
        int iZzs = this.zza.zzs();
        this.zze = iZzs;
        return (iZzs & 240) >> 4;
    }
}
