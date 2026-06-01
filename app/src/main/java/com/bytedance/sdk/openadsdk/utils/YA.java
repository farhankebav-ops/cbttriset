package com.bytedance.sdk.openadsdk.utils;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.ironsource.C2605va;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class YA {
    private static String IlO;

    public static boolean EO() {
        return false;
    }

    public static boolean IlO() {
        return com.bytedance.sdk.component.utils.ea.tV() && com.bytedance.sdk.openadsdk.core.DmF.MY().es() && com.bytedance.sdk.openadsdk.core.DmF.MY().AXM();
    }

    public static String MY() {
        if (TextUtils.isEmpty(IlO)) {
            IlO = new String(Base64.decode("ZGV2aWNlX2lk", 0));
        }
        return IlO;
    }

    public static String IlO(String str) {
        try {
            if (!IlO()) {
                return str;
            }
            String strOeT = com.bytedance.sdk.openadsdk.core.DmF.MY().oeT();
            if (TextUtils.isEmpty(strOeT)) {
                return str;
            }
            Log.d("TestHelperUtils", "AnyDoorId=".concat(String.valueOf(strOeT)));
            return Uri.parse(str).buildUpon().appendQueryParameter(MY(), strOeT).appendQueryParameter(C2605va.f10440b, "5001121").toString();
        } catch (Throwable unused) {
            return str;
        }
    }
}
