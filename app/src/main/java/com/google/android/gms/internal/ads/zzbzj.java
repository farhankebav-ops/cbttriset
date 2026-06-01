package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbzj implements zzguf {
    final /* synthetic */ j2.q zza;

    public zzbzj(zzbzo zzbzoVar, j2.q qVar) {
        this.zza = qVar;
        Objects.requireNonNull(zzbzoVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzbzo.zzc.remove(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbzo.zzc.remove(this.zza);
    }
}
