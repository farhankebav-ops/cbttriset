package com.pgl.ssdk;

import android.content.Context;
import android.graphics.Point;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f10752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f10753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f10754d;
    private static int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f10755f;

    private static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            f10754d = (int) displayMetrics.density;
            f10753c = displayMetrics.densityDpi;
        } catch (Throwable unused) {
        }
    }

    private static void b(Context context) {
        try {
            new DisplayMetrics();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            e = (int) displayMetrics.xdpi;
            f10755f = (int) displayMetrics.ydpi;
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            f10751a = point.x;
            f10752b = point.y;
        } catch (Throwable unused) {
        }
    }

    public static String d(Context context) {
        int i2 = -1;
        if (context != null) {
            try {
                i2 = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            } catch (Throwable unused) {
            }
        }
        return String.valueOf(i2);
    }

    public static String e(Context context) {
        try {
            c(context);
            a(context);
            b(context);
        } catch (Throwable unused) {
        }
        StringBuilder sb = new StringBuilder();
        sb.append(f10753c);
        sb.append("[<!>]");
        sb.append(f10751a);
        sb.append(",");
        return a1.a.q(sb, "[<!>]", f10752b);
    }
}
