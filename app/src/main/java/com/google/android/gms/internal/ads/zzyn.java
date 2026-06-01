package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzyn {
    private final int[] zza;
    private final zzwv[] zzb;
    private final int[] zzc;
    private final int[][][] zzd;
    private final zzwv zze;

    @VisibleForTesting
    public zzyn(String[] strArr, int[] iArr, zzwv[] zzwvVarArr, int[] iArr2, int[][][] iArr3, zzwv zzwvVar) {
        this.zza = iArr;
        this.zzb = zzwvVarArr;
        this.zzd = iArr3;
        this.zzc = iArr2;
        this.zze = zzwvVar;
    }

    public final int zza(int i2) {
        return this.zza[i2];
    }

    public final zzwv zzb(int i2) {
        return this.zzb[i2];
    }

    public final int zzc(int i2, int i8, int i9) {
        return this.zzd[i2][i8][i9];
    }

    public final int zzd(int i2, int i8, boolean z2) {
        zzwv[] zzwvVarArr = this.zzb;
        int i9 = zzwvVarArr[i2].zza(i8).zza;
        int[] iArr = new int[i9];
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < i9; i12++) {
            if ((this.zzd[i2][i8][i12] & 7) == 4) {
                iArr[i11] = i12;
                i11++;
            }
        }
        int[] iArrCopyOf = Arrays.copyOf(iArr, i11);
        String str = null;
        int i13 = 0;
        int iMin = 16;
        boolean z7 = false;
        while (i10 < iArrCopyOf.length) {
            String str2 = zzwvVarArr[i2].zza(i8).zza(iArrCopyOf[i10]).zzo;
            int i14 = i13 + 1;
            if (i13 == 0) {
                str = str2;
            } else {
                z7 |= !Objects.equals(str, str2);
            }
            iMin = Math.min(iMin, this.zzd[i2][i8][i10] & 24);
            i10++;
            i13 = i14;
        }
        return z7 ? Math.min(iMin, this.zzc[i2]) : iMin;
    }

    public final zzwv zze() {
        return this.zze;
    }
}
