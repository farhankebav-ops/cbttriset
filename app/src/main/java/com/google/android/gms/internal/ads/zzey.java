package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzey implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzey(long j, long j3, long j8) {
        this.zza = j;
        this.zzb = j3;
        this.zzc = j8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzey)) {
            return false;
        }
        zzey zzeyVar = (zzey) obj;
        return this.zza == zzeyVar.zza && this.zzb == zzeyVar.zzb && this.zzc == zzeyVar.zzc;
    }

    public final int hashCode() {
        long j = this.zza;
        int i2 = ((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        long j3 = this.zzb;
        int i8 = (i2 * 31) + ((int) (j3 ^ (j3 >>> 32)));
        long j8 = this.zzc;
        return (i8 * 31) + ((int) ((j8 >>> 32) ^ j8));
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        long j3 = this.zzb;
        int length2 = String.valueOf(j3).length();
        long j8 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 48 + length2 + 12 + String.valueOf(j8).length());
        androidx.camera.core.processing.util.a.y(sb, "Mp4Timestamp: creation time=", j, ", modification time=");
        sb.append(j3);
        sb.append(", timescale=");
        sb.append(j8);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
