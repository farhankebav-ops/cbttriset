package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zznl {
    private final zznh zza;
    private final zznj zzb = null;
    private final zznj zzc = null;
    private final Boolean zzd = null;

    public /* synthetic */ zznl(zzni zzniVar, zznk zznkVar) {
        this.zza = zzniVar.zza;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof zznl) && Objects.equal(this.zza, ((zznl) obj).zza) && Objects.equal(null, null) && Objects.equal(null, null) && Objects.equal(null, null);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, null, null, null);
    }

    @Nullable
    @zzbc(zza = 1)
    public final zznh zza() {
        return this.zza;
    }
}
