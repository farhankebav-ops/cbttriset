package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcka implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcka(zzcjp zzcjpVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcka zza(zzcjp zzcjpVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcka(zzcjpVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdm)).booleanValue() ? new zzaxa((zzawv) this.zzb.zzb()) : new zzaxa((zzawv) this.zza.zzb());
    }
}
