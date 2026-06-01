package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzexx implements zzifh {
    private final zzifq zza;

    private zzexx(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar2;
    }

    public static zzexx zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzexx(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzexw zzb() {
        return new zzexw(zzfjn.zzc(), ((zzcjv) this.zza).zza());
    }
}
