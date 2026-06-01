package com.pgl.ssdk;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f10715a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f10716b = -1;

    public static Application a() {
        try {
            return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", null).invoke(null, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Application.getProcessName();
        }
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", null);
            declaredMethod.setAccessible(true);
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public static String c() {
        String path;
        try {
            path = Environment.getDataDirectory().getPath();
        } catch (Throwable unused) {
            path = null;
        }
        return path == null ? "" : path.trim();
    }

    public static String d() {
        String absolutePath;
        try {
            absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        } catch (Throwable unused) {
            absolutePath = null;
        }
        return absolutePath == null ? "" : absolutePath.trim();
    }

    public static String e(Context context) {
        String absolutePath;
        try {
            absolutePath = context.getFilesDir().getAbsolutePath();
        } catch (Throwable unused) {
            absolutePath = null;
        }
        return absolutePath == null ? "" : absolutePath.trim();
    }

    public static String f(Context context) {
        String packageName;
        try {
            packageName = context.getPackageName();
        } catch (Throwable unused) {
            packageName = null;
        }
        return packageName == null ? "" : packageName.trim();
    }

    public static String g(Context context) {
        String packageResourcePath;
        try {
            packageResourcePath = context.getPackageResourcePath();
        } catch (Throwable unused) {
            packageResourcePath = null;
        }
        return packageResourcePath == null ? "" : packageResourcePath.trim();
    }

    public static int h(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean j(Context context) {
        ResolveInfo resolveInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            Intent intent = new Intent("android.intent.action.MAIN", (Uri) null);
            intent.addCategory("android.intent.category.LAUNCHER");
            intent.setPackage(context.getPackageName());
            List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
            if (listQueryIntentActivities == null || listQueryIntentActivities.isEmpty() || (resolveInfo = listQueryIntentActivities.get(0)) == null) {
                return false;
            }
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(activityInfo.packageName, activityInfo.name));
            return componentEnabledSetting == 0 || componentEnabledSetting == 1;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void k(Context context) {
        String strA = w0.a(context, "hac_date", (String) null);
        if (!TextUtils.isEmpty(strA)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            if (strA.equals(simpleDateFormat.format(new Date()))) {
                int iA = w0.a(context, "hac", -1);
                int iA2 = w0.a(context, "tac", -1);
                if (iA != -1 && iA2 != -1) {
                    f10715a = iA;
                    f10716b = iA2;
                    return;
                }
            }
        }
        f10715a = 0;
        f10716b = 0;
    }

    private static void l(Context context) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        w0.b(context, "hac_date", simpleDateFormat.format(new Date()));
        w0.b(context, "hac", f10715a);
        w0.b(context, "tac", f10716b);
    }

    private static String a(Context context, int i2, String str) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str));
        return context.createConfigurationContext(configuration).getResources().getString(i2);
    }

    public static String c(Context context) {
        String str;
        try {
            str = context.getApplicationInfo().sourceDir;
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String d(Context context) {
        try {
            return a(context, context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).labelRes, "en");
        } catch (Throwable unused) {
            return "";
        }
    }

    private static boolean a(Context context) {
        List<ActivityManager.AppTask> appTasks;
        if (context == null || (appTasks = ((ActivityManager) context.getSystemService("activity")).getAppTasks()) == null || appTasks.isEmpty()) {
            return false;
        }
        for (ActivityManager.AppTask appTask : appTasks) {
            if (appTask.getTaskInfo() != null && a(appTask.getTaskInfo().baseIntent)) {
                return true;
            }
        }
        return false;
    }

    public static void b(Context context) {
        try {
            if (f10715a == -1 || f10716b == -1) {
                k(context);
            }
            if (a(context)) {
                f10715a++;
            }
            f10716b++;
            if (f10715a != 0) {
                l(context);
                com.pgl.ssdk.ces.a.meta(160, null, new int[]{f10715a, f10716b});
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean a(Intent intent) {
        return (intent == null || (intent.getFlags() & 8388608) == 0) ? false : true;
    }
}
