package com.google.android.play.core.appupdate.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq extends zzn {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzn zzb;
    final /* synthetic */ zzx zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzq(zzx zzxVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzn zznVar) {
        super(taskCompletionSource);
        this.zzc = zzxVar;
        this.zza = taskCompletionSource2;
        this.zzb = zznVar;
    }

    @Override // com.google.android.play.core.appupdate.internal.zzn
    public final void zza() {
        synchronized (this.zzc.zzg) {
            try {
                zzx.zzn(this.zzc, this.zza);
                if (this.zzc.zzl.getAndIncrement() > 0) {
                    this.zzc.zzc.zzd("Already connected to the service.", new Object[0]);
                }
                zzx.zzp(this.zzc, this.zzb);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
