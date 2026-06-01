package com.bytedance.sdk.openadsdk.core;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, int i2, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("type", i2);
        } catch (JSONException unused) {
        }
        com.bytedance.sdk.openadsdk.tV.EO.MY(oet, str, "convert_track", jSONObject);
    }
}
