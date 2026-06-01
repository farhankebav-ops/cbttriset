package com.bytedance.sdk.openadsdk.core.NV.Bc;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private String Cc;
    private String EO;
    private String IlO;
    private String MY;
    private String tV;

    public String Cc() {
        return this.Cc;
    }

    public String EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    public String tV() {
        return this.tV;
    }

    public IlO Cc(String str) {
        this.Cc = str;
        return this;
    }

    public IlO EO(String str) {
        this.EO = str;
        return this;
    }

    public IlO IlO(String str) {
        this.IlO = str;
        return this;
    }

    public IlO MY(String str) {
        this.MY = str;
        return this;
    }

    public IlO tV(String str) {
        this.tV = str;
        return this;
    }

    public JSONObject IlO(IlO ilO) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.IlO);
            jSONObject.put("md5", this.MY);
            jSONObject.put("url", this.EO);
            if (ilO != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", ilO.IlO());
                jSONObject2.put("md5", ilO.MY());
                jSONObject2.put("url", ilO.EO());
                jSONObject.put("overlay", jSONObject2);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }
}
