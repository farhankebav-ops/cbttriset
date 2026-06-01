package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class cl {
    public static int IlO = 1;
    public static int MY = 2;
    private int EO = 5;
    private int tV = 30;
    private int Cc = 70;
    private int vCE = 1;
    private int Bc = IlO;
    private int lEW = 0;
    private int DmF = 0;
    private int NV = 3;

    public int Bc() {
        return this.vCE;
    }

    public int Cc() {
        return this.tV;
    }

    public int EO() {
        return this.lEW;
    }

    public int IlO() {
        return this.NV;
    }

    public int MY() {
        return this.DmF;
    }

    public int lEW() {
        return this.Bc;
    }

    public int tV() {
        return this.EO;
    }

    public int vCE() {
        return this.Cc;
    }

    public void Bc(int i2) {
        this.vCE = i2;
    }

    public void Cc(int i2) {
        this.tV = i2;
    }

    public void EO(int i2) {
        this.lEW = i2;
    }

    public void IlO(int i2) {
        this.NV = i2;
    }

    public void MY(int i2) {
        this.DmF = i2;
    }

    public void lEW(int i2) {
        this.Bc = i2;
    }

    public void tV(int i2) {
        this.EO = i2;
    }

    public void vCE(int i2) {
        this.Cc = i2;
    }

    public boolean IlO(boolean z2) {
        if (z2) {
            int i2 = this.lEW;
            return i2 == 1 || i2 == 3;
        }
        int i8 = this.lEW;
        return i8 == 3 || i8 == 2;
    }

    public JSONObject IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        try {
            jSONObject.put("ceiling_time", this.EO);
            jSONObject.put("ceiling_ratio", this.tV);
            jSONObject.put("expand_ratio", this.Cc);
            jSONObject.put("back_type", this.vCE);
            jSONObject.put("boc_return_type", this.Bc);
            jSONObject.put("pre_render_status", this.lEW);
            jSONObject.put("pre_render_use_gecko", this.DmF);
            jSONObject.put("pre_render_add_type", this.NV);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("InteractionParams", th.getMessage());
            return jSONObject;
        }
    }
}
