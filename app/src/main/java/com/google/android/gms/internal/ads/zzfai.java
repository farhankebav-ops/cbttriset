package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfai implements zzifh {
    private final zzfaf zza;

    private zzfai(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfai zzc(zzfaf zzfafVar) {
        return new zzfai(zzfafVar);
    }

    public static boolean zzd(zzfaf zzfafVar) {
        return zzfafVar.zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Boolean zzb() {
        return Boolean.valueOf(this.zza.zzh());
    }
}
