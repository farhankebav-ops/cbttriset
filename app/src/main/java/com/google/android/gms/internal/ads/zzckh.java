package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzckh implements zzifh {
    private final zzifq zza;

    private zzckh(zzcjp zzcjpVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzckh zzc(zzcjp zzcjpVar, zzifq zzifqVar) {
        return new zzckh(zzcjpVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcnr zzb() {
        zzcjn zzcjnVar = (zzcjn) this.zza.zzb();
        zzifp.zzb(zzcjnVar);
        return zzcjnVar;
    }
}
