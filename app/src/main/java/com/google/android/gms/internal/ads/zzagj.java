package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagj extends zzagq {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzagq[] zze;

    public zzagj(String str, boolean z2, boolean z7, String[] strArr, zzagq[] zzagqVarArr) {
        super("CTOC");
        this.zza = str;
        this.zzb = z2;
        this.zzc = z7;
        this.zzd = strArr;
        this.zze = zzagqVarArr;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagj.class == obj.getClass()) {
            zzagj zzagjVar = (zzagj) obj;
            if (this.zzb == zzagjVar.zzb && this.zzc == zzagjVar.zzc && Objects.equals(this.zza, zzagjVar.zza) && Arrays.equals(this.zzd, zzagjVar.zzd) && Arrays.equals(this.zze, zzagjVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = (this.zzb ? 1 : 0) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        String str = this.zza;
        return str.hashCode() + (((i2 * 31) + (this.zzc ? 1 : 0)) * 31);
    }
}
