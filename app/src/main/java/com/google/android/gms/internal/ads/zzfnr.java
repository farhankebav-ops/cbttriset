package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfnr extends com.google.android.gms.ads.internal.client.zzbm {
    final /* synthetic */ zzgvb zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzbx zzb;
    final /* synthetic */ zzfns zzc;

    public zzfnr(zzfns zzfnsVar, zzgvb zzgvbVar, com.google.android.gms.ads.internal.client.zzbx zzbxVar) {
        this.zza = zzgvbVar;
        this.zzb = zzbxVar;
        Objects.requireNonNull(zzfnsVar);
        this.zzc = zzfnsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        Objects.requireNonNull(this.zzc);
        zzfnj.zza(this.zzb, this.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) {
        String string = zzeVar.zzb().toString();
        zzfns zzfnsVar = this.zzc;
        String str = zzfnsVar.zze.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 57 + String.valueOf(str).length());
        sb.append("Failed to load interstitial ad with error: ");
        sb.append(string);
        sb.append(" for ad unit: ");
        sb.append(str);
        com.google.android.gms.ads.internal.util.client.zzo.zzi(sb.toString());
        zzfnsVar.zzv(zzeVar);
    }
}
