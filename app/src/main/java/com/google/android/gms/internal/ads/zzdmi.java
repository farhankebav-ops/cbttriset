package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdmi implements zzifh {
    private final zzdmb zza;

    private zzdmi(zzdmb zzdmbVar) {
        this.zza = zzdmbVar;
    }

    public static zzdmi zzc(zzdmb zzdmbVar) {
        return new zzdmi(zzdmbVar);
    }

    public static zzdlq zzd(zzdmb zzdmbVar) {
        zzdlq zzdlqVarZza = zzdmbVar.zza();
        zzifp.zzb(zzdlqVarZza);
        return zzdlqVarZza;
    }

    public final zzdlq zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
