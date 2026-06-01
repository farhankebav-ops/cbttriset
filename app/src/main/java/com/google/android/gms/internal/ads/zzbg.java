package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzbg {
    public final int zza;
    public final String zzb;
    public final int zzc;
    private final zzv[] zzd;
    private int zze;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
    }

    public zzbg(String str, zzv... zzvVarArr) {
        int length = zzvVarArr.length;
        int i2 = 1;
        zzgmd.zza(length > 0);
        this.zzb = str;
        this.zzd = zzvVarArr;
        this.zza = length;
        int iZzg = zzas.zzg(zzvVarArr[0].zzo);
        this.zzc = iZzg == -1 ? zzas.zzg(zzvVarArr[0].zzn) : iZzg;
        String strZzc = zzc(zzvVarArr[0].zzd);
        int i8 = zzvVarArr[0].zzf | 16384;
        while (true) {
            zzv[] zzvVarArr2 = this.zzd;
            if (i2 >= zzvVarArr2.length) {
                return;
            }
            if (!strZzc.equals(zzc(zzvVarArr2[i2].zzd))) {
                zzv[] zzvVarArr3 = this.zzd;
                zzd("languages", zzvVarArr3[0].zzd, zzvVarArr3[i2].zzd, i2);
                return;
            } else {
                zzv[] zzvVarArr4 = this.zzd;
                if (i8 != (zzvVarArr4[i2].zzf | 16384)) {
                    zzd("role flags", Integer.toBinaryString(zzvVarArr4[0].zzf), Integer.toBinaryString(this.zzd[i2].zzf), i2);
                    return;
                }
                i2++;
            }
        }
    }

    private static String zzc(@Nullable String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    private static void zzd(String str, @Nullable String str2, @Nullable String str3, int i2) {
        int length = String.valueOf(str2).length();
        int length2 = String.valueOf(str3).length();
        StringBuilder sb = new StringBuilder(str.length() + 40 + length + 17 + length2 + 9 + String.valueOf(i2).length() + 1);
        androidx.camera.core.processing.util.a.A(sb, "Different ", str, " combined in one TrackGroup: '", str2);
        sb.append("' (track 0) and '");
        sb.append(str3);
        sb.append("' (track ");
        sb.append(i2);
        sb.append(")");
        zzdt.zzf("TrackGroup", "", new IllegalStateException(sb.toString()));
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzbg.class == obj.getClass()) {
            zzbg zzbgVar = (zzbg) obj;
            if (this.zzb.equals(zzbgVar.zzb) && Arrays.equals(this.zzd, zzbgVar.zzd)) {
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
        int iHashCode = this.zzb.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        int iHashCode2 = Arrays.hashCode(this.zzd) + (iHashCode * 31);
        this.zze = iHashCode2;
        return iHashCode2;
    }

    public final String toString() {
        String string = Arrays.toString(this.zzd);
        String str = this.zzb;
        return a1.a.s(new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(string).length()), str, ": ", string);
    }

    public final zzv zza(int i2) {
        return this.zzd[i2];
    }

    public final int zzb(zzv zzvVar) {
        int i2 = 0;
        while (true) {
            zzv[] zzvVarArr = this.zzd;
            if (i2 >= zzvVarArr.length) {
                return -1;
            }
            if (zzvVar == zzvVarArr[i2]) {
                return i2;
            }
            i2++;
        }
    }
}
