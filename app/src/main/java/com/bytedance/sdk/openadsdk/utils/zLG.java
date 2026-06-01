package com.bytedance.sdk.openadsdk.utils;

import a1.a;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.webkit.ProxyConfig;
import com.bytedance.sdk.component.DmF.vCE;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.ironsource.C2605va;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import com.vungle.ads.internal.signals.SignalManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;
import org.json.JSONObject;
import r.c;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public class zLG {
    private static final HashSet<String> EV;
    public static Integer IlO;
    private static String bWL;
    private static String ea;
    private static final byte[] hp;
    private static final byte[] rp;
    private static final ExecutorService MY = Executors.newSingleThreadExecutor();
    private static volatile boolean EO = false;
    private static final AtomicInteger tV = new AtomicInteger(0);
    private static volatile String Cc = "";
    private static final ReentrantLock vCE = new ReentrantLock();
    private static String Bc = null;
    private static String lEW = null;
    private static String DmF = null;
    private static final HashSet<String> NV = new HashSet<>(Arrays.asList("Asia/Shanghai", "Asia/Urumqi", "Asia/Chongqing", "Asia/Harbin", "Asia/Kashgar"));

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.utils.zLG$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                if (TextUtils.isEmpty(zLG.Cc)) {
                    com.bytedance.sdk.component.DmF.vCE vce = new com.bytedance.sdk.component.DmF.vCE(com.bytedance.sdk.openadsdk.core.cl.IlO());
                    vce.setWebViewClient(new vCE.IlO());
                    String unused = zLG.Cc = vce.getUserAgentString();
                }
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "", e);
            } catch (NoClassDefFoundError e4) {
                com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "", e4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class IlO implements Callable<String> {
        private final int IlO;

        public IlO(int i2) {
            this.IlO = i2;
        }

        private synchronized String EO() {
            final String[] strArr;
            strArr = new String[]{"unKnow"};
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            mmj.IlO(new Runnable() { // from class: com.bytedance.sdk.openadsdk.utils.zLG.IlO.1
                @Override // java.lang.Runnable
                public void run() {
                    strArr[0] = zLG.wPn();
                    String str = strArr[0];
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", e.getMessage());
            }
            return strArr[0];
        }

        private String MY() {
            String property;
            Throwable th;
            try {
                property = System.getProperty("http.agent");
                if (property != null) {
                    try {
                        if (!"unKnow".equals(property)) {
                            if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                                com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_ua_data", "android_system_ua", property);
                                return property;
                            }
                            com.bytedance.sdk.openadsdk.core.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()).IlO("android_system_ua", property);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        com.bytedance.sdk.component.utils.oeT.EO("getUA", "e:" + th.getMessage());
                        return property;
                    }
                }
                return property;
            } catch (Throwable th3) {
                property = "unKnow";
                th = th3;
            }
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IlO, reason: merged with bridge method [inline-methods] */
        public synchronized String call() throws Exception {
            String strMY;
            try {
                strMY = "unKnow";
                int i2 = this.IlO;
                if (i2 == 1) {
                    strMY = EO();
                } else if (i2 == 2) {
                    strMY = MY();
                }
            } catch (Throwable th) {
                throw th;
            }
            return strMY;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class MY {
        public final ComponentName IlO;
        public final int MY;

        public MY(ComponentName componentName, int i2) {
            this.IlO = componentName;
            this.MY = i2;
        }
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        EV = hashSet;
        hashSet.addAll(Arrays.asList("America/Eirunepe", "America/Rio_Branco", "America/Boa_Vista", "America/Campo_Grande", "America/Cuiaba", "America/Manaus", "America/Porto_Velho", "America/Araguaina", "America/Bahia", "America/Belem", "America/Fortaleza", "America/Maceio", "America/Recife", "America/Santarem", "America/Sao_Paulo", "America/Noronha"));
        IlO = null;
        rp = new byte[]{108, 111, 97, 100, 105, 110, 103};
        hp = new byte[]{97, 114, 98, 105, 116, 114, 97, 103, 101};
    }

    public static String AXM() {
        int i2 = -xF();
        return i2 >= 0 ? "Etc/GMT+".concat(String.valueOf(i2)) : "Etc/GMT".concat(String.valueOf(i2));
    }

    public static int Bc(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 4) {
            return 1;
        }
        if (i2 == 5) {
            return 4;
        }
        if (i2 != 6) {
            return i2;
        }
        return 5;
    }

    public static boolean Cc(int i2) {
        return i2 == 5;
    }

    public static String DmF() {
        return EO("MemTotal");
    }

    public static String EO(int i2) {
        return i2 != 1 ? i2 != 2 ? (i2 == 3 || i2 == 4) ? "open_ad" : i2 != 7 ? i2 != 8 ? "embeded_ad" : "fullscreen_interstitial_ad" : "rewarded_video" : "interaction" : "banner_ad";
    }

    public static void IlO(@NonNull com.bytedance.sdk.openadsdk.core.model.oeT oet, @NonNull View view) {
    }

    public static boolean MY(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                Intent intent = new Intent("android.intent.action.DIAL", Uri.parse("tel:" + Uri.encode(str)));
                if (!(context instanceof Activity)) {
                    intent.setFlags(268435456);
                }
                com.bytedance.sdk.component.utils.MY.IlO(context, intent, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static long NV() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String bWL() {
        String strAa = com.bytedance.sdk.openadsdk.core.cl.tV().aa();
        if (!TextUtils.isEmpty(strAa)) {
            return strAa;
        }
        String strIlO = oeT.IlO();
        return !TextUtils.isEmpty(strIlO) ? a.m("https://", strIlO, "/service/2/dual_events/") : strAa;
    }

    public static String cL() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static String cl() {
        return "https://lf-static.tiktokpangle-cdn-us.com/obj/ad-pattern-tx/renderer/package_tx.json";
    }

    public static String ea() {
        String strVSq = com.bytedance.sdk.openadsdk.core.cl.tV().vSq();
        return TextUtils.isEmpty(strVSq) ? oeT.IlO() : strVSq;
    }

    public static int es() {
        try {
            String id = TimeZone.getDefault().getID();
            if (NV.contains(id)) {
                return 2;
            }
            if (id != null && id.startsWith("Asia/")) {
                return 2;
            }
            if (id != null && id.startsWith("Europe/")) {
                return 4;
            }
            if (id == null || !id.startsWith("America/")) {
                return 3;
            }
            return !EV.contains(id) ? 5 : 3;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.toString());
            return 0;
        }
    }

    public static String hp() {
        String strOc = com.bytedance.sdk.openadsdk.core.cl.tV().oc();
        return TextUtils.isEmpty(strOc) ? oeT.IlO() : strOc;
    }

    public static String kBB() {
        String str = ea;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(hp);
        ea = str2;
        return str2;
    }

    public static boolean lEW(Context context) {
        return false;
    }

    private static boolean oc() {
        try {
            return "mounted".equals(Environment.getExternalStorageState());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean oeT() {
        return tV.get() == 1;
    }

    public static boolean rp() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean tV(int i2) {
        return i2 == 4;
    }

    public static String vAh() {
        String str = bWL;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = new String(rp);
        bWL = str2;
        return str2;
    }

    public static boolean vCE(int i2) {
        return i2 == 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String wPn() {
        try {
            WebView webView = new WebView(com.bytedance.sdk.openadsdk.core.cl.IlO());
            webView.setWebViewClient(new vCE.IlO());
            String userAgentString = webView.getSettings().getUserAgentString();
            if (userAgentString != null && !"unKnow".equals(userAgentString)) {
                if (com.bytedance.sdk.openadsdk.multipro.MY.EO()) {
                    com.bytedance.sdk.openadsdk.multipro.tV.IlO.IlO("sp_multi_ua_data", "webview_ua", userAgentString);
                    return userAgentString;
                }
                com.bytedance.sdk.openadsdk.core.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()).IlO("webview_ua", userAgentString);
            }
            return userAgentString;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("getUA", "e:" + th.getMessage());
            return "unKnow";
        }
    }

    public static int xF() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static String zPa() {
        return "https://log.byteoversea.com/service/2/app_log_test/";
    }

    public static synchronized String Bc() {
        try {
            if (TextUtils.isEmpty(DmF) && com.bytedance.sdk.openadsdk.core.cl.IlO() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.cl.IlO().getPackageManager().getPackageInfo(Cc(), 0);
                    lEW = String.valueOf(packageInfo.versionCode);
                    DmF = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "ToolUtils getVersionName throws exception :", th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return DmF;
    }

    public static synchronized String Cc() {
        Context contextIlO;
        try {
            if (TextUtils.isEmpty(Bc) && (contextIlO = com.bytedance.sdk.openadsdk.core.cl.IlO()) != null) {
                try {
                    Bc = contextIlO.getPackageName();
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "ToolUtils getPackageName throws exception :", th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return Bc;
    }

    public static boolean DmF(Context context) {
        if (context == null) {
            return false;
        }
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static long EV() {
        try {
            if (!oc()) {
                return 0L;
            }
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static String lEW() {
        try {
            ActivityManager activityManager = (ActivityManager) com.bytedance.sdk.openadsdk.core.cl.IlO().getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long j = memoryInfo.totalMem;
            if (j > 0) {
                return String.valueOf(j / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String rp(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter(C2605va.f10440b, "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", vCE()).toString();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", e.getMessage());
            return str;
        }
    }

    public static String tV() {
        return pP.IlO();
    }

    public static synchronized String vCE() {
        try {
            if (TextUtils.isEmpty(lEW) && com.bytedance.sdk.openadsdk.core.cl.IlO() != null) {
                try {
                    PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.cl.IlO().getPackageManager().getPackageInfo(Cc(), 0);
                    lEW = String.valueOf(packageInfo.versionCode);
                    DmF = packageInfo.versionName;
                } catch (Throwable th) {
                    com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "ToolUtils getVersionCode throws exception :", th);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return lEW;
    }

    public static Intent IlO(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static long tV(Context context) {
        return com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("free_internal_storage", 0L).longValue();
    }

    public static boolean DmF(String str) {
        if (com.bytedance.sdk.openadsdk.core.bWL.Cc()) {
            return true;
        }
        com.bytedance.sdk.component.utils.oeT.EO(a.m("You must use method '", str, "' after initialization, please check."), new Object[0]);
        return false;
    }

    public static void hp(Context context) {
        try {
            AtomicInteger atomicInteger = tV;
            if (atomicInteger.get() != 0) {
                return;
            }
            AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
            boolean zIsEnabled = accessibilityManager.isEnabled();
            boolean zIsTouchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
            if (zIsEnabled && zIsTouchExplorationEnabled) {
                atomicInteger.set(1);
                com.bytedance.sdk.openadsdk.ea.EO.IlO().EO();
            } else {
                atomicInteger.set(2);
            }
        } catch (Exception unused) {
            tV.set(2);
        }
    }

    public static String tV(String str) {
        return IlO(str, false, false);
    }

    public static int NV(Context context) {
        try {
            return context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.getMessage());
            return -1;
        }
    }

    public static boolean tV(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        return oet != null && oet.Jz() == 3 && oet.nm() && (oet.ii() == 4 || oet.ii() == 5);
    }

    public static long Cc(Context context) {
        return com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("total_sdcard_storage", 0L).longValue();
    }

    public static String EO() {
        if (!TextUtils.isEmpty(Cc)) {
            return Cc;
        }
        com.bytedance.sdk.openadsdk.multipro.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        String strIlO = com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_local_web_ua", SignalManager.TWENTY_FOUR_HOURS_MILLIS);
        Cc = strIlO;
        if (TextUtils.isEmpty(strIlO)) {
            ReentrantLock reentrantLock = vCE;
            try {
                if (reentrantLock.tryLock()) {
                    try {
                        if (TextUtils.isEmpty(Cc)) {
                            Cc = WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.cl.IlO());
                        }
                        com.bytedance.sdk.openadsdk.core.DmF.IlO("sdk_local_web_ua", Cc);
                        reentrantLock.unlock();
                    } catch (Exception e) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "", e);
                    } catch (NoClassDefFoundError e4) {
                        com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "", e4);
                    }
                }
            } finally {
                vCE.unlock();
            }
        }
        return Cc;
    }

    public static String MY(int i2) {
        if (i2 == 1) {
            return "embeded_ad_landingpage";
        }
        if (i2 == 2) {
            return "banner_ad_landingpage";
        }
        if (i2 == 3) {
            return "interaction_landingpage";
        }
        if (i2 == 4) {
            return "splash_ad_landingpage";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return "unknow";
        }
        return "rewarded_video_landingpage";
    }

    public static String Cc(String str) {
        if (TextUtils.isEmpty(str)) {
            str = com.bytedance.sdk.openadsdk.core.cl.tV().dY();
        }
        if (TextUtils.isEmpty(str)) {
            return "https://api16-access-ttp.tiktokpangle.us/service/2/app_log/";
        }
        return !str.startsWith(ProxyConfig.MATCH_HTTP) ? "https://".concat(str) : str;
    }

    public static long EV(Context context) {
        int i2 = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i2 = context.getApplicationInfo().minSdkVersion;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.getMessage());
        }
        return i2;
    }

    public static void NV(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        com.bytedance.sdk.component.utils.oeT.EO(a.m("You should use method '", str, "' on the asynchronous thread,it may cause anr, please check."), new Object[0]);
    }

    public static void lEW(final String str) {
        com.bytedance.sdk.openadsdk.ea.EO.IlO();
        com.bytedance.sdk.openadsdk.ea.EO.IlO("reportMultiLog", false, new com.bytedance.sdk.openadsdk.ea.MY() { // from class: com.bytedance.sdk.openadsdk.utils.zLG.2
            @Override // com.bytedance.sdk.openadsdk.ea.MY
            public com.bytedance.sdk.openadsdk.ea.IlO.EO getLogStats() throws Exception {
                if (zLG.EO || !com.bytedance.sdk.openadsdk.core.cl.tV().KC()) {
                    return null;
                }
                boolean unused = zLG.EO = true;
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("error", str);
                return com.bytedance.sdk.openadsdk.ea.IlO.tV.MY().IlO("reportMultiLog").MY(jSONObject.toString());
            }
        });
    }

    public static int rp(Context context) {
        return Bc(com.bytedance.sdk.component.utils.wPn.IlO(context, 0L));
    }

    @NonNull
    public static MY IlO(Context context, Intent intent) {
        return new MY(null, 0);
    }

    public static boolean lEW(int i2) {
        if (i2 <= 0) {
            return false;
        }
        return i2 >= 100 || new Random(System.currentTimeMillis()).nextInt(100) + 1 <= i2;
    }

    public static boolean IlO() {
        return (com.bytedance.sdk.openadsdk.core.ea.IlO() == null || com.bytedance.sdk.openadsdk.core.ea.IlO().tV()) ? false : true;
    }

    public static String Bc(@NonNull Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", e.toString());
            return "";
        }
    }

    public static String IlO(int i2) {
        if (i2 == 1) {
            return "embeded_ad";
        }
        if (i2 == 2) {
            return "banner_ad";
        }
        if (i2 == 3) {
            return "interaction";
        }
        if (i2 == 4) {
            return "open_ad";
        }
        if (i2 == 5) {
            return "fullscreen_interstitial_ad";
        }
        if (i2 != 7) {
            return null;
        }
        return "rewarded_video";
    }

    public static int vCE(Context context) {
        return com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("is_root", -1);
    }

    public static int bWL(Context context) {
        List<ResolveInfo> listQueryIntentActivities;
        Integer num = IlO;
        if (num != null) {
            return num.intValue();
        }
        if (context == null || (listQueryIntentActivities = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("https://www.example.com")), 0)) == null) {
            return 0;
        }
        int size = listQueryIntentActivities.size();
        IlO = Integer.valueOf(size);
        return size;
    }

    public static boolean vCE(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int MY(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null) {
            return -1;
        }
        int iOyN = oet.OyN();
        int i2 = 1;
        if (iOyN == 1) {
            return 2;
        }
        if (iOyN == 3) {
            return 4;
        }
        if (iOyN != 5) {
            i2 = 7;
            if (iOyN != 7) {
                return iOyN != 8 ? -1 : 5;
            }
        }
        return i2;
    }

    public static String MY() {
        String str = "unKnow";
        com.bytedance.sdk.openadsdk.multipro.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        try {
            String strMY = com.bytedance.sdk.openadsdk.multipro.MY.EO() ? com.bytedance.sdk.openadsdk.multipro.tV.IlO.MY("sp_multi_ua_data", "android_system_ua", "unKnow") : com.bytedance.sdk.openadsdk.core.EO.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO()).MY("android_system_ua", "unKnow");
            if (strMY != null && !"unKnow".equals(strMY)) {
                return strMY;
            }
            FutureTask futureTask = new FutureTask(new IlO(2));
            MY.execute(futureTask);
            str = (String) futureTask.get(500L, TimeUnit.MILLISECONDS);
        } catch (Exception unused) {
        }
        com.bytedance.sdk.component.utils.oeT.EO("getUA", " getAndroidSystemUA userAgent".concat(String.valueOf(str)));
        return str;
    }

    public static String Bc(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static String IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null) {
            return null;
        }
        try {
            return EO(oet.OyN());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int IlO(String str) {
        str.getClass();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "open_ad":
            case "cache_splash_ad":
                return 4;
            case "fullscreen_interstitial_ad":
                return 5;
            case "interaction":
                return 3;
            default:
                return 1;
        }
    }

    public static String IlO(Context context) {
        String strMY = com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("total_memory", (String) null);
        if (strMY != null && MY(strMY) > 0) {
            return strMY;
        }
        String strEO = EO("MemTotal");
        if (MY(strEO) <= 0) {
            strEO = lEW();
        }
        com.bytedance.sdk.openadsdk.core.EO.IlO(context).IlO("total_memory", strEO);
        return strEO;
    }

    public static String EO(String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MEM_INFO);
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused) {
                                }
                            }
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception unused2) {
                                }
                            }
                            return null;
                        } finally {
                        }
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused4) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused6) {
                }
                return str2;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static long MY(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static String IlO(@NonNull String str, boolean z2, boolean z7) {
        String strHp;
        if (str != null && !str.startsWith("/")) {
            str = "/".concat(str);
        }
        if (z7) {
            strHp = ea();
        } else {
            strHp = hp();
        }
        if (TextUtils.isEmpty(strHp)) {
            strHp = "api16-access-ttp.tiktokpangle.us";
        }
        String strM = a.m("https://", strHp, str);
        if (YA.IlO() && !z2) {
            strM = YA.IlO(strM);
        }
        return z2 ? rp(strM) : strM;
    }

    public static String MY(Context context) {
        return com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("total_memory", "0");
    }

    public static long EO(Context context) {
        return com.bytedance.sdk.openadsdk.core.EO.IlO(context).MY("total_internal_storage", 0L).longValue();
    }

    public static boolean EO(com.bytedance.sdk.openadsdk.core.model.oeT oet) {
        if (oet == null) {
            return true;
        }
        int iMY = com.bytedance.sdk.openadsdk.core.cl.tV().MY(oet.hFV());
        int iEO = com.bytedance.sdk.component.utils.xF.EO(com.bytedance.sdk.openadsdk.core.cl.IlO());
        if (iMY == 1) {
            return tV(iEO);
        }
        if (iMY == 2) {
            return Cc(iEO) || tV(iEO) || vCE(iEO);
        }
        if (iMY != 3) {
            return iMY != 5 || tV(iEO) || vCE(iEO);
        }
        return false;
    }

    public static JSONObject IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, long j, c cVar) {
        if (oet == null) {
            return new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("creative_id", oet.ED());
            jSONObject.put("buffers_time", j);
            com.bykv.vk.openvk.IlO.IlO.IlO.EO.c cVarFdM = oet.fdM();
            if (cVarFdM != null) {
                jSONObject.put("video_size", cVarFdM.f4687c);
                jSONObject.put("video_resolution", cVarFdM.e);
            }
            IlO(jSONObject, cVar);
            return jSONObject;
        } catch (JSONException e) {
            com.bytedance.sdk.component.utils.oeT.IlO("TTAD.ToolUtils", "getVideoAction json error", e);
            return jSONObject;
        }
    }

    private static void IlO(JSONObject jSONObject, c cVar) {
        if (jSONObject.has("video_resolution") || cVar == null) {
            return;
        }
        try {
            jSONObject.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(cVar.tV()), Integer.valueOf(cVar.Cc())));
        } catch (Throwable unused) {
        }
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, String str) {
        if (oet != null) {
            try {
                String strPFe = oet.pFe();
                if (TextUtils.isEmpty(strPFe) && oet.zTS() != null && oet.zTS().EO() == 1 && !TextUtils.isEmpty(oet.zTS().MY())) {
                    strPFe = oet.zTS().MY();
                }
                String str2 = strPFe;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.lMM.IlO(com.bytedance.sdk.openadsdk.core.cl.IlO(), str2, oet, IlO(str), str, false);
            } catch (Throwable unused) {
            }
        }
    }

    public static void IlO(String str, String str2, Context context) {
        int i2;
        if (TextUtils.isEmpty(str2) || !DmF(context)) {
            return;
        }
        int length = str2.length();
        int i8 = 1;
        if (length % 3572 == 0) {
            i2 = length / 3572;
        } else {
            i2 = (length / 3572) + 1;
        }
        int i9 = 3572;
        int i10 = 0;
        while (i8 <= i2) {
            if (i9 < length) {
                Log.d(str, i2 + "-" + i8 + ":" + str2.substring(i10, i9));
                i8++;
                i10 = i9;
                i9 += 3572;
            } else {
                Log.d(str, i2 + "-" + i8 + ":" + str2.substring(i10));
                return;
            }
        }
    }

    public static void IlO(StringBuilder sb, String str, String str2) {
        int iIndexOf;
        if (sb == null || TextUtils.isEmpty(str) || (iIndexOf = sb.indexOf(str)) <= 0) {
            return;
        }
        sb.replace(iIndexOf, str.length() + iIndexOf, str2);
    }

    public static com.bytedance.sdk.openadsdk.common.tV IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.component.DmF.vCE vce, Context context, String str) {
        int iIi = oet.ii();
        if (!oet.nm()) {
            return null;
        }
        if (iIi != 1 && iIi != 3) {
            return null;
        }
        vce.IlO(true, (View) new com.bytedance.sdk.openadsdk.common.EO(context));
        return new com.bytedance.sdk.openadsdk.common.tV(oet, vce, str, false);
    }

    public static void IlO(JSONObject jSONObject) {
        int iIntValue;
        try {
            Pair<String, Long> pairTV = com.bytedance.sdk.openadsdk.core.DmF.tV("oem_store");
            int i2 = -1;
            if (pairTV != null && ((iIntValue = Integer.valueOf((String) pairTV.first).intValue()) != -2 || System.currentTimeMillis() - ((Long) pairTV.second).longValue() < com.bytedance.sdk.openadsdk.AXM.IlO.IlO("oem_store_state_time", 259200000))) {
                i2 = iIntValue;
            }
            jSONObject.put("oem_store", i2);
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.getMessage());
        }
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.component.DmF.vCE vce) {
        IlO(oet, vce, false);
    }

    public static void IlO(com.bytedance.sdk.openadsdk.core.model.oeT oet, com.bytedance.sdk.component.DmF.vCE vce, boolean z2) {
        com.bytedance.sdk.component.DmF.vCE vce2;
        com.bytedance.sdk.openadsdk.core.model.vCE vceCl;
        List<Integer> list;
        if (oet == null || vce == null) {
            return;
        }
        int iIi = oet.ii();
        if (!oet.nm() || (!(iIi == 2 || iIi == 3 || iIi == 5) || (vceCl = oet.cl()) == null)) {
            vce2 = vce;
        } else {
            List<Integer> listCc = vceCl.Cc();
            ArrayList arrayList = new ArrayList();
            if (z2) {
                for (int i2 = 0; i2 < listCc.size(); i2++) {
                    arrayList.add(Integer.valueOf(listCc.get(i2).intValue() - 1));
                }
                list = arrayList;
            } else {
                list = listCc;
            }
            vce2 = vce;
            vce2.IlO(true, vceCl.EO(), vceCl.tV(), list, vceCl.vCE(), vceCl.MY());
        }
        int iSu = oet.su();
        long jSr = oet.sr();
        if ((iSu == 1 || iSu == 2) && jSr > 0) {
            vce2.IlO(iSu, jSr);
        }
    }

    public static int IlO(WebView webView) {
        if (webView == null) {
            return -1;
        }
        try {
            WebBackForwardList webBackForwardListCopyBackForwardList = webView.copyBackForwardList();
            int size = webBackForwardListCopyBackForwardList.getSize();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                WebHistoryItem itemAtIndex = webBackForwardListCopyBackForwardList.getItemAtIndex(i2);
                if (itemAtIndex != null) {
                    String url = itemAtIndex.getUrl();
                    if (!arrayList.contains(url)) {
                        arrayList.add(url);
                    }
                }
            }
            return arrayList.indexOf(webView.getUrl()) + 1;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.oeT.EO("TTAD.ToolUtils", th.toString());
            return -1;
        }
    }

    public static JSONObject IlO(AdSlot adSlot) {
        JSONObject jSONObject = new JSONObject();
        if (adSlot != null) {
            try {
                jSONObject.put("is_sb", !TextUtils.isEmpty(adSlot.getBidAdm()));
            } catch (Throwable unused) {
            }
        }
        return jSONObject;
    }
}
