package com.bytedance.sdk.openadsdk.core.Bc;

import com.bytedance.sdk.component.Bc.MY.tV;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.cL.Bc;
import com.bytedance.sdk.openadsdk.utils.oeT;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static void IlO(String str, long j) {
        JSONObject jSONObjectMY = MY(str, j);
        tV tVVarMY = Bc.IlO().MY().MY();
        tVVarMY.MY(zLG.tV("/api/ad/union/sdk/stats/"));
        tVVarMY.tV(jSONObjectMY.toString());
        tVVarMY.IlO(6);
        tVVarMY.IlO("uploadFrequentEvent");
        tVVarMY.IlO(new com.bytedance.sdk.component.Bc.IlO.IlO() { // from class: com.bytedance.sdk.openadsdk.core.Bc.EO.1
            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, com.bytedance.sdk.component.Bc.MY my) {
            }

            @Override // com.bytedance.sdk.component.Bc.IlO.IlO
            public void IlO(com.bytedance.sdk.component.Bc.MY.EO eo, IOException iOException) {
                iOException.getMessage();
                if (eo != null) {
                    oeT.IlO(eo.tV());
                }
            }
        });
    }

    private static JSONObject MY(String str, long j) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "over_freq");
            jSONObject.put("rit", str);
            jSONObject.put("ad_sdk_version", BuildConfig.VERSION_NAME);
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
