package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakz {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final int zzj;
    public final int zzk;

    private zzakz(int i2, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = i10;
        this.zze = i11;
        this.zzf = i12;
        this.zzg = i13;
        this.zzh = i14;
        this.zzi = i15;
        this.zzj = i16;
        this.zzk = i17;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static zzakz zza(String str) {
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i2 = 0;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i2 >= length) {
                if (i8 != -1) {
                    return new zzakz(i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, length);
                }
                return null;
            }
            String strZza = zzglm.zza(strArrSplit[i2].trim());
            switch (strZza.hashCode()) {
                case -1178781136:
                    if (strZza.equals("italic")) {
                        i14 = i2;
                    }
                    break;
                case -1026963764:
                    if (strZza.equals("underline")) {
                        i15 = i2;
                    }
                    break;
                case -192095652:
                    if (strZza.equals("strikeout")) {
                        i16 = i2;
                    }
                    break;
                case -70925746:
                    if (strZza.equals("primarycolour")) {
                        i10 = i2;
                    }
                    break;
                case 3029637:
                    if (strZza.equals("bold")) {
                        i13 = i2;
                    }
                    break;
                case 3373707:
                    if (strZza.equals("name")) {
                        i8 = i2;
                    }
                    break;
                case 366554320:
                    if (strZza.equals("fontsize")) {
                        i12 = i2;
                    }
                    break;
                case 767321349:
                    if (strZza.equals("borderstyle")) {
                        i17 = i2;
                    }
                    break;
                case 1767875043:
                    if (strZza.equals("alignment")) {
                        i9 = i2;
                    }
                    break;
                case 1988365454:
                    if (strZza.equals("outlinecolour")) {
                        i11 = i2;
                    }
                    break;
            }
            i2++;
        }
    }
}
