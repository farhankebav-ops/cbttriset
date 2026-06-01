package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdkp implements zzifh {
    private final zzifq zza;

    private zzdkp(zzdkm zzdkmVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdkp zzc(zzdkm zzdkmVar, zzifq zzifqVar) {
        return new zzdkp(zzdkmVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdlv zzb() {
        zzdlu zzdluVar = (zzdlu) this.zza.zzb();
        zzifp.zzb(zzdluVar);
        return zzdluVar;
    }
}
