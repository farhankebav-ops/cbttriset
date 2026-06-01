package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcjh implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcjh(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcjh zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcjh(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcjg((zzcix) this.zza.zzb(), (zzdvi) this.zzb.zzb());
    }
}
