package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzpl {
    public static final zzpl zza = new zzpk().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    public /* synthetic */ zzpl(zzpk zzpkVar, byte[] bArr) {
        this.zzb = zzpkVar.zze();
        this.zzc = zzpkVar.zzf();
        this.zzd = zzpkVar.zzg();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzpl.class == obj.getClass()) {
            zzpl zzplVar = (zzpl) obj;
            if (this.zzb == zzplVar.zzb && this.zzc == zzplVar.zzc && this.zzd == zzplVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z2 = this.zzb;
        boolean z7 = this.zzc;
        return (z7 ? 1 : 0) + (z7 ? 1 : 0) + ((z2 ? 1 : 0) << 2) + (this.zzd ? 1 : 0);
    }
}
