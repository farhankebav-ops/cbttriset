package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzgug implements Runnable {
    final Future zza;
    final zzguf zzb;

    public zzgug(Future future, zzguf zzgufVar) {
        this.zza = future;
        this.zzb = zzgufVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable thZza;
        Future future = this.zza;
        if ((future instanceof zzgvk) && (thZza = zzgvl.zza((zzgvk) future)) != null) {
            this.zzb.zza(thZza);
            return;
        }
        try {
            this.zzb.zzb(zzgui.zzs(future));
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th) {
            this.zzb.zza(th);
        }
    }

    public final String toString() {
        zzglz zzglzVarZzb = zzgma.zzb(this);
        zzglzVarZzb.zza(this.zzb);
        return zzglzVarZzb.toString();
    }
}
