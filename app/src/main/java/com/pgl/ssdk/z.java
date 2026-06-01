package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.bumptech.glide.load.Key;
import com.pgl.ssdk.ces.out.DungeonFlag;
import com.vungle.ads.internal.protos.Sdk;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Context f10836a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            a0.c(z.b());
            com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.PRIVACY_ICON_FALLBACK_ERROR_VALUE, z.b(), null);
        }
    }

    @DungeonFlag
    private static String a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", 3);
            jSONObject.put("exception", th.toString());
            jSONObject.put("stacktrace", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes(Key.STRING_CHARSET_NAME), 0);
        } catch (Throwable unused) {
            return "eyJzdGF0dXMiOjN9";
        }
    }

    public static Context b() {
        return f10836a;
    }

    public static void c(Context context) {
        f10836a = context;
    }

    @DungeonFlag
    public static String b(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", 0);
            jSONObject.put("envcode", ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue());
            jSONObject.put("bootcount", w.a(context));
            jSONObject.put("usb_debug", w.d(context));
            JSONArray[] jSONArrayArrC = w.c(context);
            if (jSONArrayArrC != null) {
                jSONObject.put("sdata", jSONArrayArrC[0]);
                jSONObject.put("sdmta", jSONArrayArrC[1]);
                jSONObject.put("curtime", System.currentTimeMillis() / 1000);
            }
            jSONObject.put("camera_count", x.a());
            jSONObject.put("sim", x.c(context));
            jSONObject.put("virtual_display", a0.b(context));
            jSONObject.put("acbs", u.b(context));
            jSONObject.put("bl_unlock", w.b(context));
            y.a(jSONObject);
            String strE = v.e();
            jSONObject.put("romtype", w.c());
            jSONObject.put("root", w.e());
            if (!TextUtils.isEmpty(strE)) {
                jSONObject.put("sign", strE);
            }
            return (String) com.pgl.ssdk.ces.a.meta(227, context, jSONObject.toString());
        } catch (Throwable th) {
            return a(th);
        }
    }

    public static String c() {
        String strB = b(b());
        a();
        return strB;
    }

    public static long a(Context context) {
        try {
            return ((Long) com.pgl.ssdk.ces.a.meta(154, context, null)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    @DungeonFlag
    public static void a() {
        q0.b(new a());
    }
}
