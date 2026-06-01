package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzflj implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;

    public zzflj(zzflm zzflmVar, zzflc zzflcVar) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflc zzflcVar = this.zzb;
        zzflcVar.zzj(th);
        zzflcVar.zzd(false);
        this.zza.zza(zzflcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
    }
}
