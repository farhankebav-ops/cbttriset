package com.mimikridev.utilmanager.firebase;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.ReviewManager;
import com.google.android.play.core.review.ReviewManagerFactory;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.ironsource.Q6;
import com.ironsource.mediationsdk.metadata.a;
import com.mimikridev.utilmanager.R;
import com.mimikridev.utilmanager.dialog.DialogUtil;
import com.mimikridev.utilmanager.firebase.FirebaseUtil;
import com.mimikridev.utilmanager.theme.ThemeManager;
import f3.b;
import java.io.File;
import java.security.MessageDigest;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class FirebaseUtil {
    private static final int IMMEDIATE_APP_UPDATE_REQ_CODE = 3001;
    private static final String KEY_BTN_BUY = "btn_beli";
    private static final String KEY_BTN_BUY_TXT = "btn_beli_txt";
    private static final String KEY_DIALOG_BTN_OK = "app_dialog_btn_ok";
    private static final String KEY_DIALOG_DESC = "app_dialog_desc";
    private static final String KEY_DIALOG_TITLE = "app_dialog_title";
    private static final String KEY_MIN_UPDATE = "app_min_update";
    private static final String KEY_REDIR_URL = "app_redirect_url";
    private static final String PREF_LAST_REVIEW_DAY = "last_review_day";
    private static final String PREF_NAME = "firebase_util_prefs";
    private static final String PREF_REVIEW_COUNT = "review_count";
    private static final String TAG = "FirebaseUtil";
    private static FirebaseAnalytics analytics = null;
    private static AppUpdateManager appUpdateManager = null;
    private static boolean hasLoggedDeviceStatus = false;
    private static String installSource = "unknown";
    private static FirebaseRemoteConfig remoteConfig = null;
    private static int versionCode = 0;
    private static String versionName = "";

    public static void InAppReview(final Activity activity) {
        final int i2 = 0;
        final SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_NAME, 0);
        int i8 = Calendar.getInstance().get(6);
        int i9 = sharedPreferences.getInt(PREF_LAST_REVIEW_DAY, -1);
        int i10 = sharedPreferences.getInt(PREF_REVIEW_COUNT, 0);
        if (i9 != i8) {
            sharedPreferences.edit().putInt(PREF_LAST_REVIEW_DAY, i8).putInt(PREF_REVIEW_COUNT, 0).apply();
        } else {
            i2 = i10;
        }
        if (i2 >= 3) {
            Log.d(TAG, "🚫 Review dibatasi 3x per hari.");
        } else {
            final ReviewManager reviewManagerCreate = ReviewManagerFactory.create(activity);
            reviewManagerCreate.requestReviewFlow().addOnCompleteListener(new OnCompleteListener() { // from class: f3.c
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public final void onComplete(Task task) {
                    FirebaseUtil.lambda$InAppReview$5(reviewManagerCreate, activity, sharedPreferences, i2, task);
                }
            });
        }
    }

    public static void Properties(Activity activity, String str) {
        String string;
        String str2;
        String str3 = a.g;
        String str4 = "unknown";
        if (analytics == null) {
            analytics = FirebaseAnalytics.getInstance(activity);
        }
        int i2 = 0;
        try {
            PackageInfo packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 134217728);
            Signature[] apkContentsSigners = Build.VERSION.SDK_INT >= 28 ? packageInfo.signingInfo.getApkContentsSigners() : packageInfo.signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(apkContentsSigners[0].toByteArray());
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b8 : bArrDigest) {
                sb.append(String.format("%02X:", Byte.valueOf(b8)));
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            string = sb.toString();
        } catch (Exception e) {
            Log.e(TAG, "Gagal membaca SHA app", e);
            string = "unknown";
        }
        try {
            String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
            while (true) {
                if (i2 >= 9) {
                    str2 = "false";
                    break;
                } else {
                    if (new File(strArr[i2]).exists()) {
                        str2 = a.g;
                        break;
                    }
                    i2++;
                }
            }
        } catch (Exception unused) {
            str2 = "unknown";
        }
        if (!Build.FINGERPRINT.startsWith("generic")) {
            String str5 = Build.MODEL;
            if (!str5.contains("Emulator") && !str5.contains("Android SDK built for x86") && !Build.MANUFACTURER.contains("Genymotion") && ((!Build.BRAND.startsWith("generic") || !Build.DEVICE.startsWith("generic")) && !"google_sdk".equals(Build.PRODUCT))) {
                str3 = "false";
            }
        }
        try {
            str4 = activity.getPackageManager().hasSystemFeature("org.chromium.arc") ? "chromeos" : (activity.getResources().getConfiguration().screenLayout & 15) >= 3 ? "tablet" : "phone";
        } catch (Exception unused2) {
        }
        analytics.setUserProperty("is_rooted", str2);
        analytics.setUserProperty("is_emulator", str3);
        analytics.setUserProperty("sha_app", string);
        analytics.setUserProperty("user_type", str);
        analytics.setUserProperty("device_type", str4);
        Bundle bundle = new Bundle();
        bundle.putString("is_rooted", str2);
        bundle.putString("is_emulator", str3);
        bundle.putString("sha_app", string);
        bundle.putString("user_type", str);
        bundle.putString("device_type", str4);
        bundle.putString("brand", Build.BRAND);
        bundle.putString(Q6.B, Build.MODEL);
        bundle.putString("device_language", getDeviceLanguage(activity));
        bundle.putString("android_version", Build.VERSION.RELEASE);
        analytics.logEvent("app_properties", bundle);
        Log.d(TAG, "✅ Properties logged: " + bundle);
    }

    public static void checkInAppUpdate(Activity activity) {
        if (appUpdateManager == null) {
            appUpdateManager = AppUpdateManagerFactory.create(activity);
        }
        appUpdateManager.getAppUpdateInfo().addOnSuccessListener(new com.mimikridev.utilmanager.dialog.a(activity));
    }

    private static void checkMinUpdate(Activity activity, int i2) {
        if (((int) remoteConfig.getDouble(KEY_MIN_UPDATE)) > i2) {
            new AlertDialog.Builder(activity).setTitle(remoteConfig.getString(KEY_DIALOG_TITLE)).setMessage(remoteConfig.getString(KEY_DIALOG_DESC)).setCancelable(false).setIcon(R.mipmap.ic_launcher).setPositiveButton(remoteConfig.getString(KEY_DIALOG_BTN_OK), new b(activity, 0)).setNegativeButton("Tutup", new b(activity, 1)).show();
        }
    }

    private static String detectDeviceType(Activity activity) {
        try {
            String str = Build.DEVICE;
            return (str == null || !str.toLowerCase().contains("cheets")) ? (activity.getResources().getConfiguration().screenLayout & 15) >= 3 ? "tablet" : "phone" : "chromeos";
        } catch (Exception e) {
            Log.e(TAG, "detectDeviceType error: " + e.getMessage());
            return "unknown";
        }
    }

    public static void dg(Context context) {
        Activity activity = (Activity) context;
        activity.runOnUiThread(new com.vungle.ads.internal.omsdk.a(activity, 2));
    }

    private static void fetchRemoteConfig(Activity activity, int i2) {
        remoteConfig.fetchAndActivate().addOnCompleteListener(new f3.a(activity, i2, 1));
    }

    public static FirebaseAnalytics getAnalytics() {
        return analytics;
    }

    public static int getAppVersionCode() {
        return versionCode;
    }

    public static String getAppVersionName() {
        return versionName;
    }

    public static String getDeviceLanguage(Context context) {
        return (Build.VERSION.SDK_INT >= 24 ? context.getResources().getConfiguration().getLocales().get(0) : context.getResources().getConfiguration().locale).getLanguage();
    }

    public static String getInstallSource() {
        return installSource;
    }

    public static FirebaseRemoteConfig getRemoteConfig() {
        return remoteConfig;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0076 -> B:51:0x007b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:29:0x0071
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1182)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    public static void init(android.app.Activity r5) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mimikridev.utilmanager.firebase.FirebaseUtil.init(android.app.Activity):void");
    }

    private static boolean isDebugBuild(Activity activity) {
        return (activity.getApplicationInfo().flags & 2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$InAppReview$4(SharedPreferences sharedPreferences, int i2, Task task) {
        Log.d(TAG, "✅ Review ditampilkan");
        sharedPreferences.edit().putInt(PREF_REVIEW_COUNT, i2 + 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$InAppReview$5(ReviewManager reviewManager, Activity activity, SharedPreferences sharedPreferences, int i2, Task task) {
        if (task.isSuccessful()) {
            reviewManager.launchReviewFlow(activity, (ReviewInfo) task.getResult()).addOnCompleteListener(new f3.a(sharedPreferences, i2, 0));
        } else {
            Log.w(TAG, "⚠️ Gagal memulai in-app review", task.getException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkInAppUpdate$6(Activity activity, AppUpdateInfo appUpdateInfo) {
        if (appUpdateInfo.updateAvailability() == 2 && appUpdateInfo.isUpdateTypeAllowed(1)) {
            startImmediateUpdate(activity, appUpdateInfo);
        } else if (appUpdateInfo.updateAvailability() == 3) {
            startImmediateUpdate(activity, appUpdateInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkMinUpdate$2(Activity activity, DialogInterface dialogInterface, int i2) {
        String string = remoteConfig.getString(KEY_REDIR_URL);
        if (string == null || string.isEmpty()) {
            string = "https://play.google.com/store/apps/details?id=" + activity.getPackageName();
        }
        activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        activity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$dg$1(Activity activity) {
        DialogUtil.showErrorDialogExit(activity, remoteConfig.getString("app_blocked_title"), remoteConfig.getString("app_blocked_msg"), "Exit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$fetchRemoteConfig$0(Activity activity, int i2, Task task) {
        if (!task.isSuccessful()) {
            Log.w(TAG, "⚠️ Remote Config fetch failed", task.getException());
            return;
        }
        Log.d(TAG, "✅ Remote Config fetched & activated");
        ThemeManager.saveRemoteConfigToTheme(activity, remoteConfig);
        checkMinUpdate(activity, i2);
        if (remoteConfig.getBoolean("is_blocked")) {
            dg(activity);
        }
    }

    public static void logScreen(Activity activity, String str) {
        FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundleC = androidx.camera.core.processing.util.a.c(FirebaseAnalytics.Param.SCREEN_NAME, str);
        bundleC.putString(FirebaseAnalytics.Param.SCREEN_CLASS, activity.getClass().getSimpleName());
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundleC);
    }

    public static void setRuntimePropertiesAndLogEvent(@NonNull Activity activity, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        try {
            if (analytics == null) {
                analytics = FirebaseAnalytics.getInstance(activity);
            }
            analytics.setUserProperty("is_rooted", str);
            analytics.setUserProperty("is_emulator", str4);
            analytics.setUserProperty("sha_app", str2);
            analytics.setUserProperty("user_type", str3);
            Log.d(TAG, "User properties (runtime) updated.");
            if (hasLoggedDeviceStatus) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("is_rooted", str);
            bundle.putString("is_emulator", str4);
            bundle.putString("device_type", detectDeviceType(activity));
            bundle.putString("brand", Build.BRAND);
            bundle.putString(Q6.B, Build.MODEL);
            bundle.putString("android_version", Build.VERSION.RELEASE);
            bundle.putString("user_type", str3);
            bundle.putString("sha_app", str2);
            analytics.logEvent("device_status_check", bundle);
            hasLoggedDeviceStatus = true;
            Log.d(TAG, "Firebase event 'device_status_check' sent.");
        } catch (Exception e) {
            Log.e(TAG, "setRuntimePropertiesAndLogEvent error: " + e.getMessage(), e);
        }
    }

    private static void startImmediateUpdate(Activity activity, AppUpdateInfo appUpdateInfo) {
        try {
            appUpdateManager.startUpdateFlowForResult(appUpdateInfo, 1, activity, 3001);
        } catch (IntentSender.SendIntentException e) {
            Log.e(TAG, "Update flow failed", e);
        }
    }
}
