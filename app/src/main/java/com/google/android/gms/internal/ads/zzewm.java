package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzewm implements zzeya {
    private final zzeya zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzewm(zzeya zzeyaVar, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzeyaVar;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        j2.q qVarZza = this.zza.zza();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcG)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j = this.zzb;
        if (j > 0) {
            qVarZza = zzgui.zzi(qVarZza, j, timeUnit, this.zzc);
        }
        return zzgui.zzh(qVarZza, Throwable.class, new zzgtq() { // from class: com.google.android.gms.internal.ads.zzewl
            @Override // com.google.android.gms.internal.ads.zzgtq
            public final /* synthetic */ j2.q zza(Object obj) {
                return this.zza.zzc((Throwable) obj);
            }
        }, zzcbv.zzg);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return this.zza.zzb();
    }

    public final /* synthetic */ j2.q zzc(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzcE)).booleanValue()) {
            zzeya zzeyaVar = this.zza;
            zzcbj zzcbjVarZzh = com.google.android.gms.ads.internal.zzt.zzh();
            int iZzb = zzeyaVar.zzb();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 22);
            sb.append("OptionalSignalTimeout:");
            sb.append(iZzb);
            zzcbjVarZzh.zzg(th, sb.toString());
        }
        return zzgui.zza(null);
    }
}
