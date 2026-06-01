package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdrf implements zzbmp {
    private final zzczv zza;

    @Nullable
    private final zzbyh zzb;
    private final String zzc;
    private final String zzd;

    public zzdrf(zzczv zzczvVar, zzffu zzffuVar) {
        this.zza = zzczvVar;
        this.zzb = zzffuVar.zzl;
        this.zzc = zzffuVar.zzj;
        this.zzd = zzffuVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zza() {
        this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzb(@Nullable zzbyh zzbyhVar) {
        int i2;
        String str;
        zzbyh zzbyhVar2 = this.zzb;
        if (zzbyhVar2 != null) {
            zzbyhVar = zzbyhVar2;
        }
        if (zzbyhVar != null) {
            str = zzbyhVar.zza;
            i2 = zzbyhVar.zzb;
        } else {
            i2 = 1;
            str = "";
        }
        this.zza.zze(new zzbxs(str, i2), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbmp
    public final void zzc() {
        this.zza.zzf();
    }
}
