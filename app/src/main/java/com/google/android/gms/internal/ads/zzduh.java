package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbdz;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzduh implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzduh(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
        this.zzc = zzifqVar4;
    }

    public static zzduh zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4) {
        return new zzduh(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        Set setSingleton;
        final String strZza = ((zzfak) this.zza).zza();
        Context contextZza = ((zzcjv) this.zzb).zza();
        zzgus zzgusVarZzc = zzfjn.zzc();
        Map mapZzb = ((zzifl) this.zzc).zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzfJ)).booleanValue()) {
            zzbdt zzbdtVar = new zzbdt(new zzbdy(contextZza));
            zzbdtVar.zzb(new zzbds() { // from class: com.google.android.gms.internal.ads.zzdui
                @Override // com.google.android.gms.internal.ads.zzbds
                public final /* synthetic */ void zza(zzbdz.zzt.zza zzaVar) {
                    zzaVar.zzh(strZza);
                }
            });
            setSingleton = Collections.singleton(new zzdgn(new zzduk(zzbdtVar, mapZzb), zzgusVarZzc));
        } else {
            setSingleton = Collections.EMPTY_SET;
        }
        zzifp.zzb(setSingleton);
        return setSingleton;
    }
}
