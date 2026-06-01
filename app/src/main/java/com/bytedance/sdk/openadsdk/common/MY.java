package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.xF;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.zLG;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class MY {
    private static String IlO;

    public static String Bc() {
        try {
            if (!TextUtils.isEmpty(IlO)) {
                return IlO;
            }
            String strIlO = com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_app_sha1", 259200000L);
            IlO = strIlO;
            if (IlO(strIlO)) {
                return IlO;
            }
            String strIlO2 = com.bytedance.sdk.component.utils.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO());
            IlO = strIlO2;
            if (!IlO(strIlO2)) {
                return "";
            }
            String upperCase = IlO.toUpperCase();
            IlO = upperCase;
            com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_app_sha1", upperCase);
            return IlO;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String Cc() {
        return com.bytedance.sdk.openadsdk.core.DmF.MY().lEW();
    }

    public static String EO() {
        return BuildConfig.VERSION_NAME;
    }

    public static String IlO() {
        return "open_news";
    }

    public static String MY() {
        return "1371";
    }

    public static String tV() {
        return zLG.Bc();
    }

    public static String vCE() {
        return xF.Bc(com.bytedance.sdk.openadsdk.core.cl.IlO());
    }

    public static String IlO(Context context) {
        return com.bytedance.sdk.openadsdk.core.rp.IlO(context);
    }

    private static boolean IlO(String str) {
        String[] strArrSplit;
        if (!TextUtils.isEmpty(str) && (strArrSplit = str.split(":")) != null && strArrSplit.length >= 20) {
            for (String str2 : strArrSplit) {
                if (!"00".equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
