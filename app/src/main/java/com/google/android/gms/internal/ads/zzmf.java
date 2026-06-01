package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzmf extends IllegalStateException {
    public final int zza;
    public final int zzb;

    public zzmf(int i2, int i8) {
        super(i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i8).length() + 31), "Player stuck suppressed for ", i8, " ms") : com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i8).length() + 43), "Player stuck playing without ending for ", i8, " ms") : com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i8).length() + 45), "Player stuck playing with no progress for ", i8, " ms") : com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i8).length() + 47), "Player stuck buffering with no progress for ", i8, " ms") : com.google.android.gms.ads.internal.client.a.j(new StringBuilder(String.valueOf(i8).length() + 46), "Player stuck buffering and not loading for ", i8, " ms"));
        this.zza = i2;
        this.zzb = i8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzmf.class == obj.getClass()) {
            zzmf zzmfVar = (zzmf) obj;
            if (this.zza == zzmfVar.zza && this.zzb == zzmfVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb;
    }
}
