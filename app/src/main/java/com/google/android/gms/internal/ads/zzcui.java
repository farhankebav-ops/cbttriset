package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcui implements zzifh {
    private final zzcue zza;

    private zzcui(zzcue zzcueVar) {
        this.zza = zzcueVar;
    }

    public static zzcui zzc(zzcue zzcueVar) {
        return new zzcui(zzcueVar);
    }

    public static zzfgf zzd(zzcue zzcueVar) {
        zzfgf zzfgfVarZza = zzcueVar.zza();
        zzifp.zzb(zzfgfVarZza);
        return zzfgfVarZza;
    }

    public final zzfgf zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
