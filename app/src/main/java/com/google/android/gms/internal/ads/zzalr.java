package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzalr {
    private static final Pattern zza = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
    private static final Pattern zzb = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    private final zzeg zzc = new zzeg();
    private final StringBuilder zzd = new StringBuilder();

    public static void zzb(zzeg zzegVar) {
        while (true) {
            for (boolean z2 = true; zzegVar.zzd() > 0 && z2; z2 = false) {
                char c7 = (char) zzegVar.zzi()[zzegVar.zzg()];
                if (c7 == '\t' || c7 == '\n' || c7 == '\f' || c7 == '\r' || c7 == ' ') {
                    zzegVar.zzk(1);
                } else {
                    int iZzg = zzegVar.zzg();
                    int iZze = zzegVar.zze();
                    byte[] bArrZzi = zzegVar.zzi();
                    if (iZzg + 2 <= iZze) {
                        int i2 = iZzg + 1;
                        if (bArrZzi[iZzg] == 47) {
                            int i8 = iZzg + 2;
                            if (bArrZzi[i2] == 42) {
                                while (true) {
                                    int i9 = i8 + 1;
                                    if (i9 >= iZze) {
                                        break;
                                    }
                                    if (((char) bArrZzi[i8]) == '*' && ((char) bArrZzi[i9]) == '/') {
                                        iZze = i8 + 2;
                                        i8 = iZze;
                                    } else {
                                        i8 = i9;
                                    }
                                }
                                zzegVar.zzk(iZze - zzegVar.zzg());
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            return;
        }
    }

    @Nullable
    public static String zzc(zzeg zzegVar, StringBuilder sb) {
        zzb(zzegVar);
        if (zzegVar.zzd() == 0) {
            return null;
        }
        String strZzd = zzd(zzegVar, sb);
        if (!strZzd.isEmpty()) {
            return strZzd;
        }
        char cZzs = (char) zzegVar.zzs();
        StringBuilder sb2 = new StringBuilder(String.valueOf(cZzs).length());
        sb2.append(cZzs);
        return sb2.toString();
    }

    private static String zzd(zzeg zzegVar, StringBuilder sb) {
        boolean z2;
        char c7;
        sb.setLength(0);
        int iZzg = zzegVar.zzg();
        int iZze = zzegVar.zze();
        loop0: while (true) {
            for (false; iZzg < iZze && !z2; true) {
                c7 = (char) zzegVar.zzi()[iZzg];
                z2 = (c7 < 'A' || c7 > 'Z') && (c7 < 'a' || c7 > 'z') && !((c7 >= '0' && c7 <= '9') || c7 == '#' || c7 == '-' || c7 == '.' || c7 == '_');
            }
            sb.append(c7);
            iZzg++;
        }
        zzegVar.zzk(iZzg - zzegVar.zzg());
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x02fd, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List zza(com.google.android.gms.internal.ads.zzeg r18) {
        /*
            Method dump skipped, instruction units count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalr.zza(com.google.android.gms.internal.ads.zzeg):java.util.List");
    }
}
