package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagi extends zzagq {
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzagq[] zzg;

    public zzagi(String str, int i2, int i8, long j, long j3, zzagq[] zzagqVarArr) {
        super("CHAP");
        this.zza = str;
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = j;
        this.zze = j3;
        this.zzg = zzagqVarArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagi.class == obj.getClass()) {
            zzagi zzagiVar = (zzagi) obj;
            if (this.zzb == zzagiVar.zzb && this.zzc == zzagiVar.zzc && this.zzd == zzagiVar.zzd && this.zze == zzagiVar.zze && Objects.equals(this.zza, zzagiVar.zza) && Arrays.equals(this.zzg, zzagiVar.zzg)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str = this.zza;
        long j = this.zze;
        return str.hashCode() + (((((((i2 * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + ((int) j)) * 31);
    }
}
