package com.ironsource;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.InterfaceC2565t4;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.d5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2283d5 implements B7, B7.a {
    private static final String A = "browser_user_agent";
    private static final String B = "browser_user_agent_time";
    private static final String C = "IABTCF_gdprApplies";
    private static final String D = "IABTCF_TCString";
    private static final String E = "IABTCF_AddtlConsent";
    private static final String j = "android";
    private static final String k = "com.google.android.gms.permission.AD_ID";
    private static final String l = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String m = "com.google.android.gms.appset.AppSet";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f8186n = "com.google.android.gms.tasks.OnSuccessListener";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f8187o = "getAdvertisingIdInfo";
    private static final String p = "getClient";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f8188q = "getAppSetIdInfo";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f8189r = "addOnSuccessListener";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f8190s = "getId";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f8191t = "isLimitAdTrackingEnabled";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f8192u = "Mediation_Shared_Preferences";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f8193v = "supersonic_shared_preferen";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f8194w = "cachedUUID";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f8195x = "auid";
    private static final String y = "unityads-installinfo";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f8196z = "unityads-idfi";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8198c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8199d = null;
    private String e = "";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8200f = false;
    private String g = "";
    private volatile String h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile String f8201i;

    /* JADX INFO: renamed from: com.ironsource.d5$a */
    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public class a implements InvocationHandler {
        public a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (objArr != null) {
                try {
                    if (objArr.length > 0 && (obj2 = objArr[0]) != null) {
                        String string = obj2.getClass().getMethod(C2283d5.f8190s, null).invoke(objArr[0], null).toString();
                        if (!TextUtils.isEmpty(string)) {
                            C2283d5.this.g = string;
                            return null;
                        }
                    }
                } catch (Exception e) {
                    C2531r4.d().a(e);
                }
            }
            return null;
        }
    }

    private String O(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objQ = Q(context);
        return objQ.getClass().getMethod(f8190s, null).invoke(objQ, null).toString();
    }

    private void P(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objInvoke = AppSet.class.getMethod(p, Context.class).invoke(AppSet.class, context);
        Object objInvoke2 = objInvoke.getClass().getMethod(f8188q, null).invoke(objInvoke, null);
        objInvoke2.getClass().getMethod(f8189r, OnSuccessListener.class).invoke(objInvoke2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{OnSuccessListener.class}, new a()));
    }

    private Object Q(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        return AdvertisingIdClient.class.getMethod(f8187o, Context.class).invoke(AdvertisingIdClient.class, context);
    }

    private String R(Context context) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Object objQ = Q(context);
        return String.valueOf(((Boolean) objQ.getClass().getMethod("isLimitAdTrackingEnabled", null).invoke(objQ, null)).booleanValue());
    }

    private String S(Context context) {
        try {
            return C2324fa.a(context, f8192u, A, "");
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    private long T(Context context) {
        try {
            return Long.parseLong(C2324fa.a(context, f8192u, B, String.valueOf(-1L)));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1L;
        }
    }

    @Override // com.ironsource.B7
    public String A(Context context) {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    @Override // com.ironsource.B7
    public File B(Context context) {
        return context.getCacheDir();
    }

    @Override // com.ironsource.B7
    public boolean C(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("status", -1) : -1;
        return intExtra == 2 || intExtra == 5;
    }

    @Override // com.ironsource.B7
    public int D(Context context) {
        Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (intentRegisterReceiver != null) {
            return intentRegisterReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    @Override // com.ironsource.B7
    public float E(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        try {
            return audioManager.getStreamVolume(3) / audioManager.getStreamMaxVolume(3);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return -1.0f;
        }
    }

    @Override // com.ironsource.B7
    public String F(Context context) {
        try {
            return C2324fa.a(context, E, (String) null);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return null;
        }
    }

    @Override // com.ironsource.B7
    public String G(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkCountryIso();
    }

    @Override // com.ironsource.B7
    public List<ApplicationInfo> H(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    @Override // com.ironsource.B7
    public String I(Context context) {
        C2229a5 c2229a5 = C2229a5.f7951a;
        if (c2229a5.b()) {
            try {
                if (!c2229a5.a()) {
                    return O(context);
                }
                if (this.f8201i != null) {
                    return this.f8201i;
                }
                String strO = O(context);
                if (TextUtils.isEmpty(strO)) {
                    return strO;
                }
                this.f8201i = strO;
                return strO;
            } catch (Exception e) {
                C2531r4.d().a(e);
            }
        }
        return null;
    }

    @Override // com.ironsource.B7
    public boolean J(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.B7
    public int K(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    @Override // com.ironsource.B7
    public String L(Context context) {
        try {
            ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.HOME"), 65536);
            if (resolveInfoResolveActivity != null) {
                return resolveInfoResolveActivity.activityInfo.packageName;
            }
            return null;
        } catch (Throwable th) {
            C2531r4.d().a(th);
            return null;
        }
    }

    @Override // com.ironsource.B7
    public synchronized String M(Context context) {
        if (!TextUtils.isEmpty(this.f8197b)) {
            return this.f8197b;
        }
        if (C2324fa.a(context, f8192u, B7.f6379a, true)) {
            String strA = C2324fa.a(context, f8192u, f8194w, "");
            if (TextUtils.isEmpty(strA)) {
                String string = UUID.randomUUID().toString();
                this.f8197b = string;
                C2324fa.b(context, f8192u, f8194w, string);
            } else {
                this.f8197b = strA;
            }
        }
        return this.f8197b;
    }

    @Override // com.ironsource.B7
    public int N(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    @Override // com.ironsource.B7
    public Boolean b(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Boolean.valueOf(memoryInfo.lowMemory);
    }

    @Override // com.ironsource.B7
    public String c(Context context) {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    @Override // com.ironsource.B7
    public String d() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    @Override // com.ironsource.B7
    public boolean e(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.B7
    public String f() {
        return "android";
    }

    @Override // com.ironsource.B7
    public long g() {
        if (j()) {
            return a(Environment.getExternalStorageDirectory());
        }
        return 0L;
    }

    @Override // com.ironsource.B7
    public boolean h(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return false;
        }
    }

    @Override // com.ironsource.B7
    public String i() {
        return Build.VERSION.RELEASE;
    }

    @Override // com.ironsource.B7
    public boolean j() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                if (Environment.isExternalStorageRemovable()) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return false;
        }
    }

    @Override // com.ironsource.B7
    public int k() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    @Override // com.ironsource.B7
    public String l() {
        return Build.MODEL;
    }

    @Override // com.ironsource.B7
    public int m() {
        return -(TimeZone.getDefault().getOffset(a()) / 60000);
    }

    @Override // com.ironsource.B7
    public ActivityManager.MemoryInfo n(Context context) {
        if (context == null || !Mb.U().g().a()) {
            return null;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return null;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    @Override // com.ironsource.B7
    public int o() {
        return k();
    }

    @Override // com.ironsource.B7
    public boolean p() {
        return b(AndroidStaticDeviceInfoDataSource.BINARY_SU);
    }

    @Override // com.ironsource.B7
    public long q(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1L;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    @Override // com.ironsource.B7
    public float r() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    @Override // com.ironsource.B7
    public String s() {
        try {
            return this.e.isEmpty() ? S(ContextProvider.getInstance().getApplicationContext()) : this.e;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    @Override // com.ironsource.B7
    public String t() {
        try {
            return System.getProperty("os.arch");
        } catch (SecurityException e) {
            IronLog.INTERNAL.error(e.getMessage());
            return null;
        }
    }

    @Override // com.ironsource.B7
    public String u(Context context) {
        TelephonyManager telephonyManager;
        return (context == null || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : telephonyManager.getNetworkOperatorName();
    }

    @Override // com.ironsource.B7
    public String v(Context context) {
        try {
            return C2324fa.a(context, "IABTCF_TCString", (String) null);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return null;
        }
    }

    @Override // com.ironsource.B7
    public boolean w(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    @Override // com.ironsource.B7
    public String x(Context context) {
        return Locale.getDefault().toString();
    }

    @Override // com.ironsource.B7
    public String y(Context context) {
        if (!C2229a5.f7951a.c()) {
            return "";
        }
        try {
            P(context);
            return !TextUtils.isEmpty(this.g) ? this.g : "";
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    @Override // com.ironsource.B7
    public int z(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    private boolean b(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i2 = 0; i2 < 8; i2++) {
                if (new File(strArr[i2] + str).exists()) {
                    return true;
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
        return false;
    }

    @Override // com.ironsource.B7
    public long a() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    @Override // com.ironsource.B7
    public Long c(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.availMem);
    }

    @Override // com.ironsource.B7
    public File f(Context context) {
        return context.getExternalFilesDir(null);
    }

    @Override // com.ironsource.B7
    public String i(Context context) {
        if (!TextUtils.isEmpty(this.f8199d)) {
            return this.f8199d;
        }
        if (context == null) {
            return null;
        }
        String strA = C2324fa.a(context, "unityads-installinfo", "unityads-idfi", (String) null);
        this.f8199d = strA;
        return strA;
    }

    @Override // com.ironsource.B7
    public File l(Context context) {
        return context.getExternalCacheDir();
    }

    @Override // com.ironsource.B7
    public String m(Context context) {
        if (context == null) {
            return "";
        }
        int iN = N(context);
        if (iN == 0) {
            return C2300e4.h.C;
        }
        if (iN == 1) {
            return C2300e4.h.D;
        }
        if (iN == 11) {
            return C2300e4.h.C;
        }
        if (iN == 12) {
            return C2300e4.h.D;
        }
        switch (iN) {
            case 6:
            case 8:
                return C2300e4.h.C;
            case 7:
            case 9:
                return C2300e4.h.D;
            default:
                return "none";
        }
    }

    @Override // com.ironsource.B7
    public int o(Context context) {
        int iK = K(context);
        int iZ = z(context);
        return (((iK == 0 || iK == 2) && iZ == 2) || ((iK == 1 || iK == 3) && iZ == 1)) ? 2 : 1;
    }

    @Override // com.ironsource.B7
    public boolean p(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    @Override // com.ironsource.B7
    public int c() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    @Override // com.ironsource.B7
    public synchronized String d(Context context) {
        if (!TextUtils.isEmpty(this.f8198c)) {
            return this.f8198c;
        }
        if (context == null) {
            return "";
        }
        String strA = C2324fa.a(context, "supersonic_shared_preferen", "auid", "");
        this.f8198c = strA;
        if (TextUtils.isEmpty(strA)) {
            String string = UUID.randomUUID().toString();
            this.f8198c = string;
            C2324fa.b(context, "supersonic_shared_preferen", "auid", string);
        }
        return this.f8198c;
    }

    @Override // com.ironsource.B7
    public int k(Context context) {
        try {
            Intent intentRegisterReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra != -1 && intExtra2 != -1) {
                return (int) ((intExtra / intExtra2) * 100.0f);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return -1;
    }

    @Override // com.ironsource.B7
    public String r(Context context) {
        if (a(context)) {
            return "Tablet";
        }
        return "Phone";
    }

    @Override // com.ironsource.B7
    public int t(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    @Override // com.ironsource.B7
    public int e() {
        return Build.VERSION.SDK_INT;
    }

    @Override // com.ironsource.B7
    public boolean g(Context context) {
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (str.equalsIgnoreCase(k)) {
                    return true;
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
        }
        return false;
    }

    @Override // com.ironsource.B7
    public boolean a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            if (displayMetrics.widthPixels / displayMetrics.density >= 600.0f) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.B7
    public long h() {
        return a(Environment.getDataDirectory());
    }

    @Override // com.ironsource.B7
    public boolean n() {
        return this.f8200f;
    }

    @Override // com.ironsource.B7
    public String q() {
        return Build.MANUFACTURER;
    }

    @Override // com.ironsource.B7
    public File j(Context context) {
        return context.getFilesDir();
    }

    @Override // com.ironsource.B7
    public int s(Context context) {
        try {
            return C2324fa.a(context, "IABTCF_gdprApplies", -1);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return -1;
        }
    }

    @Override // com.ironsource.B7
    public int b() {
        return c();
    }

    @Override // com.ironsource.B7
    public String b(Context context) {
        try {
            if (C2229a5.f7951a.a()) {
                if (this.h == null) {
                    String strR = R(context);
                    if (TextUtils.isEmpty(strR)) {
                        return strR;
                    }
                    this.h = strR;
                    return strR;
                }
                return this.h;
            }
            return R(context);
        } catch (Exception e) {
            C2531r4.d().a(e);
            return null;
        }
    }

    private long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong()) / 1048576;
    }

    @Override // com.ironsource.B7
    public Long a(ActivityManager.MemoryInfo memoryInfo) {
        if (memoryInfo == null) {
            return null;
        }
        return Long.valueOf(memoryInfo.threshold);
    }

    @Override // com.ironsource.B7
    public long a(String str) {
        return a(new File(str));
    }

    @Override // com.ironsource.B7
    public boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    @Override // com.ironsource.B7.a
    public void a(Context context, long j3) {
        if (context != null) {
            if (!new C2383ig(new InterfaceC2565t4.a()).a(T(context), j3)) {
                this.e = S(context);
                this.f8200f = !r0.isEmpty();
            }
            if (this.e.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    this.e = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j3 > 0) {
                        b(context, System.currentTimeMillis());
                    }
                } catch (Exception e) {
                    C2531r4.d().a(e);
                    IronLog.INTERNAL.error(e.toString());
                }
            }
        }
    }

    private void b(Context context, long j3) {
        try {
            C2324fa.b(context, f8192u, B, String.valueOf(j3));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void a(Context context, String str) {
        try {
            C2324fa.b(context, f8192u, A, str);
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
