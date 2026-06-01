package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeei {
    private final zzbxd zza;

    public zzeei(zzbxd zzbxdVar) {
        this.zza = zzbxdVar;
    }

    public final void zza() {
        j2.q qVarZza = this.zza.zza();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zziq)).booleanValue()) {
            zzcby.zzb(qVarZza, "persistFlags");
        } else {
            zzcby.zza(qVarZza, "persistFlags");
        }
    }
}
