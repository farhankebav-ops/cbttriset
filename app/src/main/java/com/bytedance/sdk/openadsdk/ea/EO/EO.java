package com.bytedance.sdk.openadsdk.ea.EO;

import com.ironsource.Q6;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO {
        public final String IlO;
        public final JSONObject MY;

        public IlO(String str, JSONObject jSONObject) {
            this.IlO = str;
            this.MY = jSONObject;
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("device_info");
            if (jSONObjectOptJSONObject != null) {
                try {
                    jSONObjectOptJSONObject.put(Q6.U0, com.bytedance.sdk.openadsdk.es.IlO.MY.IlO.IlO().MY());
                    jSONObject.put("device_info", jSONObjectOptJSONObject);
                } catch (JSONException unused) {
                }
            }
        }
    }

    public static MY IlO() {
        return tV.IlO();
    }
}
