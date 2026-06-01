package com.google.android.play.core.review.internal;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzn extends zzj {
    final /* synthetic */ zzt zza;

    public zzn(zzt zztVar) {
        this.zza = zztVar;
    }

    @Override // com.google.android.play.core.review.internal.zzj
    public final void zza() {
        synchronized (this.zza.zzg) {
            try {
                if (this.zza.zzl.get() > 0 && this.zza.zzl.decrementAndGet() > 0) {
                    this.zza.zzc.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
                zzt zztVar = this.zza;
                if (zztVar.zzn != null) {
                    zztVar.zzc.zzc("Unbind from service.", new Object[0]);
                    zzt zztVar2 = this.zza;
                    zztVar2.zzb.unbindService(zztVar2.zzm);
                    this.zza.zzh = false;
                    this.zza.zzn = null;
                    this.zza.zzm = null;
                }
                this.zza.zzw();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
