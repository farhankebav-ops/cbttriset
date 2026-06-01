package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    public static void IlO(String str) {
        IlO("any_door_id", str);
    }

    private static String MY(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return com.bytedance.sdk.openadsdk.multipro.tV.tV.MY(null, str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static String IlO() {
        return MY("any_door_id", null);
    }

    private static void IlO(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.multipro.tV.tV.IlO((String) null, str, str2);
        } catch (Throwable unused) {
        }
    }
}
