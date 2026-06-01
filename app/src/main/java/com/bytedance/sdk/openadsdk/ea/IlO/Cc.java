package com.bytedance.sdk.openadsdk.ea.IlO;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Cc {
    public static void IlO(final String str, final String str2, final int i2, final String str3) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO(str, false, 10, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.ea.IlO.Cc.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("url", str2);
                jSONObject.put("error_code", i2);
                jSONObject.put("error_msg", str3);
                return tV.MY().IlO(str).MY(jSONObject.toString());
            }
        });
    }
}
