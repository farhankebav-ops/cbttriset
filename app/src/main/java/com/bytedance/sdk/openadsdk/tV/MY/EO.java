package com.bytedance.sdk.openadsdk.tV.MY;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO implements MY {
    MY IlO;

    @Override // com.bytedance.sdk.openadsdk.tV.MY.MY
    public void IlO(JSONObject jSONObject, long j) throws JSONException {
        MY my = this.IlO;
        if (my != null) {
            my.IlO(jSONObject, j);
        }
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        jSONObject.put("event_ts", j);
    }
}
