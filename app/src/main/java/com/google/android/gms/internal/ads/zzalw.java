package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalw {
    public final String zza;
    public final int zzb;
    public final String zzc;
    public final Set zzd;

    private zzalw(String str, int i2, String str2, Set set) {
        this.zzb = i2;
        this.zza = str;
        this.zzc = str2;
        this.zzd = set;
    }

    public static zzalw zza(String str, int i2) {
        String str2;
        String strTrim = str.trim();
        zzgmd.zza(!strTrim.isEmpty());
        int iIndexOf = strTrim.indexOf(" ");
        if (iIndexOf == -1) {
            str2 = "";
        } else {
            String strTrim2 = strTrim.substring(iIndexOf).trim();
            strTrim = strTrim.substring(0, iIndexOf);
            str2 = strTrim2;
        }
        String str3 = zzep.zza;
        String[] strArrSplit = strTrim.split("\\.", -1);
        String str4 = strArrSplit[0];
        HashSet hashSet = new HashSet();
        for (int i8 = 1; i8 < strArrSplit.length; i8++) {
            hashSet.add(strArrSplit[i8]);
        }
        return new zzalw(str4, i2, str2, hashSet);
    }

    public static zzalw zzb() {
        return new zzalw("", 0, "", Collections.EMPTY_SET);
    }
}
