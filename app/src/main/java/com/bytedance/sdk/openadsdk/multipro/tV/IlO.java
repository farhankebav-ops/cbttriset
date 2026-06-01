package com.bytedance.sdk.openadsdk.multipro.tV;

import a1.a;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.component.vCE.IlO.vCE;
import com.bytedance.sdk.openadsdk.core.DmF;
import com.bytedance.sdk.openadsdk.core.cl;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class IlO {
    public static HashSet<String> IlO = new HashSet<String>() { // from class: com.bytedance.sdk.openadsdk.multipro.tV.IlO.1
        {
            add("app_id");
            add("tt_gdpr");
            add("keywords");
            add("extra_data");
            add("sdk_app_sha1");
            add("uuid");
            add("android_system_ua");
            add("sdk_local_web_ua");
            add("sdk_local_rom_info");
        }
    };

    private static Context EO() {
        return cl.IlO();
    }

    public static boolean IlO() {
        return cl.IlO() != null;
    }

    private static vCE MY() {
        try {
            if (IlO()) {
                return com.bytedance.sdk.openadsdk.multipro.IlO.IlO.IlO(cl.IlO());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String tV() {
        return a.r(new StringBuilder(), com.bytedance.sdk.openadsdk.multipro.tV.MY, "/t_sp/");
    }

    public static synchronized void IlO(String str, String str2, Boolean bool) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.IlO(EO(), str, str2, bool);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    Uri uri = Uri.parse(tV() + "boolean/" + str2 + MY(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", bool);
                    vceMY.IlO(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private static String MY(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return "?sp_file_name=".concat(String.valueOf(str));
    }

    public static String MY(String str, String str2, String str3) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    return IlO(EO(), str, str2, str3);
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    String strIlO = vceMY.IlO(Uri.parse(tV() + "string/" + str2 + MY(str)));
                    if (strIlO != null && !strIlO.equals("null")) {
                        return strIlO;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return str3;
    }

    public static void MY(String str, String str2) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.MY(EO(), str, str2);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    vceMY.IlO(Uri.parse(tV() + "long/" + str2 + MY(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void IlO(String str, String str2, String str3) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.IlO(EO(), str, str2, str3);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    Uri uri = Uri.parse(tV() + "string/" + str2 + MY(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", str3);
                    vceMY.IlO(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void IlO(String str, String str2, Integer num) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.IlO(EO(), str, str2, num);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    Uri uri = Uri.parse(tV() + "int/" + str2 + MY(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", num);
                    vceMY.IlO(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static synchronized void IlO(String str, String str2, Long l) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.IlO(EO(), str, str2, l);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    Uri uri = Uri.parse(tV() + "long/" + str2 + MY(str));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("value", l);
                    vceMY.IlO(uri, contentValues, null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static String IlO(Context context, String str, String str2, String str3) {
        String strIlO = IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2, str3);
        }
        SharedPreferences sharedPreferencesIlO = MY.IlO(context, strIlO);
        return sharedPreferencesIlO == null ? str3 : sharedPreferencesIlO.getString(str2, str3);
    }

    public static String IlO(String str, String str2) {
        return IlO.contains(str2) ? "pag_sp_bad_par" : str;
    }

    public static int IlO(String str, String str2, int i2) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    return IlO(EO(), str, str2, i2);
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    String strIlO = vceMY.IlO(Uri.parse(tV() + "int/" + str2 + MY(str)));
                    if (strIlO != null && !strIlO.equals("null")) {
                        return Integer.parseInt(strIlO);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return i2;
    }

    public static int IlO(Context context, String str, String str2, int i2) {
        String strIlO = IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2, i2);
        }
        SharedPreferences sharedPreferencesIlO = MY.IlO(context, strIlO);
        return sharedPreferencesIlO == null ? i2 : sharedPreferencesIlO.getInt(str2, i2);
    }

    public static float IlO(Context context, String str, String str2, float f4) {
        String strIlO = IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2, f4);
        }
        SharedPreferences sharedPreferencesIlO = MY.IlO(context, strIlO);
        return sharedPreferencesIlO == null ? f4 : sharedPreferencesIlO.getFloat(str2, f4);
    }

    public static boolean IlO(String str, String str2, boolean z2) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    return IlO(EO(), str, str2, z2);
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    String strIlO = vceMY.IlO(Uri.parse(tV() + "boolean/" + str2 + MY(str)));
                    if (strIlO != null && !strIlO.equals("null")) {
                        return Boolean.parseBoolean(strIlO);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return z2;
    }

    public static boolean IlO(Context context, String str, String str2, boolean z2) {
        String strIlO = IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2, z2);
        }
        SharedPreferences sharedPreferencesIlO = MY.IlO(context, strIlO);
        return sharedPreferencesIlO == null ? z2 : sharedPreferencesIlO.getBoolean(str2, z2);
    }

    public static long IlO(String str, String str2, long j) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    return IlO(EO(), str, str2, j);
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    String strIlO = vceMY.IlO(Uri.parse(tV() + "long/" + str2 + MY(str)));
                    if (strIlO != null && !strIlO.equals("null")) {
                        return Long.parseLong(strIlO);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return j;
    }

    public static long IlO(Context context, String str, String str2, long j) {
        String strIlO = IlO(str, str2);
        if (DmF.Bc(strIlO)) {
            return com.bytedance.sdk.component.IlO.IlO(context, strIlO).IlO(str2, j);
        }
        SharedPreferences sharedPreferencesIlO = MY.IlO(context, strIlO);
        return sharedPreferencesIlO == null ? j : sharedPreferencesIlO.getLong(str2, j);
    }

    public static void IlO(String str) {
        if (IlO()) {
            try {
                if (!com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    MY.MY(EO(), str);
                    return;
                }
                vCE vceMY = MY();
                if (vceMY != null) {
                    vceMY.IlO(Uri.parse(tV() + "clean" + MY(str)), null, null);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
