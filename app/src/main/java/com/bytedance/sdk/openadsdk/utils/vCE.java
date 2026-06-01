package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.ironsource.C2300e4;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vCE {
    public static String IlO(String str) {
        if (!com.bytedance.sdk.component.utils.ea.tV() || TextUtils.isEmpty(str)) {
            return str;
        }
        com.bytedance.sdk.openadsdk.core.model.lEW lew = new com.bytedance.sdk.openadsdk.core.model.lEW(com.bytedance.sdk.openadsdk.core.DmF.MY().ea());
        StringBuilder sb = new StringBuilder(str);
        Iterator<String> it = lew.MY().iterator();
        while (it.hasNext()) {
            if (sb.toString().contains(it.next())) {
                if (sb.toString().contains("?")) {
                    sb.append(C2300e4.i.f8401c);
                    sb.append(lew.IlO());
                } else {
                    sb.append("?");
                    sb.append(lew.IlO());
                }
            }
        }
        return sb.toString();
    }
}
