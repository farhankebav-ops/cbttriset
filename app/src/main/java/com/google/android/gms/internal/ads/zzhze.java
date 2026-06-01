package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhze extends zzhzc {
    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ void zza(Object obj, int i2, long j) {
        ((zzhzd) obj).zzk(i2 << 3, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ void zzb(Object obj, int i2, int i8) {
        ((zzhzd) obj).zzk((i2 << 3) | 5, Integer.valueOf(i8));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i2, long j) {
        ((zzhzd) obj).zzk((i2 << 3) | 1, Long.valueOf(j));
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ void zzd(Object obj, int i2, zzhvi zzhviVar) {
        ((zzhzd) obj).zzk((i2 << 3) | 2, zzhviVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ void zze(Object obj, int i2, Object obj2) {
        ((zzhzd) obj).zzk((i2 << 3) | 3, (zzhzd) obj2);
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* synthetic */ Object zzf() {
        return zzhzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* synthetic */ Object zzg(Object obj) {
        zzhzd zzhzdVar = (zzhzd) obj;
        zzhzdVar.zzd();
        return zzhzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* bridge */ /* synthetic */ Object zzh(Object obj) {
        zzhwo zzhwoVar = (zzhwo) obj;
        zzhzd zzhzdVar = zzhwoVar.zzt;
        if (zzhzdVar != zzhzd.zza()) {
            return zzhzdVar;
        }
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        zzhwoVar.zzt = zzhzdVarZzb;
        return zzhzdVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final /* synthetic */ void zzi(Object obj, Object obj2) {
        ((zzhwo) obj).zzt = (zzhzd) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzhzc
    public final void zzj(Object obj) {
        ((zzhwo) obj).zzt.zzd();
    }
}
