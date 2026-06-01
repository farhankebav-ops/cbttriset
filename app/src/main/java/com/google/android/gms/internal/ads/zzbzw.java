package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbzw {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzbzw(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzcaf zzcafVar) {
        this.zza = zzgVar;
    }

    public final void zza(int i2, long j) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaL)).booleanValue()) {
            return;
        }
        com.google.android.gms.ads.internal.util.zzg zzgVar = this.zza;
        if (j - zzgVar.zzF() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzaM)).booleanValue()) {
            zzgVar.zzE(i2);
            zzgVar.zzG(j);
        } else {
            zzgVar.zzE(-1);
            zzgVar.zzG(j);
        }
    }
}
