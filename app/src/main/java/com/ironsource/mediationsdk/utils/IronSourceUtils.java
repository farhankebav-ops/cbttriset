package com.ironsource.mediationsdk.utils;

import a1.a;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.B1;
import com.ironsource.B7;
import com.ironsource.C2228a4;
import com.ironsource.C2235ab;
import com.ironsource.C2291dd;
import com.ironsource.C2394j9;
import com.ironsource.C2531r4;
import com.ironsource.Mb;
import com.ironsource.N6;
import com.ironsource.R9;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.logger.c;
import com.ironsource.mediationsdk.r;
import com.unity3d.mediation.LevelPlay;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class IronSourceUtils {
    private static int A = 1;
    private static AtomicBoolean B = new AtomicBoolean(false);
    private static String C = null;
    private static Boolean D = null;
    private static IronSourceUtils E = new IronSourceUtils();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9382a = "default_is_events_formatter_type";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9383b = "default_is_events_url";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9384c = "default_is_non_connectivity_events";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9385d = "default_is_opt_in_events";
    private static final String e = "default_is_opt_out_events";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9386f = "default_is_trigger_events";
    private static final String g = "default_rv_events_formatter_type";
    private static final String h = "default_rv_events_url";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f9387i = "default_rv_non_connectivity_events";
    private static final String j = "default_rv_opt_in_events";
    private static final String k = "default_rv_opt_out_events";
    private static final String l = "default_rv_trigger_events";
    private static final String m = "default_pxl_events_url";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f9388n = "default_pxl_trigger_events";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final String f9389o = "default_app_opt_in_events";
    private static final String p = "default_app_opt_out_events";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final String f9390q = "default_app_events_url";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static final String f9391r = "default_app_trigger_events";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static final String f9392s = "default_app_events_formatter_type";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static final String f9393t = "default_app_non_connectivity_events";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static final String f9394u = "general_properties";

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static final String f9395v = "last_response";

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private static final String f9396w = "firstSessionTimestamp";

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final String f9397x = "providerPriority";
    private static final String y = "9.0.0";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final String f9398z = "Mediation_Shared_Preferences";

    public static String a(long j3, String str) {
        return h(j3 + r.m().n() + str);
    }

    public static IronSourceUtils b() {
        return E;
    }

    private static String c(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? f9382a : (IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) || IronSourceConstants.PIXEL_EVENT_TYPE.equals(str)) ? g : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? f9392s : "";
    }

    private static String d(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? f9384c : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? f9387i : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? f9393t : "";
    }

    private static String e(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? f9385d : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? j : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? f9389o : "";
    }

    private static String f(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? e : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? k : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? p : "";
    }

    public static boolean g() {
        return A == 1;
    }

    private static Map<LevelPlay.AdFormat, Map<String, JSONObject>> getAdUnitIds() {
        HashMap map = new HashMap();
        try {
            C2235ab c2235abA = Mb.U().e().a();
            if (c2235abA != null) {
                for (LevelPlay.AdFormat adFormat : LevelPlay.AdFormat.values()) {
                    HashMap map2 = new HashMap();
                    map.put(adFormat, map2);
                    for (String str : c2235abA.a(adFormat)) {
                        if (!str.equals(B1.e)) {
                            map2.put(str, new JSONObject());
                        }
                    }
                }
            }
            return map;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error("failed to get ad unit ids - exception = " + e4);
            return map;
        }
    }

    @Deprecated
    public static String getSDKVersion() {
        return "9.0.0";
    }

    public static String h(String str) {
        try {
            return String.format("%064x", new BigInteger(1, MessageDigest.getInstance("SHA-256").digest(str.getBytes())));
        } catch (NoSuchAlgorithmException e4) {
            C2531r4.d().a(e4);
            if (str == null) {
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getSHA256(input:null)", e4);
                return "";
            }
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, a.m("getSHA256(input:", str, ")"), e4);
            return "";
        }
    }

    public static synchronized void i(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "automation_log:" + Long.toString(System.currentTimeMillis()) + " text: " + str, 0);
    }

    private static void setSerr(int i2) {
        A = i2;
    }

    private static String b(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? f9383b : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? h : IronSourceConstants.PIXEL_EVENT_TYPE.equals(str) ? m : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? f9390q : "";
    }

    private static String g(String str) {
        return IronSourceConstants.INTERSTITIAL_EVENT_TYPE.equals(str) ? f9386f : IronSourceConstants.REWARDED_VIDEO_EVENT_TYPE.equals(str) ? l : IronSourceConstants.PIXEL_EVENT_TYPE.equals(str) ? f9388n : IronSourceConstants.APP_EVENT_TYPE.equals(str) ? f9391r : "";
    }

    public static String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities == null) {
                return "none";
            }
            if (networkCapabilities.hasTransport(1)) {
                return C2228a4.f7946b;
            }
            return networkCapabilities.hasTransport(0) ? C2228a4.g : "none";
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.NATIVE.error("failed to connection type - exception = " + e4);
            return "none";
        }
    }

    public static synchronized void c(Context context, String str, int[] iArr) {
        String string;
        try {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    string = sb.toString();
                } else {
                    string = null;
                }
                editorEdit.putString(f(str), string);
                editorEdit.apply();
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptOutEvents(eventType: " + str + ", optOutEvents:" + iArr + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void d(Context context, String str, int[] iArr) {
        String string;
        try {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    string = sb.toString();
                } else {
                    string = null;
                }
                editorEdit.putString(g(str), string);
                editorEdit.apply();
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultTriggerEvents(eventType: " + str + ", triggerEvents:" + iArr + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void e(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
            editorEdit.putString(b(str), str2);
            editorEdit.apply();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsURL(eventType: " + str + ", eventsUrl:" + str2 + ")", e4);
        }
    }

    public static void f(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public static synchronized void b(Context context, String str, int[] iArr) {
        String string;
        try {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    string = sb.toString();
                } else {
                    string = null;
                }
                editorEdit.putString(e(str), string);
                editorEdit.apply();
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultOptInEvents(eventType: " + str + ", optInEvents:" + iArr + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static boolean g(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            return activeNetworkInfo.isConnected();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.NATIVE.error("failed to check if network is connected - exception = " + e4);
            return false;
        }
    }

    public static String f() {
        String strA = N6.a().a("userId");
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return strA;
    }

    public static void a(Runnable runnable, String str) {
        Thread thread = new Thread(runnable, str);
        thread.setUncaughtExceptionHandler(new c());
        thread.start();
    }

    public static boolean f(Context context) {
        return C2291dd.d(context);
    }

    public static synchronized void a(Context context, String str, int[] iArr) {
        String string;
        try {
            try {
                SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
                if (iArr != null) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 : iArr) {
                        sb.append(i2);
                        sb.append(",");
                    }
                    string = sb.toString();
                } else {
                    string = null;
                }
                editorEdit.putString(d(str), string);
                editorEdit.apply();
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultNonConnectivityEvents(eventType: " + str + ", nonConnectivityEvents:" + iArr + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public static synchronized void e(Context context, String str) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
        editorEdit.putString(f9395v, str);
        editorEdit.apply();
    }

    public static String e(Context context) {
        return context.getSharedPreferences(f9398z, 0).getString(f9395v, "");
    }

    public static synchronized int[] c(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            try {
                String string = context.getSharedPreferences(f9398z, 0).getString(f(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptOutEvents(eventType: " + str + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iArr;
    }

    public static synchronized void d(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
            editorEdit.putString(c(str), str2);
            editorEdit.apply();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:saveDefaultEventsFormatterType(eventType: " + str + ", formatterType:" + str2 + ")", e4);
        }
    }

    public static long e() {
        return System.currentTimeMillis();
    }

    public static synchronized String b(Context context, String str, String str2) {
        try {
            str2 = context.getSharedPreferences(f9398z, 0).getString(b(str), str2);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsURL(eventType: " + str + ", defaultEventsURL:" + str2 + ")", e4);
        }
        return str2;
    }

    public static synchronized String a(Context context, String str, String str2) {
        try {
            str2 = context.getSharedPreferences(f9398z, 0).getString(c(str), str2);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultEventsFormatterType(eventType: " + str + ", defaultFormatterType:" + str2 + ")", e4);
        }
        return str2;
    }

    public static synchronized int[] d(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            try {
                String string = context.getSharedPreferences(f9398z, 0).getString(g(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultTriggerEvents(eventType: " + str + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iArr;
    }

    public static synchronized int[] b(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            try {
                String string = context.getSharedPreferences(f9398z, 0).getString(e(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultOptInEvents(eventType: " + str + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iArr;
    }

    public static String c(Context context, String str, String str2) {
        return context.getSharedPreferences(f9398z, 0).getString(str, str2);
    }

    public static synchronized int[] a(Context context, String str) {
        int[] iArr;
        iArr = null;
        try {
            try {
                String string = context.getSharedPreferences(f9398z, 0).getString(d(str), null);
                if (!TextUtils.isEmpty(string)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ",");
                    ArrayList arrayList = new ArrayList();
                    while (stringTokenizer.hasMoreTokens()) {
                        arrayList.add(Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    int size = arrayList.size();
                    iArr = new int[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                    }
                }
            } catch (Exception e4) {
                C2531r4.d().a(e4);
                IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "IronSourceUtils:getDefaultNonConnectivityEvents(eventType: " + str + ")", e4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return iArr;
    }

    public static boolean c(Context context) {
        if (D == null) {
            D = Boolean.valueOf(!C2394j9.a(context));
        }
        return D.booleanValue();
    }

    public static String c() {
        return N6.a().a("userId");
    }

    public static JSONObject b(boolean z2) {
        return a(z2, false, 1);
    }

    public static synchronized String d() {
        try {
            if (B.compareAndSet(false, true)) {
                C = UUID.randomUUID().toString();
            }
        } catch (Throwable th) {
            throw th;
        }
        return C;
    }

    public static void b(Context context, String str, boolean z2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
        editorEdit.putBoolean(str, z2);
        editorEdit.apply();
    }

    public static R9 d(Context context) {
        String str;
        B7 b7I = Mb.U().i();
        if (context == null) {
            return null;
        }
        String strB = r.m().b(context);
        if (TextUtils.isEmpty(strB)) {
            strB = b7I.M(context);
            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, "using custom identifier", 0);
            str = IronSourceConstants.TYPE_UUID;
        } else {
            str = IronSourceConstants.TYPE_GAID;
        }
        return new R9(strB, str);
    }

    public static void b(Context context, String str, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
        editorEdit.putInt(str, i2);
        editorEdit.apply();
    }

    public static JSONObject a(boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (!z2) {
                return jSONObject;
            }
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, "dynamic");
            return jSONObject;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            return jSONObject;
        }
    }

    public static void b(Context context, String str, long j3) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f9398z, 0).edit();
        editorEdit.putLong(str, j3);
        editorEdit.apply();
    }

    public static JSONObject a(String str, List<String> list, List<String> list2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            ArrayList arrayList = new ArrayList();
            int i2 = 0;
            for (int i8 = 0; i2 < list.size() && i8 < list2.size(); i8++) {
                String str2 = list.get(i2);
                String str3 = list2.get(i8);
                if (!TextUtils.isEmpty(str3) && !str2.equals(str3)) {
                    str2 = str2 + ";" + str3;
                }
                arrayList.add(str2);
                i2++;
            }
            jSONObject.put(IronSourceConstants.EVENTS_EXT1, str + ";" + TextUtils.join(",", arrayList));
            return jSONObject;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            return jSONObject;
        }
    }

    public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            if (jSONObject == null && jSONObject2 == null) {
                return new JSONObject();
            }
            if (jSONObject == null) {
                return jSONObject2;
            }
            if (jSONObject2 == null) {
                return jSONObject;
            }
            Iterator<String> itKeys = jSONObject2.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!jSONObject.has(next)) {
                    jSONObject.put(next, jSONObject2.get(next));
                }
            }
            return jSONObject;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return jSONObject;
        }
    }

    public static Map<String, String> b(JSONObject jSONObject) {
        HashMap map = new HashMap();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        map.put(next, jSONObject.get(next).toString());
                    }
                }
            }
            return map;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return map;
        }
    }

    public static JSONObject a(boolean z2, boolean z7, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
            if (z2) {
                jSONObject.put(IronSourceConstants.EVENTS_DEMAND_ONLY, 1);
            }
            if (z7 && i2 != -1) {
                jSONObject.put(IronSourceConstants.EVENTS_PROGRAMMATIC, i2);
            }
            return jSONObject;
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            return jSONObject;
        }
    }

    public static boolean a(Context context, String str, boolean z2) {
        return context.getSharedPreferences(f9398z, 0).getBoolean(str, z2);
    }

    public static int a(Context context, String str, int i2) {
        return context.getSharedPreferences(f9398z, 0).getInt(str, i2);
    }

    public static String b(Context context) {
        if (Mb.U().i().a(context)) {
            return "Tablet";
        }
        return "Phone";
    }

    public static long a(Context context, String str, long j3) {
        return context.getSharedPreferences(f9398z, 0).getLong(str, j3);
    }

    public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject(jSONObject.toString());
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object obj = jSONObject2.get(next);
            if ((obj instanceof JSONObject) && jSONObject3.optJSONObject(next) != null) {
                jSONObject3.put(next, a(jSONObject3.getJSONObject(next), (JSONObject) obj));
            } else {
                jSONObject3.put(next, obj);
            }
        }
        return jSONObject3;
    }

    public static List<Pair<String, String>> a(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            if (jSONObject != JSONObject.NULL) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (!jSONObject.get(next).toString().isEmpty()) {
                        arrayList.add(new Pair(next, jSONObject.get(next).toString()));
                    }
                }
            }
            return arrayList;
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            return arrayList;
        }
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a() {
        try {
            return new Throwable().getStackTrace()[1].getMethodName();
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            return "";
        }
    }
}
