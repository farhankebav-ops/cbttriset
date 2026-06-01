package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f10756a = 504;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10757b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10758c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static boolean f10759d;
    private static long e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Context f10760f;

    public static void a(Context context, String str) {
        if (f10760f == null) {
            f10760f = context;
        }
        int i2 = f10756a;
        if (i2 == 102 || i2 == 202 || i2 == 200) {
            return;
        }
        e = System.currentTimeMillis();
        f10759d = false;
        f10757b = str;
        f10756a = 102;
        q0.b(new n0(context, 301, null));
    }

    public static void b() {
        Context context = f10760f;
        if (context != null) {
            q0.b(new n0(context, 301, null));
            f10756a = 102;
            com.pgl.ssdk.ces.b.h().a();
            z.a();
        }
    }

    public static synchronized String a() {
        try {
            if (TextUtils.isEmpty(f10758c)) {
                f10758c = (String) com.pgl.ssdk.ces.a.meta(303, f10760f, null);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10758c;
    }

    public static synchronized Object a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return com.pgl.ssdk.ces.a.meta(302, f10760f, bArr);
    }
}
