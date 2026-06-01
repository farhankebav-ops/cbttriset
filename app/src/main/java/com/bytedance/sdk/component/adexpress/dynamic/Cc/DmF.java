package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import a1.a;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class DmF {
    public static void IlO(String str, JSONObject jSONObject) {
        JSONObject jSONObjectDm = com.bytedance.sdk.component.adexpress.MY.dm(str);
        if (jSONObjectDm == null) {
            return;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject jSONObjectOptJSONObject = jSONObjectDm.optJSONObject("values");
        if (jSONObjectOptJSONObject == null) {
            return;
        }
        IlO(jSONObjectOptJSONObject, jSONObject);
    }

    public static String MY(String str, String str2) {
        if (!com.bytedance.sdk.component.adexpress.tV.MY()) {
            return IlO.IlO(str);
        }
        if (str.indexOf(46) < 0) {
            str = str.concat(".png");
        }
        return a.D(str2, "static/images/", str);
    }

    public static JSONObject IlO(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObjectDm = com.bytedance.sdk.component.adexpress.MY.dm(str);
        if (jSONObjectDm == null) {
            return null;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        return IlO(jSONObject2, jSONObjectDm.optJSONObject("themeValues"), jSONObject);
    }

    private static void IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject2 == null) {
            jSONObject2 = new JSONObject();
        }
        if (jSONObject == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!jSONObject2.has(next)) {
                try {
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static JSONObject IlO(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        for (JSONObject jSONObject2 : jSONObjectArr) {
            if (jSONObject2 != null) {
                Iterator<String> itKeys = jSONObject2.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.put(next, jSONObject2.opt(next));
                    } catch (JSONException unused) {
                    }
                }
            }
        }
        return jSONObject;
    }

    public static String IlO(String str) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectDm = com.bytedance.sdk.component.adexpress.MY.dm(str);
        if (jSONObjectDm == null || (jSONObjectOptJSONObject = jSONObjectDm.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString("data");
    }

    public static String IlO(String str, String str2) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectDm = com.bytedance.sdk.component.adexpress.MY.dm(str);
        if (jSONObjectDm == null || (jSONObjectOptJSONObject = jSONObjectDm.optJSONObject("values")) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optString(str2);
    }

    public static JSONObject IlO(JSONArray jSONArray) {
        JSONObject jSONObjectOptJSONObject;
        if (jSONArray == null || jSONArray.length() <= 0 || (jSONObjectOptJSONObject = jSONArray.optJSONObject(0)) == null) {
            return null;
        }
        return jSONObjectOptJSONObject.optJSONObject("values");
    }
}
