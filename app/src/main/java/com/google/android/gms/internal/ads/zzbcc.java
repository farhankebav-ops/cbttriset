package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbcc {
    final long zza;
    final String zzb;
    final int zzc;

    public zzbcc(long j, String str, int i2) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof zzbcc)) {
            return false;
        }
        zzbcc zzbccVar = (zzbcc) obj;
        return zzbccVar.zza == this.zza && zzbccVar.zzc == this.zzc;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
