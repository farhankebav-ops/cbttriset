package com.ironsource.adqualitysdk.sdk.i;

import java.util.Collection;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class df extends da {
    /* JADX INFO: renamed from: ﺙ, reason: contains not printable characters */
    public static String m1923(List<Object> list) {
        return ka.m2875((String) da.m1896(list, 0, String.class));
    }

    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static List<String> m1924(List<Object> list) {
        return hu.m2386().m2388().m2437(da.m1896(list, 0, Object.class), (List) da.m1896(list, 1, List.class), ((Integer) da.m1896(list, 2, Integer.class)).intValue());
    }

    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static int m1925(List<Object> list) {
        return ka.m2874((String) da.m1896(list, 0, String.class), (String) da.m1896(list, 1, String.class));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static String m1926(List<Object> list) {
        String str = (String) da.m1896(list, 0, String.class);
        boolean zBooleanValue = list.size() > 2 ? ((Boolean) da.m1896(list, 2, Boolean.class)).booleanValue() : true;
        return list.get(1) instanceof String ? ka.m2876(str, (String) da.m1896(list, 1, String.class), zBooleanValue) : ka.m2883(str, new JSONArray((Collection) da.m1896(list, 1, List.class)), zBooleanValue);
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static boolean m1927(List<Object> list) {
        return ka.m2884((String) da.m1896(list, 0, String.class));
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static List<String> m1928(List<Object> list) {
        String str = (String) da.m1896(list, 0, String.class);
        return list.get(1) instanceof String ? ka.m2879(str, (String) da.m1896(list, 1, String.class)) : ka.m2885(str, new JSONArray((Collection) da.m1896(list, 1, List.class)));
    }
}
