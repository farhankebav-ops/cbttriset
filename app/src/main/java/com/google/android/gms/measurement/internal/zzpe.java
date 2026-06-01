package com.google.android.gms.measurement.internal;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@VisibleForTesting
final class zzpe {
    private final zzpg zza;
    private int zzb = 1;
    private long zzc = zzd();

    public zzpe(zzpg zzpgVar) {
        this.zza = zzpgVar;
    }

    private final long zzd() {
        zzpg zzpgVar = this.zza;
        Preconditions.checkNotNull(zzpgVar);
        long jLongValue = ((Long) zzfy.zzu.zzb(null)).longValue();
        long jLongValue2 = ((Long) zzfy.zzv.zzb(null)).longValue();
        for (int i2 = 1; i2 < this.zzb; i2++) {
            jLongValue += jLongValue;
            if (jLongValue >= jLongValue2) {
                break;
            }
        }
        return Math.min(jLongValue, jLongValue2) + zzpgVar.zzaZ().currentTimeMillis();
    }

    public final void zza() {
        this.zzb++;
        this.zzc = zzd();
    }

    public final boolean zzb() {
        return this.zza.zzaZ().currentTimeMillis() >= this.zzc;
    }

    public final /* synthetic */ long zzc() {
        return this.zzc;
    }
}
