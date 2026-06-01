package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzym implements zzyk {
    private final zzyk zza;

    public zzym(zzyk zzykVar) {
        this.zza = zzykVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzym) {
            return this.zza.equals(((zzym) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public zzbg zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public zzv zzb(int i2) {
        return this.zza.zzb(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public zzv zzc() {
        return this.zza.zzc();
    }

    public final zzyk zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzf(int i2) {
        return this.zza.zzf(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzg(int i2) {
        return this.zza.zzg(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public final int zzh() {
        return this.zza.zzh();
    }
}
