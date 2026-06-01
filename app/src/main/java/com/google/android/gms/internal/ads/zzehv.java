package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzehv implements zzehk {
    private final zzcqu zza;
    private final zzdse zzb;
    private final zzfgn zzc;
    private final Executor zzd;
    private final VersionInfoParcel zze;
    private final zzbma zzf;
    private final boolean zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjS)).booleanValue();
    private final zzegj zzh;
    private final zzdvc zzi;
    private final zzdvi zzj;

    public zzehv(zzcqu zzcquVar, Context context, Executor executor, zzdse zzdseVar, zzfgn zzfgnVar, VersionInfoParcel versionInfoParcel, zzbma zzbmaVar, zzegj zzegjVar, zzdvc zzdvcVar, zzdvi zzdviVar) {
        this.zza = zzcquVar;
        this.zzd = executor;
        this.zzb = zzdseVar;
        this.zzc = zzfgnVar;
        this.zze = versionInfoParcel;
        this.zzf = zzbmaVar;
        this.zzh = zzegjVar;
        this.zzi = zzdvcVar;
        this.zzj = zzdviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final boolean zza(zzfgf zzfgfVar, zzffu zzffuVar) {
        zzffz zzffzVar = zzffuVar.zzs;
        return (zzffzVar == null || zzffzVar.zza == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzehk
    public final j2.q zzb(final zzfgf zzfgfVar, final zzffu zzffuVar) {
        final zzdsi zzdsiVar = new zzdsi();
        j2.q qVarZza = zzgui.zza(null);
        zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzeht
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc(zzffuVar, zzfgfVar, zzdsiVar, obj);
            }
        };
        Executor executor = this.zzd;
        j2.q qVarZzj = zzgui.zzj(qVarZza, zzgtqVar, executor);
        qVarZzj.addListener(new Runnable(zzdsiVar) { // from class: com.google.android.gms.internal.ads.zzehu
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
            }
        }, executor);
        return qVarZzj;
    }

    public final /* synthetic */ j2.q zzc(final zzffu zzffuVar, zzfgf zzfgfVar, zzdsi zzdsiVar, Object obj) throws zzchn {
        zzbel zzbelVar = zzbeu.zzcy;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzi.zze(), zzduq.RENDERING_WEBVIEW_CREATION_START.zza());
        }
        zzdse zzdseVar = this.zzb;
        zzfgn zzfgnVar = this.zzc;
        final zzcgy zzcgyVarZza = zzdseVar.zza(zzfgnVar.zzf, zzffuVar, zzfgfVar.zzb.zzb);
        zzcgyVarZza.zzaw(zzffuVar.zzW);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzi.zze(), zzduq.RENDERING_WEBVIEW_CREATION_END.zza());
        }
        zzcca zzccaVar = new zzcca();
        zzcqu zzcquVar = this.zza;
        zzcue zzcueVar = new zzcue(zzfgfVar, zzffuVar, null);
        VersionInfoParcel versionInfoParcel = this.zze;
        boolean z2 = this.zzg;
        zzbma zzbmaVar = this.zzf;
        final zzcqr zzcqrVarZzf = zzcquVar.zzf(zzcueVar, new zzdia(new zzehx(versionInfoParcel, zzccaVar, zzffuVar, zzcgyVarZza, zzfgnVar, z2, zzbmaVar, this.zzh, this.zzj), zzcgyVarZza), new zzcqs(zzffuVar.zzaa));
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbelVar)).booleanValue()) {
            com.google.android.gms.ads.internal.client.a.m(this.zzi.zze(), zzduq.RENDERING_AD_COMPONENT_CREATION_END.zza());
        }
        zzdsd zzdsdVarZzi = zzcqrVarZzf.zzi();
        zzbma zzbmaVar2 = true == z2 ? zzbmaVar : null;
        zzdvc zzdvcVar = this.zzi;
        zzdsdVarZzi.zzi(zzcgyVarZza, false, zzbmaVar2, zzdvcVar.zze());
        zzccaVar.zzc(zzcqrVarZzf);
        zzcqrVarZzf.zzd().zzq(new zzczi() { // from class: com.google.android.gms.internal.ads.zzehr
            @Override // com.google.android.gms.internal.ads.zzczi
            public final /* synthetic */ void zzdw() {
                zzcgy zzcgyVar = zzcgyVarZza;
                if (zzcgyVar.zzP() != null) {
                    zzcgyVar.zzP().zzq();
                }
            }
        }, zzcbv.zzg);
        zzffz zzffzVar = zzffuVar.zzs;
        String strZza = zzffzVar.zza;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfS)).booleanValue() && zzcqrVarZzf.zzk().zza(true)) {
            strZza = zzcip.zza(strZza, zzcip.zzb(zzffuVar));
        }
        zzcqrVarZzf.zzi();
        return zzgui.zzk(zzdsd.zzj(zzcgyVarZza, zzffzVar.zzb, strZza, zzdvcVar.zze(), zzcquVar.zzd()), new zzglu(this) { // from class: com.google.android.gms.internal.ads.zzehs
            @Override // com.google.android.gms.internal.ads.zzglu
            public final /* synthetic */ Object apply(Object obj2) {
                zzcgy zzcgyVar = zzcgyVarZza;
                if (zzffuVar.zzM) {
                    zzcgyVar.zzav();
                }
                zzcqr zzcqrVar = zzcqrVarZzf;
                zzcgyVar.zzJ();
                zzcgyVar.onPause();
                return zzcqrVar.zzh();
            }
        }, this.zzd);
    }
}
