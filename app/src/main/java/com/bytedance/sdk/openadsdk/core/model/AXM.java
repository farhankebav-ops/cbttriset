package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class AXM {
    private String IlO = "horizontal";
    private int MY = 1;
    private int EO = 1;
    private int tV = 0;
    private int Cc = 0;
    private int vCE = 0;
    private int Bc = 0;
    private int lEW = 5000;
    private int DmF = 500;
    private int NV = 0;

    public int Bc() {
        return this.Bc;
    }

    public int Cc() {
        return this.Cc;
    }

    public int DmF() {
        return this.DmF;
    }

    public int EO() {
        return this.EO;
    }

    public JSONObject EV() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("direction", this.IlO);
            jSONObject.put("auto_loop", this.MY);
            jSONObject.put("allow_manual_loop", this.EO);
            jSONObject.put("unlimited_loop", this.tV);
            jSONObject.put("left_margin", this.Cc);
            jSONObject.put("right_margin", this.vCE);
            jSONObject.put("ad_margin", this.Bc);
            jSONObject.put("loop_interval_time", this.lEW);
            jSONObject.put("flip_speed", this.DmF);
            jSONObject.put("stop_auto_loop", this.NV);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public String IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public int NV() {
        return this.NV;
    }

    public int lEW() {
        return this.lEW;
    }

    public int tV() {
        return this.tV;
    }

    public int vCE() {
        return this.vCE;
    }

    public static AXM IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return new AXM();
        }
        AXM axm = new AXM();
        axm.IlO = jSONObject.optString("direction", "horizontal");
        axm.MY = jSONObject.optInt("auto_loop", 1);
        axm.EO = jSONObject.optInt("allow_manual_loop", 1);
        axm.tV = jSONObject.optInt("unlimited_loop", 0);
        axm.Cc = jSONObject.optInt("left_margin", 0);
        axm.vCE = jSONObject.optInt("right_margin", 0);
        axm.Bc = jSONObject.optInt("ad_margin", 0);
        axm.lEW = jSONObject.optInt("loop_interval_time", 5000);
        axm.DmF = jSONObject.optInt("flip_speed", 500);
        axm.NV = jSONObject.optInt("stop_auto_loop", 0);
        return axm;
    }
}
