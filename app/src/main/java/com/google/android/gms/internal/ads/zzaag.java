package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaag implements zzabv {
    final /* synthetic */ zzsv zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ zzaak zzd;

    public zzaag(zzaak zzaakVar, zzsv zzsvVar, int i2, long j) {
        this.zza = zzsvVar;
        this.zzb = i2;
        this.zzc = j;
        Objects.requireNonNull(zzaakVar);
        this.zzd = zzaakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zza(long j) {
        this.zzd.zzay(this.zza, this.zzb, this.zzc, j);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final void zzb() {
        this.zzd.zzav(this.zza, this.zzb, this.zzc);
    }
}
