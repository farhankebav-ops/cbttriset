package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zzgtv extends zzgup {
    private final Executor zza;
    final /* synthetic */ zzgtw zzb;

    public zzgtv(zzgtw zzgtwVar, Executor executor) {
        Objects.requireNonNull(zzgtwVar);
        this.zzb = zzgtwVar;
        executor.getClass();
        this.zza = executor;
    }

    public abstract void zzb(Object obj);

    @Override // com.google.android.gms.internal.ads.zzgup
    public final boolean zzd() {
        return this.zzb.isDone();
    }

    public final void zze() {
        try {
            this.zza.execute(this);
        } catch (RejectedExecutionException e) {
            this.zzb.zzb(e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final void zzf(Object obj) {
        this.zzb.zzD(null);
        zzb(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgup
    public final void zzg(Throwable th) {
        zzgtw zzgtwVar = this.zzb;
        zzgtwVar.zzD(null);
        if (th instanceof ExecutionException) {
            zzgtwVar.zzb(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzgtwVar.cancel(false);
        } else {
            zzgtwVar.zzb(th);
        }
    }
}
