package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzadw {
    public int zza;

    @Nullable
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public zzadw() {
    }

    public final boolean zza(int i2) {
        int i8;
        int i9;
        int i10;
        int i11;
        if (!zzadx.zzl(i2) || (i8 = (i2 >>> 19) & 3) == 1 || (i9 = (i2 >>> 17) & 3) == 0 || (i10 = (i2 >>> 12) & 15) == 0 || i10 == 15 || (i11 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i12 = i10 - 1;
        this.zza = i8;
        this.zzb = zzadx.zza[3 - i9];
        int i13 = zzadx.zzb[i11];
        this.zzd = i13;
        if (i8 == 2) {
            i13 /= 2;
            this.zzd = i13;
        } else if (i8 == 0) {
            i13 /= 4;
            this.zzd = i13;
        }
        int i14 = (i2 >>> 9) & 1;
        this.zzg = zzadx.zzm(i8, i9);
        if (i9 == 3) {
            int i15 = i8 == 3 ? zzadx.zzc[i12] : zzadx.zzd[i12];
            this.zzf = i15;
            this.zzc = (((i15 * 12) / i13) + i14) * 4;
        } else {
            if (i8 == 3) {
                int i16 = i9 == 2 ? zzadx.zze[i12] : zzadx.zzf[i12];
                this.zzf = i16;
                this.zzc = androidx.camera.core.processing.util.a.a(i16, 144, i13, i14);
            } else {
                int i17 = zzadx.zzg[i12];
                this.zzf = i17;
                this.zzc = androidx.camera.core.processing.util.a.a(i9 == 1 ? 72 : 144, i17, i13, i14);
            }
        }
        this.zze = ((i2 >> 6) & 3) == 3 ? 1 : 2;
        return true;
    }

    public zzadw(zzadw zzadwVar) {
        this.zza = zzadwVar.zza;
        this.zzb = zzadwVar.zzb;
        this.zzc = zzadwVar.zzc;
        this.zzd = zzadwVar.zzd;
        this.zze = zzadwVar.zze;
        this.zzf = zzadwVar.zzf;
        this.zzg = zzadwVar.zzg;
    }
}
