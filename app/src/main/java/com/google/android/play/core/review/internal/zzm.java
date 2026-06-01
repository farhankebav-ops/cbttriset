package com.google.android.play.core.review.internal;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzm extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzj zzb;
    final /* synthetic */ zzt zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzm(zzt zztVar, TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, zzj zzjVar) {
        super(taskCompletionSource);
        this.zza = taskCompletionSource2;
        this.zzb = zzjVar;
        this.zzc = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        synchronized (this.zzc.zzg) {
            try {
                zzt.zzn(this.zzc, this.zza);
                if (this.zzc.zzl.getAndIncrement() > 0) {
                    this.zzc.zzc.zzc("Already connected to the service.", new Object[0]);
                }
                zzt.zzp(this.zzc, this.zzb);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
