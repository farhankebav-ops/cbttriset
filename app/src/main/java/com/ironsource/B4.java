package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C2300e4;
import com.ironsource.sdk.utils.Logger;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
/* JADX INFO: loaded from: classes5.dex */
public class B4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f6361c = "B4";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f6362d = "setSharedSignal";
    private static final String e = "getSharedSignal";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f6363f = "functionName";
    private static final String g = "functionParams";
    private static final String h = "success";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final String f6364i = "fail";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f6365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    A4 f6366b;

    /* JADX INFO: compiled from: r8-map-id-84874db269549a40c0b5c7061a31fb3953e4b1b5018e77414ceb6004f20237e9 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f6367a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        JSONObject f6368b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f6369c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f6370d;

        private a() {
        }

        public static a a(JSONObject jSONObject) {
            a aVar = new a();
            aVar.f6367a = jSONObject.optString("functionName");
            aVar.f6368b = jSONObject.optJSONObject("functionParams");
            aVar.f6369c = jSONObject.optString("success");
            aVar.f6370d = jSONObject.optString("fail");
            return aVar;
        }
    }

    public B4(Context context, A4 a42) {
        this.f6365a = context;
        this.f6366b = a42;
    }

    private a a(String str) throws JSONException {
        return a.a(new JSONObject(str));
    }

    private void b(Context context, a aVar, InterfaceC2487oa interfaceC2487oa) {
        C2346ge c2346ge = new C2346ge();
        JSONObject jSONObject = aVar.f6368b;
        this.f6366b.a(context, EnumC2667z4.a(jSONObject.optString("source")), jSONObject.optString(C2300e4.h.W), jSONObject.optString("data"));
        interfaceC2487oa.a(true, aVar.f6369c, c2346ge);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r7, com.ironsource.InterfaceC2487oa r8) throws java.lang.Exception {
        /*
            r6 = this;
            java.lang.String r0 = "unsupported API: "
            com.ironsource.B4$a r1 = r6.a(r7)
            java.lang.String r2 = r1.f6367a     // Catch: java.lang.Exception -> L22
            int r3 = r2.hashCode()     // Catch: java.lang.Exception -> L22
            r4 = 576059875(0x2255f9e3, float:2.8999172E-18)
            r5 = 1
            if (r3 == r4) goto L24
            r4 = 1486812399(0x589ef4ef, float:1.3981986E15)
            if (r3 == r4) goto L18
            goto L2e
        L18:
            java.lang.String r3 = "setSharedSignal"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L2e
            r2 = 0
            goto L2f
        L22:
            r7 = move-exception
            goto L51
        L24:
            java.lang.String r3 = "getSharedSignal"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Exception -> L22
            if (r2 == 0) goto L2e
            r2 = r5
            goto L2f
        L2e:
            r2 = -1
        L2f:
            if (r2 == 0) goto L4b
            if (r2 != r5) goto L39
            android.content.Context r7 = r6.f6365a     // Catch: java.lang.Exception -> L22
            r6.a(r7, r1, r8)     // Catch: java.lang.Exception -> L22
            return
        L39:
            java.lang.UnsupportedOperationException r2 = new java.lang.UnsupportedOperationException     // Catch: java.lang.Exception -> L22
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L22
            r3.<init>(r0)     // Catch: java.lang.Exception -> L22
            r3.append(r7)     // Catch: java.lang.Exception -> L22
            java.lang.String r7 = r3.toString()     // Catch: java.lang.Exception -> L22
            r2.<init>(r7)     // Catch: java.lang.Exception -> L22
            throw r2     // Catch: java.lang.Exception -> L22
        L4b:
            android.content.Context r7 = r6.f6365a     // Catch: java.lang.Exception -> L22
            r6.b(r7, r1, r8)     // Catch: java.lang.Exception -> L22
            return
        L51:
            r6.a(r1, r8, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.B4.a(java.lang.String, com.ironsource.oa):void");
    }

    private void a(Context context, a aVar, InterfaceC2487oa interfaceC2487oa) {
        C2346ge c2346ge = new C2346ge();
        JSONObject jSONObject = aVar.f6368b;
        c2346ge.b("data", this.f6366b.a(context, EnumC2667z4.a(jSONObject.optString("source")), jSONObject.optString(C2300e4.h.W)));
        interfaceC2487oa.a(true, aVar.f6369c, c2346ge);
    }

    private void a(a aVar, InterfaceC2487oa interfaceC2487oa, Exception exc) {
        C2531r4.d().a(exc);
        String message = exc.getMessage();
        Logger.i(f6361c, aVar.f6367a + " exception " + message);
        C2346ge c2346ge = new C2346ge();
        if (TextUtils.isEmpty(message)) {
            message = "Unknown error";
        }
        c2346ge.b("error", message);
        interfaceC2487oa.a(false, aVar.f6370d, c2346ge);
    }
}
