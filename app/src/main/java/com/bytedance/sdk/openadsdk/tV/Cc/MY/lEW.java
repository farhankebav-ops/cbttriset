package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class lEW implements EO {
    private int EO;
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
            jSONObject.put("video_start_duration", this.IlO);
            jSONObject.put("video_cache_size", this.MY);
            jSONObject.put("is_auto_play", this.EO);
        } catch (Throwable th) {
            oeT.EO("FeedPlayModel", th.getMessage());
        }
    }
}
