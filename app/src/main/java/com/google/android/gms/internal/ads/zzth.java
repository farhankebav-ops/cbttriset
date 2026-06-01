package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzth {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzth(String str, boolean z2, boolean z7) {
        this.zza = str;
        this.zzb = z2;
        this.zzc = z7;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzth.class) {
            zzth zzthVar = (zzth) obj;
            if (TextUtils.equals(this.zza, zzthVar.zza) && this.zzb == zzthVar.zzb && this.zzc == zzthVar.zzc) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.zza.hashCode() + 31) * 31) + (true != this.zzb ? 1237 : 1231)) * 31) + (true != this.zzc ? 1237 : 1231);
    }
}
