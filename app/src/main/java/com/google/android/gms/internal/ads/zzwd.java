package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzwd implements zzyu {
    public long zza;
    public long zzb;

    @Nullable
    public zzyt zzc;

    @Nullable
    public zzwd zzd;

    public zzwd(long j, int i2) {
        zza(j, 65536);
    }

    public final void zza(long j, int i2) {
        zzgmd.zzh(this.zzc == null);
        this.zza = j;
        this.zzb = j + 65536;
    }

    public final int zzb(long j) {
        long j3 = j - this.zza;
        int i2 = this.zzc.zzb;
        return (int) j3;
    }

    public final zzwd zzc() {
        this.zzc = null;
        zzwd zzwdVar = this.zzd;
        this.zzd = null;
        return zzwdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final zzyt zzd() {
        zzyt zzytVar = this.zzc;
        zzytVar.getClass();
        return zzytVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    @Nullable
    public final zzyu zze() {
        zzwd zzwdVar = this.zzd;
        if (zzwdVar == null || zzwdVar.zzc == null) {
            return null;
        }
        return zzwdVar;
    }
}
