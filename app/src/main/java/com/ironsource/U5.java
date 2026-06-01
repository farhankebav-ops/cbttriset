package com.ironsource;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class U5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final U5 f7671a = new U5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f7672b = "ext_";

    private U5() {
    }

    public final Map<String, String> a(Bundle bundle) {
        Set<String> setKeySet = bundle != null ? bundle.keySet() : null;
        if (setKeySet == null) {
            return r5.s.f13639a;
        }
        int iD0 = r5.x.d0(r5.n.L0(setKeySet, 10));
        if (iD0 < 16) {
            iD0 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(iD0);
        for (String str : setKeySet) {
            String strL = a1.a.l(f7672b, str);
            Object obj = bundle.get(str);
            linkedHashMap.put(strL, obj instanceof Iterable ? r5.l.c1((Iterable) obj, ", ", null, null, null, 62) : obj == null ? null : obj.toString());
        }
        return linkedHashMap;
    }
}
