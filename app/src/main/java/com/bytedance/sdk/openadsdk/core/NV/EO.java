package com.bytedance.sdk.openadsdk.core.NV;

import a1.a;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.settings.hp;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static String IlO(String str) {
        return TextUtils.isEmpty(str) ? str : IlO(hp.aP().BO(), str);
    }

    public static String IlO(String str, String str2) {
        if (TextUtils.isEmpty(str2) || str2.startsWith("http://") || str2.startsWith("https://")) {
            return str2;
        }
        if (!TextUtils.isEmpty(str) && !str.endsWith("/")) {
            return a.D(str, "/static/", str2);
        }
        return a.D(str, "static/", str2);
    }
}
