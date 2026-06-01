package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbpw implements zzcce {
    final /* synthetic */ zzbpv zza;

    public zzbpw(zzbqa zzbqaVar, zzbpv zzbpvVar) {
        this.zza = zzbpvVar;
        Objects.requireNonNull(zzbqaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcce
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        com.google.android.gms.ads.internal.util.zze.zza("Getting a new session for JS Engine.");
        this.zza.zzf(((zzbow) obj).zzl());
    }
}
