package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekr extends zzekk {
    private final zzcjn zza;
    private final zzcxw zzb;
    private final zzdeo zzc;
    private final zzekv zzd;
    private final zzfgg zze;
    private final zzehp zzf;

    public zzekr(zzcjn zzcjnVar, zzcxw zzcxwVar, zzdeo zzdeoVar, zzfgg zzfggVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzcxwVar;
        this.zzc = zzdeoVar;
        this.zze = zzfggVar;
        this.zzd = zzekvVar;
        this.zzf = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final j2.q zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzfgg zzfggVar;
        zzcxw zzcxwVar = this.zzb;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zzd));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzed)).booleanValue() && (zzfggVar = this.zze) != null) {
            zzcxwVar.zzf(zzfggVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzf);
        }
        zzdrm zzdrmVarZzp = this.zza.zzp();
        zzdrmVarZzp.zzd(zzcxwVar.zze());
        zzdrmVarZzp.zze(this.zzc);
        zzcus zzcusVarZza = zzdrmVarZzp.zza().zza();
        return zzcusVarZza.zzc(zzcusVarZza.zzb());
    }
}
