package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcqo {
    private final zzdvi zza;
    private final zzfgf zzb;

    public zzcqo(zzdvi zzdviVar, zzfgf zzfgfVar) {
        this.zza = zzdviVar;
        this.zzb = zzfgfVar;
    }

    public final void zza(long j, int i2) {
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zza(this.zzb.zzb.zzb);
        zzdvhVarZza.zzc("action", "ad_closed");
        zzdvhVarZza.zzc("show_time", String.valueOf(j));
        zzdvhVarZza.zzc(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
        int i8 = i2 - 1;
        zzdvhVarZza.zzc("acr", i8 != 0 ? i8 != 1 ? i8 != 2 ? i8 != 3 ? i8 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : "h");
        zzdvhVarZza.zzd();
    }
}
