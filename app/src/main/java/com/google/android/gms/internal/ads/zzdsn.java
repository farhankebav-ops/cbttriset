package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdsn implements zzifh {
    private final zzifq zza;

    private zzdsn(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdsn zzc(zzifq zzifqVar) {
        return new zzdsn(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdsm zzb() {
        return new zzdsm((zzcgy) this.zza.zzb());
    }
}
