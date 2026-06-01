package com.apm.insight;

import android.app.Application;
import android.content.Context;
import com.apm.insight.runtime.ConfigManager;
import com.apm.insight.runtime.g;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f4361a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Application f4362b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f4363c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4364d = "default";
    private static boolean e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static com.apm.insight.nativecrash.b f4365f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile ConcurrentHashMap<Integer, String> f4366i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static volatile String f4367n;
    private static ConfigManager g = new ConfigManager();
    private static a h = new a();
    private static g j = null;
    private static volatile String k = null;
    private static Object l = new Object();
    private static volatile int m = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f4368o = 0;
    private static boolean p = true;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static boolean f4369q = true;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static boolean f4370r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private static boolean f4371s = true;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private static boolean f4372t = true;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static boolean f4373u = true;

    public static com.apm.insight.nativecrash.b a() {
        if (f4365f == null) {
            f4365f = g.a(f4361a);
        }
        return f4365f;
    }

    public static a b() {
        return h;
    }

    public static g c() {
        if (j == null) {
            synchronized (e.class) {
                j = new g();
            }
        }
        return j;
    }

    public static void d(boolean z2) {
        f4371s = z2;
    }

    public static String e() {
        return f() + '_' + Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
    }

    public static String f() {
        if (k == null) {
            synchronized (l) {
                try {
                    if (k == null) {
                        k = Long.toHexString(new Random().nextLong()) + "U";
                    }
                } finally {
                }
            }
        }
        return k;
    }

    public static Context g() {
        return f4361a;
    }

    public static Application h() {
        return f4362b;
    }

    public static ConfigManager i() {
        return g;
    }

    public static long j() {
        return f4363c;
    }

    public static String k() {
        return f4364d;
    }

    public static void l() {
        f4368o = 1;
    }

    public static int m() {
        return f4368o;
    }

    public static boolean n() {
        return e;
    }

    public static void o() {
        e = true;
    }

    public static ConcurrentHashMap<Integer, String> p() {
        return f4366i;
    }

    public static int q() {
        return m;
    }

    public static String r() {
        return f4367n;
    }

    public static boolean s() {
        return p;
    }

    public static boolean t() {
        return f4369q;
    }

    public static boolean u() {
        return f4370r;
    }

    public static boolean v() {
        return f4371s;
    }

    public static boolean w() {
        return f4373u;
    }

    public static boolean x() {
        return f4372t;
    }

    public static void b(int i2, String str) {
        m = i2;
        f4367n = str;
    }

    public static boolean d() {
        if (!g.isDebugMode()) {
            return false;
        }
        Object obj = a().a().get("channel");
        return (obj == null ? "unknown" : String.valueOf(obj)).contains("local_test");
    }

    public static void e(boolean z2) {
        f4373u = z2;
    }

    public static void a(com.apm.insight.nativecrash.b bVar) {
        f4365f = bVar;
    }

    public static void b(boolean z2) {
        f4369q = z2;
    }

    public static void a(Application application) {
        if (application != null) {
            f4362b = application;
        }
    }

    public static void a(Application application, Context context) {
        if (f4362b == null) {
            f4363c = System.currentTimeMillis();
            f4361a = context;
            f4362b = application;
            k = Long.toHexString(new Random().nextLong()) + RequestConfiguration.MAX_AD_CONTENT_RATING_G;
        }
    }

    public static void c(boolean z2) {
        f4370r = z2;
    }

    public static void f(boolean z2) {
        f4372t = z2;
    }

    public static void a(Application application, Context context, ICommonParams iCommonParams) {
        a(application, context);
        f4365f = new com.apm.insight.nativecrash.b(f4361a, iCommonParams, a());
    }

    public static String a(long j3, CrashType crashType, boolean z2, boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append(j3);
        sb.append("_");
        sb.append(crashType.getName());
        sb.append('_');
        sb.append(f());
        sb.append('_');
        sb.append(z2 ? "oom_" : "normal_");
        sb.append(f4363c);
        sb.append('_');
        sb.append(z7 ? "ignore_" : "normal_");
        sb.append(Long.toHexString(new Random().nextLong()));
        sb.append(RequestConfiguration.MAX_AD_CONTENT_RATING_G);
        return sb.toString();
    }

    public static void a(String str) {
        f4364d = str;
    }

    public static void a(int i2, String str) {
        if (f4366i == null) {
            synchronized (e.class) {
                try {
                    if (f4366i == null) {
                        f4366i = new ConcurrentHashMap<>();
                    }
                } finally {
                }
            }
        }
        f4366i.put(Integer.valueOf(i2), str);
    }

    public static void a(boolean z2) {
        p = z2;
    }
}
