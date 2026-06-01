package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmj {
    public final long zza;
    public final zzbf zzb;
    public final int zzc;

    @Nullable
    public final zzuu zzd;
    public final long zze;
    public final zzbf zzf;
    public final int zzg;

    @Nullable
    public final zzuu zzh;
    public final long zzi;
    public final long zzj;

    public zzmj(long j, zzbf zzbfVar, int i2, @Nullable zzuu zzuuVar, long j3, zzbf zzbfVar2, int i8, @Nullable zzuu zzuuVar2, long j8, long j9) {
        this.zza = j;
        this.zzb = zzbfVar;
        this.zzc = i2;
        this.zzd = zzuuVar;
        this.zze = j3;
        this.zzf = zzbfVar2;
        this.zzg = i8;
        this.zzh = zzuuVar2;
        this.zzi = j8;
        this.zzj = j9;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmj.class == obj.getClass()) {
            zzmj zzmjVar = (zzmj) obj;
            if (this.zza == zzmjVar.zza && this.zzc == zzmjVar.zzc && this.zze == zzmjVar.zze && this.zzg == zzmjVar.zzg && this.zzi == zzmjVar.zzi && this.zzj == zzmjVar.zzj && Objects.equals(this.zzb, zzmjVar.zzb) && Objects.equals(this.zzd, zzmjVar.zzd) && Objects.equals(this.zzf, zzmjVar.zzf) && Objects.equals(this.zzh, zzmjVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
