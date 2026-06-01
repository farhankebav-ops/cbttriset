package com.onesignal.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q5.x;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class JSONObjectExtensionsKt {

    /* JADX INFO: renamed from: com.onesignal.common.JSONObjectExtensionsKt$putMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static final class AnonymousClass1 extends l implements e6.l {
        final /* synthetic */ Map<String, Object> $map;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Map<String, ? extends Object> map) {
            super(1);
            this.$map = map;
        }

        @Override // e6.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) throws JSONException {
            invoke((JSONObject) obj);
            return x.f13520a;
        }

        public final void invoke(JSONObject it) throws JSONException {
            k.e(it, "it");
            JSONObjectExtensionsKt.putMap(it, this.$map);
        }
    }

    public static final <T> List<T> expandJSONArray(JSONObject jSONObject, String name, e6.l into) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        k.e(into, "into");
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has(name)) {
            JSONArray jSONArray = jSONObject.getJSONArray(name);
            int length = jSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                JSONObject itemJSONObject = jSONArray.getJSONObject(i2);
                k.d(itemJSONObject, "itemJSONObject");
                Object objInvoke = into.invoke(itemJSONObject);
                if (objInvoke != null) {
                    arrayList.add(objInvoke);
                }
            }
        }
        return arrayList;
    }

    public static final void expandJSONObject(JSONObject jSONObject, String name, e6.l into) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        k.e(into, "into");
        if (jSONObject.has(name)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(name);
            k.d(jSONObject2, "this.getJSONObject(name)");
            into.invoke(jSONObject2);
        }
    }

    public static final <T> JSONObject putJSONArray(JSONObject jSONObject, String name, List<? extends T> list, e6.l create) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        k.e(create, "create");
        if (list != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject2 = (JSONObject) create.invoke(it.next());
                if (jSONObject2 != null) {
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put(name, jSONArray);
        }
        return jSONObject;
    }

    public static final JSONObject putJSONObject(JSONObject jSONObject, String name, e6.l expand) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        k.e(expand, "expand");
        JSONObject jSONObject2 = new JSONObject();
        expand.invoke(jSONObject2);
        jSONObject.put(name, jSONObject2);
        return jSONObject;
    }

    public static final JSONObject putMap(JSONObject jSONObject, Map<String, ? extends Object> map) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(map, "map");
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                value = JSONObject.NULL;
            }
            jSONObject.put(key, value);
        }
        return jSONObject;
    }

    public static final JSONObject putSafe(JSONObject jSONObject, String name, Object obj) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (obj != null) {
            jSONObject.put(name, obj);
        }
        return jSONObject;
    }

    public static final Boolean safeBool(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return Boolean.valueOf(jSONObject.getBoolean(name));
        }
        return null;
    }

    public static final Double safeDouble(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return Double.valueOf(jSONObject.getDouble(name));
        }
        return null;
    }

    public static final Integer safeInt(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return Integer.valueOf(jSONObject.getInt(name));
        }
        return null;
    }

    public static final JSONObject safeJSONObject(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return jSONObject.getJSONObject(name);
        }
        return null;
    }

    public static final Long safeLong(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return Long.valueOf(jSONObject.getLong(name));
        }
        return null;
    }

    public static final String safeString(JSONObject jSONObject, String name) {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (jSONObject.has(name)) {
            return jSONObject.getString(name);
        }
        return null;
    }

    public static final List<Object> toList(JSONArray jSONArray) {
        k.e(jSONArray, "<this>");
        int length = jSONArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i2 = 0; i2 < length; i2++) {
            Object objOpt = jSONArray.opt(i2);
            if (JSONObject.NULL.equals(objOpt)) {
                arrayList.add(null);
            } else if (objOpt instanceof JSONArray) {
                arrayList.add(toList((JSONArray) objOpt));
            } else if (objOpt instanceof JSONObject) {
                arrayList.add(toMap((JSONObject) objOpt));
            } else {
                arrayList.add(objOpt);
            }
        }
        return arrayList;
    }

    public static final Map<String, Object> toMap(JSONObject jSONObject) throws JSONException {
        k.e(jSONObject, "<this>");
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        k.d(itKeys, "this.keys()");
        while (itKeys.hasNext()) {
            String key = itKeys.next();
            Object list = jSONObject.get(key);
            k.d(key, "key");
            if (JSONObject.NULL.equals(list)) {
                list = null;
            } else if (list instanceof JSONObject) {
                list = toMap((JSONObject) list);
            } else if (list instanceof JSONArray) {
                list = toList((JSONArray) list);
            }
            map.put(key, list);
        }
        return map;
    }

    public static final JSONObject putMap(JSONObject jSONObject, String name, Map<String, ? extends Object> map) throws JSONException {
        k.e(jSONObject, "<this>");
        k.e(name, "name");
        if (map != null) {
            putJSONObject(jSONObject, name, new AnonymousClass1(map));
        }
        return jSONObject;
    }
}
