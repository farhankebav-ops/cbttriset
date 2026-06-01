package com.apm.insight.runtime;

import androidx.annotation.Nullable;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, d> f4624a = new HashMap<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f4625b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f4626c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4627d = false;
    private String e;

    private d(JSONObject jSONObject, String str) {
        this.e = str;
        a(jSONObject);
        f4624a.put(this.e, this);
        com.apm.insight.a.a((Object) "after update aid ".concat(String.valueOf(str)));
    }

    private void a(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        this.f4625b = jSONObject;
        if (jSONObject == null || (jSONObjectOptJSONObject = jSONObject.optJSONObject("error_module")) == null) {
            return;
        }
        this.f4627d = jSONObjectOptJSONObject.optInt("switcher") == 1 && jSONObjectOptJSONObject.optInt("err_sampling_rate") == 1;
    }

    @Nullable
    public static JSONObject b(String str) {
        d dVar = f4624a.get(str);
        if (dVar != null) {
            return dVar.f4625b;
        }
        return null;
    }

    public static d c(String str) {
        return f4624a.get(str);
    }

    public static long d(String str) {
        d dVar = f4624a.get(str);
        if (dVar == null) {
            return 3600000L;
        }
        try {
            return Long.decode(com.apm.insight.a.a(dVar.f4625b, "over_all", "get_settings_interval")).longValue() * 1000;
        } catch (Throwable unused) {
            return 3600000L;
        }
    }

    public static boolean e(String str) {
        JSONObject jSONObject;
        d dVar = f4624a.get(str);
        return (dVar == null || (jSONObject = dVar.f4625b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean f(String str) {
        JSONObject jSONObject;
        d dVar = f4624a.get(str);
        return (dVar == null || (jSONObject = dVar.f4625b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public static boolean g(String str) {
        JSONObject jSONObject;
        d dVar = f4624a.get(str);
        return (dVar == null || (jSONObject = dVar.f4625b) == null || 1 != com.apm.insight.a.a(jSONObject, 0, "crash_module", "switcher")) ? false : true;
    }

    public final boolean a() {
        if (this.f4625b == null) {
            return false;
        }
        return this.f4627d;
    }

    public static boolean a(String str) {
        return f4624a.get(str) != null;
    }

    public static void a(String str, JSONObject jSONObject) {
        d dVar = f4624a.get(str);
        if (dVar != null) {
            dVar.a(jSONObject);
        } else {
            new d(jSONObject, str);
        }
    }
}
