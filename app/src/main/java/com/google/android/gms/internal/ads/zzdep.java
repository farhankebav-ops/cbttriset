package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdep implements zzifh {
    private final zzdeo zza;
    private final zzifq zzb;

    private zzdep(zzdeo zzdeoVar, zzifq zzifqVar) {
        this.zza = zzdeoVar;
        this.zzb = zzifqVar;
    }

    public static zzdep zza(zzdeo zzdeoVar, zzifq zzifqVar) {
        return new zzdep(zzdeoVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcyq zzcyqVarZzp = this.zza.zzp(((zzift) this.zzb).zzb());
        zzifp.zzb(zzcyqVarZzp);
        return zzcyqVarZzp;
    }
}
