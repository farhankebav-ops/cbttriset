package com.bytedance.sdk.openadsdk.core.NV.Cc;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.es;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class Bc {
    public void IlO(String str, oeT oet, String str2, Map<String, String> map) {
        if (map != null) {
            try {
                if (map.isEmpty()) {
                    return;
                }
                String str3 = map.get("label");
                if (TextUtils.isEmpty(str3)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                String strKT = oet.KT();
                if (!"sendLogExtra".equals(str) || TextUtils.isEmpty(strKT)) {
                    jSONObject.put("log_extra", strKT);
                } else {
                    JSONObject jSONObject2 = new JSONObject(strKT);
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        if (!"label".equals(entry.getKey())) {
                            jSONObject2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    jSONObject.put("log_extra", jSONObject2.toString());
                }
                JSONObject jSONObject3 = new JSONObject();
                if ("sendAdExtra".equals(str)) {
                    for (Map.Entry<String, String> entry2 : map.entrySet()) {
                        if (!"label".equals(entry2.getKey())) {
                            jSONObject3.put(entry2.getKey(), entry2.getValue());
                        }
                    }
                }
                jSONObject.put("ad_extra_data", jSONObject3.toString());
                jSONObject.putOpt("ua_policy", Integer.valueOf(oet.quf()));
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, "app_union", str2, str3, Long.parseLong(oet.ED()), 0L, jSONObject, es.Cc(oet));
            } catch (Throwable unused) {
            }
        }
    }
}
