package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcpk implements zzguf {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcpq zzb;

    public zzcpk(zzcpq zzcpqVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzcpqVar);
        this.zzb = zzcpqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzcpq zzcpqVar = this.zzb;
        zzcpqVar.zzu().zza(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, this.zza, null, zzcpqVar.zzp(), zzcpqVar.zzw()), null);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = this.zza;
        String str2 = (String) obj;
        zzcpq zzcpqVar = this.zzb;
        zzcpqVar.zzu().zza(zzcpqVar.zzt().zzb(zzcpqVar.zzr(), zzcpqVar.zzs(), false, str, str2, zzcpqVar.zzp(), zzcpqVar.zzw()), zzcpqVar.zzv());
    }
}
