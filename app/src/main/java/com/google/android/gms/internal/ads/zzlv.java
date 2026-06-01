package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import androidx.core.location.LocationRequestCompat;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzlv {
    public static final zzlv zza;
    public static final zzlv zzb;
    public static final zzlv zzc;
    public final long zzd;
    public final long zze;

    static {
        zzlv zzlvVar = new zzlv(0L, 0L);
        zza = zzlvVar;
        new zzlv(LocationRequestCompat.PASSIVE_INTERVAL, LocationRequestCompat.PASSIVE_INTERVAL);
        zzb = new zzlv(LocationRequestCompat.PASSIVE_INTERVAL, 0L);
        new zzlv(0L, LocationRequestCompat.PASSIVE_INTERVAL);
        zzc = zzlvVar;
    }

    public zzlv(long j, long j3) {
        zzgmd.zza(j >= 0);
        zzgmd.zza(j3 >= 0);
        this.zzd = j;
        this.zze = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlv.class == obj.getClass()) {
            zzlv zzlvVar = (zzlv) obj;
            if (this.zzd == zzlvVar.zzd && this.zze == zzlvVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzd) * 31) + ((int) this.zze);
    }
}
