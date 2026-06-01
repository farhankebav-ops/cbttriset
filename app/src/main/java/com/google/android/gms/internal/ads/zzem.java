package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.core.location.LocationRequestCompat;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzem {

    @GuardedBy("this")
    private long zza;

    @GuardedBy("this")
    private long zzb;

    @GuardedBy("this")
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzem(long j) {
        zzd(0L);
    }

    public static long zzi(long j) {
        return zzep.zzt(j, 1000000L, 90000L, RoundingMode.DOWN);
    }

    public static long zzj(long j) {
        return zzep.zzt(j, 90000L, 1000000L, RoundingMode.DOWN);
    }

    public final synchronized long zza() {
        long j = this.zza;
        if (j == LocationRequestCompat.PASSIVE_INTERVAL || j == 9223372036854775806L) {
            return -9223372036854775807L;
        }
        return j;
    }

    public final synchronized long zzb() {
        long j;
        try {
            j = this.zzc;
        } catch (Throwable th) {
            throw th;
        }
        return j != -9223372036854775807L ? j + this.zzb : zza();
    }

    public final synchronized long zzc() {
        return this.zzb;
    }

    public final synchronized void zzd(long j) {
        this.zza = j;
        this.zzb = j == LocationRequestCompat.PASSIVE_INTERVAL ? 0L : -9223372036854775807L;
        this.zzc = -9223372036854775807L;
    }

    public final synchronized long zze(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            long j3 = this.zzc;
            if (j3 != -9223372036854775807L) {
                long jZzj = zzj(j3);
                long j8 = (4294967296L + jZzj) / 8589934592L;
                long j9 = (((-1) + j8) * 8589934592L) + j;
                long j10 = (j8 * 8589934592L) + j;
                j = Math.abs(j9 - jZzj) < Math.abs(j10 - jZzj) ? j9 : j10;
            }
            return zzg(zzi(j));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized long zzf(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j3 = this.zzc;
        if (j3 != -9223372036854775807L) {
            long jZzj = zzj(j3);
            long j8 = jZzj / 8589934592L;
            Long.signum(j8);
            long j9 = (j8 * 8589934592L) + j;
            j = j9 >= jZzj ? j9 : ((j8 + 1) * 8589934592L) + j;
        }
        return zzg(zzi(j));
    }

    public final synchronized long zzg(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        try {
            if (!zzh()) {
                long jLongValue = this.zza;
                if (jLongValue == 9223372036854775806L) {
                    Long l = (Long) this.zzd.get();
                    if (l == null) {
                        throw null;
                    }
                    jLongValue = l.longValue();
                }
                this.zzb = jLongValue - j;
                notifyAll();
            }
            this.zzc = j;
            return j + this.zzb;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean zzh() {
        return this.zzb != -9223372036854775807L;
    }
}
