package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdp {
    public final Object zza;
    private zzr zzb = new zzr();
    private boolean zzc;
    private boolean zzd;

    public zzdp(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzdp.class != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzdp) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(zzdo zzdoVar) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzdoVar.zza(this.zza, this.zzb.zzb());
        }
    }

    public final void zzb(int i2, zzdn zzdnVar) {
        if (this.zzd) {
            return;
        }
        if (i2 != -1) {
            this.zzb.zza(i2);
        }
        this.zzc = true;
        zzdnVar.zza(this.zza);
    }

    public final void zzc(zzdo zzdoVar) {
        if (this.zzd || !this.zzc) {
            return;
        }
        zzs zzsVarZzb = this.zzb.zzb();
        this.zzb = new zzr();
        this.zzc = false;
        zzdoVar.zza(this.zza, zzsVarZzb);
    }
}
