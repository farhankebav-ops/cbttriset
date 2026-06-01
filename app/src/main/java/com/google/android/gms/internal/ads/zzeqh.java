package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeqh implements zzeya {
    private final j2.q zza;
    private final Executor zzb;
    private final ScheduledExecutorService zzc;

    public zzeqh(j2.q qVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = qVar;
        this.zzb = executor;
        this.zzc = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final j2.q zza() {
        j2.q qVar = this.zza;
        zzeqg zzeqgVar = zzeqg.zza;
        Executor executor = this.zzb;
        j2.q qVarZzj = zzgui.zzj(qVar, zzeqgVar, executor);
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzny)).intValue() > 0) {
            qVarZzj = zzgui.zzi(qVarZzj, ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(r1)).intValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzgui.zzh(qVarZzj, Throwable.class, zzeqf.zza, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzeya
    public final int zzb() {
        return 6;
    }
}
