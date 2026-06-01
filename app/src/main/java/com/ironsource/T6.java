package com.ironsource;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class T6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static T6 f7626a = new T6();

    public static T6 a() {
        return f7626a;
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                if (objOpt instanceof List) {
                    jSONObject.put(next, TextUtils.join(",", (List) objOpt));
                }
            }
        }
        return jSONObject;
    }

    public static HashMap<String, Object> a(ConcurrentHashMap<String, Object> concurrentHashMap) throws JSONException {
        HashMap<String, Object> map = new HashMap<>();
        for (Map.Entry<String, Object> entry : concurrentHashMap.entrySet()) {
            if (entry.getValue() instanceof JSONObject) {
                map.put(entry.getKey(), a((JSONObject) entry.getValue()));
            } else if (entry.getValue() instanceof JSONArray) {
                map.put(entry.getKey(), a((JSONArray) entry.getValue()));
            } else if (entry.getValue() instanceof Map) {
                map.put(entry.getKey(), a((Map<String, Object>) entry.getValue()));
            } else {
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }

    public static JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            jSONObject2.put(next, jSONObject.opt(next));
        }
        return jSONObject2;
    }

    public static JSONArray a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            jSONArray2.put(jSONArray.opt(i2));
        }
        return jSONArray2;
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        for (String str : map.keySet()) {
            map2.put(str, map.get(str));
        }
        return map2;
    }
}
