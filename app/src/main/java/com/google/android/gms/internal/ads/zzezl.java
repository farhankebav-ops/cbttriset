package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezl implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;
    private final zzifq zzc;

    private zzezl(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar3;
        this.zzc = zzifqVar4;
    }

    public static zzezl zza(zzifq zzifqVar, zzifq zzifqVar2, zzifq zzifqVar3, zzifq zzifqVar4, zzifq zzifqVar5) {
        return new zzezl(zzifqVar, zzifqVar2, zzifqVar3, zzifqVar4, zzifqVar5);
    }

    public static zzezj zzc(String str, zzbcw zzbcwVar, zzcbj zzcbjVar, ScheduledExecutorService scheduledExecutorService, zzgus zzgusVar) {
        return new zzezj(str, zzbcwVar, zzcbjVar, scheduledExecutorService, zzgusVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzezj(((zzfag) this.zza).zza(), zzcnf.zza(), (zzcbj) this.zzb.zzb(), (ScheduledExecutorService) this.zzc.zzb(), zzfjn.zzc());
    }
}
