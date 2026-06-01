package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzxa {
    public final long zza;
    public final long zzb;

    public zzxa(long j, long j3) {
        this.zza = j;
        this.zzb = j3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzxa)) {
            return false;
        }
        zzxa zzxaVar = (zzxa) obj;
        return this.zza == zzxaVar.zza && this.zzb == zzxaVar.zzb;
    }

    public final int hashCode() {
        return (((int) this.zza) * 31) + ((int) this.zzb);
    }
}
