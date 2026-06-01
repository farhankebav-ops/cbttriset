package com.bytedance.sdk.openadsdk.core.model;

import android.content.Intent;
import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tl {
    private String Bc;
    private String Cc;
    private String DmF;
    private int EO;
    private int EV;
    private String IlO;
    private String MY;
    private String NV;
    private int lEW;
    private int tV;
    private String vCE;

    public void Bc(String str) {
        this.MY = str;
    }

    public String Cc() {
        return this.vCE;
    }

    public String DmF() {
        return this.EO == 2 ? this.MY : this.IlO;
    }

    public String EO() {
        return this.DmF;
    }

    public String IlO() {
        return this.Bc;
    }

    public int MY() {
        return this.lEW;
    }

    public JSONObject NV() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.IlO)) {
                jSONObject.put("market_dpl", this.IlO);
            }
            if (!TextUtils.isEmpty(this.MY)) {
                jSONObject.put("market_dpl_auto", this.MY);
            }
            if (!TextUtils.isEmpty(this.Cc)) {
                jSONObject.put("market_pkg", this.Cc);
            }
            if (!TextUtils.isEmpty(this.Bc)) {
                jSONObject.put("app_pkg", this.Bc);
            }
            if (!TextUtils.isEmpty(this.vCE)) {
                jSONObject.put("regex", this.vCE);
            }
            jSONObject.put("exec_type", this.EO);
            jSONObject.put("oem_vendor_type", this.tV);
            jSONObject.put("overlay", this.lEW);
            jSONObject.put("gp_card", this.EV);
            if (!TextUtils.isEmpty(this.DmF)) {
                jSONObject.put("caller_id", this.DmF);
            }
            if (!TextUtils.isEmpty(this.NV)) {
                jSONObject.put("ext_map", this.NV);
            }
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("OemModel", th.getMessage());
            return null;
        }
    }

    public boolean lEW() {
        return this.EV == 1;
    }

    public String tV() {
        return this.Cc;
    }

    public void vCE(String str) {
        this.IlO = str;
    }

    public boolean Bc() {
        return this.tV == 1;
    }

    public void Cc(String str) {
        this.vCE = str;
    }

    public void EO(String str) {
        this.NV = str;
    }

    public void IlO(String str) {
        this.Bc = str;
    }

    public void MY(int i2) {
        this.lEW = i2;
    }

    public void tV(String str) {
        this.Cc = str;
    }

    public int vCE() {
        return this.tV;
    }

    public void EO(int i2) {
        this.EO = i2;
    }

    public void IlO(int i2) {
        this.EV = i2;
    }

    public void MY(String str) {
        this.DmF = str;
    }

    public void tV(int i2) {
        this.tV = i2;
    }

    public static tl IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tl tlVar = new tl();
        try {
            tlVar.vCE(jSONObject.optString("market_dpl", ""));
            tlVar.Bc(jSONObject.optString("market_dpl_auto", ""));
            tlVar.EO(jSONObject.optInt("exec_type", 0));
            tlVar.tV(jSONObject.optInt("oem_vendor_type", 0));
            tlVar.tV(jSONObject.optString("market_pkg", ""));
            tlVar.Cc(jSONObject.optString("regex", ""));
            tlVar.MY(jSONObject.optInt("overlay", 1));
            tlVar.MY(jSONObject.optString("caller_id", ""));
            tlVar.EO(jSONObject.optString("ext_map", null));
            tlVar.IlO(jSONObject.optInt("gp_card", 0));
            tlVar.IlO(jSONObject.optString("app_pkg", ""));
            return tlVar;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("OemModel", th.getMessage());
            return tlVar;
        }
    }

    public void IlO(Intent intent) {
        if (TextUtils.isEmpty(this.NV)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.NV);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObject.get(next);
                if (obj instanceof String) {
                    intent.putExtra(next, (String) obj);
                } else if (obj instanceof Integer) {
                    intent.putExtra(next, (Integer) obj);
                } else if (obj instanceof Boolean) {
                    intent.putExtra(next, (Boolean) obj);
                } else if (obj instanceof Long) {
                    intent.putExtra(next, (Long) obj);
                } else if (obj instanceof Double) {
                    intent.putExtra(next, (Double) obj);
                } else if (obj instanceof Float) {
                    intent.putExtra(next, (Float) obj);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
