package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.AdSlot;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public AdSlot Cc;
    public int EO = 1;
    public String IlO;
    public int MY;
    public ArrayList<Integer> tV;

    public ArrayList<Integer> Cc() {
        return this.tV;
    }

    public int EO() {
        return this.EO;
    }

    public String IlO() {
        return this.IlO;
    }

    public int MY() {
        return this.MY;
    }

    public AdSlot tV() {
        return this.Cc;
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

    public void IlO(AdSlot adSlot) {
        this.Cc = adSlot;
    }

    public void IlO(ArrayList<Integer> arrayList) {
        this.tV = arrayList;
    }

    public static void IlO(EO eo) {
        int iMY;
        if (eo == null || eo.tV() == null || (iMY = eo.MY()) >= 0 || iMY == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.ea.EO.IlO();
        com.bytedance.sdk.openadsdk.ea.EO.IlO("rd_client_custom_error", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.core.model.EO.1
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("from", EO.this.EO());
                jSONObject.put("err_code", EO.this.MY());
                jSONObject.put("server_res_str", EO.this.IlO());
                if (EO.this.Cc() != null && EO.this.Cc().size() > 0) {
                    jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) EO.this.Cc()).toString());
                }
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("rd_client_custom_error").IlO(EO.this.tV().getDurationSlotType()).MY(jSONObject.toString());
            }
        });
    }
}
