package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcyf implements zzifh {
    private final zzcxx zza;

    private zzcyf(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    public static zzcyf zzc(zzcxx zzcxxVar) {
        return new zzcyf(zzcxxVar);
    }

    public static zzfgn zzd(zzcxx zzcxxVar) {
        zzfgn zzfgnVarZzb = zzcxxVar.zzb();
        zzifp.zzb(zzfgnVarZzb);
        return zzfgnVarZzb;
    }

    public final zzfgn zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
