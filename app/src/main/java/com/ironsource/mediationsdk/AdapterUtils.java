package com.ironsource.mediationsdk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class AdapterUtils {
    public static final int MIN_TABLET_DP_SIZE = 600;

    public static int dpToPixels(Context context, int i2) {
        if (context != null) {
            return (int) TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils dpToPixels - context is null, returning dpSize", 3);
        return i2;
    }

    public static String getScreenSizeParams(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f4 = displayMetrics.heightPixels;
        float f8 = displayMetrics.density;
        float fMin = Math.min(displayMetrics.widthPixels / f8, f4 / f8);
        float f9 = displayMetrics.xdpi;
        float f10 = displayMetrics.widthPixels / f9;
        float f11 = displayMetrics.heightPixels / displayMetrics.ydpi;
        double dSqrt = Math.sqrt((f11 * f11) + (f10 * f10));
        int i2 = context.getResources().getConfiguration().smallestScreenWidthDp;
        StringBuilder sb = new StringBuilder("smallestWidth = ");
        sb.append(fMin);
        sb.append(" diagonalInches = ");
        sb.append(dSqrt);
        return androidx.camera.core.processing.util.a.m(sb, " smallScreenDpApi =  ", i2);
    }

    public static boolean isLargeScreen(Context context) {
        if (context != null) {
            return context.getResources().getConfiguration().smallestScreenWidthDp >= 600;
        }
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "AdapterUtils isLargeScreen - context is null", 3);
        return false;
    }
}
