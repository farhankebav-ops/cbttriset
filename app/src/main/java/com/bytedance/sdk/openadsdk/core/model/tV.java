package com.bytedance.sdk.openadsdk.core.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private int Bc;
    private String IlO = "";
    private String MY = "";
    private String EO = "";
    private String tV = "";
    private double Cc = -1.0d;
    private int vCE = -1;

    public String Bc() {
        return this.tV;
    }

    public int Cc() {
        return this.vCE;
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

    public JSONObject lEW() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", MY());
            jSONObject.put("app_size", vCE());
            jSONObject.put("comment_num", Cc());
            jSONObject.put("download_url", IlO());
            jSONObject.put(C2300e4.h.V, EO());
            jSONObject.put(FirebaseAnalytics.Param.SCORE, tV());
            jSONObject.put("app_category", Bc());
            return jSONObject;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO(e.toString(), new Object[0]);
            return jSONObject;
        }
    }

    public double tV() {
        return this.Cc;
    }

    public int vCE() {
        return this.Bc;
    }

    public void EO(String str) {
        this.EO = str;
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(String str) {
        this.MY = str;
    }

    public void tV(String str) {
        this.tV = str;
    }

    public void IlO(double d8) {
        if (d8 >= 1.0d && d8 <= 5.0d) {
            this.Cc = d8;
        } else {
            this.Cc = -1.0d;
        }
    }

    public void MY(int i2) {
        this.Bc = i2;
    }

    public void IlO(int i2) {
        if (i2 <= 0) {
            this.vCE = -1;
        } else {
            this.vCE = i2;
        }
    }
}
