package com.ironsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.ge, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2346ge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONObject f8620a;

    public C2346ge() {
        this.f8620a = new JSONObject();
    }

    private void f(String str) {
        try {
            this.f8620a = new JSONObject(str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            this.f8620a = new JSONObject();
        }
    }

    public JSONObject a() {
        return this.f8620a;
    }

    public Object b(String str) {
        try {
            return a().get(str);
        } catch (JSONException e) {
            C2531r4.d().a(e);
            return null;
        }
    }

    public boolean c(String str) {
        return this.f8620a.optBoolean(str);
    }

    public String d(String str) {
        return this.f8620a.optString(str, null);
    }

    public boolean e(String str) {
        return a().isNull(str);
    }

    public String toString() {
        JSONObject jSONObject = this.f8620a;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean a(String str) {
        return a().has(str);
    }

    public C2346ge(String str) {
        f(str);
    }

    public static Object b(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                if (obj2 != null) {
                    jSONObject.put(obj2.toString(), b(map.get(obj2)));
                }
            }
            return jSONObject;
        }
        if (!(obj instanceof Iterable)) {
            return obj;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public String a(String str, String str2) {
        return this.f8620a.optString(str, str2);
    }

    public int a(String str, int i2) {
        return this.f8620a.optInt(str, i2);
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(a(jSONArray.get(i2)));
        }
        return arrayList;
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.f8620a.put(str, jSONObject);
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    private Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return b((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public void b(String str, String str2) {
        try {
            this.f8620a.put(str, str2);
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
    }

    private Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap map = new HashMap();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, a(jSONObject.get(next)));
        }
        return map;
    }
}
