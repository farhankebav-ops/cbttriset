package com.ironsource;

import java.util.Collection;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ua, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class C2588ua {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f10395a = 100;

    public static final boolean a(JSONObject lhs, JSONObject rhs) {
        kotlin.jvm.internal.k.e(lhs, "lhs");
        kotlin.jvm.internal.k.e(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    public static final boolean a(JSONArray lhs, JSONArray rhs) {
        kotlin.jvm.internal.k.e(lhs, "lhs");
        kotlin.jvm.internal.k.e(rhs, "rhs");
        return a(lhs, rhs, 0);
    }

    private static final boolean a(JSONObject jSONObject, JSONObject jSONObject2, int i2) {
        if (jSONObject == jSONObject2) {
            return true;
        }
        if (jSONObject.length() != jSONObject2.length() || i2 > 100) {
            return false;
        }
        Iterator<String> itKeys = jSONObject.keys();
        kotlin.jvm.internal.k.d(itKeys, "lhs.keys()");
        for (String str : (m6.a) m6.k.G0(itKeys)) {
            if (!jSONObject2.has(str) || !a(jSONObject.get(str), jSONObject2.get(str), i2)) {
                return false;
            }
        }
        return true;
    }

    private static final boolean a(JSONArray jSONArray, JSONArray jSONArray2, int i2) {
        if (jSONArray == jSONArray2) {
            return true;
        }
        if (jSONArray.length() != jSONArray2.length() || i2 > 100) {
            return false;
        }
        Iterable iterableD0 = r2.q.D0(0, jSONArray.length());
        if (!(iterableD0 instanceof Collection) || !((Collection) iterableD0).isEmpty()) {
            Iterator it = iterableD0.iterator();
            while (((k6.c) it).f12714c) {
                int iNextInt = ((r5.v) it).nextInt();
                if (!a(jSONArray.get(iNextInt), jSONArray2.get(iNextInt), i2)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static final boolean a(Object obj, Object obj2, int i2) {
        if ((obj instanceof JSONObject) && (obj2 instanceof JSONObject)) {
            return a((JSONObject) obj, (JSONObject) obj2, i2 + 1);
        }
        if ((obj instanceof JSONArray) && (obj2 instanceof JSONArray)) {
            return a((JSONArray) obj, (JSONArray) obj2, i2 + 1);
        }
        if ((obj instanceof Number) && (obj2 instanceof Number)) {
            return ((Number) obj).doubleValue() == ((Number) obj2).doubleValue();
        }
        return kotlin.jvm.internal.k.a(obj, obj2);
    }
}
