package com.bytedance.sdk.openadsdk.core.model;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    private int EO;
    private String IlO;
    private String MY;

    public int EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public String MY() {
        return this.MY;
    }

    @Nullable
    public JSONObject tV() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("u", this.IlO);
            jSONObject.put("ft", this.EO);
            jSONObject.put("fu", this.MY);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(String str) {
        this.MY = str;
    }

    public void IlO(int i2) {
        this.EO = i2;
    }
}
