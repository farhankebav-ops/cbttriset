package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekp extends zzekk {
    private final zzcjn zza;
    private final zzcxw zzb;
    private final zzena zzc;
    private final zzdeo zzd;
    private final zzekv zze;
    private final zzehp zzf;

    public zzekp(zzcjn zzcjnVar, zzcxw zzcxwVar, zzena zzenaVar, zzdeo zzdeoVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzcxwVar;
        this.zzc = zzenaVar;
        this.zzd = zzdeoVar;
        this.zze = zzekvVar;
        this.zzf = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final j2.q zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzcxw zzcxwVar = this.zzb;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zze));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzf);
        }
        zzdjc zzdjcVarZzm = this.zza.zzm();
        zzdjcVarZzm.zze(zzcxwVar.zze());
        zzdjcVarZzm.zzf(this.zzd);
        zzdjcVarZzm.zzd(this.zzc);
        zzcus zzcusVarZzb = zzdjcVarZzm.zza().zzb();
        return zzcusVarZzb.zzc(zzcusVarZzb.zzb());
    }
}
