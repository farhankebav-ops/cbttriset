package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfam implements zzifh {
    private final zzfaf zza;

    private zzfam(zzfaf zzfafVar) {
        this.zza = zzfafVar;
    }

    public static zzfam zzc(zzfaf zzfafVar) {
        return new zzfam(zzfafVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final Integer zzb() {
        return Integer.valueOf(this.zza.zzj());
    }
}
