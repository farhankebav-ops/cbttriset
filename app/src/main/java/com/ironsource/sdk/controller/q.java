package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.C1;
import com.ironsource.C2346ge;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f10055b = "q";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10056c = "getPermissions";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10057d = "isPermissionGranted";
    private static final String e = "permissions";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10058f = "permission";
    private static final String g = "status";
    private static final String h = "functionName";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10059i = "functionParams";
    private static final String j = "success";
    private static final String k = "fail";
    private static final String l = "unhandledPermission";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f10060a;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10061a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f10062b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f10063c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f10064d;

        public /* synthetic */ a(int i2) {
            this();
        }

        private a() {
        }
    }

    public q(Context context) {
        this.f10060a = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a(0);
        aVar.f10061a = jSONObject.optString("functionName");
        aVar.f10062b = jSONObject.optJSONObject("functionParams");
        aVar.f10063c = jSONObject.optString("success");
        aVar.f10064d = jSONObject.optString("fail");
        return aVar;
    }

    public void b(JSONObject jSONObject, a aVar, InterfaceC2487oa interfaceC2487oa) {
        C2346ge c2346ge = new C2346ge();
        try {
            String string = jSONObject.getString(f10058f);
            c2346ge.b(f10058f, string);
            if (C1.d(this.f10060a, string)) {
                c2346ge.b("status", String.valueOf(C1.c(this.f10060a, string)));
                interfaceC2487oa.a(true, aVar.f10063c, c2346ge);
            } else {
                c2346ge.b("status", l);
                interfaceC2487oa.a(false, aVar.f10064d, c2346ge);
            }
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            c2346ge.b("errMsg", e4.getMessage());
            interfaceC2487oa.a(false, aVar.f10064d, c2346ge);
        }
    }

    public void a(String str, InterfaceC2487oa interfaceC2487oa) throws Exception {
        a aVarA = a(str);
        if (f10056c.equals(aVarA.f10061a)) {
            a(aVarA.f10062b, aVarA, interfaceC2487oa);
            return;
        }
        if (f10057d.equals(aVarA.f10061a)) {
            b(aVarA.f10062b, aVarA, interfaceC2487oa);
            return;
        }
        Logger.i(f10055b, "PermissionsJSAdapter unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, a aVar, InterfaceC2487oa interfaceC2487oa) {
        C2346ge c2346ge = new C2346ge();
        try {
            c2346ge.a(e, C1.a(this.f10060a, jSONObject.getJSONArray(e)));
            interfaceC2487oa.a(true, aVar.f10063c, c2346ge);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            Logger.i(f10055b, "PermissionsJSAdapter getPermissions JSON Exception when getting permissions parameter " + e4.getMessage());
            c2346ge.b("errMsg", e4.getMessage());
            interfaceC2487oa.a(false, aVar.f10064d, c2346ge);
        }
    }
}
