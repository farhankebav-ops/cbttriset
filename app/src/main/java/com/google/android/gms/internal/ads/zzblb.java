package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzblb implements zzguf {
    final /* synthetic */ zzcgy zza;

    public zzblb(zzcgy zzcgyVar) {
        this.zza = zzcgyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        com.google.android.gms.ads.internal.zzt.zzh().zzg(th, "DefaultGmsgHandlers.attributionReportingManager");
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        zzcgy zzcgyVar = this.zza;
        new com.google.android.gms.ads.internal.util.zzbt(zzcgyVar.getContext(), zzcgyVar.zzs().afmaVersion, str, null, zzcgyVar.zzC() != null ? zzcgyVar.zzC().zzax : null).zzb();
    }
}
