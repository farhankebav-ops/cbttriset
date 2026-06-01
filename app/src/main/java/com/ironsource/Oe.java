package com.ironsource;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.bumptech.glide.load.Key;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.mediation.LevelPlay;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class Oe {
    private static final String A = "mcc";
    private static final String B = "mnc";
    private static final String C = "icc";
    private static final String D = "mCar";
    private static final String E = "tz";
    private static final String F = "tzOff";
    private static final String G = "rvManual";
    private static final String H = "ts";
    private static final String I = "android";
    private static final String J = "impression";
    private static final String K = "placementId";
    private static final String L = "=";
    private static final String M = "&";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f7341a = "https://i-sdk.mediation.unity3d.com/sdk/v";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7342b = "?request=";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f7343c = "platform";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f7344d = "applicationKey";
    private static final String e = "applicationUserId";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f7345f = "sdkVersion";
    private static final String g = "pluginType";
    private static final String h = "pluginVersion";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f7346i = "plugin_fw_v";
    private static final String j = "advId";
    private static final String k = "auid";
    private static final String l = "isDemandOnly";
    private static final String m = "serr";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f7347n = "appVer";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f7348o = "osVer";
    private static final String p = "devModel";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f7349q = "devMake";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f7350r = "connType";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f7351s = "rawConnType";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f7352t = "mt";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f7353u = "fs";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f7354v = "coppa";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f7355w = "dff";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f7356x = "browserUserAgent";
    private static final String y = "deviceLang";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f7357z = "bundleId";

    public static String a(Context context, String str, String str2, String str3, String str4, boolean z2, List<Pair<String, String>> list, boolean z7) throws UnsupportedEncodingException {
        String str5;
        List<String> list2;
        B7 b7I = Mb.U().i();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("platform", "android"));
        arrayList.add(new Pair("applicationKey", str));
        if (!TextUtils.isEmpty(str2)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("applicationUserId", str2, arrayList);
        }
        arrayList.add(new Pair("sdkVersion", LevelPlay.getSdkVersion()));
        if (z2) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(G, "1", arrayList);
        }
        if (!IronSourceUtils.g()) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(m, "0", arrayList);
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            arrayList.add(new Pair(g, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            arrayList.add(new Pair(h, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            arrayList.add(new Pair(f7346i, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(j, str3, arrayList);
        }
        if (!TextUtils.isEmpty(str4)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("mt", str4, arrayList);
        }
        String strB = C1.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(strB)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(f7347n, strB, arrayList);
        }
        arrayList.add(new Pair(f7348o, Build.VERSION.SDK_INT + ""));
        com.ironsource.adqualitysdk.sdk.i.a0.n(f7349q, Build.MANUFACTURER, arrayList);
        arrayList.add(new Pair(p, Build.MODEL));
        arrayList.add(new Pair("fs", (IronSourceUtils.c(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = C2469na.b().c();
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.f9238b)) {
            arrayList.add(new Pair(f7354v, concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f9238b).get(0)));
        }
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.f9241f)) {
            String str6 = concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f9241f).get(0);
            if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.j)) {
                com.ironsource.adqualitysdk.sdk.i.a0.n("ts", "1", arrayList);
            }
        }
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.f9240d)) {
            String str7 = concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f9240d).get(0);
            if (!TextUtils.isEmpty(str7) && str7.equalsIgnoreCase(com.ironsource.mediationsdk.metadata.a.g)) {
                com.ironsource.adqualitysdk.sdk.i.a0.n(f7355w, "1", arrayList);
            }
        }
        if (concurrentHashMapC.containsKey(com.ironsource.mediationsdk.metadata.a.e) && (list2 = concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.e)) != null) {
            arrayList.add(new Pair(com.ironsource.mediationsdk.metadata.a.e, list2.get(0)));
        }
        String strA = IronSourceUtils.a(context);
        if (!TextUtils.isEmpty(strA)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(f7350r, strA, arrayList);
        }
        String strD = C2246b4.d(context);
        if (!TextUtils.isEmpty(strD)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(f7351s, strD, arrayList);
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        String strS = b7I.s();
        if (strS.length() != 0) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(f7356x, strS, arrayList);
        }
        try {
            str5 = b7I.c(context) + "-" + b7I.A(context);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            str5 = null;
        }
        if (str5 != null && str5.length() != 0) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(y, str5, arrayList);
        }
        arrayList.add(new Pair("bundleId", context.getPackageName()));
        arrayList.add(new Pair("mcc", "" + C2228a4.b(context)));
        arrayList.add(new Pair("mnc", "" + C2228a4.c(context)));
        String strG = b7I.G(context);
        if (!TextUtils.isEmpty(strG)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("icc", strG, arrayList);
        }
        String strU = b7I.u(context);
        if (!TextUtils.isEmpty(strU)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n(D, strU, arrayList);
        }
        String strD2 = b7I.d();
        if (!TextUtils.isEmpty(strD2)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("tz", strD2, arrayList);
        }
        arrayList.add(new Pair(F, "" + b7I.m()));
        String strD3 = b7I.d(context);
        if (!TextUtils.isEmpty(strD3)) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("auid", strD3, arrayList);
        }
        if (z7) {
            com.ironsource.adqualitysdk.sdk.i.a0.n("isDemandOnly", "1", arrayList);
        }
        com.ironsource.adqualitysdk.sdk.i.a0.n(Q6.i0, String.valueOf(C2385j0.a()), arrayList);
        return a1.a.r(new StringBuilder(), a(LevelPlay.getSdkVersion()), URLEncoder.encode(L9.e(C2499p5.b().c(), a(arrayList)), Key.STRING_CHARSET_NAME));
    }

    private static void b(String str) {
        f7341a = str;
    }

    public static String a(String str, boolean z2, int i2) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair("impression", Boolean.toString(z2)));
        arrayList.add(new Pair("placementId", Integer.toString(i2)));
        return a1.a.D(str, "&", a(arrayList));
    }

    private static String a(List<Pair<String, String>> list) throws UnsupportedEncodingException {
        String string = "";
        for (Pair<String, String> pair : list) {
            if (string.length() > 0) {
                string = string.concat("&");
            }
            StringBuilder sbR = androidx.camera.core.processing.util.a.r(string);
            sbR.append((String) pair.first);
            sbR.append("=");
            sbR.append(URLEncoder.encode((String) pair.second, Key.STRING_CHARSET_NAME));
            string = sbR.toString();
        }
        return string;
    }

    private static String a(String str) {
        return a1.a.s(new StringBuilder(), f7341a, str, f7342b);
    }
}
