package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekn extends zzekk {
    private final zzcjn zza;
    private final zzcxw zzb;
    private final zzena zzc;
    private final zzdeo zzd;
    private final zzdju zze;
    private final zzdbp zzf;

    @Nullable
    private final ViewGroup zzg;

    @Nullable
    private final zzddu zzh;
    private final zzekv zzi;
    private final zzehp zzj;

    public zzekn(zzcjn zzcjnVar, zzcxw zzcxwVar, zzena zzenaVar, zzdeo zzdeoVar, zzdju zzdjuVar, zzdbp zzdbpVar, @Nullable ViewGroup viewGroup, @Nullable zzddu zzdduVar, zzekv zzekvVar, zzehp zzehpVar) {
        this.zza = zzcjnVar;
        this.zzb = zzcxwVar;
        this.zzc = zzenaVar;
        this.zzd = zzdeoVar;
        this.zze = zzdjuVar;
        this.zzf = zzdbpVar;
        this.zzg = viewGroup;
        this.zzh = zzdduVar;
        this.zzi = zzekvVar;
        this.zzj = zzehpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final j2.q zzc(zzfgn zzfgnVar, Bundle bundle, zzffu zzffuVar, zzfgf zzfgfVar) {
        zzcxw zzcxwVar = this.zzb;
        zzcxwVar.zzb(zzfgnVar);
        zzcxwVar.zzc(bundle);
        zzcxwVar.zzd(new zzcxp(zzfgfVar, zzffuVar, this.zzi));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzee)).booleanValue()) {
            zzcxwVar.zzg(this.zzj);
        }
        zzcsk zzcskVarZzi = this.zza.zzi();
        zzcskVarZzi.zzl(zzcxwVar.zze());
        zzcskVarZzi.zzm(this.zzd);
        zzcskVarZzi.zzk(this.zzc);
        zzcskVarZzi.zzd(this.zze);
        zzcskVarZzi.zzg(new zzctg(this.zzf, this.zzh));
        zzcskVarZzi.zze(new zzcrd(this.zzg));
        zzcus zzcusVarZzc = zzcskVarZzi.zza().zzc();
        return zzcusVarZzc.zzc(zzcusVarZzc.zzb());
    }
}
