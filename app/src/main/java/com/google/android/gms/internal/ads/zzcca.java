package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzcca implements j2.q {
    private final zzgvb zza = zzgvb.zze();

    private static final boolean zza(boolean z2) {
        if (!z2) {
            com.google.android.gms.ads.internal.zzt.zzh().zzh(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z2;
    }

    @Override // j2.q
    public final void addListener(Runnable runnable, Executor executor) {
        this.zza.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        return this.zza.cancel(z2);
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final boolean zzc(@Nullable Object obj) {
        boolean zZza = this.zza.zza(obj);
        zza(zZza);
        return zZza;
    }

    public final boolean zzd(Throwable th) {
        boolean zZzb = this.zza.zzb(th);
        zza(zZzb);
        return zZzb;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
