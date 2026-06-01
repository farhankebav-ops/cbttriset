package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdkr implements zzifh {
    private final zzdkm zza;

    private zzdkr(zzdkm zzdkmVar) {
        this.zza = zzdkmVar;
    }

    public static zzdkr zzc(zzdkm zzdkmVar) {
        return new zzdkr(zzdkmVar);
    }

    public static zzdqt zzd(zzdkm zzdkmVar) {
        zzdqt zzdqtVarZzd = zzdkmVar.zzd();
        zzifp.zzb(zzdqtVarZzd);
        return zzdqtVarZzd;
    }

    public final zzdqt zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
