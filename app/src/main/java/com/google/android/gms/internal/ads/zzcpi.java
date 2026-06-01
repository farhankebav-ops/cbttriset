package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcpi implements zzcyr {
    private final zzffx zza;
    private final zzfgf zzb;
    private final zzfnc zzc;
    private final zzfng zzd;

    public zzcpi(zzfgf zzfgfVar, zzfng zzfngVar, zzfnc zzfncVar) {
        this.zzb = zzfgfVar;
        this.zzd = zzfngVar;
        this.zzc = zzfncVar;
        this.zza = zzfgfVar.zzb.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzcyr
    public final void zzdN(com.google.android.gms.ads.internal.client.zze zzeVar) {
        List list = this.zza.zza;
        this.zzd.zza(this.zzc.zza(this.zzb, null, list), null);
    }
}
