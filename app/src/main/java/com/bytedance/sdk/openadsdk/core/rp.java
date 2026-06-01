package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.RequiresPermission;
import com.bytedance.sdk.openadsdk.utils.mmj;
import com.onesignal.session.internal.influence.impl.InfluenceConstants;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class rp {
    private static String EO;
    private static String IlO;
    private static String MY;
    private static boolean tV;

    @RequiresPermission(anyOf = {"android.permission.ACCESS_WIFI_STATE"})
    private static void Cc(Context context) {
        Context contextTV;
        if (tV || (contextTV = tV(context)) == null) {
            return;
        }
        MY = String.valueOf(Build.TIME);
        EO = EO.IlO(contextTV).MY("uuid", (String) null);
        tV = true;
    }

    public static String IlO(Context context) {
        if (!TextUtils.isEmpty(IlO)) {
            return IlO;
        }
        vCE(context);
        return IlO;
    }

    public static String MY(Context context) {
        if (MY == null && !tV) {
            synchronized (rp.class) {
                try {
                    if (!tV) {
                        Cc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MY;
    }

    private static Context tV(Context context) {
        return context == null ? cl.IlO() : context;
    }

    private static void vCE(Context context) {
        Context contextTV = tV(context);
        if (contextTV == null) {
            return;
        }
        String strMY = EO.IlO(contextTV).MY("abcd", (String) null);
        if (TextUtils.isEmpty(strMY)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(strMY);
            int iOptInt = jSONObject.optInt("cypher", -1);
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                String strEO = com.bytedance.sdk.component.utils.IlO.EO(strOptString);
                if (TextUtils.isEmpty(strEO)) {
                    return;
                }
                IlO = new JSONObject(strEO).optString("abcd");
                IlO();
            }
        } catch (Throwable unused) {
        }
    }

    public static String EO(Context context) {
        if (TextUtils.isEmpty(EO) && !tV) {
            synchronized (rp.class) {
                try {
                    if (!tV) {
                        Cc(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return EO;
    }

    public static void IlO(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.equals(IlO)) {
                IlO = str;
            }
            IlO();
        }
        if (TextUtils.isEmpty(IlO)) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.DmF.EO.MY(IlO);
        EV.IlO(IlO);
    }

    public static String MY() {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = LocaleList.getDefault().get(0);
            } else {
                locale = Locale.getDefault();
            }
            String language = locale != null ? locale.getLanguage() : "";
            if (locale == null || !"zh".equals(language)) {
                return language;
            }
            String string = locale.toString();
            if (locale.toString().length() >= 5) {
                string = string.substring(0, 5);
            }
            if (Locale.SIMPLIFIED_CHINESE.toString().equals(string)) {
                return "zh";
            }
            return "zh-Hant";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static void IlO() {
        if (TextUtils.isEmpty(IlO)) {
            return;
        }
        mmj.MY(new com.bytedance.sdk.component.lEW.lEW("update_did") { // from class: com.bytedance.sdk.openadsdk.core.rp.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(InfluenceConstants.TIME, SystemClock.elapsedRealtime());
                    jSONObject.put("abcd", rp.IlO);
                    EO.IlO(cl.IlO()).IlO("abcd", com.bytedance.sdk.component.utils.IlO.IlO(jSONObject).toString());
                } catch (Throwable unused) {
                }
            }
        });
    }
}
