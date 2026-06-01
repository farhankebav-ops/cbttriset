package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp implements EO {
    public long EO;
    public long IlO;
    public int MY;

    public void IlO(long j) {
        this.IlO = j;
    }

    public void MY(long j) {
        this.EO = j;
    }

    public void IlO(int i2) {
        this.MY = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.Cc.MY.EO
    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.IlO);
            jSONObject.put("buffers_count", this.MY);
            jSONObject.put("total_duration", this.EO);
        } catch (Throwable th) {
            oeT.EO("PlayBufferModel", th.getMessage());
        }
    }
}
