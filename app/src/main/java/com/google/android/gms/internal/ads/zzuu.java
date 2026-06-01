package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzuu {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    private zzuu(Object obj, int i2, int i8, long j, int i9) {
        this.zza = obj;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = j;
        this.zze = i9;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzuu)) {
            return false;
        }
        zzuu zzuuVar = (zzuu) obj;
        return this.zza.equals(zzuuVar.zza) && this.zzb == zzuuVar.zzb && this.zzc == zzuuVar.zzc && this.zzd == zzuuVar.zzd && this.zze == zzuuVar.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzuu zza(Object obj) {
        return this.zza.equals(obj) ? this : new zzuu(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzuu(Object obj, int i2, int i8, long j) {
        this(obj, i2, i8, j, -1);
    }

    public zzuu(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public zzuu(Object obj, long j, int i2) {
        this(obj, -1, -1, j, i2);
    }
}
