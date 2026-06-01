package com.bytedance.sdk.openadsdk.es.IlO.IlO;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.openadsdk.core.model.oeT;
import com.bytedance.sdk.openadsdk.tV.rp;
import com.bytedance.sdk.openadsdk.utils.zLG;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static boolean IlO(Context context, String str, oeT oet) {
        String strIlO = zLG.IlO(oet);
        com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, 1, null);
        Intent intentIlO = IlO(context, str);
        if (TextUtils.isEmpty(str) || intentIlO == null) {
            com.bytedance.sdk.openadsdk.core.tV.IlO(oet, strIlO, -2, oet.zTS().tV());
            return false;
        }
        boolean zLEW = zLG.lEW(context);
        HashMap mapU = a.u("url", str);
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
                IlO(context, oet, mapU);
                mapU.put("matched_count", Integer.valueOf(myIlO.MY));
                ComponentName componentName = myIlO.IlO;
                if (componentName != null) {
                    intentIlO.setComponent(componentName);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.oeT.EO("DeepLinkUtils", th.getMessage());
            }
        }
        try {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, strIlO, "open_url_app", mapU);
            context.startActivity(intentIlO);
            rp.IlO().IlO(mapU).IlO(oet, strIlO);
            com.bytedance.sdk.openadsdk.tV.EO.IlO("dp_start_act_success", oet, strIlO, mapU);
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
            return false;
        }
    }

    private static Intent IlO(Context context, String str) {
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
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
