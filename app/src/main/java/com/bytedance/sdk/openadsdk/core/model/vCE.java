package com.bytedance.sdk.openadsdk.core.model;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    private int Bc;
    private List<String> Cc;
    private List<Integer> EO;
    private int IlO;
    private int MY;
    private int tV;
    private int vCE;

    public JSONObject Bc() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("interceptor_x", this.IlO);
            jSONObject.put("interceptor_y", this.MY);
            if (this.EO != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this.EO.iterator();
                while (it.hasNext()) {
                    jSONArray.put(it.next().intValue());
                }
                jSONObject.put("interceptor_page", jSONArray);
            }
            jSONObject.put("interceptor_interval_time", this.tV);
            if (this.Cc != null) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it2 = this.Cc.iterator();
                while (it2.hasNext()) {
                    jSONArray2.put(it2.next());
                }
                jSONObject.put("url_regular", jSONArray2);
            }
            jSONObject.put("is_act", this.vCE);
            jSONObject.put("boc_index", this.Bc);
            return jSONObject;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO(th.getMessage(), new Object[0]);
            return jSONObject;
        }
    }

    public List<Integer> Cc() {
        return this.EO;
    }

    public int EO() {
        return this.IlO;
    }

    public void IlO(int i2) {
        this.vCE = i2;
    }

    public void MY(int i2) {
        this.Bc = i2;
    }

    public int tV() {
        return this.MY;
    }

    public int vCE() {
        return this.tV;
    }

    public void Cc(int i2) {
        this.tV = i2;
    }

    public void EO(int i2) {
        this.IlO = i2;
    }

    public int IlO() {
        int i2 = this.Bc;
        if (i2 >= 2) {
            return i2;
        }
        return 0;
    }

    public List<String> MY() {
        return this.Cc;
    }

    public void tV(int i2) {
        this.MY = i2;
    }

    public void IlO(List<String> list) {
        this.Cc = list;
    }

    public void MY(List<Integer> list) {
        this.EO = list;
    }
}
