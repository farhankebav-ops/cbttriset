package com.bytedance.sdk.openadsdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.browser.customtabs.CustomTabsSession;
import androidx.camera.core.processing.util.a;
import com.bytedance.sdk.openadsdk.activity.TTBaseActivity;
import com.bytedance.sdk.openadsdk.core.act.AdActAction;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class vAh {
    /* JADX INFO: Access modifiers changed from: private */
    public static com.bytedance.sdk.openadsdk.ea.IlO.MY MY(String str, int i2, com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        com.bytedance.sdk.openadsdk.ea.IlO.MY my = new com.bytedance.sdk.openadsdk.ea.IlO.MY();
        my.IlO(str);
        my.IlO(oet);
        my.MY(zLG.IlO(oet));
        my.IlO(i2);
        my.IlO(false);
        my.MY(oet.Jz());
        return my;
    }

    public static boolean IlO(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str2) {
        final String str3;
        final com.bytedance.sdk.openadsdk.core.model.oeT oet2;
        final String str4;
        final CustomTabsIntent.Builder builder;
        if (context instanceof Activity) {
            if (!IlO((Activity) context)) {
                context = null;
            }
        } else {
            Activity activityMY = com.bytedance.sdk.openadsdk.core.ea.IlO().Cc().MY();
            if (activityMY != null && IlO(activityMY)) {
                context = activityMY;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.cl.IlO();
        }
        final Context context2 = context;
        if (context2 == null) {
            return false;
        }
        final String strIlO = zLG.IlO(oet);
        if (!com.bytedance.sdk.component.utils.xF.IlO(str)) {
            com.bytedance.sdk.openadsdk.tV.EO.IlO(MY(str2, 5, oet));
            return false;
        }
        final String strMY = com.bytedance.sdk.openadsdk.core.model.oeT.MY(context2, oet);
        if (!TextUtils.isEmpty(strMY)) {
            try {
                builder = new CustomTabsIntent.Builder();
                builder.setUrlBarHidingEnabled(false);
                builder.setShareState(2);
                str3 = str;
                oet2 = oet;
                str4 = str2;
            } catch (Throwable th) {
                th = th;
                str3 = str;
                oet2 = oet;
                str4 = str2;
            }
            try {
                new AdActAction(context2, oet, str2, str).IlO(new AdActAction.BindCustomTabsServiceCallback() { // from class: com.bytedance.sdk.openadsdk.utils.vAh.1
                    @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                    public void onBindFail(int i2, String str5) {
                        com.bytedance.sdk.openadsdk.ea.IlO.MY MY = vAh.MY(str4, i2, oet2);
                        MY.EO(str5);
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(MY);
                        vAh.MY(context2, str3, oet2, str4, strIlO);
                    }

                    @Override // com.bytedance.sdk.openadsdk.core.act.AdActAction.BindCustomTabsServiceCallback
                    public void onBindSuccess(CustomTabsSession customTabsSession) {
                        if (customTabsSession != null) {
                            try {
                                builder.setSession(customTabsSession);
                            } catch (Throwable th2) {
                                String message = th2.getMessage();
                                com.bytedance.sdk.component.utils.oeT.EO("OpenUtils", message);
                                com.bytedance.sdk.openadsdk.ea.IlO.MY MY = vAh.MY(str4, 13, oet2);
                                MY.EO(message);
                                com.bytedance.sdk.openadsdk.tV.EO.IlO(MY);
                                vAh.MY(context2, str3, oet2, str4, strIlO);
                                return;
                            }
                        }
                        CustomTabsIntent customTabsIntentBuild = builder.build();
                        if (!(context2 instanceof Activity)) {
                            customTabsIntentBuild.intent.addFlags(268435456);
                        }
                        com.bytedance.sdk.openadsdk.core.act.EO.IlO(context2, strMY, customTabsIntentBuild, Uri.parse(str3));
                        Context context3 = context2;
                        if (context3 instanceof TTBaseActivity) {
                            ((TTBaseActivity) context3).MY(true);
                        }
                        com.bytedance.sdk.openadsdk.ea.IlO.MY MY2 = vAh.MY(str4, 100, oet2);
                        MY2.IlO(true);
                        MY2.MY(8);
                        com.bytedance.sdk.openadsdk.tV.EO.IlO(MY2);
                    }
                });
                return true;
            } catch (Throwable th2) {
                th = th2;
                String message = th.getMessage();
                com.bytedance.sdk.component.utils.oeT.EO("OpenUtils", message);
                com.bytedance.sdk.openadsdk.ea.IlO.MY MY = MY(str4, 12, oet2);
                MY.EO(message);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(MY);
                return MY(context2, str3, oet2, str4, strIlO);
            }
        }
        return MY(context2, str, oet, str2, strIlO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean MY(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.VIEW");
        try {
            intent.setData(Uri.parse(str));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            try {
                context.startActivity(intent);
                com.bytedance.sdk.openadsdk.ea.IlO.MY MY = MY(str2, 100, oet);
                MY.IlO(true);
                MY.MY(2);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(MY);
                return true;
            } catch (Throwable th) {
                String message = th.getMessage();
                com.bytedance.sdk.openadsdk.ea.IlO.MY MY2 = MY(str2, 7, oet);
                MY2.EO(message);
                MY2.MY(2);
                com.bytedance.sdk.openadsdk.tV.EO.IlO(MY2);
                return false;
            }
        } catch (Throwable th2) {
            String message2 = th2.getMessage();
            com.bytedance.sdk.openadsdk.ea.IlO.MY MY3 = MY(str2, 6, oet);
            MY3.EO(message2);
            MY3.MY(2);
            com.bytedance.sdk.openadsdk.tV.EO.IlO(MY3);
            return false;
        }
    }

    public static boolean IlO(String str) {
        return !TextUtils.isEmpty(str);
    }

    public static boolean IlO(Activity activity) {
        return (activity == null || activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }

    public static boolean MY(Context context, String str, com.bytedance.sdk.openadsdk.core.model.oeT oet, String str2) {
        if (context instanceof Activity) {
            if (!IlO((Activity) context)) {
                context = null;
            }
        } else {
            Activity activityMY = com.bytedance.sdk.openadsdk.core.ea.IlO().Cc().MY();
            if (activityMY != null && IlO(activityMY)) {
                context = activityMY;
            }
        }
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.cl.IlO();
        }
        Context context2 = context;
        if (context2 == null || !IlO(str)) {
            return false;
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        HashMap mapU = a.u("deeplink_url", str);
        mapU.put("jsb_deeplink", 1);
        if (com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO()) {
            return com.bytedance.sdk.openadsdk.es.IlO.IlO.EO.IlO(context2, str, oet, zLG.MY(oet), mapU, true);
        }
        try {
            if (!(context2 instanceof Activity)) {
                intent.addFlags(268435456);
            }
            com.bytedance.sdk.openadsdk.tV.EO.IlO(oet, str2, "open_url_app", mapU);
            context2.startActivity(intent);
            com.bytedance.sdk.openadsdk.tV.rp.IlO().IlO(mapU).IlO(oet, str2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
