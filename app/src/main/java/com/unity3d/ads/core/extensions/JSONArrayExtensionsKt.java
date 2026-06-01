package com.unity3d.ads.core.extensions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.d;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import org.json.JSONException;
import r2.q;
import r5.n;
import r5.v;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONArrayExtensionsKt {
    public static final Map<String, List<String>> getHeadersMap(JSONArray jSONArray) throws JSONException {
        k.e(jSONArray, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = jSONArray.get(i2);
            k.c(obj, "null cannot be cast to non-null type org.json.JSONArray");
            JSONArray jSONArray2 = (JSONArray) obj;
            List arrayList = (List) linkedHashMap.get(jSONArray2.getString(0));
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            String string = jSONArray2.getString(1);
            k.d(string, "header.getString(1)");
            arrayList.add(string);
            String string2 = jSONArray2.getString(0);
            k.d(string2, "header.getString(0)");
            linkedHashMap.put(string2, arrayList);
        }
        return linkedHashMap;
    }

    public static final Object[] toTypedArray(JSONArray jSONArray) {
        k.e(jSONArray, "<this>");
        d dVarD0 = q.D0(0, jSONArray.length());
        ArrayList arrayList = new ArrayList(n.L0(dVarD0, 10));
        Iterator it = dVarD0.iterator();
        while (it.hasNext()) {
            arrayList.add(jSONArray.get(((v) it).nextInt()));
        }
        return arrayList.toArray(new Object[0]);
    }
}
