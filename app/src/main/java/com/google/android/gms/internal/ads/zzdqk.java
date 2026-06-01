package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdqk implements zzguf {
    final /* synthetic */ String zza;
    final /* synthetic */ zzblx zzb;

    public zzdqk(zzdqt zzdqtVar, String str, zzblx zzblxVar) {
        this.zza = str;
        this.zzb = zzblxVar;
        Objects.requireNonNull(zzdqtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcgy) obj).zzac(this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
    }
}
