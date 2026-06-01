package com.ironsource.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.C2569t8;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f10215a;

    public static void d(String str, String str2) {
        if (f10215a) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f10215a) {
            Log.e(str, str2);
        }
    }

    public static void enableLogging(int i2) {
        f10215a = C2569t8.d.MODE_0.b() != i2;
    }

    public static void i(String str, String str2) {
        if (f10215a) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (f10215a) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f10215a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f10215a) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f10215a) {
            Log.e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!f10215a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        if (f10215a) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f10215a) {
            Log.w(str, str2, th);
        }
    }
}
