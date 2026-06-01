package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzhx extends FutureTask implements Comparable {
    final boolean zza;
    final /* synthetic */ zzhz zzb;
    private final long zzc;
    private final String zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhx(zzhz zzhzVar, Runnable runnable, boolean z2, String str) {
        super(runnable, null);
        Objects.requireNonNull(zzhzVar);
        this.zzb = zzhzVar;
        Preconditions.checkNotNull(str);
        long andIncrement = zzhz.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = str;
        this.zza = z2;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            com.google.android.gms.ads.internal.client.a.n(zzhzVar.zzu, "Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(@NonNull Object obj) {
        zzhx zzhxVar = (zzhx) obj;
        boolean z2 = zzhxVar.zza;
        boolean z7 = this.zza;
        if (z7 != z2) {
            return !z7 ? 1 : -1;
        }
        long j = this.zzc;
        long j3 = zzhxVar.zzc;
        if (j < j3) {
            return -1;
        }
        if (j > j3) {
            return 1;
        }
        this.zzb.zzu.zzaV().zzc().zzb("Two tasks share the same index. index", Long.valueOf(j));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler;
        this.zzb.zzu.zzaV().zzb().zzb(this.zzd, th);
        if ((th instanceof zzhv) && (defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()) != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzhx(zzhz zzhzVar, Callable callable, boolean z2, String str) {
        super(callable);
        Objects.requireNonNull(zzhzVar);
        this.zzb = zzhzVar;
        Preconditions.checkNotNull("Task exception on worker thread");
        long andIncrement = zzhz.zzj.getAndIncrement();
        this.zzc = andIncrement;
        this.zzd = "Task exception on worker thread";
        this.zza = z2;
        if (andIncrement == LocationRequestCompat.PASSIVE_INTERVAL) {
            com.google.android.gms.ads.internal.client.a.n(zzhzVar.zzu, "Tasks index overflow");
        }
    }
}
