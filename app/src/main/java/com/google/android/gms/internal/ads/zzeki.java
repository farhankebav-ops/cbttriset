package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeki extends zzekk {
    private final zzcjn zza;
    private final zzdju zzb;
    private final zzcxw zzc;
    private final zzdeo zzd;
    private final zzekv zze;
    private final zzehp zzf;

    public zzeki(zzcjn zzcjnVar, zzdju zzdjuVar, zzcxw zzcxwVar, zzdeo zzdeoVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzdjuVar;
        this.zzc = zzcxwVar;
        this.zzd = zzdeoVar;
        this.zze = zzekvVar;
        this.zzf = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final j2.q zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzcxw zzcxwVar = this.zzc;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzf);
        }
        zzdjy zzdjyVarZzo = this.zza.zzo();
        zzdjyVarZzo.zzf(zzcxwVar.zze());
        zzdjyVarZzo.zzg(this.zzd);
        zzdjyVarZzo.zze(this.zzb);
        zzdjyVarZzo.zzd(new zzcrd(null));
        zzcus zzcusVarZza = zzdjyVarZzo.zza().zza();
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }
}
