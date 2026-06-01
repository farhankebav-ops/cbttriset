package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
final class zzf {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zza.matcher(str);
        StringBuilder sb = null;
        int iEnd = 0;
        while (matcher.find()) {
            if (sb == null) {
                sb = new StringBuilder();
            }
            int iStart = matcher.start();
            int i2 = iStart;
            while (i2 >= 0 && str.charAt(i2) == '\\') {
                i2--;
            }
            if ((iStart - i2) % 2 != 0) {
                int i8 = Integer.parseInt(matcher.group().substring(2), 16);
                sb.append((CharSequence) str, iEnd, matcher.start());
                if (i8 == 92) {
                    sb.append("\\\\");
                } else {
                    sb.append(Character.toChars(i8));
                }
                iEnd = matcher.end();
            }
        }
        if (sb == null) {
            return str;
        }
        if (iEnd < matcher.regionEnd()) {
            sb.append((CharSequence) str, iEnd, matcher.regionEnd());
        }
        return sb.toString();
    }
}
