package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcln implements zzdwt {
    private final Long zza;
    private final String zzb;
    private final zzckz zzc;
    private final zzclp zzd;

    public zzcln(zzckz zzckzVar, zzclp zzclpVar, Long l, String str) {
        this.zzc = zzckzVar;
        this.zzd = zzclpVar;
        this.zza = l;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final zzdxc zza() {
        long jLongValue = this.zza.longValue();
        zzclp zzclpVar = this.zzd;
        return zzdxd.zza(jLongValue, zzclpVar.zzd(), zzclpVar.zza(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzdwt
    public final zzdxg zzb() {
        long jLongValue = this.zza.longValue();
        zzclp zzclpVar = this.zzd;
        return zzdxh.zza(jLongValue, zzclpVar.zzd(), zzclpVar.zza(), this.zzc, this.zzb);
    }
}
