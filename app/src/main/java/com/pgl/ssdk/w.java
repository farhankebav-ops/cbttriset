package com.pgl.ssdk;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.ironsource.Y1;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f10823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long[][] f10824b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static String f10825c;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(w.f10825c)) {
                String unused = w.f10825c = w.d();
                w0.b(z.b(), "romtype", w.f10825c);
            }
        }
    }

    public static JSONArray[] c(Context context) {
        if (f10824b == null) {
            f10824b = (long[][]) com.pgl.ssdk.ces.a.meta(157, context, null);
        }
        long[][] jArr = f10824b;
        if (jArr == null || jArr.length != 2) {
            f10824b = null;
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        long[][] jArr2 = f10824b;
        long[] jArr3 = jArr2[0];
        long[] jArr4 = jArr2[1];
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < jArr3.length; i2++) {
            try {
                jSONArray.put(i2, jCurrentTimeMillis - jArr3[i2]);
                jSONArray2.put(i2, jCurrentTimeMillis - jArr4[i2]);
            } catch (JSONException unused) {
            }
        }
        return new JSONArray[]{jSONArray, jSONArray2};
    }

    public static boolean d(Context context) {
        Object objMeta = com.pgl.ssdk.ces.a.meta(ModuleDescriptor.MODULE_VERSION, context, null);
        if (objMeta instanceof Boolean) {
            return ((Boolean) objMeta).booleanValue();
        }
        return false;
    }

    public static int e() {
        return ((Integer) com.pgl.ssdk.ces.a.meta(162, null, null)).intValue();
    }

    public static boolean b(Context context) {
        Object objMeta = com.pgl.ssdk.ces.a.meta(156, context, null);
        if (objMeta instanceof Boolean) {
            return ((Boolean) objMeta).booleanValue();
        }
        return false;
    }

    public static String a(Context context) {
        String str = f10823a;
        if (str != null) {
            return str;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            f10823a = Settings.Global.getString(context.getContentResolver(), "boot_count");
        } else {
            f10823a = "lowapi";
        }
        return f10823a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d() {
        return (b("com.samsung.android.knox.SemPersonaManager") || b("com.samsung.android.knoxguard.KnoxGuardManager")) ? "samsung" : (b("androidhnext.Manifest") || b("androidhnext.R")) ? "honor" : (b("androidhwext.Manifest") || b("androidhwext.R")) ? "huawei" : (b("oppo.Manifest") || b("oppo.R") || b("oplus.Manifest") || b("oplus.R") || b("com.oneplus.Manifest") || b("com.oneplus.R")) ? "oppo" : (b("vivo.Manifest") || b("vivo.R")) ? "vivo" : (b("miui.Manifest") || b("miui.R") || b("miui.os.Build")) ? "xiaomi" : (b("lineageos.platform.Manifest") || b("lineageos.platform.R")) ? "lineage" : c("/system/framework/com.motorola.motosignature.jar") ? "moto" : (c("/system/framework/transsion-framework.jar") || c("/system/framework/transsion-services.jar")) ? "transsion" : Y1.f7807d;
    }

    private static boolean b(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        if (!TextUtils.isEmpty(f10825c)) {
            return f10825c;
        }
        String strA = w0.a(z.b(), "romtype", (String) null);
        f10825c = strA;
        if (!TextUtils.isEmpty(strA)) {
            return f10825c;
        }
        q0.b(new a());
        return "";
    }
}
