package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static JSONObject IlO(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject jSONObject3 = new JSONObject();
        if (jSONObject2 == null || jSONObject2.length() <= 0 || jSONObject == null) {
            return jSONObject;
        }
        try {
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object objOpt = jSONObject.opt(next);
                Object objOpt2 = jSONObject2.opt(next);
                if (objOpt2 == null || objOpt2 == JSONObject.NULL) {
                    jSONObject3.put(next, objOpt);
                } else if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                    jSONObject3.put(next, IlO((JSONObject) objOpt, (JSONObject) objOpt2));
                } else if ((objOpt instanceof JSONArray) && (objOpt2 instanceof JSONArray)) {
                    jSONObject3.put(next, IlO((JSONArray) objOpt, (JSONArray) objOpt2));
                } else {
                    jSONObject3.put(next, objOpt2);
                }
            }
            Iterator<String> itKeys2 = jSONObject2.keys();
            while (itKeys2.hasNext()) {
                String next2 = itKeys2.next();
                if (!jSONObject.has(next2)) {
                    jSONObject3.put(next2, jSONObject2.opt(next2));
                }
            }
        } catch (JSONException unused) {
        }
        return jSONObject3;
    }

    private static JSONArray IlO(JSONArray jSONArray, JSONArray jSONArray2) {
        if (jSONArray2 == null || jSONArray2.length() <= 0) {
            return jSONArray;
        }
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        JSONArray jSONArray3 = new JSONArray();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                Object objOpt = jSONArray.opt(i2);
                Object objOpt2 = jSONArray2.opt(i2);
                if (objOpt2 != null && objOpt2 != JSONObject.NULL) {
                    if ((objOpt instanceof JSONObject) && (objOpt2 instanceof JSONObject)) {
                        jSONArray3.put(i2, IlO((JSONObject) objOpt, (JSONObject) objOpt2));
                    } else if ((objOpt instanceof JSONArray) && (objOpt2 instanceof JSONArray)) {
                        jSONArray3.put(i2, IlO((JSONArray) objOpt, (JSONArray) objOpt2));
                    } else {
                        jSONArray3.put(i2, objOpt2);
                    }
                } else {
                    jSONArray3.put(i2, objOpt);
                }
            } catch (JSONException unused) {
            }
        }
        return jSONArray3;
    }
}
