package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvw {
    public final int zza;
    public final boolean zzb;

    public zzvw(int i2, boolean z2) {
        this.zza = i2;
        this.zzb = z2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzvw.class == obj.getClass()) {
            zzvw zzvwVar = (zzvw) obj;
            if (this.zza == zzvwVar.zza && this.zzb == zzvwVar.zzb) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza * 31) + (this.zzb ? 1 : 0);
    }
}
