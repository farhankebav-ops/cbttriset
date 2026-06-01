package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.C2531r4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
final class g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9973c = "com.ironsource.sdk.controller.g";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9974d = "functionName";
    private static final String e = "params";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9975f = "hash";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f9976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final s f9977b;

    public g(b bVar, s sVar) {
        this.f9976a = bVar;
        this.f9977b = sVar;
    }

    private void a(Exception exc) {
        if (!(exc instanceof NoSuchMethodException)) {
            a(exc.getLocalizedMessage());
            return;
        }
        IronLog.INTERNAL.error(exc.toString());
        Logger.i(f9973c, "messageHandler failed with exception " + exc.getMessage());
    }

    private void b(String str, String str2, String str3) {
        this.f9976a.a(a(str, str2, str3));
    }

    @JavascriptInterface
    public void messageHandler(String str, String str2, String str3) {
        try {
            Logger.i(f9973c, "messageHandler(" + str + " " + str3 + ")");
            if (this.f9977b.a(str, str2, str3)) {
                a(str, str2);
            } else {
                b(str, str2, str3);
            }
        } catch (Exception e4) {
            a(e4);
        }
    }

    private void a(String str, String str2) throws Exception {
        this.f9976a.a(str, str2);
    }

    private void a(String str) {
        this.f9976a.b(str);
    }

    private String a(String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("functionName", SDKUtils.encodeString(str));
            jSONObject.put("params", SDKUtils.encodeString(str2));
            jSONObject.put(f9975f, SDKUtils.encodeString(str3));
        } catch (JSONException e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
        }
        return jSONObject.toString();
    }
}
