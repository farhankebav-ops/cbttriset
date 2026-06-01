package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import com.ironsource.C2393j8;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzdpj {
    private final Executor zza;
    private final zzcql zzb;
    private final zzdgp zzc;
    private final zzcpe zzd;

    public zzdpj(Executor executor, zzcql zzcqlVar, zzdgp zzdgpVar, zzcpe zzcpeVar) {
        this.zza = executor;
        this.zzc = zzdgpVar;
        this.zzb = zzcqlVar;
        this.zzd = zzcpeVar;
    }

    public final void zza(final zzcgy zzcgyVar) {
        if (zzcgyVar == null) {
            return;
        }
        zzdgp zzdgpVar = this.zzc;
        zzdgpVar.zza(zzcgyVar.zzE());
        zzbau zzbauVar = new zzbau() { // from class: com.google.android.gms.internal.ads.zzdpi
            @Override // com.google.android.gms.internal.ads.zzbau
            public final /* synthetic */ void zzdo(zzbat zzbatVar) {
                Rect rect = zzbatVar.zzd;
                zzcgyVar.zzP().zza(rect.left, rect.top, false);
            }
        };
        Executor executor = this.zza;
        zzdgpVar.zzq(zzbauVar, executor);
        zzdgpVar.zzq(new zzbau() { // from class: com.google.android.gms.internal.ads.zzdpf
            @Override // com.google.android.gms.internal.ads.zzbau
            public final /* synthetic */ void zzdo(zzbat zzbatVar) {
                HashMap map = new HashMap();
                map.put(C2393j8.k, true != zzbatVar.zzj ? "0" : "1");
                zzcgyVar.zze("onAdVisibilityChanged", map);
            }
        }, executor);
        zzcql zzcqlVar = this.zzb;
        zzdgpVar.zzq(zzcqlVar, executor);
        zzcqlVar.zza(zzcgyVar);
        zzciw zzciwVarZzP = zzcgyVar.zzP();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzlg)).booleanValue() && zzciwVarZzP != null) {
            zzcpe zzcpeVar = this.zzd;
            zzciwVarZzP.zzc(zzcpeVar);
            zzciwVarZzP.zze(zzcpeVar, null, null);
        }
        zzcgyVar.zzab("/trackActiveViewUnit", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdpg
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzb((zzcgy) obj, map);
            }
        });
        zzcgyVar.zzab("/untrackActiveViewUnit", new zzblx() { // from class: com.google.android.gms.internal.ads.zzdph
            @Override // com.google.android.gms.internal.ads.zzblx
            public final /* synthetic */ void zza(Object obj, Map map) {
                this.zza.zzc((zzcgy) obj, map);
            }
        });
    }

    public final /* synthetic */ void zzb(zzcgy zzcgyVar, Map map) {
        this.zzb.zzd();
    }

    public final /* synthetic */ void zzc(zzcgy zzcgyVar, Map map) {
        this.zzb.zzb();
    }
}
