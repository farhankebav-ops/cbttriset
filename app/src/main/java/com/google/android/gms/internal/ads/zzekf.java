package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzekf {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzctr zzc;
    private final zzekv zzd;
    private final zzfnc zze;
    private final zzgvb zzf = zzgvb.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    private zzekg zzh;
    private zzfgf zzi;

    public zzekf(Executor executor, ScheduledExecutorService scheduledExecutorService, zzctr zzctrVar, zzekv zzekvVar, zzfnc zzfncVar) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzctrVar;
        this.zzd = zzekvVar;
        this.zze = zzfncVar;
    }

    private final synchronized j2.q zzd(zzffu zzffuVar) {
        Iterator it = zzffuVar.zza.iterator();
        while (it.hasNext()) {
            zzehk zzehkVarZza = this.zzc.zza(zzffuVar.zzb, (String) it.next());
            if (zzehkVarZza != null && zzehkVarZza.zza(this.zzi, zzffuVar)) {
                return zzgui.zzi(zzehkVarZza.zzb(this.zzi, zzffuVar), zzffuVar.zzR, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgui.zzc(new zzdzv(3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final void zzb(@Nullable zzffu zzffuVar) {
        j2.q qVarZzd = zzd(zzffuVar);
        this.zzd.zze(this.zzi, zzffuVar, qVarZzd, this.zze);
        zzgui.zzr(qVarZzd, new zzeke(this, zzffuVar), this.zza);
    }

    public final synchronized j2.q zza(zzfgf zzfgfVar) {
        try {
            if (!this.zzg.getAndSet(true)) {
                List list = zzfgfVar.zzb.zza;
                if (list.isEmpty()) {
                    this.zzf.zzb(new zzekz(3, zzelc.zzb(zzfgfVar)));
                } else {
                    this.zzi = zzfgfVar;
                    zzekv zzekvVar = this.zzd;
                    this.zzh = new zzekg(zzfgfVar, zzekvVar, this.zzf);
                    zzekvVar.zzc(list);
                    zzffu zzffuVarZza = this.zzh.zza();
                    while (zzffuVarZza != null) {
                        zzb(zzffuVarZza);
                        zzffuVarZza = this.zzh.zza();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.zzf;
    }

    public final /* synthetic */ zzekg zzc() {
        return this.zzh;
    }
}
