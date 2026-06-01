package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdmr {
    private final zzdvi zza;

    public zzdmr(zzdvi zzdviVar) {
        this.zza = zzdviVar;
    }

    public final void zza(@Nullable View view, zzffu zzffuVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznV)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.zza(view) ? "0" : "1";
        zzdvh zzdvhVarZza = this.zza.zza();
        zzdvhVarZza.zzc("action", "hcp");
        zzdvhVarZza.zzc("hcp", str);
        zzdvhVarZza.zzb(zzffuVar);
        zzdvhVarZza.zzd();
    }
}
