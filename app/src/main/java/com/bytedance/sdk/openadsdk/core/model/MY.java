package com.bytedance.sdk.openadsdk.core.model;

import com.ironsource.C2300e4;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private boolean Cc;
    private String EO;
    private String IlO;
    private String MY;
    private String tV;

    public boolean Cc() {
        return this.Cc;
    }

    public String EO() {
        return this.EO;
    }

    public void IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.IlO = jSONObject.optString(C2300e4.h.H0);
        this.MY = jSONObject.optString(C2300e4.h.K0);
        this.EO = jSONObject.optString("privacy_url");
        this.tV = jSONObject.optString("privacy_title");
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
            jSONObject.put("privacy_url", this.EO);
            jSONObject.put("privacy_title", this.tV);
            jSONObject.put(C2300e4.h.K0, this.MY);
            jSONObject.put(C2300e4.h.H0, this.IlO);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public String IlO() {
        return this.IlO;
    }

    public void IlO(boolean z2) {
        this.Cc = z2;
    }
}
