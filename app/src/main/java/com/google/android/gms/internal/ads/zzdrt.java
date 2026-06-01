package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdrt implements com.google.android.gms.ads.internal.zzn {
    final /* synthetic */ zzdse zza;

    public zzdrt(zzdse zzdseVar) {
        Objects.requireNonNull(zzdseVar);
        this.zza = zzdseVar;
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdp() {
        this.zza.zzb().zza();
    }

    @Override // com.google.android.gms.ads.internal.zzn
    public final void zzdq() {
        this.zza.zzb().zzb();
    }
}
