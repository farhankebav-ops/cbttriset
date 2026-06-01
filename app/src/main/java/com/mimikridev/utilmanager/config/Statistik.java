package com.mimikridev.utilmanager.config;

import a3.c;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.util.Log;
import com.mimikridev.utilmanager.dialog.DialogUtil;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Statistik {
    private static final String PREF_APP = "app_status";
    private static final String PREF_APP_MSG = "message";
    private static final String PREF_APP_TITLE = "title";
    private static final String PREF_DEVICE_ID = "device_id";
    private static final String PREF_ONESIGNAL_ID = "onesignal_id";
    private static OkHttpClient client = null;
    private static String installSource = "unknown";

    static {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new b(0));
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder builderAddInterceptor = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        client = builderAddInterceptor.connectTimeout(10L, timeUnit).readTimeout(15L, timeUnit).build();
    }

    public static void dg(Context context) {
        Activity activity = (Activity) context;
        activity.runOnUiThread(new c(25, activity, context));
    }

    public static void exitApp(Activity activity) {
        if (activity != null) {
            Intent intent = new Intent(activity, activity.getClass());
            intent.addFlags(335544320);
            activity.startActivity(intent);
            activity.finish();
            System.exit(0);
        }
    }

    public static void finishActivity(Activity activity) {
        if (activity != null) {
            activity.finish();
        }
    }

    public static void finishContext(Context context) {
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }

    public static Boolean getApp(Context context) {
        return Boolean.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getBoolean(PREF_APP, false));
    }

    public static String getAppSignatureHash(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            if (Build.VERSION.SDK_INT >= 28) {
                return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(packageManager.getPackageInfo(context.getPackageName(), 134217728).signingInfo.getApkContentsSigners()[0].toByteArray()), 2);
            }
            return Base64.encodeToString(MessageDigest.getInstance("SHA-256").digest(packageManager.getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()), 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "UNKNOWN";
        }
    }

    public static void getData(Context context) {
        if (getApp(context).booleanValue()) {
            dg(context);
        }
    }

    public static String getDeviceId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_DEVICE_ID, "");
    }

    public static String getDeviceLanguage() {
        return Locale.getDefault().getLanguage();
    }

    private static String getDeviceType(Context context) {
        String str = context.getResources().getConfiguration().smallestScreenWidthDp >= 600 ? "tablet" : "phone";
        String str2 = Build.MODEL;
        if (str2 != null && str2.toLowerCase().contains("chromebook")) {
            return "chromeos";
        }
        String str3 = Build.DEVICE;
        return (str3 == null || !str3.toLowerCase().contains("wear")) ? (str3 == null || !str3.toLowerCase().contains("tv")) ? str : "tv" : "wear";
    }

    public static String getMsg(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("message", "Your device is active and verified successfully.");
    }

    public static String getOneSignalId(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("onesignal_id", "");
    }

    public static String getTittle(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getString("title", "Device Active");
    }

    private static boolean isDeviceRooted() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/su/bin/su"};
        for (int i2 = 0; i2 < 9; i2++) {
            if (new File(strArr[i2]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isEmulator() {
        String str = Build.FINGERPRINT;
        if (str.startsWith("generic") || str.startsWith("unknown")) {
            return true;
        }
        String str2 = Build.MODEL;
        if (str2.contains("google_sdk") || str2.contains("Emulator") || str2.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dg$4(Activity activity, Context context) {
        DialogUtil.showErrorDialogExit(activity, getTittle(context), getMsg(context), "Exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$postStatistik$1(String[] strArr, CountDownLatch countDownLatch, String str) {
        strArr[0] = str;
        countDownLatch.countDown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$sendData$3(Context context, String str) {
        try {
            Log.d("StatistikUtil", "Final result: " + postStatistik(context, str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseWithStringMethod(String str, Context context) {
        if (str.contains(PREF_DEVICE_ID)) {
            try {
                String str2 = str.split("\"device_id\":\"")[1].split("\"")[0];
                if (!str2.isEmpty()) {
                    saveDeviceId(context, str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (str.contains("title")) {
            try {
                saveTitle(context, str.split("\"title\":\"")[1].split("\"")[0]);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (str.contains("message")) {
            try {
                saveTitle(context, str.split("\"message\":\"")[1].split("\"")[0]);
            } catch (Exception e8) {
                e8.printStackTrace();
            }
        }
        if (str.contains("app")) {
            try {
                if (Boolean.parseBoolean(str.split("\"app\":")[1].split(",")[0].trim())) {
                    saveApp(context, Boolean.TRUE);
                    dg(context);
                } else {
                    saveApp(context, Boolean.FALSE);
                }
            } catch (Exception e9) {
                e9.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String postStatistik(android.content.Context r24, java.lang.String r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 595
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mimikridev.utilmanager.config.Statistik.postStatistik(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void saveApp(Context context, Boolean bool) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean(PREF_APP, bool.booleanValue()).apply();
    }

    public static void saveDeviceId(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_DEVICE_ID, str).apply();
    }

    public static void saveMsg(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("message", str).apply();
    }

    public static void saveOneSignalId(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("onesignal_id", str).apply();
    }

    public static void saveTitle(Context context, String str) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString("title", str).apply();
    }

    public static void sendData(Context context, String str) {
        new Thread(new c(26, context, str)).start();
    }
}
