package com.bytedance.sdk.openadsdk.core.model;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class hp {
    private final int EO;
    private final int IlO;
    private final int MY;
    private final int tV;

    public hp(JSONObject jSONObject) {
        this.IlO = jSONObject.optInt("auto_click", 0);
        this.MY = jSONObject.optInt("close_jump_probability", 0);
        this.EO = jSONObject.optInt("skip_jump_probability", 0);
        this.tV = jSONObject.optInt("hidden_bar", 0);
    }

    public JSONObject Cc() {
        try {
            JSONObject jSONObject = new JSONObject();
            int i2 = this.IlO;
            if (i2 == 1) {
                jSONObject.put("auto_click", i2);
            }
            int i8 = this.MY;
            if (i8 > 0 && i8 <= 100) {
                jSONObject.put("close_jump_probability", i8);
            }
            int i9 = this.EO;
            if (i9 > 0 && i9 <= 100) {
                jSONObject.put("skip_jump_probability", i9);
            }
            if (this.tV == 1) {
                jSONObject.put("hidden_bar", 1);
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public int EO() {
        int i2 = this.EO;
        if (i2 < 0 || i2 > 100) {
            return 0;
        }
        return i2;
    }

    public int IlO() {
        return this.IlO;
    }

    public int MY() {
        int i2 = this.MY;
        if (i2 < 0 || i2 > 100) {
            return 0;
        }
        return i2;
    }

    public boolean tV() {
        return this.tV == 1;
    }

    public static boolean IlO(oeT oet) {
        if (oet == null || !oet.xJ() || oet.XfO() == null) {
            return false;
        }
        return oet.XfO().tV();
    }
}
