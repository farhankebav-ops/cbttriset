package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Locale;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.ironsource.b5, reason: case insensitive filesystem */
/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class C2247b5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f8055a = "b5";

    public static JSONObject a(Context context) {
        SDKUtils.loadGoogleAdvertiserInfo(context);
        String advertiserId = SDKUtils.getAdvertiserId();
        String limitAdTracking = SDKUtils.getLimitAdTracking();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(f8055a, "add AID");
                jSONObject.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
            }
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(f8055a, "add LAT");
                jSONObject.put(C2300e4.i.M, Boolean.parseBoolean(limitAdTracking));
            }
            return jSONObject;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        d(context, jSONObject);
        c(jSONObject);
        b(context, jSONObject);
        g(context, jSONObject);
        e(context, jSONObject);
        b(jSONObject);
        f(context, jSONObject);
        c(context, jSONObject);
        a(context, jSONObject);
        h(context, jSONObject);
        return jSONObject;
    }

    private static void c(JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.y), SDKUtils.encodeString(String.valueOf(Mb.U().i().h())));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            String strB = C2246b4.b(context);
            String strD = C2246b4.d(context);
            if (!TextUtils.isEmpty(strD)) {
                jSONObject.put(SDKUtils.encodeString("rawConnectionType"), SDKUtils.encodeString(strD));
            }
            if (!TextUtils.isEmpty(strB) && !strB.equals("none")) {
                jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(strB));
            }
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8422v), C2246b4.e(context));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.P), C2265c5.b(context).a(context));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            if (a(C2300e4.i.k0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.k0), b7I.C(context));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(Q6.Y0), Mb.U().i().J(context));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            if (a(C2300e4.i.f8411n0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8411n0), b7I.h(context));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void c(Context context, JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            if (a(C2300e4.i.f8408l0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8408l0), b7I.D(context));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.Y), Mb.U().i().k(context));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, SDKUtils.encodeString(str2));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public static JSONObject c(Context context) {
        B7 b7I = Mb.U().i();
        C2265c5 c2265c5B = C2265c5.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String strD = c2265c5B.d();
            if (strD != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(strD));
            }
            String strC = c2265c5B.c();
            if (strC != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(strC));
            }
            String strE = c2265c5B.e();
            if (strE != null) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.m), SDKUtils.encodeString(strE));
            }
            String strF = c2265c5B.f();
            if (strF != null) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8410n), strF.replaceAll("[^0-9/.]", ""));
            }
            String strF2 = c2265c5B.f();
            if (strF2 != null) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8412o), SDKUtils.encodeString(strF2));
            }
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.p), String.valueOf(c2265c5B.a()));
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8415q), SDKUtils.encodeString(SDKUtils.getSDKVersion()));
            if (c2265c5B.b() != null && c2265c5B.b().length() > 0) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8417r), SDKUtils.encodeString(c2265c5B.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8424x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
            }
            if (a(C2300e4.i.f8407j0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8407j0), SDKUtils.encodeString(String.valueOf(b7I.q(context))));
            }
            String strG = C1.g(context);
            if (!TextUtils.isEmpty(strG)) {
                jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(strG));
            }
            String strValueOf = String.valueOf(b7I.r());
            if (!TextUtils.isEmpty(strValueOf)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.K), SDKUtils.encodeString(strValueOf));
            }
            String strValueOf2 = String.valueOf(b7I.p());
            if (!TextUtils.isEmpty(strValueOf2)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.O), SDKUtils.encodeString(strValueOf2));
            }
            jSONObject.put(SDKUtils.encodeString("gpi"), C2291dd.d(context));
            jSONObject.put("mcc", C2228a4.b(context));
            jSONObject.put("mnc", C2228a4.c(context));
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.S), C2228a4.f(context));
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.R), SDKUtils.encodeString(C2228a4.g(context)));
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.V), C1.f(context));
            jSONObject.put(SDKUtils.encodeString(C2300e4.i.X), C1.d(context));
            jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(C1.b(context)));
            jSONObject.put(SDKUtils.encodeString("stid"), C2291dd.c(context));
            String strE2 = C1.e(context);
            if (!TextUtils.isEmpty(strE2)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8402c0), SDKUtils.encodeString(strE2));
            }
            jSONObject.put(C2300e4.i.d0, SDKUtils.encodeString(String.valueOf(b7I.a())));
            jSONObject.put(C2300e4.i.f8404e0, SDKUtils.encodeString(String.valueOf(b7I.m())));
            String strG2 = b7I.G(context);
            if (!TextUtils.isEmpty(strG2)) {
                jSONObject.put("icc", strG2);
            }
            String strD2 = b7I.d();
            if (!TextUtils.isEmpty(strD2)) {
                jSONObject.put("tz", SDKUtils.encodeString(strD2));
            }
            jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
            return jSONObject;
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }

    private static boolean a(String str) {
        return SDKUtils.getControllerConfigAsJSONObject().optBoolean(str);
    }

    private static void a(JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            a(jSONObject, C2300e4.i.H, String.valueOf(b7I.k()));
            a(jSONObject, C2300e4.i.I, String.valueOf(b7I.c()));
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void b(JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            if (a(C2300e4.i.i0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.i0), b7I.j());
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        B7 b7I = Mb.U().i();
        try {
            if (a(C2300e4.i.f8409m0)) {
                jSONObject.put(SDKUtils.encodeString(C2300e4.i.f8409m0), b7I.e(context));
            }
        } catch (Exception e) {
            C2531r4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
