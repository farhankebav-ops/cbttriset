package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.tV.MY;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class es {
    public static void IlO(Context context, boolean z2, JSONObject jSONObject, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str, int i2, WebView webView, com.bytedance.sdk.openadsdk.core.widget.Cc cc) {
        int iOptInt = jSONObject.optInt("landingStyle");
        String strOptString = jSONObject.optString("url");
        String strOptString2 = jSONObject.optString("fallback_url");
        try {
            jSONObject.put("is_activity", z2);
        } catch (JSONException unused) {
        }
        boolean z7 = true;
        com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, 1, jSONObject);
        if (TextUtils.isEmpty(strOptString)) {
            return;
        }
        if (iOptInt == 0) {
            if (webView != null) {
                webView.loadUrl(strOptString);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, 2, (JSONObject) null);
            } else {
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, -1, (JSONObject) null);
            }
        } else if (iOptInt == 1 || iOptInt == 8) {
            com.bytedance.sdk.openadsdk.ea.IlO.MY my = new com.bytedance.sdk.openadsdk.ea.IlO.MY();
            my.IlO(MY.IlO.MY);
            my.IlO(oet);
            my.MY(str);
            my.IlO(-1);
            my.IlO(false);
            my.MY(oet.Jz());
            com.bytedance.sdk.openadsdk.tV.EO.IlO(my);
            com.bytedance.sdk.openadsdk.utils.vAh.IlO(context, strOptString, oet, MY.IlO.MY);
        } else if (iOptInt == 2) {
            if (!com.bytedance.sdk.openadsdk.utils.vAh.MY(context, strOptString, oet, str)) {
                com.bytedance.sdk.openadsdk.ea.IlO.MY my2 = new com.bytedance.sdk.openadsdk.ea.IlO.MY();
                my2.IlO(MY.IlO.MY);
                my2.IlO(oet);
                my2.MY(str);
                my2.IlO(-1);
                my2.IlO(false);
                my2.MY(oet.Jz());
                com.bytedance.sdk.openadsdk.tV.EO.IlO(my2);
                HashMap map = new HashMap();
                map.put("deeplink_url", strOptString);
                map.put("fallback_url", strOptString2);
                map.put("jsb_deeplink", 1);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, "open_fallback_url", map);
                com.bytedance.sdk.openadsdk.utils.vAh.IlO(context, strOptString2, oet, MY.IlO.MY);
            }
        } else if (iOptInt != 3) {
            z7 = false;
        } else if (lMM.MY(context, strOptString, oet, i2, str, false)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, 3, (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str, -2, (JSONObject) null);
        }
        if (cc == null || !z7) {
            return;
        }
        cc.IlO();
    }
}
