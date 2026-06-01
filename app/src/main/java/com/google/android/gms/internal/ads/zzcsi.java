package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcsi implements zzczi {

    @Nullable
    private final zzcgy zza;
    private final zzdvi zzb;
    private final zzffu zzc;

    public zzcsi(@Nullable zzcgy zzcgyVar, zzdvi zzdviVar, zzffu zzffuVar) {
        this.zza = zzcgyVar;
        this.zzb = zzdviVar;
        this.zzc = zzffuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczi
    public final void zzdw() {
        zzcgy zzcgyVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznV)).booleanValue() || (zzcgyVar = this.zza) == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.zza(zzcgyVar.zzE()) ? "0" : "1";
        zzdvh zzdvhVarZza = this.zzb.zza();
        zzdvhVarZza.zzc("action", "hcp");
        zzdvhVarZza.zzc("hcp", str);
        zzdvhVarZza.zzb(this.zzc);
        zzdvhVarZza.zzd();
    }
}
