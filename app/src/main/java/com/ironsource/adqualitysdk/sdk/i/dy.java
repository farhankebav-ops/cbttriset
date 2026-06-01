package com.ironsource.adqualitysdk.sdk.i;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class dy {

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    private static Map<String, String> f1917 = new HashMap();

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static String m2174(String str) {
        String str2 = f1917.get(str);
        if (str2 != null) {
            return str2;
        }
        f1917.put(str, str);
        return str;
    }
}
