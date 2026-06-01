package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfag implements zzifh {
    private final zzfaf zza;

    private zzfag(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfag zzc(zzfaf zzfafVar) {
        return new zzfag(zzfafVar);
    }

    public static String zzd(zzfaf zzfafVar) {
        String strZza = zzfafVar.zza();
        zzifp.zzb(strZza);
        return strZza;
    }

    public final String zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
