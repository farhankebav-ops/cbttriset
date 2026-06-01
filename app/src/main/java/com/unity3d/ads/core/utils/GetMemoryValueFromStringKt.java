package com.unity3d.ads.core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import n6.t;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class GetMemoryValueFromStringKt {
    public static final long getMemoryValueFromString(String str) {
        Long lP0;
        if (str == null) {
            return -1L;
        }
        Matcher matcher = Pattern.compile("(\\d+)").matcher(str);
        String strGroup = null;
        while (matcher.find()) {
            strGroup = matcher.group(1);
        }
        if (strGroup == null || (lP0 = t.p0(strGroup)) == null) {
            return -1L;
        }
        return lP0.longValue();
    }
}
