package com.ironsource.sdk.controller;

import android.content.Context;
import com.ironsource.B7;
import com.ironsource.C2300e4;
import com.ironsource.C2346ge;
import com.ironsource.InterfaceC2487oa;
import com.ironsource.Mb;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9983c = "i";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9984d = "getDeviceData";
    private static final String e = "deviceDataFunction";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f9985f = "deviceDataParams";
    private static final String g = "success";
    private static final String h = "fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final B7 f9987b = Mb.U().i();

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f9988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f9989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f9990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f9991d;

        public /* synthetic */ a(int i2) {
            this();
        }

        private a() {
        }
    }

    public i(Context context) {
        this.f9986a = context;
    }

    public void a(String str, InterfaceC2487oa interfaceC2487oa) throws Exception {
        a aVarA = a(str);
        if (f9984d.equals(aVarA.f9988a)) {
            interfaceC2487oa.a(true, aVarA.f9990c, a());
            return;
        }
        Logger.i(f9983c, "unhandled API request " + str);
    }

    private C2346ge a() {
        C2346ge c2346ge = new C2346ge();
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.i0), SDKUtils.encodeString(String.valueOf(this.f9987b.j())));
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.f8407j0), SDKUtils.encodeString(String.valueOf(this.f9987b.q(this.f9986a))));
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.k0), SDKUtils.encodeString(String.valueOf(this.f9987b.C(this.f9986a))));
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.f8408l0), SDKUtils.encodeString(String.valueOf(this.f9987b.D(this.f9986a))));
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.f8409m0), SDKUtils.encodeString(String.valueOf(this.f9987b.e(this.f9986a))));
        c2346ge.b(SDKUtils.encodeString(C2300e4.i.f8411n0), SDKUtils.encodeString(String.valueOf(this.f9987b.h(this.f9986a))));
        return c2346ge;
    }

    private a a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        a aVar = new a(0);
        aVar.f9988a = jSONObject.optString(e);
        aVar.f9989b = jSONObject.optJSONObject(f9985f);
        aVar.f9990c = jSONObject.optString("success");
        aVar.f9991d = jSONObject.optString("fail");
        return aVar;
    }
}
