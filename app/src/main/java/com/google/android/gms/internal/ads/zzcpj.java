package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcpj implements zzguf {
    final /* synthetic */ zzcpq zza;

    public zzcpj(zzcpq zzcpqVar) {
        Objects.requireNonNull(zzcpqVar);
        this.zza = zzcpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpq zzcpqVar = this.zza;
        zzcpqVar.zzu().zzb(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, "", (String) obj, zzcpqVar.zzs().zzc, null), true == com.google.android.gms.ads.internal.zzt.zzh().zzs(zzcpqVar.zzq()) ? 2 : 1);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }
}
