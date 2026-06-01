package com.bytedance.adsdk.ugeno.EO;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.Cc;
import com.bytedance.adsdk.ugeno.EO.IlO;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    public static String IlO(String str, JSONObject jSONObject) {
        IlO ilOEO;
        IlO.InterfaceC0029IlO interfaceC0029IlOIlO;
        if (!TextUtils.isEmpty(str) && jSONObject != null) {
            try {
                if (str.startsWith("${") && str.endsWith("}") && (ilOEO = Cc.IlO().EO()) != null && (interfaceC0029IlOIlO = ilOEO.IlO(str.substring(2, str.length() - 1))) != null) {
                    return (String) interfaceC0029IlOIlO.IlO(jSONObject);
                }
            } catch (Throwable unused) {
            }
        }
        return str;
    }
}
