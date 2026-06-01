package com.google.android.gms.tasks;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzi implements Runnable {
    final /* synthetic */ Task zza;
    final /* synthetic */ zzj zzb;

    public zzi(zzj zzjVar, Task task) {
        this.zzb = zzjVar;
        this.zza = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb.zzb) {
            try {
                zzj zzjVar = this.zzb;
                if (zzjVar.zzc != null) {
                    zzjVar.zzc.onComplete(this.zza);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
