package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzkq {
    public final zzuu zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final boolean zzj;

    public zzkq(zzuu zzuuVar, long j, long j3, long j8, long j9, boolean z2, boolean z7, boolean z8, boolean z9, boolean z10) {
        boolean z11 = true;
        zzgmd.zza(!z10 || z8);
        if (z9 && !z8) {
            z11 = false;
        }
        zzgmd.zza(z11);
        this.zza = zzuuVar;
        this.zzb = j;
        this.zzc = j3;
        this.zzd = j8;
        this.zze = j9;
        this.zzf = false;
        this.zzg = false;
        this.zzh = z8;
        this.zzi = z9;
        this.zzj = z10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzkq.class == obj.getClass()) {
            zzkq zzkqVar = (zzkq) obj;
            if (this.zzb == zzkqVar.zzb && this.zzc == zzkqVar.zzc && this.zzd == zzkqVar.zzd && this.zze == zzkqVar.zze && this.zzh == zzkqVar.zzh && this.zzi == zzkqVar.zzi && this.zzj == zzkqVar.zzj && Objects.equals(this.zza, zzkqVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        long j = this.zze;
        long j3 = this.zzd;
        return (((((((((((((iHashCode * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) j3)) * 31) + ((int) j)) * 29791) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0);
    }

    public final zzkq zza(long j) {
        return j == this.zzb ? this : new zzkq(this.zza, j, this.zzc, this.zzd, this.zze, false, false, this.zzh, this.zzi, this.zzj);
    }

    public final zzkq zzb(long j) {
        return j == this.zzc ? this : new zzkq(this.zza, this.zzb, j, this.zzd, this.zze, false, false, this.zzh, this.zzi, this.zzj);
    }
}
