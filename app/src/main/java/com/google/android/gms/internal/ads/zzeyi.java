package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeyi implements zzifh {
    private final zzifq zza;

    private zzeyi(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
    }

    public static zzeyi zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzeyi(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeyg zzb() {
        return new zzeyg(((zzcjv) this.zza).zza(), zzfjn.zzc());
    }
}
