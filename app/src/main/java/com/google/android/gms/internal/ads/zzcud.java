package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzcud {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final j2.q zzc;
    private volatile boolean zzd = true;

    public zzcud(Executor executor, ScheduledExecutorService scheduledExecutorService, j2.q qVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = qVar;
    }

    public final void zza(zzguf zzgufVar) {
        zzgui.zzr(this.zzc, new zzctx(this, zzgufVar), this.zza);
    }

    public final boolean zzb() {
        return this.zzd;
    }

    public final /* synthetic */ j2.q zzc(zzguf zzgufVar, j2.q qVar, zzcto zzctoVar) {
        if (zzctoVar != null) {
            zzgufVar.zzb(zzctoVar);
        }
        return zzgui.zzi(qVar, ((Long) zzbhi.zza.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final /* synthetic */ void zze(List list, final zzguf zzgufVar) {
        if (list == null || list.isEmpty()) {
            this.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcuc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzgufVar.zza(new zzdzv(3));
                }
            });
            return;
        }
        j2.q qVarZza = zzgui.zza(null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final j2.q qVar = (j2.q) it.next();
            zzgtq zzgtqVar = new zzgtq() { // from class: com.google.android.gms.internal.ads.zzctz
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ j2.q zza(Object obj) {
                    zzgufVar.zza((Throwable) obj);
                    return zzgui.zza(null);
                }
            };
            Executor executor = this.zza;
            qVarZza = zzgui.zzj(zzgui.zzh(qVarZza, Throwable.class, zzgtqVar, executor), new zzgtq() { // from class: com.google.android.gms.internal.ads.zzcua
                @Override // com.google.android.gms.internal.ads.zzgtq
                public final /* synthetic */ j2.q zza(Object obj) {
                    return this.zza.zzc(zzgufVar, qVar, (zzcto) obj);
                }
            }, executor);
        }
        zzgui.zzr(qVarZza, new zzcty(this, zzgufVar), this.zza);
    }

    public final /* synthetic */ void zzf() {
        zzcbv.zzf.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcub
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        });
    }
}
