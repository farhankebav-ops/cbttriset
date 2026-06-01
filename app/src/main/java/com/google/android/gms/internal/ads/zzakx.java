package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzakx {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzakx(int i2, int i8, int i9, int i10, int i11, int i12) {
        this.zza = i2;
        this.zzb = i8;
        this.zzc = i9;
        this.zzd = i10;
        this.zze = i11;
        this.zzf = i12;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Nullable
    public static zzakx zza(String str) {
        zzgmd.zza(str.startsWith("Format:"));
        String[] strArrSplit = TextUtils.split(str.substring(7), ",");
        int i2 = 0;
        int i8 = -1;
        int i9 = -1;
        int i10 = -1;
        int i11 = -1;
        int i12 = -1;
        while (true) {
            int length = strArrSplit.length;
            if (i2 >= length) {
                if (i9 == -1 || i10 == -1 || i12 == -1) {
                    return null;
                }
                return new zzakx(i8, i9, i10, i11, i12, length);
            }
            String strZza = zzglm.zza(strArrSplit[i2].trim());
            switch (strZza.hashCode()) {
                case 100571:
                    if (strZza.equals("end")) {
                        i10 = i2;
                    }
                    break;
                case 3556653:
                    if (strZza.equals(C2300e4.h.K0)) {
                        i12 = i2;
                    }
                    break;
                case 102749521:
                    if (strZza.equals("layer")) {
                        i8 = i2;
                    }
                    break;
                case 109757538:
                    if (strZza.equals("start")) {
                        i9 = i2;
                    }
                    break;
                case 109780401:
                    if (strZza.equals("style")) {
                        i11 = i2;
                    }
                    break;
            }
            i2++;
        }
    }
}
