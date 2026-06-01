package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.hm;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class ct extends da {
    /* JADX INFO: renamed from: ﻐ, reason: contains not printable characters */
    public static Field m1820(List<Object> list) {
        return hu.m2386().m2389().m2329((Class) da.m1896(list, 0, Class.class), (hm) da.m1896(list, 1, hm.class));
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static Field m1821(List<Object> list) {
        if (!(list.get(0) instanceof Class)) {
            Object objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
            return hu.m2386().m2389().m2330(objM1896.getClass(), (Class) da.m1896(list, 1, Class.class));
        }
        Class cls = (Class) da.m1896(list, 0, Class.class);
        if (list.get(1) instanceof Class) {
            return hu.m2386().m2389().m2330(cls, (Class) da.m1896(list, 1, Class.class));
        }
        return hu.m2386().m2389().m2329(cls, (hm) da.m1896(list, 1, hm.class));
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static List<Field> m1823(List<Object> list) {
        if (!(list.get(0) instanceof Class)) {
            Object objM1896 = da.m1896(list, 0, (Class<Object>) Object.class);
            boolean zBooleanValue = list.size() > 1 ? ((Boolean) da.m1896(list, 1, Boolean.class)).booleanValue() : false;
            hu.m2386().m2389();
            Field[] fieldArrM2328 = hn.m2328(objM1896.getClass(), zBooleanValue, -1, null);
            if (fieldArrM2328 != null) {
                return Arrays.asList(fieldArrM2328);
            }
        } else if (list.size() > 1) {
            return hu.m2386().m2389().m2331((Class) da.m1896(list, 0, Class.class), (hm) da.m1896(list, 1, hm.class));
        }
        return new ArrayList();
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Field m1824(List<Object> list) {
        return hu.m2386().m2389().m2332((Class) da.m1896(list, 0, Class.class), (String) da.m1896(list, 1, String.class));
    }

    /* JADX INFO: renamed from: ﾇ, reason: contains not printable characters */
    public static hm.e m1822() {
        hu.m2386().m2389();
        return hn.m2325();
    }
}
