package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import a1.a;
import com.ironsource.C2300e4;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes4.dex */
final class zzfo {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static String zza(zzfm zzfmVar, String str) {
        StringBuilder sbX = a.x("# ", str);
        zzd(zzfmVar, sbX, 0);
        return sbX.toString();
    }

    public static void zzb(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i2, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i2, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i2, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i8 = 1; i8 < str.length(); i8++) {
                char cCharAt = str.charAt(i8);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzgq.zza(new zzde(((String) obj).getBytes(zzep.zza))));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzdf) {
            sb.append(": \"");
            sb.append(zzgq.zza((zzdf) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzeh) {
            sb.append(" {");
            zzd((zzeh) obj, sb, i2 + 2);
            sb.append("\n");
            zzc(i2, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i9 = i2 + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i9, C2300e4.h.W, entry.getKey());
        zzb(sb, i9, "value", entry.getValue());
        sb.append("\n");
        zzc(i2, sb);
        sb.append("}");
    }

    private static void zzc(int i2, StringBuilder sb) {
        while (i2 > 0) {
            int i8 = 80;
            if (i2 <= 80) {
                i8 = i2;
            }
            sb.append(zza, 0, i8);
            i2 -= i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x01fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzd(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm r18, java.lang.StringBuilder r19, int r20) {
        /*
            Method dump skipped, instruction units count: 570
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfo.zzd(com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzfm, java.lang.StringBuilder, int):void");
    }
}
