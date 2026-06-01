package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class nvX {
    private static final Map<String, nvX> IlO = new HashMap();
    private SharedPreferences MY;

    private nvX(String str, Context context) {
        if (context != null) {
            this.MY = context.getSharedPreferences(str, 0);
        }
    }

    public static nvX IlO(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_sp";
        }
        Map<String, nvX> map = IlO;
        nvX nvx = map.get(str);
        if (nvx != null) {
            return nvx;
        }
        synchronized (nvX.class) {
            if (nvx == null) {
                try {
                    nvx = new nvX(str, com.bytedance.sdk.openadsdk.core.cl.IlO());
                } catch (Throwable th) {
                    throw th;
                }
            }
            map.put(str, nvx);
        }
        return nvx;
    }

    public String IlO(String str, String str2) {
        try {
            return this.MY.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void IlO(String str) {
        try {
            this.MY.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
