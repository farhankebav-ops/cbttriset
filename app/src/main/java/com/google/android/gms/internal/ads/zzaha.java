package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzaha implements zzao {
    public final float zza;
    public final int zzb;

    public zzaha(float f4, int i2) {
        this.zza = f4;
        this.zzb = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaha.class == obj.getClass()) {
            zzaha zzahaVar = (zzaha) obj;
            if (this.zza == zzahaVar.zza && this.zzb == zzahaVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.floatToIntBits(this.zza) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb;
    }

    public final String toString() {
        float f4 = this.zza;
        int length = String.valueOf(f4).length();
        int i2 = this.zzb;
        StringBuilder sb = new StringBuilder(length + 47 + String.valueOf(i2).length());
        sb.append("smta: captureFrameRate=");
        sb.append(f4);
        sb.append(", svcTemporalLayerCount=");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
