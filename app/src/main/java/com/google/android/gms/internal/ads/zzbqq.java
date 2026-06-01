package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbqq implements zzcce {
    final /* synthetic */ zzbpv zza;
    final /* synthetic */ Object zzb;
    final /* synthetic */ zzcca zzc;
    final /* synthetic */ zzbqt zzd;

    public zzbqq(zzbqt zzbqtVar, zzbpv zzbpvVar, Object obj, zzcca zzccaVar) {
        this.zza = zzbpvVar;
        this.zzb = obj;
        this.zzc = zzccaVar;
        Objects.requireNonNull(zzbqtVar);
        this.zzd = zzbqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise fulfilled");
        Object obj2 = this.zzb;
        zzcca zzccaVar = this.zzc;
        this.zzd.zzc(this.zza, (zzbqc) obj, obj2, zzccaVar);
    }
}
