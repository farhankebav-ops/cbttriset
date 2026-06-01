package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV implements EO {
    private final String IlO;
    private final long MY;

    public EV(String str, long j) {
        this.IlO = str;
        this.MY = j;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.Cc.MY.EO
    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.IlO);
            jSONObject.put("preload_size", this.MY);
        } catch (Throwable th) {
            oeT.EO("LoadVideoStartModel", th.getMessage());
        }
    }
}
