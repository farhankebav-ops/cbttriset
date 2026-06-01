package com.bytedance.sdk.openadsdk.core.lEW;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EV {
    public static void IlO(String str, int i2, String str2, String str3, String str4, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (TextUtils.isEmpty(str2)) {
            str2 = com.bytedance.sdk.openadsdk.core.lEW.IlO(i2);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("render_source", str);
            oeT.IlO ilOUvo = oet.uvo();
            if (ilOUvo != null) {
                jSONObject.put("tpl_id", ilOUvo.vCE());
                if ("Web".equals(str)) {
                    if (ilOUvo.bWL()) {
                        jSONObject.put("engine_version", "v3");
                    } else {
                        jSONObject.put("engine_version", "v1");
                    }
                }
            } else if (oet.Ea() != null) {
                jSONObject.put("tpl_id", oet.Ea().IlO());
                if ("Web".equals(str)) {
                    jSONObject.put("engine_version", "v3");
                }
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.ea.EO.IlO().IlO(com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO(IlO(str3)).EO(str4).Cc(oet != null ? oet.JAC() : "").MY(i2).MY(jSONObject.toString()).vCE(str2));
    }

    private static int IlO(String str) {
        str.getClass();
        switch (str) {
            case "banner_ad":
                return 1;
            case "rewarded_video":
                return 7;
            case "open_ad":
                return 3;
            case "fullscreen_interstitial_ad":
                return 8;
            case "interaction":
                return 2;
            default:
                return 5;
        }
    }
}
