package com.bytedance.sdk.openadsdk.core.settings;

import com.bytedance.sdk.openadsdk.core.settings.Cc;
import com.bytedance.sdk.openadsdk.core.settings.rp;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO extends rp {
    public IlO() {
        super("tt_set_apm.prop", new rp.IlO() { // from class: com.bytedance.sdk.openadsdk.core.settings.IlO.1
            @Override // com.bytedance.sdk.openadsdk.core.settings.rp.IlO
            public void IlO() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.settings.rp.IlO
            public void MY() {
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.settings.Cc
    public void IlO(JSONObject jSONObject) {
        Cc.IlO IlO = IlO();
        if (jSONObject.has("apm_url")) {
            IlO.IlO("apm_url", jSONObject.optString("apm_url"));
        }
        if (jSONObject.has("perf_con")) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("perf_con");
                if (jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.has("perf_con_apm")) {
                    IlO.IlO("perf_con_apm", jSONObjectOptJSONObject.optInt("perf_con_apm"));
                }
            } catch (Exception unused) {
            }
        }
        IlO.IlO();
        tV();
    }
}
