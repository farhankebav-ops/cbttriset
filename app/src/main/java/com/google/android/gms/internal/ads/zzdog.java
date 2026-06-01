package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdog implements zzguf {
    final /* synthetic */ zzduq zza;
    final /* synthetic */ zzdoj zzb;

    public zzdog(zzdoj zzdojVar, zzduq zzduqVar) {
        this.zza = zzduqVar;
        Objects.requireNonNull(zzdojVar);
        this.zzb = zzdojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        com.google.android.gms.ads.internal.client.a.m(this.zzb.zzd().zze(), this.zza.zza());
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }
}
