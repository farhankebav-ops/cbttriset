package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bykv.vk.openvk.IlO.IlO.IlO.EO.b;
import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class bWL implements EO {
    private final String Cc;
    private final int EO;
    private long IlO;
    private long MY;
    private final int tV;

    public bWL(b bVar) {
        this.EO = bVar.f4682a;
        this.tV = bVar.f4683b;
        this.Cc = bVar.f4684c;
    }

    public void IlO(long j) {
        this.IlO = j;
    }

    public void MY(long j) {
        this.MY = j;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.Cc.MY.EO
    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("buffers_time", this.IlO);
            jSONObject.put("total_duration", this.MY);
            jSONObject.put("error_code", this.EO);
            jSONObject.put("extra_error_code", this.tV);
            jSONObject.put("error_message", this.Cc);
        } catch (Throwable th) {
            oeT.EO("PlayErrorModel", th.getMessage());
        }
    }
}
