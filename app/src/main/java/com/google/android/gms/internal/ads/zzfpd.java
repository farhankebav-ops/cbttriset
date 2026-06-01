package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfpd extends TimerTask {
    final /* synthetic */ zzfpf zza;
    final /* synthetic */ Timer zzb;
    final /* synthetic */ zzfpg zzc;

    public zzfpd(zzfpg zzfpgVar, zzfpf zzfpfVar, Timer timer) {
        this.zza = zzfpfVar;
        this.zzb = timer;
        Objects.requireNonNull(zzfpgVar);
        this.zzc = zzfpgVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        this.zzc.zze();
        this.zza.zza(true);
        this.zzb.cancel();
    }
}
