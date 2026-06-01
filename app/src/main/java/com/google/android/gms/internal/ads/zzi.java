package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;
import java.util.Locale;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzi {
    public static final zzi zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;

    @Nullable
    public final byte[] zze;
    public final int zzf;
    public final int zzg;
    private int zzh;

    static {
        zzh zzhVar = new zzh();
        zzhVar.zza(1);
        zzhVar.zzb(2);
        zzhVar.zzc(3);
        zza = zzhVar.zzg();
        zzh zzhVar2 = new zzh();
        zzhVar2.zza(1);
        zzhVar2.zzb(1);
        zzhVar2.zzc(2);
        zzhVar2.zzg();
        String str = zzep.zza;
        Integer.toString(0, 36);
        Integer.toString(1, 36);
        Integer.toString(2, 36);
        Integer.toString(3, 36);
        Integer.toString(4, 36);
        Integer.toString(5, 36);
    }

    public /* synthetic */ zzi(int i2, int i8, int i9, byte[] bArr, int i10, int i11, byte[] bArr2) {
        this.zzb = i2;
        this.zzc = i8;
        this.zzd = i9;
        this.zze = bArr;
        this.zzf = i10;
        this.zzg = i11;
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = false)
    public static boolean zza(@Nullable zzi zziVar) {
        if (zziVar == null) {
            return true;
        }
        int i2 = zziVar.zzb;
        if (i2 != -1 && i2 != 1 && i2 != 2) {
            return false;
        }
        int i8 = zziVar.zzc;
        if (i8 != -1 && i8 != 2) {
            return false;
        }
        int i9 = zziVar.zzd;
        if ((i9 != -1 && i9 != 3) || zziVar.zze != null) {
            return false;
        }
        int i10 = zziVar.zzg;
        if (i10 != -1 && i10 != 8) {
            return false;
        }
        int i11 = zziVar.zzf;
        return i11 == -1 || i11 == 8;
    }

    @Pure
    public static int zzb(int i2) {
        if (i2 == 1) {
            return 1;
        }
        if (i2 != 9) {
            return (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : -1;
        }
        return 6;
    }

    @Pure
    public static int zzc(int i2) {
        if (i2 == 1) {
            return 3;
        }
        if (i2 == 4) {
            return 10;
        }
        if (i2 == 13) {
            return 2;
        }
        if (i2 == 16) {
            return 6;
        }
        if (i2 != 18) {
            return (i2 == 6 || i2 == 7) ? 3 : -1;
        }
        return 7;
    }

    private static String zzh(int i2) {
        return i2 != -1 ? i2 != 6 ? i2 != 1 ? i2 != 2 ? androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 22), "Undefined color space ", i2) : "BT601" : "BT709" : "BT2020" : "Unset color space";
    }

    private static String zzi(int i2) {
        return i2 != -1 ? i2 != 10 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 6 ? i2 != 7 ? androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 25), "Undefined color transfer ", i2) : "HLG" : "ST2084 PQ" : "SDR SMPTE 170M" : "sRGB" : "Linear" : "Gamma 2.2" : "Unset color transfer";
    }

    private static String zzj(int i2) {
        return i2 != -1 ? i2 != 1 ? i2 != 2 ? androidx.camera.core.processing.util.a.m(new StringBuilder(String.valueOf(i2).length() + 22), "Undefined color range ", i2) : "Limited range" : "Full range" : "Unset color range";
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzi.class == obj.getClass()) {
            zzi zziVar = (zzi) obj;
            if (this.zzb == zziVar.zzb && this.zzc == zziVar.zzc && this.zzd == zziVar.zzd && Arrays.equals(this.zze, zziVar.zze) && this.zzf == zziVar.zzf && this.zzg == zziVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2 = this.zzh;
        if (i2 != 0) {
            return i2;
        }
        int iHashCode = ((((Arrays.hashCode(this.zze) + ((((((this.zzb + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzc) * 31) + this.zzd) * 31)) * 31) + this.zzf) * 31) + this.zzg;
        this.zzh = iHashCode;
        return iHashCode;
    }

    public final String toString() {
        int i2 = this.zzf;
        int i8 = this.zzd;
        int i9 = this.zzc;
        String strZzh = zzh(this.zzb);
        String strZzj = zzj(i9);
        String strZzi = zzi(i8);
        String strQ = i2 != -1 ? a1.a.q(new StringBuilder(String.valueOf(i2).length() + 8), "bit Luma", i2) : "NA";
        int i10 = this.zzg;
        String strQ2 = i10 != -1 ? a1.a.q(new StringBuilder(String.valueOf(i10).length() + 10), "bit Chroma", i10) : "NA";
        boolean z2 = this.zze != null;
        StringBuilder sb = new StringBuilder(androidx.camera.core.processing.util.a.D(androidx.camera.core.processing.util.a.D(androidx.camera.core.processing.util.a.D(androidx.camera.core.processing.util.a.D(strZzh.length() + 12, 2, strZzj) + strZzi.length() + 2, 2, String.valueOf(z2)), 2, strQ), 1, strQ2));
        sb.append("ColorInfo(");
        sb.append(strZzh);
        sb.append(", ");
        sb.append(strZzj);
        sb.append(", ");
        sb.append(strZzi);
        sb.append(", ");
        sb.append(z2);
        androidx.camera.core.processing.util.a.A(sb, ", ", strQ, ", ", strQ2);
        sb.append(")");
        return sb.toString();
    }

    public final zzh zzd() {
        return new zzh(this, null);
    }

    public final boolean zze() {
        return (this.zzf == -1 || this.zzg == -1) ? false : true;
    }

    public final boolean zzf() {
        return (this.zzb == -1 || this.zzc == -1 || this.zzd == -1) ? false : true;
    }

    public final String zzg() {
        String str;
        String string;
        if (zzf()) {
            String strZzh = zzh(this.zzb);
            String strZzj = zzj(this.zzc);
            String strZzi = zzi(this.zzd);
            String str2 = zzep.zza;
            Locale locale = Locale.US;
            str = strZzh + "/" + strZzj + "/" + strZzi;
        } else {
            str = "NA/NA/NA";
        }
        if (zze()) {
            int i2 = this.zzf;
            int i8 = this.zzg;
            StringBuilder sb = new StringBuilder(com.google.android.gms.ads.internal.client.a.a(i2, 1) + String.valueOf(i8).length());
            sb.append(i2);
            sb.append("/");
            sb.append(i8);
            string = sb.toString();
        } else {
            string = "NA/NA";
        }
        return a1.a.s(new StringBuilder(string.length() + str.length() + 1), str, "/", string);
    }
}
