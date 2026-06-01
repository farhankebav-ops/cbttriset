package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagt extends zzagq {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzagt(int i2, int i8, int i9, int[] iArr, int[] iArr2) {
        super("MLLT");
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = iArr;
        this.zze = iArr2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagt.class == obj.getClass()) {
            zzagt zzagtVar = (zzagt) obj;
            if (this.zza == zzagtVar.zza && this.zzb == zzagtVar.zzb && this.zzc == zzagtVar.zzc && Arrays.equals(this.zzd, zzagtVar.zzd) && Arrays.equals(this.zze, zzagtVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int[] iArr = this.zzd;
        int iHashCode = Arrays.hashCode(iArr) + (((((i2 * 31) + this.zzb) * 31) + this.zzc) * 31);
        return Arrays.hashCode(this.zze) + (iHashCode * 31);
    }
}
