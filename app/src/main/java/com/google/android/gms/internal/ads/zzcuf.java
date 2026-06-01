package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcuf implements zzifh {
    private final zzcue zza;

    private zzcuf(zzcue zzcueVar) {
        this.zza = zzcueVar;
    }

    public static zzcuf zzc(zzcue zzcueVar) {
        return new zzcuf(zzcueVar);
    }

    public static zzffu zzd(zzcue zzcueVar) {
        zzffu zzffuVarZzb = zzcueVar.zzb();
        zzifp.zzb(zzffuVarZzb);
        return zzffuVarZzb;
    }

    public final zzffu zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
