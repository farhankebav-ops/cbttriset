package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbqr implements zzccc {
    final /* synthetic */ zzcca zza;
    final /* synthetic */ zzbpv zzb;

    public zzbqr(zzbqt zzbqtVar, zzcca zzccaVar, zzbpv zzbpvVar) {
        this.zza = zzccaVar;
        this.zzb = zzbpvVar;
        Objects.requireNonNull(zzbqtVar);
    }

    @Override // com.google.android.gms.internal.ads.zzccc
    public final void zza() {
        com.google.android.gms.ads.internal.util.zze.zza("callJs > getEngine: Promise rejected");
        this.zza.zzd(new zzbqe("Unable to obtain a JavascriptEngine."));
        this.zzb.zza();
    }
}
