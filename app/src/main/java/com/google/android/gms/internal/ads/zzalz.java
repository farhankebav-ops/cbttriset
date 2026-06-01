package com.google.android.gms.internal.ads;

import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import androidx.annotation.Nullable;
import com.ironsource.Q6;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
public final class zzalz {
    public static final Pattern zza = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)((?:.|\\f)*)?$");
    private static final Pattern zzb = Pattern.compile("(\\S+?):(\\S+)");
    private static final Map zzc;
    private static final Map zzd;

    static {
        HashMap map = new HashMap();
        map.put("white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map.put("lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map.put("cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map.put("red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map.put("yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map.put("magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map.put("blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map.put("black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzc = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("bg_white", Integer.valueOf(Color.rgb(255, 255, 255)));
        map2.put("bg_lime", Integer.valueOf(Color.rgb(0, 255, 0)));
        map2.put("bg_cyan", Integer.valueOf(Color.rgb(0, 255, 255)));
        map2.put("bg_red", Integer.valueOf(Color.rgb(255, 0, 0)));
        map2.put("bg_yellow", Integer.valueOf(Color.rgb(255, 255, 0)));
        map2.put("bg_magenta", Integer.valueOf(Color.rgb(255, 0, 255)));
        map2.put("bg_blue", Integer.valueOf(Color.rgb(0, 0, 255)));
        map2.put("bg_black", Integer.valueOf(Color.rgb(0, 0, 0)));
        zzd = Collections.unmodifiableMap(map2);
    }

    @Nullable
    public static zzalt zza(zzeg zzegVar, List list) {
        Charset charset = StandardCharsets.UTF_8;
        String strZzN = zzegVar.zzN(charset);
        if (strZzN != null) {
            Pattern pattern = zza;
            Matcher matcher = pattern.matcher(strZzN);
            if (matcher.matches()) {
                return zzd(null, matcher, zzegVar, list);
            }
            String strZzN2 = zzegVar.zzN(charset);
            if (strZzN2 != null) {
                Matcher matcher2 = pattern.matcher(strZzN2);
                if (matcher2.matches()) {
                    return zzd(strZzN.trim(), matcher2, zzegVar, list);
                }
            }
        }
        return null;
    }

    public static zzcl zzb(String str) {
        zzaly zzalyVar = new zzaly();
        zze(str, zzalyVar);
        return zzalyVar.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01db  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.text.SpannedString zzc(@androidx.annotation.Nullable java.lang.String r13, java.lang.String r14, java.util.List r15) {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalz.zzc(java.lang.String, java.lang.String, java.util.List):android.text.SpannedString");
    }

    @Nullable
    private static zzalt zzd(@Nullable String str, Matcher matcher, zzeg zzegVar, List list) {
        zzaly zzalyVar = new zzaly();
        try {
            String strGroup = matcher.group(1);
            if (strGroup == null) {
                throw null;
            }
            zzalyVar.zza = zzamb.zza(strGroup);
            String strGroup2 = matcher.group(2);
            if (strGroup2 == null) {
                throw null;
            }
            zzalyVar.zzb = zzamb.zza(strGroup2);
            String strGroup3 = matcher.group(3);
            strGroup3.getClass();
            zze(strGroup3, zzalyVar);
            StringBuilder sb = new StringBuilder();
            String strZzN = zzegVar.zzN(StandardCharsets.UTF_8);
            while (!TextUtils.isEmpty(strZzN)) {
                if (sb.length() > 0) {
                    sb.append("\n");
                }
                sb.append(strZzN.trim());
                strZzN = zzegVar.zzN(StandardCharsets.UTF_8);
            }
            zzalyVar.zzc = zzc(str, sb.toString(), list);
            return new zzalt(zzalyVar.zza().zzr(), zzalyVar.zza, zzalyVar.zzb);
        } catch (IllegalArgumentException unused) {
            zzdt.zzc("WebvttCueParser", "Skipping cue with bad header: ".concat(String.valueOf(matcher.group())));
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0081 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cf A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0146 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0190 A[Catch: NumberFormatException -> 0x01bd, TRY_ENTER, TryCatch #0 {NumberFormatException -> 0x01bd, blocks: (B:6:0x0026, B:9:0x003c, B:11:0x0044, B:33:0x0089, B:32:0x0081, B:34:0x008c, B:36:0x0094, B:38:0x009c, B:39:0x00a4, B:41:0x00ac, B:54:0x00d8, B:53:0x00cf, B:55:0x00dc, B:56:0x0101, B:58:0x0107, B:80:0x014f, B:79:0x0146, B:81:0x0155, B:82:0x015d, B:84:0x0163, B:100:0x0199, B:99:0x0190, B:101:0x019f, B:103:0x01a7, B:104:0x01b1), top: B:108:0x0026 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zze(java.lang.String r16, com.google.android.gms.internal.ads.zzaly r17) {
        /*
            Method dump skipped, instruction units count: 536
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalz.zze(java.lang.String, com.google.android.gms.internal.ads.zzaly):void");
    }

    private static void zzf(@Nullable String str, zzalw zzalwVar, List list, SpannableStringBuilder spannableStringBuilder, List list2) {
        int i2 = zzalwVar.zzb;
        int length = spannableStringBuilder.length();
        String str2 = zzalwVar.zza;
        int iHashCode = str2.hashCode();
        int i8 = -1;
        if (iHashCode != 0) {
            if (iHashCode != 105) {
                if (iHashCode != 3314158) {
                    if (iHashCode == 3511770) {
                        if (!str2.equals("ruby")) {
                            return;
                        }
                        int iZzg = zzg(list2, str, zzalwVar);
                        ArrayList arrayList = new ArrayList(list.size());
                        arrayList.addAll(list);
                        Collections.sort(arrayList, zzalv.zza);
                        int i9 = i2;
                        int i10 = 0;
                        int length2 = 0;
                        while (i10 < arrayList.size()) {
                            if ("rt".equals(((zzalv) arrayList.get(i10)).zzc().zza)) {
                                zzalv zzalvVar = (zzalv) arrayList.get(i10);
                                int iZzg2 = zzg(list2, str, zzalvVar.zzc());
                                if (iZzg2 == i8) {
                                    iZzg2 = iZzg != i8 ? iZzg : 1;
                                }
                                int i11 = zzalvVar.zzc().zzb - length2;
                                int iZzd = zzalvVar.zzd() - length2;
                                CharSequence charSequenceSubSequence = spannableStringBuilder.subSequence(i11, iZzd);
                                spannableStringBuilder.delete(i11, iZzd);
                                spannableStringBuilder.setSpan(new zzcr(charSequenceSubSequence.toString(), iZzg2), i9, i11, 33);
                                length2 += charSequenceSubSequence.length();
                                i9 = i11;
                            }
                            i10++;
                            i8 = -1;
                        }
                    } else if (iHashCode != 98) {
                        if (iHashCode == 99) {
                            if (!str2.equals("c")) {
                                return;
                            }
                            for (String str3 : zzalwVar.zzd) {
                                Map map = zzc;
                                if (map.containsKey(str3)) {
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(((Integer) map.get(str3)).intValue()), i2, length, 33);
                                } else {
                                    Map map2 = zzd;
                                    if (map2.containsKey(str3)) {
                                        spannableStringBuilder.setSpan(new BackgroundColorSpan(((Integer) map2.get(str3)).intValue()), i2, length, 33);
                                    }
                                }
                            }
                        } else if (iHashCode != 117) {
                            if (iHashCode != 118 || !str2.equals("v")) {
                                return;
                            } else {
                                spannableStringBuilder.setSpan(new zzcu(zzalwVar.zzc), i2, length, 33);
                            }
                        } else if (!str2.equals("u")) {
                            return;
                        } else {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                        }
                    } else if (!str2.equals("b")) {
                        return;
                    } else {
                        spannableStringBuilder.setSpan(new StyleSpan(1), i2, length, 33);
                    }
                } else if (!str2.equals(Q6.f7460q)) {
                    return;
                }
            } else if (!str2.equals("i")) {
                return;
            } else {
                spannableStringBuilder.setSpan(new StyleSpan(2), i2, length, 33);
            }
        } else if (!str2.equals("")) {
            return;
        }
        List listZzh = zzh(list2, str, zzalwVar);
        for (int i12 = 0; i12 < listZzh.size(); i12++) {
            zzals zzalsVar = ((zzalx) listZzh.get(i12)).zzb;
            if (zzalsVar != null) {
                if (zzalsVar.zzf() != -1) {
                    zzcs.zza(spannableStringBuilder, new StyleSpan(zzalsVar.zzf()), i2, length, 33);
                }
                if (zzalsVar.zzg()) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), i2, length, 33);
                }
                if (zzalsVar.zzo()) {
                    zzcs.zza(spannableStringBuilder, new ForegroundColorSpan(zzalsVar.zzm()), i2, length, 33);
                }
                if (zzalsVar.zzr()) {
                    zzcs.zza(spannableStringBuilder, new BackgroundColorSpan(zzalsVar.zzp()), i2, length, 33);
                }
                if (zzalsVar.zzk() != null) {
                    zzcs.zza(spannableStringBuilder, new TypefaceSpan(zzalsVar.zzk()), i2, length, 33);
                }
                int iZzu = zzalsVar.zzu();
                if (iZzu == 1) {
                    zzcs.zza(spannableStringBuilder, new AbsoluteSizeSpan((int) zzalsVar.zzv(), true), i2, length, 33);
                } else if (iZzu == 2) {
                    zzcs.zza(spannableStringBuilder, new RelativeSizeSpan(zzalsVar.zzv()), i2, length, 33);
                } else if (iZzu == 3) {
                    zzcs.zza(spannableStringBuilder, new RelativeSizeSpan(zzalsVar.zzv() / 100.0f), i2, length, 33);
                }
                if (zzalsVar.zzz()) {
                    spannableStringBuilder.setSpan(new zzcq(), i2, length, 33);
                }
            }
        }
    }

    private static int zzg(List list, @Nullable String str, zzalw zzalwVar) {
        List listZzh = zzh(list, str, zzalwVar);
        for (int i2 = 0; i2 < listZzh.size(); i2++) {
            zzals zzalsVar = ((zzalx) listZzh.get(i2)).zzb;
            if (zzalsVar.zzx() != -1) {
                return zzalsVar.zzx();
            }
        }
        return -1;
    }

    private static List zzh(List list, @Nullable String str, zzalw zzalwVar) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzals zzalsVar = (zzals) list.get(i2);
            int iZze = zzalsVar.zze(str, zzalwVar.zza, zzalwVar.zzd, zzalwVar.zzc);
            if (iZze > 0) {
                arrayList.add(new zzalx(iZze, zzalsVar));
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
