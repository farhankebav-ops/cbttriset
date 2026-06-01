package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzvh extends zzym {
    private final zzbg zza;

    public zzvh(zzyk zzykVar, zzbg zzbgVar) {
        super(zzykVar);
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final boolean equals(@Nullable Object obj) {
        if (super.equals(obj) && (obj instanceof zzvh)) {
            return this.zza.equals(((zzvh) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzym
    public final int hashCode() {
        return this.zza.hashCode() + (super.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyp
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyp
    public final zzv zzb(int i2) {
        return this.zza.zza(zzd().zzf(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzym, com.google.android.gms.internal.ads.zzyk
    public final zzv zzc() {
        return this.zza.zza(zzd().zzh());
    }
}
