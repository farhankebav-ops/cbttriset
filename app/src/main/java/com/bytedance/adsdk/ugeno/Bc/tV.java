package com.bytedance.adsdk.ugeno.Bc;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class tV {
    private static Context EO;
    private static String IlO;
    private static Resources MY;

    public static void IlO(String str) {
        IlO = str;
    }

    private static String IlO(Context context) {
        if (IlO == null) {
            IlO = context.getPackageName();
        }
        return IlO;
    }

    private static int IlO(Context context, String str, String str2) {
        if (MY == null) {
            MY = context.getResources();
        }
        return MY.getIdentifier(str, str2, IlO(context));
    }

    public static int IlO(Context context, String str) {
        return IlO(context, str, "drawable");
    }
}
