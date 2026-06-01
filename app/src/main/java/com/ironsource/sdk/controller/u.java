package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.C2240ag;
import com.ironsource.C2346ge;
import com.ironsource.C2506pc;
import com.ironsource.C2531r4;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.Logger;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class u {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f10071d = "u";
    private static final String e = "updateToken";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f10072f = "getToken";
    private static final String g = "functionName";
    private static final String h = "functionParams";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f10073i = "success";
    private static final String j = "fail";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f10075b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C2506pc f10074a = new C2506pc();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C2240ag f10076c = new C2240ag();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f10077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f10078b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f10079c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f10080d;

        public /* synthetic */ a(int i2) {
            this();
        }

        private a() {
        }
    }

    public u(Context context) {
        this.f10075b = context;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a(0);
        aVar.f10077a = jSONObject.optString("functionName");
        aVar.f10078b = jSONObject.optJSONObject("functionParams");
        aVar.f10079c = jSONObject.optString("success");
        aVar.f10080d = jSONObject.optString("fail");
        return aVar;
    }

    public void a(String str, InterfaceC2487oa interfaceC2487oa) throws Exception {
        a aVarA = a(str);
        if (e.equals(aVarA.f10077a)) {
            a(aVarA.f10078b, aVarA, interfaceC2487oa);
            return;
        }
        if (f10072f.equals(aVarA.f10077a)) {
            a(aVarA, interfaceC2487oa);
            return;
        }
        Logger.i(f10071d, "unhandled API request " + str);
    }

    public void a(JSONObject jSONObject, a aVar, InterfaceC2487oa interfaceC2487oa) {
        C2346ge c2346ge = new C2346ge();
        try {
            this.f10074a.a(jSONObject);
            interfaceC2487oa.a(true, aVar.f10079c, c2346ge);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            IronLog.INTERNAL.error(e4.toString());
            Logger.i(f10071d, "updateToken exception " + e4.getMessage());
            interfaceC2487oa.a(false, aVar.f10080d, c2346ge);
        }
    }

    private void a(a aVar, InterfaceC2487oa interfaceC2487oa) {
        try {
            JSONObject jSONObjectA = this.f10076c.a();
            Iterator<String> itKeys = jSONObjectA.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj = jSONObjectA.get(next);
                if (obj instanceof String) {
                    jSONObjectA.put(next, StringUtils.encodeURI((String) obj));
                }
            }
            interfaceC2487oa.a(true, aVar.f10079c, jSONObjectA);
        } catch (Exception e4) {
            C2531r4.d().a(e4);
            interfaceC2487oa.a(false, aVar.f10080d, e4.getMessage());
        }
    }
}
