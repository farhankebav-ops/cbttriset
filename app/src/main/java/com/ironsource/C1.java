package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C1 {
    public static boolean a() {
        return true;
    }

    public static String b(Context context) {
        try {
            return a(context).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    public static String c(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir.getPath();
        }
        return null;
    }

    public static boolean d(Context context, String str) {
        boolean z2 = false;
        int i2 = 0;
        z2 = false;
        z2 = false;
        if (!TextUtils.isEmpty(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
                if (packageInfo.requestedPermissions != null) {
                    boolean zEquals = false;
                    while (true) {
                        try {
                            String[] strArr = packageInfo.requestedPermissions;
                            if (i2 >= strArr.length || zEquals) {
                                break;
                            }
                            zEquals = str.equals(strArr[i2]);
                            i2++;
                        } catch (Exception e) {
                            e = e;
                            z2 = zEquals;
                            C2531r4.d().a(e);
                            IronLog.INTERNAL.error(e.toString());
                            return z2;
                        }
                    }
                    return zEquals;
                }
            } catch (Exception e4) {
                e = e4;
            }
        }
        return z2;
    }

    public static String e(Context context) {
        String installerPackageName;
        try {
            installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        } catch (Throwable th) {
            C2531r4.d().a(th);
            installerPackageName = null;
        }
        return TextUtils.isEmpty(installerPackageName) ? "" : installerPackageName;
    }

    public static long f(Context context) {
        try {
            return a(context).lastUpdateTime;
        } catch (PackageManager.NameNotFoundException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    public static String g(Context context) {
        return context.getPackageName();
    }

    public static int a(Activity activity) {
        return activity.getRequestedOrientation();
    }

    public static JSONObject a(Context context, JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            int i2 = 0;
            if (jSONArray.length() == 0) {
                while (true) {
                    String[] strArr = packageInfo.requestedPermissions;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    jSONObject.put(strArr[i2], (packageInfo.requestedPermissionsFlags[i2] & 2) != 0 ? "Granted" : "Rejected");
                    i2++;
                }
            } else {
                List listAsList = Arrays.asList(packageInfo.requestedPermissions);
                while (i2 < jSONArray.length()) {
                    String string = jSONArray.getString(i2);
                    int iIndexOf = listAsList.indexOf(string);
                    if (iIndexOf != -1) {
                        jSONObject.put(string, (packageInfo.requestedPermissionsFlags[iIndexOf] & 2) != 0 ? "Granted" : "Rejected");
                    } else {
                        jSONObject.put(string, "notFoundInManifest");
                    }
                    i2++;
                }
            }
            return jSONObject;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }

    public static boolean c(Context context, String str) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String b(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    public static long d(Context context) {
        try {
            return a(context).firstInstallTime;
        } catch (PackageManager.NameNotFoundException e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    public static PackageInfo a(Context context) throws PackageManager.NameNotFoundException {
        return context.getPackageManager().getPackageInfo(g(context), 0);
    }

    public static String a(Context context, String str) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || TextUtils.isEmpty(str)) {
                return null;
            }
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(str, 0)).toString();
        } catch (Exception e) {
            C2531r4.d().a(e);
            return null;
        }
    }
}
