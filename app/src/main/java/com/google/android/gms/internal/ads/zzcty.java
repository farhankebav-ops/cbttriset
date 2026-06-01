package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcty implements zzguf {
    final /* synthetic */ zzguf zza;
    final /* synthetic */ zzcud zzb;

    public zzcty(zzcud zzcudVar, zzguf zzgufVar) {
        this.zza = zzgufVar;
        Objects.requireNonNull(zzcudVar);
        this.zzb = zzcudVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zzb.zzf();
        this.zza.zza(th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        this.zzb.zzf();
        this.zza.zzb((zzcto) obj);
    }
}
