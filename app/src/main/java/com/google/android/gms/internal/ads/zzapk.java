package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzapk implements Runnable {
    private final zzapu zza;
    private final zzaqa zzb;
    private final Runnable zzc;

    public zzapk(zzapu zzapuVar, zzaqa zzaqaVar, Runnable runnable) {
        this.zza = zzapuVar;
        this.zzb = zzaqaVar;
        this.zzc = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzapu zzapuVar = this.zza;
        zzapuVar.zzl();
        zzaqa zzaqaVar = this.zzb;
        if (zzaqaVar.zzc()) {
            zzapuVar.zzs(zzaqaVar.zza);
        } else {
            zzapuVar.zzt(zzaqaVar.zzc);
        }
        if (zzaqaVar.zzd) {
            zzapuVar.zzc("intermediate-response");
        } else {
            zzapuVar.zzd("done");
        }
        Runnable runnable = this.zzc;
        if (runnable != null) {
            runnable.run();
        }
    }
}
