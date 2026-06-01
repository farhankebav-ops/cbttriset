package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzoa {

    @VisibleForTesting
    protected long zza;

    @VisibleForTesting
    protected long zzb;
    final /* synthetic */ zzoc zzc;
    private final zzay zzd;

    public zzoa(zzoc zzocVar) {
        Objects.requireNonNull(zzocVar);
        this.zzc = zzocVar;
        this.zzd = new zznz(this, zzocVar.zzu);
        long jElapsedRealtime = zzocVar.zzu.zzaZ().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    @WorkerThread
    public final void zza(long j) {
        this.zzc.zzg();
        this.zzd.zzd();
        this.zza = j;
        this.zzb = j;
    }

    @WorkerThread
    public final void zzb(long j) {
        this.zzd.zzd();
    }

    public final void zzc() {
        this.zzd.zzd();
        long jElapsedRealtime = this.zzc.zzu.zzaZ().elapsedRealtime();
        this.zza = jElapsedRealtime;
        this.zzb = jElapsedRealtime;
    }

    @WorkerThread
    public final boolean zzd(boolean z2, boolean z7, long j) {
        zzoc zzocVar = this.zzc;
        zzocVar.zzg();
        zzocVar.zzb();
        if (zzocVar.zzu.zzB()) {
            zzic zzicVar = zzocVar.zzu;
            zzicVar.zzd().zzk.zzb(zzicVar.zzaZ().currentTimeMillis());
        }
        long j3 = j - this.zza;
        if (!z2 && j3 < 1000) {
            zzocVar.zzu.zzaV().zzk().zzb("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j3));
            return false;
        }
        if (!z7) {
            j3 = j - this.zzb;
            this.zzb = j;
        }
        zzic zzicVar2 = zzocVar.zzu;
        zzicVar2.zzaV().zzk().zzb("Recording user engagement, ms", Long.valueOf(j3));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j3);
        boolean z8 = !zzicVar2.zzc().zzv();
        zzic zzicVar3 = zzocVar.zzu;
        zzpp.zzav(zzicVar3.zzs().zzh(z8), bundle, true);
        if (!z7) {
            zzicVar3.zzj().zzF("auto", "_e", bundle);
        }
        this.zza = j;
        zzay zzayVar = this.zzd;
        zzayVar.zzd();
        zzayVar.zzb(((Long) zzfy.zzaq.zzb(null)).longValue());
        return true;
    }
}
