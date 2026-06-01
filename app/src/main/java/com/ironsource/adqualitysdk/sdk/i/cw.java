package com.ironsource.adqualitysdk.sdk.i;

import com.ironsource.adqualitysdk.sdk.i.ht;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class cw extends da {
    /* JADX INFO: renamed from: ﻛ, reason: contains not printable characters */
    public static ht.e m1836() {
        return new ht.e();
    }

    /* JADX INFO: renamed from: ｋ, reason: contains not printable characters */
    public static List<Method> m1837(List<Object> list) {
        ht htVar = (ht) da.m1896(list, 1, ht.class);
        return list.get(0) instanceof Class ? hr.m2346((Class) da.m1896(list, 0, Class.class), htVar) : hr.m2346(da.m1896(list, 0, Object.class).getClass(), htVar);
    }

    /* JADX INFO: renamed from: ﾒ, reason: contains not printable characters */
    public static Method m1838(List<Object> list) {
        ht htVar = (ht) da.m1896(list, 1, ht.class);
        return list.get(0) instanceof Class ? hr.m2347((Class) da.m1896(list, 0, Class.class), htVar) : hr.m2347(da.m1896(list, 0, Object.class).getClass(), htVar);
    }
}
