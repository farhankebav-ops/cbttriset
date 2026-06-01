package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfcp implements zzfiv {
    private final zzfdm zza;

    public zzfcp(zzfdm zzfdmVar) {
        this.zza = zzfdmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final j2.q zza(zzfiw zzfiwVar) {
        zzfcs zzfcsVar = (zzfcs) zzfiwVar;
        return ((zzfco) this.zza).zzb(zzfcsVar.zzb, zzfcsVar.zza, null);
    }

    @Override // com.google.android.gms.internal.ads.zzfiv
    public final void zzb(zzfil zzfilVar) {
        zzfilVar.zza = ((zzfco) this.zza).zza();
    }
}
