package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdru implements zzbuo {
    final /* synthetic */ zzdsd zza;

    public zzdru(zzdsd zzdsdVar) {
        Objects.requireNonNull(zzdsdVar);
        this.zza = zzdsdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zza(int i2, int i8, int i9, int i10) {
        this.zza.zzg().zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzb() {
        this.zza.zzg().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbuo
    public final void zzc() {
        this.zza.zzh().zza();
    }
}
