package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfli implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ boolean zzc;

    public zzfli(zzflm zzflmVar, zzflc zzflcVar, boolean z2) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
        this.zzc = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflc zzflcVar = this.zzb;
        if (zzflcVar.zzb()) {
            zzflm zzflmVar = this.zza;
            zzflcVar.zzj(th);
            zzflcVar.zzd(false);
            zzflmVar.zza(zzflcVar);
            if (this.zzc) {
                zzflmVar.zzh();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        zzflc zzflcVar = this.zzb;
        zzflcVar.zzd(true);
        zzflm zzflmVar = this.zza;
        zzflmVar.zza(zzflcVar);
        if (this.zzc) {
            zzflmVar.zzh();
        }
    }
}
