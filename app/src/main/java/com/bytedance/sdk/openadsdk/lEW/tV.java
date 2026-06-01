package com.bytedance.sdk.openadsdk.lEW;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.YA;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class tV extends IlO {
    public static EO IlO;

    public static String IlO(com.bytedance.sdk.component.Bc.MY.EO eo, String str) {
        EO eoIlO;
        Map map;
        if (!YA.EO() || (eoIlO = MY.IlO("net")) == null || (map = (Map) eoIlO.IlO(1, str)) == null) {
            return str;
        }
        String str2 = (String) map.get("url");
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        Map map2 = (Map) map.get("header");
        if (map2 != null) {
            for (String str3 : map2.keySet()) {
                eo.MY(str3, (String) map2.get(str3));
            }
        }
        return str;
    }
}
