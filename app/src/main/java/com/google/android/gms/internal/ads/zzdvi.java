package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdvi {
    private final zzdvn zza;
    private final Executor zzb;
    private final Map zzc;

    public zzdvi(zzdvn zzdvnVar, Executor executor) {
        this.zza = zzdvnVar;
        this.zzc = zzdvnVar.zza();
        this.zzb = executor;
    }

    public final zzdvh zza() {
        zzdvh zzdvhVar = new zzdvh(this);
        zzdvhVar.zzl();
        return zzdvhVar;
    }

    public final void zzb() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzmE)).booleanValue()) {
            zzdvh zzdvhVarZza = zza();
            zzdvhVarZza.zzc("action", "pecr");
            zzdvhVarZza.zzd();
        }
    }

    public final /* synthetic */ zzdvn zzc() {
        return this.zza;
    }

    public final /* synthetic */ Executor zzd() {
        return this.zzb;
    }

    public final /* synthetic */ Map zze() {
        return this.zzc;
    }
}
