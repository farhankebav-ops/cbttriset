package com.bytedance.sdk.component.vCE.IlO.MY;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.IlO.Cc;
import com.bytedance.sdk.component.vCE.IlO.lEW;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static boolean Cc() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.EO())) ? false : true;
    }

    public static boolean EO() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.tV())) ? false : true;
    }

    public static long IlO(int i2, Context context) {
        return MY(i2, context);
    }

    private static long MY(int i2, Context context) {
        if (context == null) {
            return i2;
        }
        Runtime runtime = Runtime.getRuntime();
        long jFreeMemory = runtime.freeMemory() / 1048576;
        long jMaxMemory = (runtime.maxMemory() / 1048576) - (runtime.totalMemory() / 1048576);
        if (jMaxMemory <= 0) {
            if (jFreeMemory <= 2) {
                return 1L;
            }
            return jFreeMemory <= 10 ? Math.min(i2, 10) : Math.min((jFreeMemory / 2) * 10, i2);
        }
        long j = ((jFreeMemory + jMaxMemory) - 10) / 2;
        if (j <= 2) {
            return 1L;
        }
        return j <= 10 ? Math.min(i2, 10) : Math.min(j * 10, i2);
    }

    public static boolean tV() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.Cc())) ? false : true;
    }

    public static boolean vCE() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.vCE())) ? false : true;
    }

    public static boolean IlO() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.IlO())) ? false : true;
    }

    public static boolean MY() {
        Cc ccTV = lEW.Bc().tV();
        return (ccTV == null || TextUtils.isEmpty(ccTV.MY())) ? false : true;
    }
}
