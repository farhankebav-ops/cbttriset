package com.bytedance.sdk.openadsdk.tV.Cc.MY;

import com.bytedance.sdk.component.utils.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class NV implements EO {
    private String Cc;
    private long EO;
    private String IlO;
    private long MY;
    private int tV;
    private String vCE;

    public void EO(String str) {
        this.vCE = str;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(long j) {
        this.EO = j;
    }

    public void IlO(long j) {
        this.MY = j;
    }

    public void MY(String str) {
        this.Cc = str;
    }

    public void IlO(int i2) {
        this.tV = i2;
    }

    @Override // com.bytedance.sdk.openadsdk.tV.Cc.MY.EO
    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("preload_url", this.IlO);
            jSONObject.put("preload_size", this.MY);
            jSONObject.put("load_time", this.EO);
            jSONObject.put("error_code", this.tV);
            jSONObject.put("error_message", this.Cc);
            jSONObject.put("error_message_server", this.vCE);
        } catch (Throwable th) {
            oeT.EO("LoadVideoErrorModel", th.getMessage());
        }
    }
}
