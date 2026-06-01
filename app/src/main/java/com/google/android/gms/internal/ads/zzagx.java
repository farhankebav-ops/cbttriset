package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
@Deprecated
public class zzagx implements zzao {
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzagx(long j, long j3, long j8, long j9, long j10) {
        this.zza = j;
        this.zzb = j3;
        this.zzc = j8;
        this.zzd = j9;
        this.zze = j10;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagx zzagxVar = (zzagx) obj;
            if (this.zza == zzagxVar.zza && this.zzb == zzagxVar.zzb && this.zzc == zzagxVar.zzc && this.zzd == zzagxVar.zzd && this.zze == zzagxVar.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zza;
        int i2 = ((int) (j ^ (j >>> 32))) + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        long j3 = this.zzb;
        int i8 = (i2 * 31) + ((int) (j3 ^ (j3 >>> 32)));
        long j8 = this.zzc;
        int i9 = (i8 * 31) + ((int) (j8 ^ (j8 >>> 32)));
        long j9 = this.zzd;
        int i10 = (i9 * 31) + ((int) (j9 ^ (j9 >>> 32)));
        long j10 = this.zze;
        return (i10 * 31) + ((int) ((j10 >>> 32) ^ j10));
    }

    public final String toString() {
        long j = this.zza;
        int length = String.valueOf(j).length();
        long j3 = this.zzb;
        int length2 = String.valueOf(j3).length();
        long j8 = this.zzc;
        int length3 = String.valueOf(j8).length();
        long j9 = this.zzd;
        int length4 = String.valueOf(j9).length();
        long j10 = this.zze;
        StringBuilder sb = new StringBuilder(length + 54 + length2 + 31 + length3 + 21 + length4 + 12 + String.valueOf(j10).length());
        androidx.camera.core.processing.util.a.y(sb, "Motion photo metadata: photoStartPosition=", j, ", photoSize=");
        sb.append(j3);
        androidx.camera.core.processing.util.a.y(sb, ", photoPresentationTimestampUs=", j8, ", videoStartPosition=");
        sb.append(j9);
        sb.append(", videoSize=");
        sb.append(j10);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzao
    public final /* synthetic */ void zza(zzam zzamVar) {
        g.a(this, zzamVar);
    }
}
