package com.google.android.gms.internal.ads;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzex implements zzao {
    public final float zza;
    public final float zzb;

    public zzex(@FloatRange(from = -90.0d, to = 90.0d) float f4, @FloatRange(from = -180.0d, to = 180.0d) float f8) {
        boolean z2 = false;
        if (f4 >= -90.0f && f4 <= 90.0f && f8 >= -180.0f && f8 <= 180.0f) {
            z2 = true;
        }
        zzgmd.zzb(z2, "Invalid latitude or longitude");
        this.zza = f4;
        this.zzb = f8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzex.class == obj.getClass()) {
            zzex zzexVar = (zzex) obj;
            if (this.zza == zzexVar.zza && this.zzb == zzexVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iFloatToIntBits = Float.floatToIntBits(this.zza) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        return Float.floatToIntBits(this.zzb) + (iFloatToIntBits * 31);
    }

    public final String toString() {
        float f4 = this.zza;
        int length = String.valueOf(f4).length();
        float f8 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 26 + String.valueOf(f8).length());
        sb.append("xyz: latitude=");
        sb.append(f4);
        sb.append(", longitude=");
        sb.append(f8);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
