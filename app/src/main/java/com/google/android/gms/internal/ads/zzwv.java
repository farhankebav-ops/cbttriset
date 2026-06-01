package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzwv {
    public static final zzwv zza = new zzwv(new zzbg[0]);
    public final int zzb;
    private final zzgpe zzc;
    private int zzd;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
    }

    public zzwv(zzbg... zzbgVarArr) {
        this.zzc = zzgpe.zzr(zzbgVarArr);
        this.zzb = zzbgVarArr.length;
        int i2 = 0;
        while (i2 < this.zzc.size()) {
            int i8 = i2 + 1;
            for (int i9 = i8; i9 < this.zzc.size(); i9++) {
                if (((zzbg) this.zzc.get(i2)).equals(this.zzc.get(i9))) {
                    zzdt.zzf("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i2 = i8;
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzwv.class == obj.getClass()) {
            zzwv zzwvVar = (zzwv) obj;
            if (this.zzb == zzwvVar.zzb && this.zzc.equals(zzwvVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzd;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = this.zzc.hashCode();
        this.zzd = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzbg zza(int i2) {
        return (zzbg) this.zzc.get(i2);
    }

    public final int zzb(zzbg zzbgVar) {
        int iIndexOf = this.zzc.indexOf(zzbgVar);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        return -1;
    }

    public final zzgpe zzc() {
        return zzgpe.zzq(zzgqe.zzc(this.zzc, zzwu.zza));
    }
}
