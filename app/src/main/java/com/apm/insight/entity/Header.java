package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.apm.insight.e;
import com.apm.insight.l.k;
import com.apm.insight.l.l;
import com.apm.insight.runtime.o;
import com.ironsource.C2300e4;
import com.ironsource.C2605va;
import com.ironsource.Q6;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class Header {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f4379a = {"version_code", "manifest_version_code", C2605va.f10440b, "update_version_code"};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f4380d = null;
    private static int e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f4381f = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f4382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f4383c = new JSONObject();

    public Header(Context context) {
        this.f4382b = context;
    }

    public static Header a(Context context) {
        Header header = new Header(context);
        JSONObject jSONObject = header.f4383c;
        try {
            jSONObject.put("sdk_version", 20079);
            jSONObject.put("sdk_version_name", "2007-20250613121539");
        } catch (Exception unused) {
        }
        return header;
    }

    @Keep
    public static void addOtherHeader(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (com.apm.insight.l.d.b()) {
                sb.append("MIUI-");
            } else if (com.apm.insight.l.d.c()) {
                sb.append("FLYME-");
            } else {
                String strA = com.apm.insight.l.d.a();
                if (com.apm.insight.l.d.a(strA)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strA)) {
                    sb.append(strA);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable unused) {
        }
        try {
            DisplayMetrics displayMetrics = e.g().getResources().getDisplayMetrics();
            int i2 = displayMetrics.densityDpi;
            String str = i2 != 120 ? i2 != 240 ? i2 != 320 ? "mdpi" : "xhdpi" : "hdpi" : "ldpi";
            jSONObject.put("density_dpi", i2);
            jSONObject.put("display_density", str);
            jSONObject.put("resolution", displayMetrics.heightPixels + "x" + displayMetrics.widthPixels);
        } catch (Exception unused2) {
        }
        try {
            String language = e.g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(Q6.F, C2300e4.f8279d);
            jSONObject.put("device_id", e.c().a());
            String strConcat = Build.VERSION.RELEASE;
            if (!strConcat.contains(".")) {
                strConcat = strConcat.concat(".0");
            }
            jSONObject.put("os_version", strConcat);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str2 = Build.MODEL;
            String str3 = Build.BRAND;
            if (str2 == null) {
                str2 = str3;
            } else if (str3 != null && !str2.contains(str3)) {
                str2 = str3 + ' ' + str2;
            }
            jSONObject.put("device_model", str2);
            jSONObject.put("device_brand", str3);
            jSONObject.put("device_manufacturer", Build.MANUFACTURER);
            jSONObject.put("cpu_abi", g());
            Context contextG = e.g();
            String packageName = contextG.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = contextG.getPackageManager().getPackageInfo(packageName, 0);
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                int i8 = applicationInfo.labelRes;
                if (i8 > 0) {
                    jSONObject.put("display_name", contextG.getString(i8));
                } else {
                    jSONObject.put("display_name", contextG.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d.a(jSONObject);
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", k.a(e.g()));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.g().getSystemService("phone");
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(Q6.P0, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e8) {
            e8.printStackTrace();
        }
    }

    public static Header b(Context context) {
        Header headerA = a(context);
        a(headerA);
        b(headerA);
        headerA.c();
        headerA.d();
        headerA.e();
        return headerA;
    }

    private static String g() {
        if (f4380d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = Build.SUPPORTED_ABIS;
                        if (i2 >= strArr.length) {
                            break;
                        }
                        sb.append(strArr[i2]);
                        if (i2 != strArr.length - 1) {
                            sb.append(", ");
                        }
                        i2++;
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    f4380d = "unknown";
                }
                f4380d = sb.toString();
            } catch (Exception e4) {
                com.apm.insight.a.b((Throwable) e4);
                f4380d = "unknown";
            }
        }
        return f4380d;
    }

    public final JSONObject c() {
        return a(e.a().a());
    }

    public final JSONObject d() {
        try {
            this.f4383c.put("device_id", e.c().a());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f4383c;
    }

    public final JSONObject e() {
        try {
            long jF = e.a().f();
            if (jF > 0) {
                this.f4383c.put("user_id", jF);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return this.f4383c;
    }

    public final JSONObject f() {
        return this.f4383c;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt("app_version") == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String strOptString = jSONObject.optString(C2605va.f10440b);
            if (TextUtils.isEmpty(strOptString)) {
                return true;
            }
            try {
                return Integer.parseInt(strOptString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static Header a(long j) {
        Header headerA;
        o oVarA = o.a();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject jSONObjectA = oVarA.a(j);
        if (jSONObjectA != null && jSONObjectA.length() != 0) {
            try {
                if (!jSONObjectA.has(C2605va.f10440b)) {
                    jSONObjectA.put(C2605va.f10440b, 4444);
                }
            } catch (Exception unused) {
            }
            headerA = new Header(e.g());
        } else {
            headerA = a(e.g());
            headerA.c();
            try {
                headerA.f4383c.put("errHeader", 1);
            } catch (Throwable unused2) {
            }
        }
        b(headerA);
        headerA.a(jSONObjectA);
        return headerA;
    }

    public static boolean b() {
        if (f4381f == -1) {
            f4381f = g().contains("86") ? 1 : 0;
        }
        return f4381f == 1;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static void b(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.f4383c);
    }

    public static boolean a() {
        if (e == -1) {
            e = g().contains("64") ? 1 : 0;
        }
        return e == 1;
    }

    public final JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.f4383c;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                this.f4383c.put(next, jSONObject.opt(next));
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
        return this.f4383c;
    }

    public final JSONObject a(@Nullable Map<String, Object> map) {
        try {
            if (map == null) {
                return this.f4383c;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (!this.f4383c.has(entry.getKey())) {
                    this.f4383c.put(entry.getKey(), entry.getValue());
                }
            }
            String[] strArr = f4379a;
            for (int i2 = 0; i2 < 4; i2++) {
                String str = strArr[i2];
                if (map.containsKey(str)) {
                    try {
                        this.f4383c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                    } catch (Throwable unused) {
                        this.f4383c.put(str, map.get(str));
                    }
                }
            }
            if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
                try {
                    this.f4383c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
                } catch (Throwable unused2) {
                }
            }
            if (map.containsKey("iid")) {
                this.f4383c.put("udid", map.get("iid"));
                this.f4383c.remove("iid");
            }
            if (map.containsKey("version_name")) {
                this.f4383c.put("app_version", map.get("version_name"));
                this.f4383c.remove("version_name");
            }
        } catch (Throwable unused3) {
        }
        return this.f4383c;
    }

    public static Header a(Header header) {
        addRuntimeHeader(header.f4383c);
        return header;
    }
}
