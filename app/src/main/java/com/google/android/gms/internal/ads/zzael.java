package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzael {
    public final int zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    public zzael(int i2, byte[] bArr, int i8, int i9) {
        this.zza = i2;
        this.zzb = bArr;
        this.zzc = i8;
        this.zzd = i9;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzael.class == obj.getClass()) {
            zzael zzaelVar = (zzael) obj;
            if (this.zza == zzaelVar.zza && this.zzc == zzaelVar.zzc && this.zzd == zzaelVar.zzd && Arrays.equals(this.zzb, zzaelVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zza;
        return ((((Arrays.hashCode(this.zzb) + (i2 * 31)) * 31) + this.zzc) * 31) + this.zzd;
    }
}
