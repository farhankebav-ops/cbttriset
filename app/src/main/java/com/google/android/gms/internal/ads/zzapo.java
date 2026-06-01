package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzapo extends Thread {
    private final BlockingQueue zza;
    private final zzapn zzb;
    private final zzape zzc;
    private volatile boolean zzd = false;
    private final zzapl zze;

    public zzapo(BlockingQueue blockingQueue, zzapn zzapnVar, zzape zzapeVar, zzapl zzaplVar) {
        this.zza = blockingQueue;
        this.zzb = zzapnVar;
        this.zzc = zzapeVar;
        this.zze = zzaplVar;
    }

    private void zzb() throws InterruptedException {
        zzapu zzapuVar = (zzapu) this.zza.take();
        SystemClock.elapsedRealtime();
        zzapuVar.zze(3);
        try {
            try {
                zzapuVar.zzc("network-queue-take");
                zzapuVar.zzl();
                TrafficStats.setThreadStatsTag(zzapuVar.zzb());
                zzapq zzapqVarZza = this.zzb.zza(zzapuVar);
                zzapuVar.zzc("network-http-complete");
                if (zzapqVarZza.zze && zzapuVar.zzq()) {
                    zzapuVar.zzd("not-modified");
                    zzapuVar.zzw();
                } else {
                    zzaqa zzaqaVarZzr = zzapuVar.zzr(zzapqVarZza);
                    zzapuVar.zzc("network-parse-complete");
                    zzapd zzapdVar = zzaqaVarZzr.zzb;
                    if (zzapdVar != null) {
                        this.zzc.zzb(zzapuVar.zzi(), zzapdVar);
                        zzapuVar.zzc("network-cache-written");
                    }
                    zzapuVar.zzp();
                    this.zze.zza(zzapuVar, zzaqaVarZzr, null);
                    zzapuVar.zzv(zzaqaVarZzr);
                }
            } catch (zzaqd e) {
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzapuVar, e);
                zzapuVar.zzw();
            } catch (Exception e4) {
                zzaqg.zzd(e4, "Unhandled exception %s", e4.toString());
                zzaqd zzaqdVar = new zzaqd(e4);
                SystemClock.elapsedRealtime();
                this.zze.zzb(zzapuVar, zzaqdVar);
                zzapuVar.zzw();
            }
            zzapuVar.zze(4);
        } catch (Throwable th) {
            zzapuVar.zze(4);
            throw th;
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        while (true) {
            try {
                zzb();
            } catch (InterruptedException unused) {
                if (this.zzd) {
                    Thread.currentThread().interrupt();
                    return;
                }
                zzaqg.zzc("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }

    public final void zza() {
        this.zzd = true;
        interrupt();
    }
}
