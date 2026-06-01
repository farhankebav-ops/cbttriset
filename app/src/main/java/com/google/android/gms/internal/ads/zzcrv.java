package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcrv implements zzifh {
    private final zzifq zza;

    private zzcrv(zzcrn zzcrnVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcrv zza(zzcrn zzcrnVar, zzifq zzifqVar) {
        return new zzcrv(zzcrnVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzgpo zzgpoVarZzi = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznE)).booleanValue() ? zzgpo.zzi(new zzdgn(((zzcsz) this.zza).zzb(), zzcbv.zza)) : zzgpo.zzh();
        zzifp.zzb(zzgpoVarZzi);
        return zzgpoVarZzi;
    }
}
