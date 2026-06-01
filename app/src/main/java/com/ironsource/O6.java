package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class O6 implements Runnable {
    public static final String M = "sdkVersion";
    public static final String N = "AdvIdOptOutReason";
    private static final int O = 15;
    private static final int P = 840;
    private static final int Q = -720;
    private Context K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7320a = getClass().getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7321b = "bundleId";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7322c = "advertisingId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7323d = C2300e4.i.M;
    private final String e = "appKey";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f7324f = C2253bb.f8071o;
    private final String g = "osVersion";
    private final String h = "connectionType";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f7325i = "rawConnectionType";
    private final String j = "language";
    private final String k = "deviceOEM";
    private final String l = "deviceModel";
    private final String m = C2300e4.i.f8417r;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String f7326n = C2253bb.f8073r;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f7327o = C2253bb.f8074s;
    private final String p = "battery";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final String f7328q = "gmtMinutesOffset";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final String f7329r = "appVersion";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final String f7330s = JsonStorageKeyNames.SESSION_ID_KEY;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f7331t = "pluginType";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final String f7332u = "pluginVersion";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final String f7333v = "plugin_fw_v";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final String f7334w = C2253bb.f8076u;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final String f7335x = C2253bb.f8075t;
    private final String y = Q6.Z0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final String f7336z = C2253bb.f8078w;
    private final String A = "mcc";
    private final String B = "mnc";
    private final String C = "icc";
    private final String D = "tz";
    private final String E = "auid";
    private final String F = "userLat";
    private final String G = "publisherAPI";
    private final String H = "missingDependencies";
    private final String I = "missingManifest";
    private final String J = Y1.f7807d;
    private final B7 L = Mb.U().i();

    private O6() {
    }

    private Map<String, Object> a() {
        boolean z2;
        String str;
        HashMap map = new HashMap();
        map.put(JsonStorageKeyNames.SESSION_ID_KEY, IronSourceUtils.d());
        String strE = e();
        if (!TextUtils.isEmpty(strE)) {
            map.put("bundleId", strE);
            String strB = C1.b(this.K, strE);
            if (!TextUtils.isEmpty(strB)) {
                map.put("appVersion", strB);
            }
        }
        map.put("appKey", c());
        String strI = this.L.I(this.K);
        String strB2 = this.L.b(this.K);
        boolean z7 = false;
        if (TextUtils.isEmpty(strI)) {
            strI = this.L.M(this.K);
            z2 = true;
            str = !TextUtils.isEmpty(strI) ? IronSourceConstants.TYPE_UUID : "";
        } else {
            str = IronSourceConstants.TYPE_GAID;
            z2 = false;
        }
        if (!TextUtils.isEmpty(strI)) {
            map.put("advertisingId", strI);
            map.put(C2253bb.f8075t, str);
        }
        if (!TextUtils.isEmpty(strB2)) {
            z7 = Boolean.parseBoolean(strB2);
            map.put(C2300e4.i.M, Boolean.valueOf(z7));
        }
        if (z2 || z7) {
            map.put(N, a(strB2));
        }
        map.put(C2253bb.f8071o, h());
        if (!TextUtils.isEmpty(b())) {
            map.put("osVersion", b());
        }
        String strA = IronSourceUtils.a(this.K);
        if (!TextUtils.isEmpty(strA)) {
            map.put("connectionType", strA);
        }
        String strD = C2246b4.d(this.K);
        if (!TextUtils.isEmpty(strD)) {
            map.put("rawConnectionType", strD);
        }
        map.put("sdkVersion", r());
        String strL = l();
        if (!TextUtils.isEmpty(strL)) {
            map.put("language", strL);
        }
        String strG = g();
        if (!TextUtils.isEmpty(strG)) {
            map.put("deviceOEM", strG);
        }
        String strF = f();
        if (!TextUtils.isEmpty(strF)) {
            map.put("deviceModel", strF);
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            map.put(C2300e4.i.f8417r, strN);
        }
        map.put(C2253bb.f8074s, Long.valueOf(k()));
        map.put(C2253bb.f8073r, Long.valueOf(i()));
        map.put("battery", Integer.valueOf(d()));
        int iJ = j();
        if (a(iJ)) {
            map.put("gmtMinutesOffset", Integer.valueOf(iJ));
        }
        String strP = p();
        if (!TextUtils.isEmpty(strP)) {
            map.put("pluginType", strP);
        }
        String strQ = q();
        if (!TextUtils.isEmpty(strQ)) {
            map.put("pluginVersion", strQ);
        }
        String strO = o();
        if (!TextUtils.isEmpty(strO)) {
            map.put("plugin_fw_v", strO);
        }
        String strValueOf = String.valueOf(this.L.p());
        if (!TextUtils.isEmpty(strValueOf)) {
            map.put(C2253bb.f8076u, strValueOf);
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            map.put(Q6.Z0, strM);
        }
        String strValueOf2 = String.valueOf(IronSourceUtils.c(this.K));
        if (!TextUtils.isEmpty(strValueOf2)) {
            map.put(C2253bb.f8078w, strValueOf2);
        }
        String strD2 = this.L.d(this.K);
        if (!TextUtils.isEmpty(strD2)) {
            map.put("auid", strD2);
        }
        map.put("mcc", Integer.valueOf(C2228a4.b(this.K)));
        map.put("mnc", Integer.valueOf(C2228a4.c(this.K)));
        String strG2 = this.L.G(this.K);
        if (!TextUtils.isEmpty(strG2)) {
            map.put("icc", strG2);
        }
        String strD3 = this.L.d();
        if (!TextUtils.isEmpty(strD3)) {
            map.put("tz", strD3);
        }
        IronLog.INTERNAL.verbose("collecting data for events: " + map);
        return map;
    }

    private String b() {
        try {
            String str = Build.VERSION.RELEASE;
            return "" + Build.VERSION.SDK_INT + "(" + str + ")";
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    private String c() {
        return com.ironsource.mediationsdk.r.m().n();
    }

    private int d() {
        try {
            Intent intentRegisterReceiver = this.K.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int intExtra = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1) : 0;
            int intExtra2 = intentRegisterReceiver != null ? intentRegisterReceiver.getIntExtra("scale", -1) : 0;
            if (intExtra != -1 && intExtra2 != -1) {
                return (int) ((intExtra / intExtra2) * 100.0f);
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, a1.a.r(new StringBuilder(), this.f7320a, ":getBatteryLevel()"), e);
        }
        return -1;
    }

    private String e() {
        try {
            return this.K.getPackageName();
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    private String h() {
        return C2300e4.f8279d;
    }

    private long i() {
        if (!s()) {
            return -1L;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round(((timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15) * 15;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, a1.a.r(new StringBuilder(), this.f7320a, ":getGmtMinutesOffset()"), e);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1048576;
        } catch (Exception e) {
            C2531r4.d().a(e);
            return -1L;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception e) {
            C2531r4.d().a(e);
            return "";
        }
    }

    private String m() {
        return com.ironsource.mediationsdk.r.m().p();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.K.getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!networkOperatorName.equals("")) {
                    return networkOperatorName;
                }
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, a1.a.r(new StringBuilder(), this.f7320a, ":getMobileCarrier()"), e);
        }
        return "";
    }

    private String o() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e);
            return "";
        }
    }

    private String p() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e);
            return "";
        }
    }

    private String q() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e);
            return "";
        }
    }

    private String r() {
        return LevelPlay.getSdkVersion();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            C2531r4.d().a(e);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            N6.a().a(a());
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "Thread name = ".concat(getClass().getSimpleName()), e);
        }
    }

    public O6(Context context) {
        this.K = context.getApplicationContext();
    }

    private boolean a(int i2) {
        return i2 <= P && i2 >= Q && i2 % 15 == 0;
    }

    private String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "missingDependencies";
        }
        if (!C2229a5.f7951a.b()) {
            return "publisherAPI";
        }
        if (this.L.g(this.K)) {
            return Boolean.parseBoolean(str) ? "userLat" : Y1.f7807d;
        }
        return "missingManifest";
    }
}
