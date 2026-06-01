package com.bytedance.sdk.component.adexpress.dynamic.Cc;

import com.bytedance.sdk.component.adexpress.MY.hp;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc implements lEW {
    private com.bytedance.sdk.component.adexpress.dynamic.vCE.MY IlO;

    /* JADX INFO: Access modifiers changed from: private */
    public void MY(hp hpVar) {
        try {
            JSONObject jSONObjectEO = hpVar.EO();
            JSONObject jSONObject = new JSONObject(jSONObjectEO.optString("template_Plugin"));
            JSONObject jSONObjectOptJSONObject = jSONObjectEO.optJSONObject("creative");
            com.bytedance.sdk.component.adexpress.dynamic.tV.lEW lewIlO = new vCE(jSONObject, jSONObjectOptJSONObject, jSONObjectEO.optJSONObject("AdSize"), new JSONObject(jSONObjectEO.optString("diff_template_Plugin"))).IlO(hpVar.MY(), hpVar.NV(), jSONObjectOptJSONObject.optDouble("score_exact_i18n"), jSONObjectOptJSONObject.optString("comment_num_i18n"), hpVar);
            try {
                JSONObject jSONObject2 = new JSONObject(jSONObjectOptJSONObject.optString("dynamic_creative"));
                lewIlO.IlO(jSONObject2.optString("color"));
                lewIlO.IlO(jSONObject2.optJSONArray("material_center"));
            } catch (Throwable unused) {
            }
            this.IlO.IlO(lewIlO);
        } catch (Exception unused2) {
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW
    public void IlO(com.bytedance.sdk.component.adexpress.dynamic.vCE.MY my) {
        this.IlO = my;
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.Cc.lEW
    public void IlO(final hp hpVar) {
        if (hpVar.rp() == 1) {
            MY(hpVar);
        } else {
            com.bytedance.sdk.component.adexpress.tV.tV.IlO(new com.bytedance.sdk.component.lEW.lEW("dynamicparse") { // from class: com.bytedance.sdk.component.adexpress.dynamic.Cc.Bc.1
                @Override // java.lang.Runnable
                public void run() {
                    Bc.this.MY(hpVar);
                }
            }, 5);
        }
    }
}
