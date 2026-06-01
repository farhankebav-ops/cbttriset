package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzefa implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzefa(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzefa zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzefa(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeez zzb() {
        return new zzeez(((zzees) this.zza).zzb(), ((zzcjq) this.zzb).zzb());
    }
}
