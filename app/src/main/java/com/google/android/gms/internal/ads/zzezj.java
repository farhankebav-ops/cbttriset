package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzezj implements zzeya {
    private final zzcbj zza;
    private final ScheduledExecutorService zzb;
    private final zzgus zzc;

    public zzezj(String str, zzbcw zzbcwVar, zzcbj zzcbjVar, ScheduledExecutorService scheduledExecutorService, zzgus zzgusVar) {
        this.zza = zzcbjVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzgusVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdt)).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzdy)).booleanValue()) {
                j2.q qVarZza = zzfxf.zza(Tasks.forResult(null), null);
                zzgus zzgusVar = this.zzc;
                j2.q qVarZzj = zzgui.zzj(qVarZza, zzezi.zza, zzgusVar);
                if (((Boolean) zzbgh.zza.zze()).booleanValue()) {
                    qVarZzj = zzgui.zzi(qVarZzj, ((Long) zzbgh.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
                }
                return zzgui.zzg(qVarZzj, Exception.class, new zzglu() { // from class: com.google.android.gms.internal.ads.zzezh
                    @Override // com.google.android.gms.internal.ads.zzglu
                    public final /* synthetic */ Object apply(Object obj) {
                        return this.zza.zzc((Exception) obj);
                    }
                }, zzgusVar);
            }
        }
        return zzgui.zza(new zzezk(null, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 43;
    }

    public final /* synthetic */ zzezk zzc(Exception exc) {
        this.zza.zzg(exc, "AppSetIdInfoGmscoreSignal");
        return new zzezk(null, -1);
    }
}
