package com.ironsource.sdk.controller;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2346ge;
import com.ironsource.C2531r4;
import com.ironsource.Hc;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f10035c = "o";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10036d = "activate";
    private static final String e = "startSession";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10037f = "finishSession";
    private static final String g = "impressionOccurred";
    private static final String h = "getOmidData";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10038i = "omidFunction";
    private static final String j = "omidParams";
    private static final String k = "success";
    private static final String l = "fail";
    private static final String m = "%s | unsupported OMID API";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f10039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Hc f10040b = new Hc();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10041a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f10042b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f10043c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f10044d;

        public /* synthetic */ a(int i2) {
            this();
        }

        private a() {
        }
    }

    public o(Context context) {
        this.f10039a = context;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void a(String str, InterfaceC2487oa interfaceC2487oa) throws Exception {
        a aVarA = a(str);
        C2346ge c2346ge = new C2346ge();
        JSONObject jSONObject = aVarA.f10042b;
        if (jSONObject != null) {
            String strOptString = jSONObject.optString("adViewId", "");
            if (!TextUtils.isEmpty(strOptString)) {
                c2346ge.b("adViewId", strOptString);
            }
        }
        try {
            String str2 = aVarA.f10041a;
            switch (str2.hashCode()) {
                case -1655974669:
                    if (str2.equals("activate")) {
                        this.f10040b.a(this.f10039a);
                        c2346ge = this.f10040b.a();
                        interfaceC2487oa.a(true, aVarA.f10043c, c2346ge);
                        return;
                    }
                    break;
                case -984459207:
                    if (str2.equals(h)) {
                        c2346ge = this.f10040b.a();
                        interfaceC2487oa.a(true, aVarA.f10043c, c2346ge);
                        return;
                    }
                    break;
                case 70701699:
                    if (str2.equals(f10037f)) {
                        this.f10040b.b(aVarA.f10042b);
                        interfaceC2487oa.a(true, aVarA.f10043c, c2346ge);
                        return;
                    }
                    break;
                case 1208109646:
                    if (str2.equals(g)) {
                        this.f10040b.c(aVarA.f10042b);
                        interfaceC2487oa.a(true, aVarA.f10043c, c2346ge);
                        return;
                    }
                    break;
                case 1850541012:
                    if (str2.equals(e)) {
                        this.f10040b.d(aVarA.f10042b);
                        interfaceC2487oa.a(true, aVarA.f10043c, c2346ge);
                        return;
                    }
                    break;
            }
            throw new IllegalArgumentException(aVarA.f10041a + " | unsupported OMID API");
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            c2346ge.b("errMsg", e4.getMessage());
            Logger.i(f10035c, "OMIDJSAdapter " + aVarA.f10041a + " Exception: " + e4.getMessage());
            interfaceC2487oa.a(false, aVarA.f10044d, c2346ge);
        }
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a(0);
        aVar.f10041a = jSONObject.optString(f10038i);
        aVar.f10042b = jSONObject.optJSONObject(j);
        aVar.f10043c = jSONObject.optString("success");
        aVar.f10044d = jSONObject.optString("fail");
        return aVar;
    }
}
