package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaia {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzeg zzf;
    private final zzeg zzg;
    private int zzh;
    private int zzi;

    public zzaia(zzeg zzegVar, zzeg zzegVar2, boolean z2) throws zzat {
        this.zzg = zzegVar;
        this.zzf = zzegVar2;
        this.zze = z2;
        zzegVar2.zzh(12);
        this.zza = zzegVar2.zzH();
        zzegVar.zzh(12);
        this.zzi = zzegVar.zzH();
        zzade.zza(zzegVar.zzB() == 1, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        int i2 = this.zzb + 1;
        this.zzb = i2;
        if (i2 == this.zza) {
            return false;
        }
        this.zzd = this.zze ? this.zzf.zzJ() : this.zzf.zzz();
        if (this.zzb == this.zzh) {
            zzeg zzegVar = this.zzg;
            this.zzc = zzegVar.zzH();
            zzegVar.zzk(4);
            int i8 = this.zzi - 1;
            this.zzi = i8;
            this.zzh = i8 > 0 ? (-1) + zzegVar.zzH() : -1;
        }
        return true;
    }
}
