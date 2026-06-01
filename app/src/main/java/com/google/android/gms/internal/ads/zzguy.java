package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzguy extends zzguu implements zzgut, AutoCloseable {
    final ScheduledExecutorService zza;

    public zzguy(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        scheduledExecutorService.getClass();
        this.zza = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzgte, java.lang.AutoCloseable
    public final /* synthetic */ void close() {
        androidx.appcompat.app.c.v(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgut, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzgur schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorService = this.zza;
        zzgvh zzgvhVarZze = zzgvh.zze(runnable, null);
        return new zzguw(zzgvhVarZze, scheduledExecutorService.schedule(zzgvhVarZze, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgut, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzgur schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzgvh zzgvhVar = new zzgvh(callable);
        return new zzguw(zzgvhVar, this.zza.schedule(zzgvhVar, j, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgut, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzgur scheduleAtFixedRate(Runnable runnable, long j, long j3, TimeUnit timeUnit) {
        zzgux zzguxVar = new zzgux(runnable);
        return new zzguw(zzguxVar, this.zza.scheduleAtFixedRate(zzguxVar, j, j3, timeUnit));
    }

    @Override // com.google.android.gms.internal.ads.zzgut, java.util.concurrent.ScheduledExecutorService
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgur scheduleWithFixedDelay(Runnable runnable, long j, long j3, TimeUnit timeUnit) {
        zzgux zzguxVar = new zzgux(runnable);
        return new zzguw(zzguxVar, this.zza.scheduleWithFixedDelay(zzguxVar, j, j3, timeUnit));
    }
}
