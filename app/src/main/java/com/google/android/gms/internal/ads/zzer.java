package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzer {
    public final String zza;

    private zzer(int i2, int i8, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzer zza(zzeg zzegVar) {
        String str;
        zzegVar.zzk(2);
        int iZzs = zzegVar.zzs();
        int i2 = iZzs >> 1;
        int i8 = iZzs & 1;
        int iZzs2 = zzegVar.zzs() >> 3;
        if (i2 == 4 || i2 == 5 || i2 == 7 || i2 == 8) {
            str = "dvhe";
        } else if (i2 == 9) {
            str = "dvav";
        } else {
            if (i2 != 10) {
                return null;
            }
            str = "dav1";
        }
        int i9 = iZzs2 | (i8 << 5);
        int length = String.valueOf(i2).length();
        int length2 = String.valueOf(i9).length();
        String str2 = i2 < 10 ? ".0" : ".";
        int iD = androidx.camera.core.processing.util.a.D(str.length(), length, str2);
        String str3 = i9 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(androidx.camera.core.processing.util.a.D(iD, length2, str3));
        sb.append(str);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        sb.append(i9);
        return new zzer(i2, i9, sb.toString());
    }
}
