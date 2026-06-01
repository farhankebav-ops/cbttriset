package com.bytedance.sdk.openadsdk.core.rp.EO;

import com.bytedance.sdk.openadsdk.core.model.OOq;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static void IlO(oeT oet) {
        if (OOq.MY(oet)) {
            com.bytedance.sdk.openadsdk.tV.EO.MY(oet, "playable_preload", "preload_start", (JSONObject) null);
        }
    }

    public static void IlO(oeT oet, long j, long j3) {
        if (oet != null) {
            if (OOq.EO(oet) || OOq.MY(oet)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("loadzip_success_time", j);
                    jSONObject.put("unzip_success_time", j3);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.oeT.IlO("PlayableEvent", "onSuccess json error", e);
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(oet, "playable_preload", "preload_success", jSONObject);
            }
        }
    }

    public static void IlO(oeT oet, int i2, String str) {
        if (oet != null) {
            if (OOq.EO(oet) || OOq.MY(oet)) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i2);
                    jSONObject.put("error_reason", str);
                } catch (JSONException e) {
                    com.bytedance.sdk.component.utils.oeT.IlO("PlayableEvent", "onFail json error", e);
                }
                com.bytedance.sdk.openadsdk.tV.EO.MY(oet, "playable_preload", "preload_fail", jSONObject);
            }
        }
    }
}
