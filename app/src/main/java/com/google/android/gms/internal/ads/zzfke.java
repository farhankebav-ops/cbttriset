package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfke implements zzguf {
    final /* synthetic */ zzfjz zza;
    final /* synthetic */ zzfkj zzb;

    public zzfke(zzfkj zzfkjVar, zzfjz zzfjzVar) {
        this.zza = zzfjzVar;
        Objects.requireNonNull(zzfkjVar);
        this.zzb = zzfkjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        this.zzb.zza.zzg().zzc(this.zza, th);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zzb.zza.zzg().zzd(this.zza);
    }
}
