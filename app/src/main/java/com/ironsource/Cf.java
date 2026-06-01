package com.ironsource;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public final class Cf {
    public final void a(Context context, String appKey, JSONObject initResponse, String sdkVersion, String testSuiteControllerUrl, Boolean bool, boolean z2) {
        kotlin.jvm.internal.k.e(context, "context");
        kotlin.jvm.internal.k.e(appKey, "appKey");
        kotlin.jvm.internal.k.e(initResponse, "initResponse");
        kotlin.jvm.internal.k.e(sdkVersion, "sdkVersion");
        kotlin.jvm.internal.k.e(testSuiteControllerUrl, "testSuiteControllerUrl");
        Kf kf = Kf.f7064a;
        a(context, a(appKey, sdkVersion, kf.c(context), kf.a(context), kf.b(context), bool, initResponse, z2, kf.b(), kf.c(), a()));
        Intent intent = new Intent(context, (Class<?>) TestSuiteActivity.class);
        intent.setFlags(805306368);
        intent.putExtra("controllerUrl", testSuiteControllerUrl);
        context.startActivity(intent);
    }

    public final String b(Context context) {
        kotlin.jvm.internal.k.e(context, "context");
        return a(context).getString("dataString", "");
    }

    private final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : Kf.f7064a.d().entrySet()) {
            jSONObject.putOpt(entry.getKey(), new JSONArray((Collection) entry.getValue()));
        }
        return jSONObject;
    }

    private final String a(String str, String str2, String str3, String str4, String str5, Boolean bool, JSONObject jSONObject, boolean z2, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        String string = new JSONObject(r5.x.f0(new q5.i(C2253bb.f8071o, C2300e4.f8279d), new q5.i("appKey", str), new q5.i("sdkVersion", str2), new q5.i("bundleId", str3), new q5.i("appName", str4), new q5.i("appVersion", str5), new q5.i("initResponse", jSONObject), new q5.i("isRvManual", Boolean.valueOf(z2)), new q5.i("generalProperties", jSONObject2), new q5.i("adaptersVersion", jSONObject3), new q5.i("metaData", jSONObject4), new q5.i("gdprConsent", bool))).toString();
        kotlin.jvm.internal.k.d(string, "JSONObject(\n            …ent))\n        .toString()");
        return string;
    }

    private final SharedPreferences a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.unity3d.ad-mediation.testSuite", 0);
        kotlin.jvm.internal.k.d(sharedPreferences, "context.getSharedPrefere…EY, Context.MODE_PRIVATE)");
        return sharedPreferences;
    }

    private final void a(Context context, String str) {
        SharedPreferences.Editor editorEdit = a(context).edit();
        kotlin.jvm.internal.k.d(editorEdit, "getTestSuitePrefs(context).edit()");
        editorEdit.putString("dataString", str);
        editorEdit.apply();
    }
}
