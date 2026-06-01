package com.bytedance.sdk.component.IlO;

import a1.a;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
class pP {
    private static boolean IlO;

    public static String IlO(Throwable th) {
        return a.q(new StringBuilder("{\"code\":"), "}", th instanceof es ? ((es) th).IlO : 0);
    }

    public static String IlO(String str) {
        String strSubstring;
        if (TextUtils.isEmpty(str)) {
            return "{\"code\":1}";
        }
        if (IlO) {
            strSubstring = str.substring(1, str.length() - 1);
        } else {
            strSubstring = "";
        }
        String strConcat = "{\"code\":1,\"__data\":".concat(String.valueOf(str));
        if (!strSubstring.isEmpty()) {
            return androidx.camera.core.processing.util.a.l(strConcat, ",", strSubstring, "}");
        }
        return a.C(strConcat, "}");
    }

    public static String IlO() {
        return "";
    }

    public static void IlO(boolean z2) {
        IlO = z2;
    }
}
