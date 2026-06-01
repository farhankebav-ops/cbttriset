package com.bytedance.sdk.component.IlO;

import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class ea {
    private final Map<String, Object> IlO = new ConcurrentHashMap();

    private ea() {
    }

    public static ea IlO() {
        return new ea();
    }

    public String MY() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : this.IlO.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public ea IlO(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.IlO.put(str, obj);
        }
        return this;
    }
}
