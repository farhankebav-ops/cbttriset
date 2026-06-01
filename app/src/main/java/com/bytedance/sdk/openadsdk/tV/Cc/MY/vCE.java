package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE implements EO {
    private int EO = 0;
    private long IlO;
    private long MY;

    public void IlO(long j) {
        this.IlO = j;
    }

    public void MY(long j) {
        this.MY = j;
    }

    public void IlO(int i2) {
        this.EO = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.Cc.MY.EO
    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("total_duration", this.IlO);
            jSONObject.put("buffers_time", this.MY);
            jSONObject.put("video_backup", this.EO);
        } catch (Throwable th) {
            oeT.EO("FeedOverModel", th.getMessage());
        }
    }
}
