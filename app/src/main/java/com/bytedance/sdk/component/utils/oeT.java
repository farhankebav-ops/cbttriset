package com.bytedance.sdk.component.utils;

import android.text.TextUtils;
import android.util.Log;
import androidx.camera.core.processing.util.a;
import com.ironsource.C2300e4;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class oeT {
    private static boolean IlO = false;
    private static String MY = "";

    public static void EO(String str, String str2) {
        if (IlO && str2 != null) {
            Log.e(MY(str), str2);
        }
    }

    public static void IlO() {
        IlO = true;
    }

    public static void MY() {
        IlO = false;
    }

    public static void IlO(String str, String str2) {
        if (IlO && str2 != null) {
            Log.d(MY(str), str2);
        }
    }

    public static void MY(String str, String str2) {
        if (IlO && str2 != null) {
            Log.i(MY(str), str2);
        }
    }

    public static void EO(String str, Object... objArr) {
        if (IlO && objArr != null) {
            Log.e(MY(str), IlO(objArr));
        }
    }

    public static void IlO(String str, Object... objArr) {
        if (IlO && objArr != null) {
            Log.d(MY(str), IlO(objArr));
        }
    }

    public static void MY(String str, Object... objArr) {
        if (IlO && objArr != null) {
            Log.i(MY(str), IlO(objArr));
        }
    }

    public static void IlO(String str, String str2, Throwable th) {
        if (IlO) {
            if (str2 == null && th == null) {
                return;
            }
            Log.e(MY(str), str2, th);
        }
    }

    private static String MY(String str) {
        return TextUtils.isEmpty(MY) ? str : IlO(a.n(new StringBuilder(C2300e4.i.f8403d), MY, "]-[", str, C2300e4.i.e));
    }

    public static void IlO(String str) {
        MY = str;
    }

    private static String IlO(Object... objArr) {
        if (objArr != null && objArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : objArr) {
                if (obj != null) {
                    sb.append(obj.toString());
                } else {
                    sb.append(" null ");
                }
                sb.append(" ");
            }
            return sb.toString();
        }
        return "";
    }
}
