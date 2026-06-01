package com.bytedance.adsdk.ugeno.tV;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.tV.vCE;
import java.util.HashMap;
import java.util.Set;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    public static vCE.IlO IlO(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        vCE.IlO ilO = new vCE.IlO();
        String strIlO = com.bytedance.adsdk.ugeno.EO.MY.IlO(str, jSONObject);
        Uri uri = Uri.parse(strIlO);
        if (uri == null) {
            return null;
        }
        ilO.EO(strIlO);
        if (!TextUtils.isEmpty(uri.getScheme())) {
            ilO.IlO(uri.getScheme());
        }
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            authority = uri.getPath();
        }
        ilO.MY(authority);
        ilO.tV(ilO.IlO() + "://" + ilO.MY());
        HashMap map = new HashMap();
        Set<String> queryParameterNames = uri.getQueryParameterNames();
        if (queryParameterNames != null && queryParameterNames.size() > 0) {
            for (String str2 : queryParameterNames) {
                map.put(str2, com.bytedance.adsdk.ugeno.EO.MY.IlO(uri.getQueryParameter(str2), jSONObject));
            }
        }
        ilO.IlO(map);
        return ilO;
    }
}
