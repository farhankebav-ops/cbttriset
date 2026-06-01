package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzgui extends zzguk {
    public static j2.q zza(Object obj) {
        return obj == null ? zzgum.zza : new zzgum(obj);
    }

    public static j2.q zzb() {
        return zzgum.zza;
    }

    public static j2.q zzc(Throwable th) {
        th.getClass();
        return new zzgul(th);
    }

    public static j2.q zzd(Callable callable, Executor executor) {
        zzgvh zzgvhVar = new zzgvh(callable);
        executor.execute(zzgvhVar);
        return zzgvhVar;
    }

    public static j2.q zze(Runnable runnable, Executor executor) {
        zzgvh zzgvhVarZze = zzgvh.zze(runnable, null);
        executor.execute(zzgvhVarZze);
        return zzgvhVarZze;
    }

    public static j2.q zzf(zzgtp zzgtpVar, Executor executor) {
        zzgvh zzgvhVar = new zzgvh(zzgtpVar);
        executor.execute(zzgvhVar);
        return zzgvhVar;
    }

    public static j2.q zzg(j2.q qVar, Class cls, zzglu zzgluVar, Executor executor) {
        int i2 = zzgta.zzd;
        zzgsz zzgszVar = new zzgsz(qVar, cls, zzgluVar);
        qVar.addListener(zzgszVar, zzguz.zzd(executor, zzgszVar));
        return zzgszVar;
    }

    public static j2.q zzh(j2.q qVar, Class cls, zzgtq zzgtqVar, Executor executor) {
        int i2 = zzgta.zzd;
        zzgsy zzgsyVar = new zzgsy(qVar, cls, zzgtqVar);
        qVar.addListener(zzgsyVar, zzguz.zzd(executor, zzgsyVar));
        return zzgsyVar;
    }

    public static j2.q zzi(j2.q qVar, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return qVar.isDone() ? qVar : zzgve.zze(qVar, j, timeUnit, scheduledExecutorService);
    }

    public static j2.q zzj(j2.q qVar, zzgtq zzgtqVar, Executor executor) {
        int i2 = zzgth.zzc;
        zzgtf zzgtfVar = new zzgtf(qVar, zzgtqVar);
        qVar.addListener(zzgtfVar, zzguz.zzd(executor, zzgtfVar));
        return zzgtfVar;
    }

    public static j2.q zzk(j2.q qVar, zzglu zzgluVar, Executor executor) {
        int i2 = zzgth.zzc;
        zzgtg zzgtgVar = new zzgtg(qVar, zzgluVar);
        qVar.addListener(zzgtgVar, zzguz.zzd(executor, zzgtgVar));
        return zzgtgVar;
    }

    @SafeVarargs
    public static j2.q zzl(j2.q... qVarArr) {
        return new zzgtr(zzgpe.zzr(qVarArr), true);
    }

    public static j2.q zzm(Iterable iterable) {
        return new zzgtr(zzgpe.zzp(iterable), true);
    }

    public static zzguh zzn(Iterable iterable) {
        return new zzguh(false, zzgpe.zzp(iterable), null);
    }

    @SafeVarargs
    public static zzguh zzo(j2.q... qVarArr) {
        return new zzguh(true, zzgpe.zzr(qVarArr), null);
    }

    public static zzguh zzp(Iterable iterable) {
        return new zzguh(true, zzgpe.zzp(iterable), null);
    }

    @SafeVarargs
    public static j2.q zzq(j2.q... qVarArr) {
        return new zzgtr(zzgpe.zzr(qVarArr), false);
    }

    public static void zzr(j2.q qVar, zzguf zzgufVar, Executor executor) {
        zzgufVar.getClass();
        qVar.addListener(new zzgug(qVar, zzgufVar), executor);
    }

    public static Object zzs(Future future) throws ExecutionException {
        if (future.isDone()) {
            return zzgvj.zza(future);
        }
        throw new IllegalStateException(zzgmu.zzd("Future was expected to be done: %s", future));
    }

    public static Object zzt(Future future) {
        try {
            return zzgvj.zza(future);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof Error) {
                throw new zzgty((Error) e.getCause());
            }
            throw new zzgvi(e.getCause());
        }
    }
}
