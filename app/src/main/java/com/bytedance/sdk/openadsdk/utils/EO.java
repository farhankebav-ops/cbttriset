package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class EO {
    public static int IlO = -1;

    public static int IlO(Context context, int i2, int i8) {
        int iIlO = IlO(context, i8);
        if (iIlO == -1) {
            return IlO;
        }
        return Math.max(Math.min(i2 > 655 ? Math.round((i2 / 728.0f) * 90.0f) : i2 > 632 ? 81 : i2 > 526 ? Math.round((i2 / 468.0f) * 60.0f) : i2 > 432 ? 68 : Math.round((i2 / 320.0f) * 50.0f), Math.min(90, Math.round(iIlO * 0.15f))), 50);
    }

    public static int IlO(Context context, int i2) {
        DisplayMetrics displayMetrics;
        Configuration configuration;
        if (context != null) {
            try {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                Resources resources = context.getResources();
                if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null && (configuration = resources.getConfiguration()) != null) {
                    int i8 = configuration.orientation;
                    if (i2 == 0) {
                        i2 = i8;
                    }
                    if (i2 == i8) {
                        return Math.round(displayMetrics.heightPixels / displayMetrics.density);
                    }
                    return Math.round(displayMetrics.widthPixels / displayMetrics.density);
                }
            } catch (Throwable unused) {
                return IlO;
            }
        }
        return IlO;
    }
}
