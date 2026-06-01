package com.google.android.gms.internal.appset;

import com.google.android.gms.common.util.DefaultClock;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    public /* synthetic */ zzj(zzl zzlVar, zzi zziVar) {
        this.zza = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long jZza = this.zza.zza();
        if (jZza == -1 || DefaultClock.getInstance().currentTimeMillis() <= jZza) {
            return;
        }
        zzl.zze(this.zza.zzb);
    }
}
