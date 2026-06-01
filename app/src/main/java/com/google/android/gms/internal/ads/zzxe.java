package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public class zzxe implements zzyk {
    protected final zzbg zza;
    protected final int zzb;
    protected final int[] zzc;
    private final zzv[] zzd;
    private int zze;

    public zzxe(zzbg zzbgVar, int[] iArr, int i2) {
        int length = iArr.length;
        zzgmd.zzh(length > 0);
        zzbgVar.getClass();
        this.zza = zzbgVar;
        this.zzb = length;
        this.zzd = new zzv[length];
        for (int i8 = 0; i8 < iArr.length; i8++) {
            this.zzd[i8] = zzbgVar.zza(iArr[i8]);
        }
        Arrays.sort(this.zzd, zzxd.zza);
        this.zzc = new int[this.zzb];
        for (int i9 = 0; i9 < this.zzb; i9++) {
            this.zzc[i9] = zzbgVar.zzb(this.zzd[i9]);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzxe zzxeVar = (zzxe) obj;
            if (this.zza.equals(zzxeVar.zza) && Arrays.equals(this.zzc, zzxeVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zze;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = Arrays.hashCode(this.zzc) + (System.identityHashCode(this.zza) * 31);
        this.zze = iHashCode;
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final zzv zzb(int i2) {
        return this.zzd[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public final zzv zzc() {
        return this.zzd[0];
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zze() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzf(int i2) {
        return this.zzc[i2];
    }

    @Override // com.google.android.gms.internal.ads.zzyp
    public final int zzg(int i2) {
        for (int i8 = 0; i8 < this.zzb; i8++) {
            if (this.zzc[i8] == i2) {
                return i8;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzyk
    public final int zzh() {
        return this.zzc[0];
    }
}
