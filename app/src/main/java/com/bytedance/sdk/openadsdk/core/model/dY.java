package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class dY {
    private JSONObject Cc;
    private String EO;
    private String IlO;
    private String MY;
    private String tV;

    public JSONObject Cc() {
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

    public JSONObject vCE() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.IlO);
            jSONObject.put("md5", this.MY);
            jSONObject.put("url", this.EO);
            jSONObject.put("data", this.tV);
            jSONObject.put("custom_components", this.Cc);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static dY IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        dY dYVar = new dY();
        dYVar.IlO = jSONObject.optString("id");
        dYVar.tV = jSONObject.optString("data");
        dYVar.EO = jSONObject.optString("url");
        dYVar.MY = jSONObject.optString("md5");
        dYVar.Cc = jSONObject.optJSONObject("custom_components");
        return dYVar;
    }
}
