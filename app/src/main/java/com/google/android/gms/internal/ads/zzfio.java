package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzfio implements zzfim {
    private final String zza;

    public zzfio(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzfim
    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzfio) {
            return this.zza.equals(((zzfio) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzfim
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
