package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzagy {
    public final long zza;
    public final long zzb;
    public final int zzc;

    public zzagy(long j, long j3, int i2) {
        zzgmd.zza(j < j3);
        this.zza = j;
        this.zzb = j3;
        this.zzc = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzagy.class == obj.getClass()) {
            zzagy zzagyVar = (zzagy) obj;
            if (this.zza == zzagyVar.zza && this.zzb == zzagyVar.zzb && this.zzc == zzagyVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Long.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    public final String toString() {
        long j = this.zza;
        long j3 = this.zzb;
        int i2 = this.zzc;
        String str = zzep.zza;
        Locale locale = Locale.US;
        StringBuilder sbT = androidx.camera.core.processing.util.a.t("Segment: startTimeMs=", j, ", endTimeMs=");
        sbT.append(j3);
        sbT.append(", speedDivisor=");
        sbT.append(i2);
        return sbT.toString();
    }
}
