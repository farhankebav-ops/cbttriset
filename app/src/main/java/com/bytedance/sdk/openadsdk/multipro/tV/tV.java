package com.bytedance.sdk.openadsdk.multipro.tV;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.IlO;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class tV {
    private static boolean IlO() {
        return cl.IlO() == null;
    }

    private static String MY(String str) {
        return TextUtils.isEmpty(str) ? "tt_sp" : str;
    }

    public static void IlO(String str, String str2, Boolean bool) {
        if (IlO()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO.IlO(MY(str), str2, bool);
        } else {
            IlO(MY(str), str2, bool);
        }
    }

    public static String MY(String str, String str2, String str3) {
        if (IlO()) {
            return str3;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            return IlO.MY(MY(str), str2, str3);
        }
        return IlO.IlO(cl.IlO(), MY(str), str2, str3);
    }

    public static void IlO(String str, String str2, Long l) {
        if (IlO()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO.IlO(MY(str), str2, l);
        } else {
            IlO(MY(str), str2, l);
        }
    }

    public static void IlO(String str, String str2, String str3) {
        if (IlO()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO.IlO(MY(str), str2, str3);
        } else {
            IlO(MY(str), str2, str3);
        }
    }

    public static void IlO(String str, String str2, Integer num) {
        if (IlO()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO.IlO(MY(str), str2, num);
        } else {
            IlO(MY(str), str2, num);
        }
    }

    public static int IlO(String str, String str2, int i2) {
        if (IlO()) {
            return i2;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            return IlO.IlO(MY(str), str2, i2);
        }
        return IlO.IlO(cl.IlO(), MY(str), str2, i2);
    }

    public static boolean IlO(String str, String str2, boolean z2) {
        if (IlO()) {
            return z2;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            return IlO.IlO(MY(str), str2, z2);
        }
        return IlO.IlO(cl.IlO(), MY(str), str2, z2);
    }

    public static long IlO(String str, String str2, long j) {
        if (IlO()) {
            return j;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            return IlO.IlO(MY(str), str2, j);
        }
        return IlO.IlO(cl.IlO(), MY(str), str2, j);
    }

    public static void IlO(String str, String str2) {
        if (IlO()) {
            return;
        }
        try {
            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                IlO.MY(MY(str), str2);
            } else {
                MY.MY(cl.IlO(), MY(str), str2);
            }
        } catch (Throwable unused) {
        }
    }

    public static void IlO(String str) {
        if (IlO()) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
            IlO.IlO(MY(str));
        } else {
            MY.MY(cl.IlO(), MY(str));
        }
    }

    private static <T> void IlO(String str, String str2, T t3) {
        String strIlO = IlO.IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            IlO.EO eoMY = com.bytedance.sdk.component.IlO.IlO(cl.IlO(), MY(strIlO)).MY();
            MY.IlO(eoMY, str2, (Object) t3);
            eoMY.apply();
        } else {
            SharedPreferences sharedPreferencesIlO = MY.IlO(cl.IlO(), MY(strIlO));
            if (sharedPreferencesIlO == null) {
                return;
            }
            SharedPreferences.Editor editorEdit = sharedPreferencesIlO.edit();
            MY.IlO(editorEdit, str2, t3);
            editorEdit.apply();
        }
    }
}
