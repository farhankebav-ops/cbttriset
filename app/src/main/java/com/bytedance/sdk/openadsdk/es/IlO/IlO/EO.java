package com.bytedance.sdk.openadsdk.es.IlO.IlO;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.cl;
import com.bytedance.sdk.openadsdk.core.lMM;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.rp;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static boolean IlO() {
        return com.bytedance.sdk.openadsdk.AXM.IlO.IlO("deeplink_utils_new", 0) == 1;
    }

    public static boolean IlO(Context context, String str, oeT oet, int i2, Map<String, Object> map, boolean z2) {
        Map<String, Object> map2 = map;
        String strIlO = zLG.IlO(oet);
        com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, 1, null);
        Intent intentIlO = IlO(context, str, oet);
        if (TextUtils.isEmpty(str) || intentIlO == null) {
            com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, -2, oet.zTS().tV());
            return false;
        }
        boolean zLEW = zLG.lEW(context);
        if (map2 == null) {
            map2 = new HashMap<>();
        }
        Map<String, Object> map3 = map2;
        if (oet != null && oet.lQ() == 0) {
            map3.put("auto_click", Boolean.valueOf(!oet.NV()));
        }
        map3.put("can_query_install", Integer.valueOf(zLEW ? 1 : 0));
        map3.put("url", str);
        if (zLEW) {
            zLG.MY myIlO = zLG.IlO(context, intentIlO);
            if (myIlO.MY <= 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("intent", intentIlO.toString());
                    jSONObject.put("can_query_install", 1);
                } catch (Exception unused) {
                }
                com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, -3, jSONObject);
                return false;
            }
            try {
                IlO(context, oet, map3);
                map3.put("matched_count", Integer.valueOf(myIlO.MY));
                ComponentName componentName = myIlO.IlO;
                if (componentName != null) {
                    intentIlO.setComponent(componentName);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("DeepLinkUtils", th.getMessage());
            }
        }
        if (cl.tV().lEW()) {
            zLG.IlO(oet, strIlO);
        }
        try {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, strIlO, "open_url_app", map3);
            context.startActivity(intentIlO);
            rp.IlO().IlO(map3).IlO(oet, strIlO);
            com.bytedance.sdk.openadsdk.tV.EO.IlO("dp_start_act_success", oet, strIlO, map3);
            return true;
        } catch (Throwable th2) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("exception", th2.getMessage());
                jSONObject2.put("intent", intentIlO.toString());
                jSONObject2.put("can_query_install", zLEW ? 1 : 0);
            } catch (Exception unused2) {
            }
            com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, -4, jSONObject2);
            if (zLEW && !cl.tV().lEW()) {
                lMM.IlO(context, oet.pFe(), oet, i2, strIlO, z2);
            }
            return false;
        }
    }

    private static Intent IlO(Context context, String str, oeT oet) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            if (oet != null && oet.IWr() != null && !TextUtils.isEmpty(oet.IWr().tV())) {
                intent.setPackage(oet.IWr().tV());
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            return intent;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("DeepLinkUtils", th.getMessage());
            return null;
        }
    }

    private static void IlO(Context context, oeT oet, Map<String, Object> map) {
        if (oet != null && oet.lQ() == 0) {
            map.put("auto_click", Boolean.valueOf(!oet.NV()));
        }
        map.put("can_query_install", Integer.valueOf(zLG.lEW(context) ? 1 : 0));
    }
}
