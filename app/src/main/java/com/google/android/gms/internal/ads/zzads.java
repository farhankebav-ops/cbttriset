package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzads {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            String str2 = zzep.zza;
            int i2 = Integer.parseInt(strGroup, 16);
            int i8 = Integer.parseInt(matcher.group(2), 16);
            if (i2 <= 0 && i8 <= 0) {
                return false;
            }
            this.zza = i2;
            this.zzb = i8;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza(zzap zzapVar) {
        zzgpe zzgpeVarZze = zzapVar.zze(zzagk.class, zzadr.zza);
        int size = zzgpeVarZze.size();
        int i2 = 0;
        while (i2 < size) {
            boolean zZzc = zzc(((zzagk) zzgpeVarZze.get(i2)).zzc);
            i2++;
            if (zZzc) {
                return true;
            }
        }
        zzgpe zzgpeVarZze2 = zzapVar.zze(zzags.class, zzadq.zza);
        int size2 = zzgpeVarZze2.size();
        int i8 = 0;
        while (i8 < size2) {
            boolean zZzc2 = zzc(((zzags) zzgpeVarZze2.get(i8)).zzc);
            i8++;
            if (zZzc2) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzb() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }
}
