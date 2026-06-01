package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzkn {
    public final long zza;
    public final float zzb;
    public final long zzc;

    public /* synthetic */ zzkn(zzkm zzkmVar, byte[] bArr) {
        this.zza = zzkmVar.zze();
        this.zzb = zzkmVar.zzf();
        this.zzc = zzkmVar.zzg();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkn)) {
            return false;
        }
        zzkn zzknVar = (zzkn) obj;
        return this.zza == zzknVar.zza && this.zzb == zzknVar.zzb && this.zzc == zzknVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzkm zza() {
        return new zzkm(this, null);
    }
}
