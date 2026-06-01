package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzctg {
    private final zzdbp zza;

    @Nullable
    private final zzddu zzb;

    public zzctg(zzdbp zzdbpVar, @Nullable zzddu zzdduVar) {
        this.zza = zzdbpVar;
        this.zzb = zzdduVar;
    }

    public final zzdbp zza() {
        return this.zza;
    }

    public final zzdgn zzb() {
        zzddu zzdduVar = this.zzb;
        return zzdduVar != null ? new zzdgn(zzdduVar, zzcbv.zzg) : new zzdgn(new zzctf(this), zzcbv.zzg);
    }

    @Nullable
    public final zzddu zzc() {
        return this.zzb;
    }
}
