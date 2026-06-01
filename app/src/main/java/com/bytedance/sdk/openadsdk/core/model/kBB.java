package com.bytedance.sdk.openadsdk.core.model;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class kBB {
    private int EO;
    private String IlO;
    private int MY;

    public int EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public JSONObject tV() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.IlO)) {
                jSONObject.put("agg_endcard_url", this.IlO);
            }
            int i2 = this.MY;
            if (i2 != -1) {
                jSONObject.put("endcard_show_time", i2);
            }
            int i8 = this.EO;
            if (i8 != -1) {
                jSONObject.put("multi_rv_skip_time", i8);
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public void IlO(String str) {
        this.IlO = str;
    }

    public void MY(int i2) {
        this.EO = i2;
    }

    public void IlO(int i2) {
        this.MY = i2;
    }

    public static kBB IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        kBB kbb = new kBB();
        try {
            kbb.IlO(jSONObject.optString("agg_endcard_url", ""));
            kbb.IlO(Math.max(jSONObject.optInt("endcard_show_time", 0), 0));
            kbb.MY(jSONObject.optInt("multi_rv_skip_time", -1));
        } catch (Throwable unused) {
        }
        return kbb;
    }
}
