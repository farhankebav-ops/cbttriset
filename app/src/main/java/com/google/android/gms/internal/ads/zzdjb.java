package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdjb implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdjb(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdjb zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdjb(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdja((zzdaz) this.zza.zzb(), (zzdgh) this.zzb.zzb());
    }
}
