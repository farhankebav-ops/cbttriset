package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcrt implements zzifh {
    private final zzcrn zza;
    private final zzifq zzb;

    private zzcrt(zzcrn zzcrnVar, zzifq zzifqVar) {
        this.zza = zzcrnVar;
        this.zzb = zzifqVar;
    }

    public static zzcrt zzc(zzcrn zzcrnVar, zzifq zzifqVar) {
        return new zzcrt(zzcrnVar, zzifqVar);
    }

    public static zzcrg zzd(zzcrn zzcrnVar, Object obj) {
        return (zzcrj) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcrg zzb() {
        return ((zzcrk) this.zzb).zzb();
    }
}
