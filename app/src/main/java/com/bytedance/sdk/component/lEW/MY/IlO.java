package com.bytedance.sdk.component.lEW.MY;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public int EO;
    public int IlO;
    public int MY;
    public int tV;

    public IlO(int i2, int i8, int i9, int i10) {
        this.IlO = i2;
        this.MY = i8;
        this.EO = i9;
        this.tV = i10;
    }

    public JSONObject IlO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_thread_num", this.IlO);
            jSONObject.put("sdk_max_thread_num", this.MY);
            jSONObject.put("app_thread_num", this.EO);
            jSONObject.put("app_max_thread_num", this.tV);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }
}
