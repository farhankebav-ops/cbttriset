package com.bytedance.sdk.openadsdk.core.EV;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    private String Bc;
    private String Cc;
    private int DmF;
    EO EO;
    private String EV;
    MY MY;
    private int NV;
    private String ea;
    private double lEW;
    private String tV;
    private String vCE;
    tV IlO = new tV(this);
    private final Set<NV> rp = new HashSet();
    private String hp = "VAST_ACTION_BUTTON";
    private boolean bWL = false;

    private JSONArray zPa() {
        JSONArray jSONArray = new JSONArray();
        for (NV nv : this.rp) {
            if (nv != null) {
                jSONArray.put(nv.tV());
            }
        }
        return jSONArray;
    }

    public String Bc() {
        return this.Bc;
    }

    public String Cc() {
        return this.Cc;
    }

    public String DmF() {
        EO eo;
        String str = this.vCE;
        if (!TextUtils.isEmpty(this.ea)) {
            String str2 = this.ea;
            this.ea = null;
            return str2;
        }
        String str3 = this.hp;
        str3.getClass();
        if (str3.equals("VAST_ICON")) {
            MY my = this.MY;
            if (my != null && !TextUtils.isEmpty(my.lEW)) {
                str = this.MY.lEW;
            }
        } else if (str3.equals("VAST_END_CARD") && (eo = this.EO) != null && !TextUtils.isEmpty(eo.lEW)) {
            str = this.EO.lEW;
        }
        this.hp = "VAST_ACTION_BUTTON";
        return str;
    }

    public EO EO() {
        return this.EO;
    }

    public String EV() {
        return this.EV;
    }

    public tV IlO() {
        return this.IlO;
    }

    public MY MY() {
        return this.MY;
    }

    public JSONObject NV() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("videoTrackers", this.IlO.IlO());
        MY my = this.MY;
        if (my != null) {
            jSONObject.put("vastIcon", my.IlO());
        }
        EO eo = this.EO;
        if (eo != null) {
            jSONObject.put("endCard", eo.IlO());
        }
        jSONObject.put("title", this.tV);
        jSONObject.put("description", this.Cc);
        jSONObject.put("clickThroughUrl", this.vCE);
        jSONObject.put("videoUrl", this.Bc);
        jSONObject.put("videDuration", this.lEW);
        jSONObject.put("tag", this.EV);
        jSONObject.put("videoWidth", this.DmF);
        jSONObject.put("videoHeight", this.NV);
        jSONObject.put("viewabilityVendor", zPa());
        return jSONObject;
    }

    public Set<NV> bWL() {
        return this.rp;
    }

    public void ea() {
        this.bWL = true;
    }

    public int hp() {
        return this.NV;
    }

    public double lEW() {
        return this.lEW;
    }

    public int rp() {
        return this.DmF;
    }

    public String tV() {
        return this.tV;
    }

    public String vCE() {
        return this.vCE;
    }

    public void Bc(String str) {
        this.ea = str;
    }

    public void Cc(String str) {
        this.hp = str;
    }

    public void EO(String str) {
        this.vCE = str;
    }

    public void IlO(MY my) {
        if (my != null) {
            my.IlO(this.Bc);
        }
        this.MY = my;
    }

    public void MY(String str) {
        this.Cc = str;
    }

    public void tV(String str) {
        this.Bc = str;
    }

    public void vCE(String str) {
        this.EV = str;
        this.IlO.IlO(str);
    }

    public void MY(int i2) {
        this.NV = i2;
    }

    public void IlO(EO eo) {
        if (eo != null) {
            eo.IlO(this.Bc);
        }
        this.EO = eo;
    }

    public void IlO(String str) {
        this.tV = str;
    }

    public void IlO(double d8) {
        this.lEW = d8;
    }

    public static IlO IlO(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        IlO ilO = new IlO();
        ilO.IlO.IlO(jSONObject.optJSONObject("videoTrackers"));
        ilO.MY = MY.IlO(jSONObject.optJSONObject("vastIcon"));
        ilO.EO = EO.MY(jSONObject.optJSONObject("endCard"));
        ilO.tV = jSONObject.optString("title");
        ilO.Cc = jSONObject.optString("description");
        ilO.vCE = jSONObject.optString("clickThroughUrl");
        ilO.Bc = jSONObject.optString("videoUrl");
        ilO.lEW = jSONObject.optDouble("videDuration");
        ilO.EV = jSONObject.optString("tag");
        ilO.DmF = jSONObject.optInt("videoWidth");
        ilO.DmF = jSONObject.optInt("videoHeight");
        ilO.rp.addAll(NV.IlO(jSONObject.optJSONArray("viewabilityVendor")));
        return ilO;
    }

    public void IlO(oeT oet) {
        this.IlO.IlO(oet);
        MY my = this.MY;
        if (my != null) {
            my.IlO(oet);
        }
        EO eo = this.EO;
        if (eo != null) {
            eo.IlO(oet);
        }
    }

    public void IlO(int i2) {
        this.DmF = i2;
    }

    public void IlO(Set<NV> set) {
        if (set == null || set.size() <= 0) {
            return;
        }
        this.rp.addAll(set);
    }
}
