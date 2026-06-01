package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2228a4;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class xF {
    public static String Bc(Context context) {
        int iEO = EO(context);
        return iEO != 2 ? iEO != 3 ? iEO != 4 ? iEO != 5 ? iEO != 6 ? "mobile" : "5g" : "4g" : C2228a4.f7946b : C2228a4.f7945a : "2g";
    }

    public static boolean Cc(Context context) {
        return EO(context) == 5;
    }

    public static int EO(Context context) {
        return wPn.IlO(context, RealWebSocket.CANCEL_AFTER_CLOSE_MILLIS);
    }

    public static boolean IlO(Context context) {
        return EO(context) != 0;
    }

    public static int MY(Context context) {
        int iEO = EO(context);
        if (iEO == 1) {
            return 0;
        }
        if (iEO == 4) {
            return 1;
        }
        if (iEO == 5) {
            return 4;
        }
        if (iEO != 6) {
            return iEO;
        }
        return 6;
    }

    public static boolean lEW(Context context) {
        if (context == null) {
            return false;
        }
        int iEO = EO(context);
        return iEO == 2 || iEO == 3 || iEO == 4 || iEO == 5 || iEO == 6;
    }

    public static boolean tV(Context context) {
        return EO(context) == 4;
    }

    public static boolean vCE(Context context) {
        return EO(context) == 6;
    }

    public static boolean IlO(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("http://") || str.startsWith("https://");
    }
}
