package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdrr implements zzifh {
    private final zzifq zza;

    private zzdrr(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdrr zza(zzifq zzifqVar) {
        return new zzdrr(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return ((zzcyf) this.zza).zza().zzp.zza == 3 ? "rewarded_interstitial" : "rewarded";
    }
}
