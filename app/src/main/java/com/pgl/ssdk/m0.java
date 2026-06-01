package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10791a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10792b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10793c = "api16-access-ttp.tiktokpangle.us";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f10794d = {"api16-access-ttp.tiktokpangle.us", "api16-access-ttp-b.tiktokpangle.us", "api16-access-ttp.tiktokpangle-b.us", "api16-access-ttp-b.tiktokpangle-b.us"};
    private static int e = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f10795f = "";

    public static String a() {
        return f10791a == 1 ? "VA" : "SG";
    }

    public static String b() {
        return f10795f;
    }

    public static void a(int i2) {
        f10791a = i2;
    }

    public static void b(String str) {
        f10795f = str;
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f10792b = str;
    }

    public static void b(Context context) {
        if (TextUtils.isEmpty(f10792b)) {
            t0.a("updateIndex");
            int i2 = e;
            if (i2 < Integer.MAX_VALUE) {
                int i8 = i2 + 1;
                e = i8;
                w0.b(context, "domain_index", i8);
                return;
            }
            e = 0;
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(f10792b)) {
            return f10792b;
        }
        try {
            if (e == Integer.MIN_VALUE) {
                e = w0.a(context, "domain_index", 0);
            }
            String[] strArr = f10794d;
            return strArr[e % strArr.length];
        } catch (Throwable unused) {
            return f10793c;
        }
    }
}
