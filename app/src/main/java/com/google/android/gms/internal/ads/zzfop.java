package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfop extends zzbyu {
    final /* synthetic */ zzgvb zza;
    final /* synthetic */ zzbyo zzb;
    final /* synthetic */ zzfoq zzc;

    public zzfop(zzfoq zzfoqVar, zzgvb zzgvbVar, zzbyo zzbyoVar) {
        this.zza = zzgvbVar;
        this.zzb = zzbyoVar;
        Objects.requireNonNull(zzfoqVar);
        this.zzc = zzfoqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zze() {
        Objects.requireNonNull(this.zzc);
        zzfnj.zza(this.zzb, this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzg(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzfoq zzfoqVar = this.zzc;
        String str = zzfoqVar.zze.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 51 + String.valueOf(str).length());
        sb.append("Failed to load rewarded ad with error: ");
        sb.append(string);
        sb.append(", adUnitId: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(sb.toString());
        zzfoqVar.zzv(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbyv
    public final void zzf(int i2) {
    }
}
