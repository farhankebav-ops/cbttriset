package com.iab.omid.library.bigosg.d;

import android.os.Build;
import com.ironsource.C2300e4;
import com.ironsource.Q6;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static String a() {
        return Build.MANUFACTURER + "; " + Build.MODEL;
    }

    public static String b() {
        return Integer.toString(Build.VERSION.SDK_INT);
    }

    public static String c() {
        return C2300e4.f8279d;
    }

    public static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        b.a(jSONObject, "deviceType", a());
        b.a(jSONObject, "osVersion", b());
        b.a(jSONObject, Q6.F, c());
        return jSONObject;
    }
}
