package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzeh {
    public static final zzeh zza = new zzeh(-1, -1);
    private final int zzb;
    private final int zzc;

    static {
        new zzeh(0, 0);
    }

    public zzeh(int i2, int i8) {
        boolean z2 = false;
        if ((i2 == -1 || i2 >= 0) && (i8 == -1 || i8 >= 0)) {
            z2 = true;
        }
        zzgmd.zza(z2);
        this.zzb = i2;
        this.zzc = i8;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeh) {
            zzeh zzehVar = (zzeh) obj;
            if (this.zzb == zzehVar.zzb && this.zzc == zzehVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzb;
        return ((i2 >>> 16) | (i2 << 16)) ^ this.zzc;
    }

    public final String toString() {
        int i2 = this.zzb;
        int length = String.valueOf(i2).length();
        int i8 = this.zzc;
        StringBuilder sb = new StringBuilder(length + 1 + String.valueOf(i8).length());
        sb.append(i2);
        sb.append("x");
        sb.append(i8);
        return sb.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }
}
