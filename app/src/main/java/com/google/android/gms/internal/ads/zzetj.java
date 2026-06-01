package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzetj implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzetj(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        this.zza = zzifqVar2;
        this.zzb = zzifqVar4;
    }

    public static zzetj zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        return new zzetj(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeso(zzevv.zzc(), ((Long) zzbgj.zzf.zze()).longValue(), (Clock) this.zza.zzb(), zzfjn.zzc(), (zzdvi) this.zzb.zzb());
    }
}
