package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzecg implements zzeci {
    private final Map zza;
    private final zzgus zzb;
    private final zzdbs zzc;

    public zzecg(Map map, zzgus zzgusVar, zzdbs zzdbsVar) {
        this.zza = map;
        this.zzb = zzgusVar;
        this.zzc = zzdbsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeci
    public final j2.q zza(final zzbxj zzbxjVar) {
        this.zzc.zzdT(zzbxjVar);
        j2.q qVarZzc = zzgui.zzc(new zzdzv(3));
        for (String str : ((String) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjc)).split(",")) {
            final zzifw zzifwVar = (zzifw) this.zza.get(str.trim());
            if (zzifwVar != null) {
                qVarZzc = zzgui.zzh(qVarZzc, zzdzv.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzecf
                    @Override // com.google.android.gms.internal.ads.zzgtq
                    public final /* synthetic */ j2.q zza(Object obj) {
                        return ((zzeci) zzifwVar.zzb()).zza(zzbxjVar);
                    }
                }, this.zzb);
            }
        }
        zzgui.zzr(qVarZzc, new zzece(this), zzcbv.zzg);
        return qVarZzc;
    }

    public final /* synthetic */ zzdbs zzb() {
        return this.zzc;
    }
}
