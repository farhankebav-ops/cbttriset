package com.unity3d.services.core.network.mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.k;
import org.json.JSONArray;
import r5.m;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class HttpResponseHeaderToJSONArrayKt {
    public static final JSONArray toResponseHeadersMap(Map<String, ? extends List<String>> map) {
        Set<Map.Entry<String, ? extends List<String>>> setEntrySet;
        if (map == null || (setEntrySet = map.entrySet()) == null) {
            return new JSONArray();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = setEntrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            jSONArray = jSONArray.put(new JSONArray((Collection) m.H0((String) entry.getKey(), (List) entry.getValue())));
            k.d(jSONArray, "acc.put(JSONArray(listOf(key, value)))");
        }
        return jSONArray;
    }
}
